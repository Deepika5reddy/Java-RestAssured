package userManagement;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class getPostmanEcho {




    @Test(description = "basic auth")
    public void validateResponseBodyGetBasicAuth() {

        Response resp = given()
                .auth()
                .basic("postman", "password")
                .when()
                .get("https://postman-echo.com/digest-auth"); //RestAssured

        int actualStatusCode = resp.statusCode();  //RestAssured
        assertEquals(actualStatusCode, 200); //Testng
        System.out.println(resp.body().asString());
    }

    @Test(description = "Digest auth", groups = {"smoke", "regression"})
    public void validateResponseBodyGetDigestAuth() {

        Response resp = given()
                .auth()
                .digest("postman", "password")
                .when()
                .get("https://postman-echo.com/digest-auth"); //RestAssured

        int actualStatusCode = resp.statusCode();  //RestAssured
        //assertEquals(actualStatusCode, StatusCode.SUCCESS.code);
        System.out.println(resp.body().asString());
    }

}
