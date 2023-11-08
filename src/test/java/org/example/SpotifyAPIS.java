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
            .addHeader("Authorization","Bearer BQCWQrJyqUNEo8IzL5xY10cjFpt-VPATWeOEtr9tWXzMOwaue1MYCfUvtqYFIL5wO8Dxi41xu2_Y4i2cIHIto1JLOLexQPRzfOC1Q8m84t4uDQSfEFxhufXvIGmatPrAGZAZGkkBah3-4mReyumA7w3HVTUz9HFKqv774WjpBIcjtZ6W7p6sRaSfZQJO9tbgP6H90if6M1LA5BbZdt09cgnb-MiHDkXB1fw4ix9npfpPoXm_epYzprzdBP6MipiZ9RGpf8TEd83I2FE6kA")
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
            .addHeader("Authorization","Bearer BQCWQrJyqUNEo8IzL5xY10cjFpt-VPATWeOEtr9tWXzMOwaue1MYCfUvtqYFIL5wO8Dxi41xu2_Y4i2cIHIto1JLOLexQPRzfOC1Q8m84t4uDQSfEFxhufXvIGmatPrAGZAZGkkBah3-4mReyumA7w3HVTUz9HFKqv774WjpBIcjtZ6W7p6sRaSfZQJO9tbgP6H90if6M1LA5BbZdt09cgnb-MiHDkXB1fw4ix9npfpPoXm_epYzprzdBP6MipiZ9RGpf8TEd83I2FE6kA")
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
            .addHeader("Authorization","Bearer BQCWQrJyqUNEo8IzL5xY10cjFpt-VPATWeOEtr9tWXzMOwaue1MYCfUvtqYFIL5wO8Dxi41xu2_Y4i2cIHIto1JLOLexQPRzfOC1Q8m84t4uDQSfEFxhufXvIGmatPrAGZAZGkkBah3-4mReyumA7w3HVTUz9HFKqv774WjpBIcjtZ6W7p6sRaSfZQJO9tbgP6H90if6M1LA5BbZdt09cgnb-MiHDkXB1fw4ix9npfpPoXm_epYzprzdBP6MipiZ9RGpf8TEd83I2FE6kA")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();
    given().spec(requestSpecification).when().get("/me/playlists").then().spec(responseSpecification).extract().response().asString();
}
@Test
public  void getUsersPlaylists(){
    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQCWQrJyqUNEo8IzL5xY10cjFpt-VPATWeOEtr9tWXzMOwaue1MYCfUvtqYFIL5wO8Dxi41xu2_Y4i2cIHIto1JLOLexQPRzfOC1Q8m84t4uDQSfEFxhufXvIGmatPrAGZAZGkkBah3-4mReyumA7w3HVTUz9HFKqv774WjpBIcjtZ6W7p6sRaSfZQJO9tbgP6H90if6M1LA5BbZdt09cgnb-MiHDkXB1fw4ix9npfpPoXm_epYzprzdBP6MipiZ9RGpf8TEd83I2FE6kA")
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
            .addHeader("Authorization","Bearer BQCWQrJyqUNEo8IzL5xY10cjFpt-VPATWeOEtr9tWXzMOwaue1MYCfUvtqYFIL5wO8Dxi41xu2_Y4i2cIHIto1JLOLexQPRzfOC1Q8m84t4uDQSfEFxhufXvIGmatPrAGZAZGkkBah3-4mReyumA7w3HVTUz9HFKqv774WjpBIcjtZ6W7p6sRaSfZQJO9tbgP6H90if6M1LA5BbZdt09cgnb-MiHDkXB1fw4ix9npfpPoXm_epYzprzdBP6MipiZ9RGpf8TEd83I2FE6kA")
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
            .addHeader("Authorization","Bearer BQCWQrJyqUNEo8IzL5xY10cjFpt-VPATWeOEtr9tWXzMOwaue1MYCfUvtqYFIL5wO8Dxi41xu2_Y4i2cIHIto1JLOLexQPRzfOC1Q8m84t4uDQSfEFxhufXvIGmatPrAGZAZGkkBah3-4mReyumA7w3HVTUz9HFKqv774WjpBIcjtZ6W7p6sRaSfZQJO9tbgP6H90if6M1LA5BbZdt09cgnb-MiHDkXB1fw4ix9npfpPoXm_epYzprzdBP6MipiZ9RGpf8TEd83I2FE6kA")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();

    given().spec(requestSpecification).when().get("/browse/featured-playlists").then().spec(responseSpecification).extract().asString();
}
@Test
public void getCategoryPlaylist(){
    requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
            .setBasePath("/v1")
            .addHeader("Authorization","Bearer BQCWQrJyqUNEo8IzL5xY10cjFpt-VPATWeOEtr9tWXzMOwaue1MYCfUvtqYFIL5wO8Dxi41xu2_Y4i2cIHIto1JLOLexQPRzfOC1Q8m84t4uDQSfEFxhufXvIGmatPrAGZAZGkkBah3-4mReyumA7w3HVTUz9HFKqv774WjpBIcjtZ6W7p6sRaSfZQJO9tbgP6H90if6M1LA5BbZdt09cgnb-MiHDkXB1fw4ix9npfpPoXm_epYzprzdBP6MipiZ9RGpf8TEd83I2FE6kA")
            .setContentType(ContentType.JSON).log(LogDetail.ALL).build();

    responseSpecification = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).log(LogDetail.ALL).build();

    given().spec(requestSpecification).when().get("/browse/categories/dinner/playlists")
            .then().spec(responseSpecification).extract().response().asString();
}

}