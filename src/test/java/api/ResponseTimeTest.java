import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ResponseTimeTest {

    @Test
    public void checkResponseTime() {

        Response response =
                RestAssured
                        .given()
                        .baseUri("https://reqres.in")
                        .basePath("/api/users/2")
                        .when()
                        .get();

        // Get response time in milliseconds
        long responseTime = response.time();

        System.out.println("Response Time: " + responseTime + " ms");

        // Simple SLA check (example: < 2000 ms)
        assertTrue(responseTime < 2000, "Response time is too slow!");

    }
}

