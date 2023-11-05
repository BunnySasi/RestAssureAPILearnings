package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class SpotifyAPIS {

public static RequestSpecification requestSpecification;
public static ResponseSpecification responseSpecification;

@Test
public void getPlayList(){

    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQDKvBe9vztO5JrBJEmLpoQb-hHIDK348UKd4NN1C98CBQ2zSiBv7nxiSSa_iGEASb3RONFMXy7TddbYTcDXU96arcEB83-h6uG9qbwGQFhhcd4qOHWqgZYAtMFbq7L0wlgPeHgD3NL4eRR7EJaREJAQKfo-BdZJnnY3rXcT_OGfAezqKgHTBqKhK5wCr2xR2QQDy9PGRwLHhzlUTiS5GEJClnGttMZ8k9R-6mMYtAVvRm1aH6sevIXMcRaBji30qTZ04ZyWS-Clzhnbyg")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();

    given().spec(requestSpecification).when().get("/playlists/3cEYpjA9oz9GiPac4AsH4n")
            .then().spec(responseSpecification).extract().response().asString();
}
@Test
public void getPlayListItems(){
    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQDKvBe9vztO5JrBJEmLpoQb-hHIDK348UKd4NN1C98CBQ2zSiBv7nxiSSa_iGEASb3RONFMXy7TddbYTcDXU96arcEB83-h6uG9qbwGQFhhcd4qOHWqgZYAtMFbq7L0wlgPeHgD3NL4eRR7EJaREJAQKfo-BdZJnnY3rXcT_OGfAezqKgHTBqKhK5wCr2xR2QQDy9PGRwLHhzlUTiS5GEJClnGttMZ8k9R-6mMYtAVvRm1aH6sevIXMcRaBji30qTZ04ZyWS-Clzhnbyg")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();

    given().spec(requestSpecification).when().get("/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks")
            .then().spec(responseSpecification).extract().response().asString();

}


}