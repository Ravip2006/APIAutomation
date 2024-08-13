package org.example.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.*;

public class PetStoreStepDefs {

    private Response response;
    private String endpoint;

    @Given("the API endpoint is {string}")
    public void the_api_endpoint_is(String endpoint) {
        this.endpoint = endpoint;
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
    }

    @When("I send a GET request")
    public void i_Send_A_GET_Request() {
        response = RestAssured.given().when().get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_Response_Status_Code_ShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }
    @And("the response body should contain {string}")
    public void theResponseBodyShouldContain(String jsonPath) {
        assertTrue(response.getBody().asString().contains(jsonPath));
    }

}