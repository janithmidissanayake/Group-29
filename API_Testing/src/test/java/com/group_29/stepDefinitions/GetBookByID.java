package com.group_29.stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class GetBookByID {
    private Response response;

    @Given("the GetBookByID API is up and running")
    public void apiIsUpAndRunning() {
        RestAssured.baseURI = "http://localhost:7081"; // Update base URL if needed
    }

    @When("I send a GETBooksByID request to {string} with username {string} and password {string}")
    public void sendGetBookByIDRequestToFetchBookByID(String endpoint, String username, String password) {
        response = RestAssured
                .given()
                .auth()
                .basic(username, password) // Basic Authentication
                .when()
                .get(endpoint.replace("{id}", "1"));

    }

    @Then("the GetBookByID response status code should be {int}")
    public void verifyGetBookByIDStatusCode(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @Then("the response should contain the book details")
    public void verifyResponseContainsBookDetails() {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("id"), "Expected book details, but found none!");
    }
}
