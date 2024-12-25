package com.group_29.api_testing.stepdefinitions.updateApiStepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;


public class UpdateBookStepDefinitions {
    private Response response;
    private int bookId;

    @Given("the API base URL is {string}")
    public void setBaseUrl(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @Given("a book exists with id {int}")
    public void aBookExistsWithId(int id) {
        this.bookId = id;
        // TODO: Implement a check to ensure the book exists
    }

    @When("I send a PUT request to {string} with the following payload")
    public void iSendAPutRequestToWithTheFollowingPayload(String endpoint, String payload) {
        RequestSpecification request = RestAssured.given()
                .auth()
                .basic("admin", "password")
                .header("Content-Type", "application/json")
                .body(payload);
        response = request.put(endpoint);
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @And("the response body should contain:")
    public void theResponseBodyShouldContain(String expectedResponseBody) {
        try {
            JsonPath jsonPath = response.jsonPath();
            Assert.assertEquals(jsonPath.getInt("id"), bookId);
            Assert.assertEquals(jsonPath.getString("title"), "Jane and Dog");
            Assert.assertEquals(jsonPath.getString("author"), "John Richard");
        } catch (Exception e) {
            Assert.fail("An error occurred during JSON processing: " + e.getMessage());
        }
    }

    @And("the response body should contain error message:")
    public void verifyErrorResponseBody(String expectedErrorMessage) {
        String actualResponseBody = response.getBody().asString();
        Assert.assertTrue(actualResponseBody.contains(expectedErrorMessage.trim()),
                "Error message not found in response");
    }
    @And("the response body should contain invalid id error message:")
    public void verifyInvalidIdResponseBody(String expectedErrorMessage) {
        String actualResponseBody = response.getBody().asString();
        Assert.assertTrue(actualResponseBody.contains(expectedErrorMessage.trim()),
                "Error message not found in response");
    }

}
