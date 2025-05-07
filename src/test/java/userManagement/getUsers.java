package userManagement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utils.JsonReader;
import utils.PropertyReader;
import utils.SoftAssertionUtil;
import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class getUsers {

    @Test
    public void getUserData()
    {
        given()
         .when().get("https://regres.in/api/users?page=2")
         .then()
                .assertThat()
          .statusCode(200);

    }

    @Test(description = "validateResponseHasItems" )
    public void validateResponseHasItems() {
        // Set base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request and store the response in a variable
        Response response =
                given()
                        .when()
                        .get("/posts");

        // Use Hamcrest to check that the response body contains specific items

        assertThat(response.jsonPath().getList("title"), hasItems("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "qui est esse"));

    }

    @Test
    public void validateListContainsInOrder() {
        // Set base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send a GET request and store the response in a variable
        Response response =
                given()
                        .when()
                        .get("/comments?postId=1");

        // Print the response body in console
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());

        // Use Hamcrest to check that the response body contains specific items
        List<String> expectedEmails = Arrays.asList("Eliseo@gardner.biz", "Jayne_Kuhic@sydney.com","Nikita@garfield.biz","Lew@alysha.tv","Hayden@althea.biz");
        assertThat(response.jsonPath().getList("email"), contains(expectedEmails.toArray(new String[0])));

    }

    @Test
    public void testGetUsersWithQueryParameters() {
        // Set base URI for the API


        // Send a GET request and store the response in a variable
        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.getBody().asString());
        response.then().body("data",hasSize(6));
        response.then().body("data[1].id", equalTo(8));
        response.then().body("data[1].email", is("lindsay.ferguson@reqres.in"));
        response.then().body("data[1].first_name", is("Lindsay"));
        response.then().body("data[1].last_name", is("Ferguson"));
        response.then().body("data[1].avatar", is("https://reqres.in/img/faces/8-image.jpg"));

    }

    @Test()
    public void validateStatusCodeGetUser() {
        System.out.println("*****************");
        Response resp =
                given()
                        .queryParam("page", 2)
                        .when()
                        .get("https://reqres.in/api/users");
        System.out.println(resp.getBody().asString());
        int actualStatusCode = resp.statusCode();  //RestAssured
        assertEquals(actualStatusCode, 200); //Testng
        resp.then().body("data[0].id", equalTo(7));
        resp.then().body("data[0].email", is("michael.lawson@reqres.in"));

    }

    @Test(description = "Validate multiple query ")
    public void testGetUsersWithMultipleQueryParams() {
        Response response =
                given()
                        .queryParam("page", 2)
                        .queryParam("per_page", 3)
                        .queryParam("rtqsdr", 4)
                        .when()
                        .get("https://reqres.in/api/users")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        System.out.println(response.getBody().asString());
    }

    @Test(description = " Validate path parameter")
    public void testGetUsersWithPathParams() {
        Response response =
                given()
                        .pathParams("raceSeason", 2017)
                        .when()
                        .get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        System.out.println(response.getBody().asString());
    }

    @Test
    public void testCreateUserWithFormParam() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "John Doe")
                .formParam("job", "Developer")
                .when()
                .post("https://reqres.in/users")
                .then()
                .statusCode(201)
                .extract()
                .response();

        // Assert that the response contains the correct name and job values
        response.then().body("name", equalTo("John Doe"));
        response.then().body("job", equalTo("Developer"));
    }
    @Test(description = "Validate Header ")
    public void testGetUserListWithHeader() {
        given()
                .header("Content-Type", "application/json")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
        System.out.println("testGetUserListWithHeader Executed Successfully");
    }

    @Test(description = "Validate 2 Header ")
    public void testWithTwoHeaders() {
        given()
                .header("Authorization", "bearer ywtefdu13tx4fdub1t3ygdxuy3gnx1iuwdheni1u3y4gfuy1t3bx")
                .header("Content-Type", "application/json")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);
        System.out.println("testWithTwoHeaders Executed Successfully");
    }

    @Test(description = "Validate  Header with Map")
    public void testTwoHeadersWithMap() {

        // Create a Map to hold headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "bearer ywtefdu13tx4fdub1t3ygdxuy3gnx1iuwdheni1u3y4gfuy1t3bx");

        // Send a GET request with headers
        given()
                .headers(headers)
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200);

        System.out.println("testTwoHeadersWithMap Executed Successfully");
    }

    @Test(description = "Fetch header from response")
    public void testFetchHeaders() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2");

        Headers headers = response.getHeaders();
        //if you want to print all headers then comment 215,216,217
        for (Header h : headers) {
            //if (h.getName().contains("Server")) {
                System.out.println(h.getName() + " : " + h.getValue());
                //assertEquals(h.getValue(), "cloudflare");
               // System.out.println("testFetchHeaders Executed Successfully");
           // }
        }
    }

    @Test
    public void testUseCookies() {
        Cookie cookies = new Cookie.Builder("cookieKey1", "cookieValue1")
                .setComment("using cookie key")
                .build();

        given()
                .cookie(cookies)
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then();
               // .statusCode(StatusCode.SUCCESS.code);
        System.out.println("testUseCookies Executed Successfully");
    }

    @Test
    public void testFetchCookies() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .extract().response();

        Map<String, String> cookies = response.getCookies();
        Cookies cookies1 = response.getDetailedCookies();
        cookies1.getValue("server");
        //assertEquals(cookies1.getValue("server"), "cloudflare");
       // assertThat(cookies, hasKey("JSESSIONID"));
        //assertThat(cookies, hasValue("ABCDEF123456"));
    }


    @Test(description = "Delete method")
    public void validateDeleteGetUser() {
        System.out.println("*****************");
        Response resp =
                given().delete("https://reqres.in/api/users");
        int actualStatusCode = resp.statusCode();  //RestAssured
       // assertEquals(actualStatusCode, StatusCode.NO_CONTENT.code); //Testng
        System.out.println("Status Code delete executed succesfully");


    }



    @Test(description = "basic auth use json reader")
    public void validateWithTestData() throws IOException, ParseException {
        Response resp = given()
                .auth()
                .basic(JsonReader.getTestData("username"), JsonReader.getTestData("password"))
                .when()
                .get("https://postman-echo.com/digest-auth"); //RestAssured

        int actualStatusCode = resp.statusCode();  //RestAssured
        assertEquals(actualStatusCode, 200); //Testng
        System.out.println(resp.body().asString());
    }


    @Test(groups = "smoke")
    public void ValidateDataFromPropertyFile() throws IOException, ParseException {
        System.out.println("*****************");
        String serverAddress = PropertyReader.propertyReader("config.properties","serverAddress");
        String endpoint = JsonReader.getTestData("endpoint");
        String url = serverAddress + endpoint;
        System.out.print("url:" +url);
        Response resp =
                given()
                        .queryParam("page", 2)
                        .when()
                        .get(url);
        System.out.println(resp.getBody().asString());
        int actualStatusCode = resp.statusCode();  //RestAssured
        assertEquals(actualStatusCode, 200); //Testng


    }


    @Test()
    public void ValidateSoftAssertions() throws IOException, ParseException {
        System.out.println("*****************");


        String serverAddress = PropertyReader.propertyReader("config.properties","serverAddress");
        String endpoint = JsonReader.getTestData("endpoint");
        String url = serverAddress + endpoint;
        System.out.print("url:" +url);
        Response resp =
                given()
                        .queryParam("page", 2)
                        .when()
                        .get(url);
        SoftAssertionUtil.assertEquals(resp.getStatusCode(), StatusCode.SUCCESS.code, "Status code is not 200");
        SoftAssertionUtil.assertAll();
        System.out.println("validateWithSoftAssertUtil executed successfully");


    }
    @DataProvider(name = "testdata")
    public Object[][] testData()
    {
        return new Object[][]{
                {"1","John"}   ,
                {"2", "Tim"},
                {"3", "Van"}
        };
    }

    @Test(dataProvider = "testdata")
    @Parameters({"id","name"})
    public void validateDataProvider(String id, String name) {
        System.out.println(id);
        System.out.println(name);


    }
}



