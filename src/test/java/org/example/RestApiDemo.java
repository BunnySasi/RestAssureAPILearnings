package org.example;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class RestApiDemo {
    public static JsonPath jsonPath;

    @Test
    public void firstDemo(){
        given().baseUri("https://reqres.in/").contentType(ContentType.JSON).queryParam("page",2)
                .when().get("api/users?page=2").then().assertThat().statusCode(200).log().all();
    }

    @Test
    public void secondDemo(){
        given().baseUri("https://reqres.in/").contentType(ContentType.JSON).queryParam("page",2)
                .when().get("api/users?page=2").then().assertThat().statusCode(200).body(
                        "data.first_name",hasItem("Ferguson")
                ).log().all();
    }

    @Test
    public void thirdDemo(){
        given().baseUri("https://reqres.in/").contentType(ContentType.JSON).queryParam("page",2)
                .when().get("api/users?page=2").then().assertThat().statusCode(200).body("" +
                        "data.email",hasItem("michael.lawson@reqres.in")).log().all();
    }
    @Test
    public void fourthDemo(){
        given().baseUri("https://reqres.in/").contentType(ContentType.JSON).queryParam("page",2)
                .when().get("api/users?page=2").then().assertThat().statusCode(200).body(
                        "data[0].email",is(not(equalTo("michael.lawson@reqres.in")))).log().all();
    }
    @Test
    public void fifthDemo(){
        given().baseUri("https://reqres.in/").contentType(ContentType.JSON).queryParam("page",2)
                .when().get("api/users?page=2").then().assertThat().statusCode(200).body("" +
                        "data[0].size()",equalTo(5)).log().all();
    }
    @Test
    public void sixthDemo(){
        String resp = given().baseUri("https://reqres.in/").contentType(ContentType.JSON).queryParam("page", 2)
                .when().get("api/users?page=2").then().assertThat().statusCode(200).extract().response().asString();
        System.out.println("Response:"+resp);
    }
    @Test
    public void seventhDemo(){
        String resp = given().baseUri("https://reqres.in/").contentType(ContentType.JSON).queryParam("page", 2)
                .when().get("api/users?page=2").then().assertThat().statusCode(200).extract().response().path("data[0].email");
        System.out.printf(resp);
        /*assertThat(resp,equalTo("michael.lawson@reqres.in"));*/
        Assert.assertEquals(resp,"michael.lawson@reqres.in1");

    }

    @Test
    public void eighthDemo(){
        String resp = given().baseUri("https://reqres.in/").contentType(ContentType.JSON).queryParam("page", 2)
                .when().get("api/users?page=2").then().assertThat().statusCode(200).body("data.email",contains( "michael.lawson@reqres.in","michael.lawson@reqres.in1"),
                        "data[1].email",empty(),
                        "data.email",hasSize(3),
                        "data.email",everyItem(startsWith("email"))
                ).toString();
        System.out.printf(resp);
    }

    @Test
    public void Example_One(){

        HashMap<String,String>testMap = new HashMap<>();
        testMap.put("email","eve.holt@reqres.in");
        testMap.put("password","cityslicka");


        /*File fs = new File("src/main/resources/dummyData.json");*/
        String resp = given().baseUri("https://reqres.in/").config(config.encoderConfig(EncoderConfig.encoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType(ContentType.JSON).body(testMap).when().post("api/login").then()
                .assertThat().statusCode(200).extract().response().asString();

        System.out.println("Response:"+resp);


    }


}
