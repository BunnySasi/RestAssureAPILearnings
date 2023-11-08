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
        body.put("code","AQBrPgqNZq3H1UfI-h_GpKcKUnE8emjzQWxeuCxSi6dmhutmJLj9OLLkPxyKo0cgnc5BEU-PZP7fKzNzaH45pbGHDL2bwJ4RVIvkL3GAwZxg8QtAFNU64FAceRSXjpOZl7L5VP8RCi27OGDzZZqA1wMdMfXmXWBn49_JX9OTmMfabquU4VCUQnm3PJMYdl349GHuYcZ_cPLQFSoeUhyfoLnHTWbbGYNWW8eA1nUwgIz2nmOTVtfGKk5q4E1-0pbZ7GiTx96C_NSKHdwLncp4LEk4y9gqh-uWpQ");
        body.put("redirect_uri","https://oauth.pstmn.io/v1/callback");
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://accounts.spotify.com")
                .addFormParams(body)
                .setContentType(ContentType.URLENC)
                .log(LogDetail.ALL)
                .build();
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL).build();

        given().spec(requestSpecification).when().post("api/token").then().spec(responseSpecification).extract().response().asString();

    }
    @Test
    public void getSpotifyDeviceDetails(){
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer BQAos75SabSBbtYLQoQku5bYIFtPuay6FUk1SUVR5tT87AIxhZ3h6Le2J9X05swyH8RbX_I7DjXdzmoDUgVR-iPoDL4GdlARYKnZJBx2Mtu3YEpMydd_DfgEwJAo9sIc6g8-hquE9PnXgxTYThtAiJswsh1uH8k8da1p8yNjudOAxwcAOiFDAfaO6c_Umf_9amuuGXhU24hwQBQaSS1FfPOUkrY74FTDfpUq872_I3GCXDvdoYOs-YGAP0hGU8snUhQpPEMiYCD9eYGYTwktZiGlnu8zosxS0m1xRXCgMime29lA")
                .log(LogDetail.ALL)
                .build();
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        given().spec(requestSpecification).when().get("/me/player/devices").then().spec(responseSpecification).extract().response().asString();
    }

    @Test
    public void SpotifyDetailofMine(){
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer BQAos75SabSBbtYLQoQku5bYIFtPuay6FUk1SUVR5tT87AIxhZ3h6Le2J9X05swyH8RbX_I7DjXdzmoDUgVR-iPoDL4GdlARYKnZJBx2Mtu3YEpMydd_DfgEwJAo9sIc6g8-hquE9PnXgxTYThtAiJswsh1uH8k8da1p8yNjudOAxwcAOiFDAfaO6c_Umf_9amuuGXhU24hwQBQaSS1FfPOUkrY74FTDfpUq872_I3GCXDvdoYOs-YGAP0hGU8snUhQpPEMiYCD9eYGYTwktZiGlnu8zosxS0m1xRXCgMime29lA")
                .log(LogDetail.ALL)
                .build();
        responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                .expectStatusCode(200).log(LogDetail.ALL).build();
        given().spec(requestSpecification).when().get("/me/player").then().spec(responseSpecification).extract().response().asString();
    }

    @Test
    public void recentPlayed(){
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Authorization","Bearer BQAos75SabSBbtYLQoQku5bYIFtPuay6FUk1SUVR5tT87AIxhZ3h6Le2J9X05swyH8RbX_I7DjXdzmoDUgVR-iPoDL4GdlARYKnZJBx2Mtu3YEpMydd_DfgEwJAo9sIc6g8-hquE9PnXgxTYThtAiJswsh1uH8k8da1p8yNjudOAxwcAOiFDAfaO6c_Umf_9amuuGXhU24hwQBQaSS1FfPOUkrY74FTDfpUq872_I3GCXDvdoYOs-YGAP0hGU8snUhQpPEMiYCD9eYGYTwktZiGlnu8zosxS0m1xRXCgMime29lA")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                .expectStatusCode(200).log(LogDetail.ALL).build();

        given().spec(requestSpecification).when().get("/me/player/recently-played").then().spec(responseSpecification).extract().response().asString();

    }

    @Test
    public void SpotifyPlay(){

        requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
                .setBasePath("/v1").addHeader("Authorization","Bearer BQAos75SabSBbtYLQoQku5bYIFtPuay6FUk1SUVR5tT87AIxhZ3h6Le2J9X05swyH8RbX_I7DjXdzmoDUgVR-iPoDL4GdlARYKnZJBx2Mtu3YEpMydd_DfgEwJAo9sIc6g8-hquE9PnXgxTYThtAiJswsh1uH8k8da1p8yNjudOAxwcAOiFDAfaO6c_Umf_9amuuGXhU24hwQBQaSS1FfPOUkrY74FTDfpUq872_I3GCXDvdoYOs-YGAP0hGU8snUhQpPEMiYCD9eYGYTwktZiGlnu8zosxS0m1xRXCgMime29lA")
                .log(LogDetail.ALL).build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(204)
                .log(LogDetail.ALL).build();

        given().spec(requestSpecification)
                .when().put("/me/player/play")
                .then().spec(responseSpecification).extract().response().asString();
    }


}
