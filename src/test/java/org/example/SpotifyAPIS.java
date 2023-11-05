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

    /*Get Album*/

    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @Test
    public void getAlbum(){

/*        RequestSpecification */

        requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Authorization","Bearer BQDy8dJY1micVJBWl4kjnR1i7YAVb3-A-fhdw30J-igidH8ZRrNxHfLic0m84ILNVC6cXDwOBGm60mO8E2eEFR-wE8hCnR3LeP6GvQEFGWKiqmLgyUg69rfKhYWxGaRc4D0AtoNbfEr4mE5C75fHejHFh7XqjjHG1P15SkOgKhspKvlvpz2wulEZ_3ILGIcNgMFCGzcvSIvHBNiS_MwJ7Fy6GW1_WCLiDi_gTsYgWxv2jfKNX8YVRcH_oEzWTd-1RiIMpaybFUyxl9weQw")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
/*        ResponseSpecification*/

        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL).build();

        /*Main Code*/

        given().spec(requestSpecification).when().get("/albums/4aawyAB9vmqN3uQ7FjRGTy")
                .then().spec(responseSpecification).extract().asString();
    }

    /*Get Album Track*/

    @Test
    public  void getAlbumTrack(){
        /*        RequestSpecification */

        requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
                .setBasePath("/v1")
                .addHeader("Authorization","Bearer BQDy8dJY1micVJBWl4kjnR1i7YAVb3-A-fhdw30J-igidH8ZRrNxHfLic0m84ILNVC6cXDwOBGm60mO8E2eEFR-wE8hCnR3LeP6GvQEFGWKiqmLgyUg69rfKhYWxGaRc4D0AtoNbfEr4mE5C75fHejHFh7XqjjHG1P15SkOgKhspKvlvpz2wulEZ_3ILGIcNgMFCGzcvSIvHBNiS_MwJ7Fy6GW1_WCLiDi_gTsYgWxv2jfKNX8YVRcH_oEzWTd-1RiIMpaybFUyxl9weQw")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        /*        ResponseSpecification*/

        responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL).build();

        /*Main Code*/
        given().spec(requestSpecification).when().get("/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
                .then().spec(responseSpecification).extract().response().asString();
    }
}