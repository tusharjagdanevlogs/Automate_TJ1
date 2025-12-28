package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstApiTest {

    @Test
    public void getSinglePost() {

        // 1. Set base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // 2. Hit GET request
        Response response = RestAssured
                .given()
                .when()
                .get("/posts/1")
                .then()
                .extract()
                .response();

        // 3. Print full JSON response
        System.out.println("Response: " + response.asString());

        // 4. Validate status code
        assertEquals(response.statusCode(), 200);

        // 5. Validate JSON field 'id'
        int id = response.jsonPath().getInt("id");
        assertEquals(id, 1);

        System.out.println("API Test Passed!");
    }
}

// write a selenium test that opens google

