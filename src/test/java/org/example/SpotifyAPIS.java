package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import java.util.HashMap;

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

@Test
public void getCurrentUsersPlayList(){
    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQDKvBe9vztO5JrBJEmLpoQb-hHIDK348UKd4NN1C98CBQ2zSiBv7nxiSSa_iGEASb3RONFMXy7TddbYTcDXU96arcEB83-h6uG9qbwGQFhhcd4qOHWqgZYAtMFbq7L0wlgPeHgD3NL4eRR7EJaREJAQKfo-BdZJnnY3rXcT_OGfAezqKgHTBqKhK5wCr2xR2QQDy9PGRwLHhzlUTiS5GEJClnGttMZ8k9R-6mMYtAVvRm1aH6sevIXMcRaBji30qTZ04ZyWS-Clzhnbyg")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();
    given().spec(requestSpecification).when().get("/me/playlists").then().spec(responseSpecification).extract().response().asString();
}
@Test
public  void getUsersPlaylists(){
    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQDKvBe9vztO5JrBJEmLpoQb-hHIDK348UKd4NN1C98CBQ2zSiBv7nxiSSa_iGEASb3RONFMXy7TddbYTcDXU96arcEB83-h6uG9qbwGQFhhcd4qOHWqgZYAtMFbq7L0wlgPeHgD3NL4eRR7EJaREJAQKfo-BdZJnnY3rXcT_OGfAezqKgHTBqKhK5wCr2xR2QQDy9PGRwLHhzlUTiS5GEJClnGttMZ8k9R-6mMYtAVvRm1aH6sevIXMcRaBji30qTZ04ZyWS-Clzhnbyg")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();
    given().spec(requestSpecification).when().get("/users/31bzhsjnow3rjgxferr55i7t4cey/playlists")
            .then().spec(responseSpecification).extract().response().asString();
}

@Test
public void createPlaylist(){
    HashMap<String,String>dataList = new HashMap<>();
    dataList.put("name","Hello");
    dataList.put("description","Hello,world!");
    dataList.put("public","true");
    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQDJE7GW9j5YyQQ7nHBREuGKfeQDgifmbGEbu4sq3jMs624tZeEK4ZHFEDBOWrTBgLdYt-y2UavqnKdM44fiCeufyoepVGq3ySuxzAf-e9g7v8HLMr09u3mRtJOHGnjIwfnwed-NQ8l1k3f1JfoixbyRKxjYJ5AalL7PdWqHTIPsKRkGU1lN3U3DpK7lTL4n3CnlLFMyZ--Zh_-zyvy4lk87XqeMRnhwoDTxoaDn9ZWH0wO-k8tDyX6PCUherkAW68k9Qi3OkkNrAMRitA")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(201)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();

    given().spec(requestSpecification).body(dataList).when().post("/users/31bzhsjnow3rjgxferr55i7t4cey/playlists")
            .then().spec(responseSpecification).extract().response().asString();
}
@Test
public void getFeaturePlaylists(){
    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQDJE7GW9j5YyQQ7nHBREuGKfeQDgifmbGEbu4sq3jMs624tZeEK4ZHFEDBOWrTBgLdYt-y2UavqnKdM44fiCeufyoepVGq3ySuxzAf-e9g7v8HLMr09u3mRtJOHGnjIwfnwed-NQ8l1k3f1JfoixbyRKxjYJ5AalL7PdWqHTIPsKRkGU1lN3U3DpK7lTL4n3CnlLFMyZ--Zh_-zyvy4lk87XqeMRnhwoDTxoaDn9ZWH0wO-k8tDyX6PCUherkAW68k9Qi3OkkNrAMRitA")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();

    given().spec(requestSpecification).when().get("/browse/featured-playlists").then().spec(responseSpecification).extract().asString();
}
@Test
public void getCategoryPlaylist(){
    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQDJE7GW9j5YyQQ7nHBREuGKfeQDgifmbGEbu4sq3jMs624tZeEK4ZHFEDBOWrTBgLdYt-y2UavqnKdM44fiCeufyoepVGq3ySuxzAf-e9g7v8HLMr09u3mRtJOHGnjIwfnwed-NQ8l1k3f1JfoixbyRKxjYJ5AalL7PdWqHTIPsKRkGU1lN3U3DpK7lTL4n3CnlLFMyZ--Zh_-zyvy4lk87XqeMRnhwoDTxoaDn9ZWH0wO-k8tDyX6PCUherkAW68k9Qi3OkkNrAMRitA")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();

    given().spec(requestSpecification).when().get("/browse/categories/dinner/playlists")
            .then().spec(responseSpecification).extract().response().asString();
}

}