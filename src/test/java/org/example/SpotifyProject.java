package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.internal.http.ResponseParseException;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.hamcrest.*;
import java.util.HashMap;

public class SpotifyProject {

    public RequestSpecification requestSpecification;
    public ResponseSpecification responseSpecification;


    @Test
    public void ScenarioOne(){
        HashMap<String,String>body = new HashMap<>();
        body.put("client_id","829eb65295a7479ab6d27a9410b143ee");
        body.put("client_secret","06ba1fe2699d4b7b8ca4cfa567537c0f");
        body.put("grant_type","authorization_code");
        body.put("code","AQBAIfX_VPS_fbtT5ktnbk_0bDHCt7K3Gay8M4zVK1RNwxJKgCdCUZURKVvYvPqMZRXOA7gO1WYlKko4kDdcxYuAGZQ0kPnfacUPj7yFrWHDAbhor4OGxsTrNTQCgZROs7swxZ2vRra01yks0rOVa85FVZcq7-VqFaMDKD22KEtsY3wNwjGS8Rq_AP2sbs2KS7DTH8TKaIEVVAecvcxjWbs1lnJG2Dh3d9cojiNtFP5ovB4S3XyA3z5rRuiL6XbxYrFbkwyYOEQWGWH_cj9oW0HIepzpgW-3Ww");
        body.put("redirect_uri","https://oauth.pstmn.io/v1/callback");
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://accounts.spotify.com")
                .addFormParams(body)
                .setContentType(ContentType.URLENC)
                .log(LogDetail.ALL)
                .build();
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL).build();

        given().spec(requestSpecification).when().post("api/token").then().spec(responseSpecification).extract().response().asString();

    }

}
