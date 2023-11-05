package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.*;
import org.hamcrest.Matchers.*;
import org.hamcrest.MatcherAssert.*;
import org.hamcrest.*;

import java.util.HashMap;

public class RestApiTwo {
    public static  RequestSpecification req;
    public static ResponseSpecification res;

    @Test
    public  void Authorization(){
        HashMap<String,String>setLogins = new HashMap<>();
        setLogins.put("username","admin");
        setLogins.put("password","password123");
        req = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/")
                .setContentType(ContentType.JSON)
                .build();

       res = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        given().spec(req).body(setLogins).when().post("auth").then().spec(res).assertThat().statusCode(200)
                .log().all();


    }
    @Test
    public void getAllBooks(){

        req = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON).build();
        res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
                .build();

        given().spec(req).when().get("booking").then().assertThat().statusCode(200).log().all().extract().asString();


    }

    @Test
    public void getSpecificPage(){
        req = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON).build();
        res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.TEXT)
                .build();

        given().spec(req).when().get("booking/3").then().spec(res).assertThat().log().all().statusCode(200).extract().asString();

    }

    @Test
    public void performBooking(){
        req = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON).build();
        res = new ResponseSpecBuilder().expectStatusCode(200)
                .build();


        given().spec(req).body("{\n" +
                        "        \"firstname\" : \"Jim\",\n" +
                        "        \"lastname\" : \"Brown\",\n" +
                        "        \"totalprice\" : 111,\n" +
                        "        \"depositpaid\" : true,\n" +
                        "        \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "        },\n" +
                        "        \"additionalneeds\" : \"Breakfast\"\n" +
                        "        }")
                .when().post("booking").then().spec(res).log().all().extract().asString();
    }

    @Test
    public void updateParticularBook(){
        req = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                        .addHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                build();
        res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.TEXT)
                .build();
        given().spec(req).body("{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfasmmt\"\n" +
                "}").when().put("booking/3").then().spec(res).log().all().extract().asString();
    }
    @Test
    public void patchParticularBook(){
        req = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                build();
        res = new ResponseSpecBuilder().expectStatusCode(200)
                .build();

        given().spec(req).body("{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}").when().patch("booking/2").then().spec(res).log().all().extract().asString();

    }

    @Test
    public void deleteParticularBook(){
        req = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
                build();
        res = new ResponseSpecBuilder().expectStatusCode(200)
                .build();

        given().spec(req).when().delete("booking/2").then().spec(res).log().all().extract().asString();
    }
}



