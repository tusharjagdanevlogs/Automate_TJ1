package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void getPosts() {
        Response res = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .extract()
                .response();

        System.out.println("Status Code: " + res.statusCode());
        System.out.println("Response Body: " + res.asString());

        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertTrue(res.asString().contains("userId"));
    }

    @Test
    public void createPost() {
        String body = "{ \"title\":\"Tushar QA\", \"body\":\"Learning API automation\", \"userId\":1 }";

        Response res = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .extract()
                .response();

        System.out.println("Status Code: " + res.statusCode());
        System.out.println("Response Body: " + res.asString());

        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertTrue(res.asString().contains("Tushar QA"));
    }
}
