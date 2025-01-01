package com.group_29.api_testing.stepDefinitions.updateApiStepDefinitions;


import com.group_29.utils.ApiUtils;
import com.group_29.utils.ConfigLoader;
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
        RestAssured.baseURI = ConfigLoader.getProperty("base_url");
    }

    @Given("a book exists with id {int}")
    public void aBookExistsWithId(int id) {
        this.bookId = id;
        String endpoint = "/api/books/" + id;
        Response bookResponse = ApiUtils.sendGetRequest(endpoint, ConfigLoader.getProperty("valid_admin_username"), ConfigLoader.getProperty("valid_admin_password"));
    }

    @When("I send a PUT request to {string} with the following payload")
    public void iSendAPutRequestToWithTheFollowingPayload(String endpoint, String payload) {
        String fullEndpoint = RestAssured.baseURI + endpoint;
        RequestSpecification request = ApiUtils.sendPutRequest(endpoint,ConfigLoader.getProperty("valid_admin_username"),ConfigLoader.getProperty("valid_admin_password"),payload);
        response = request.put(fullEndpoint);
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }

    @When("I send a PUT request to {string} as a user with the following payload")
    public void sendAPutRequestAsUser(String endpoint, String payload) {
        String fullEndpoint = RestAssured.baseURI + endpoint;
        RequestSpecification request = ApiUtils.sendPutRequest(endpoint,ConfigLoader.getProperty("valid_user_username"),ConfigLoader.getProperty("valid_user_password"),payload);
        response = request.put(fullEndpoint);
        System.out.println("Response status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        int actualResponse = response.getStatusCode();
        if (actualResponse != expectedStatusCode) {
            Assert.fail("BUG: Expected status code " + expectedStatusCode + " but got " + actualResponse);
        }
        Assert.assertEquals(expectedStatusCode, actualResponse);
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

    @And("the response body should contain an authorization error message:")
    public void verifyUnauthorizedAccessResponseBody(String expectedErrorMessage) {
        String actualResponseBody = response.getBody().asString();
        Assert.assertTrue(actualResponseBody.contains(expectedErrorMessage.trim()),
                "Error message not found in response");
    }
}
