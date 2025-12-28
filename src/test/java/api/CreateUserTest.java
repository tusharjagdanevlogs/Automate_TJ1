package api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CreateUserTest extends BaseApi {
    
    @Test
    public void testCreateUser() {
        String jsonBody = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";
        
        Response response = request
                .body(jsonBody)
                .post("/api/users");

        long responseTime = response.time();

        System.out.println("Response Time: " + responseTime + " ms");

        // Simple SLA check (example: < 2000 ms)
        assertTrue(responseTime < 2000, "Response time is too slow!");
        
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), "morpheus");
        Assert.assertNotNull(response.jsonPath().getString("id"));



    }
}