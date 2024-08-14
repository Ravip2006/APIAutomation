package com.example.steps;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import response.PetDetails;

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
       // ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(statusCode, response.getStatusCode());
    }
    @And("the response body should contain pet details")
    public void the_Response_Body_Should_Contain_Pet_Details(String jsonPath) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        PetDetails petDetails = objectMapper.readValue(response.getBody().asString(),PetDetails.class);
        assertTrue("Name of the Pet :" + petDetails.name,petDetails.name.equals("doggie"));
    }
}