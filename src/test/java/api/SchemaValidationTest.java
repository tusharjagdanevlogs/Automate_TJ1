package api;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.File;

@Listeners(utils.TestListener.class)
public class SchemaValidationTest {

    @Test
    public void validateGetResponseSchema() {
        RestAssured.
                given().
                when().
                get("https://jsonplaceholder.typicode.com/posts/1").
                then().
                assertThat().
                body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/userSchema.json")));

        System.out.println("🎉 Schema validation passed!");
    }
}

