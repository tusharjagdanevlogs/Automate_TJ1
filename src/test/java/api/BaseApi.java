package api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseApi {
    
    protected RequestSpecification request;
    
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in";
        request = RestAssured.given().header("Content-Type", "application/json");
    }
}