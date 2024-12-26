package com.group_29.api_testing.stepdefinitions.postApiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PostBooksTest {

    private Response response;

    @Given("I am an admin user")
    public void iAmAnAdminUser() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    @Given("I am a user")
    public void iAmAUser() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    @When("I send a POST request to {string} with the book details")
    public void iSendAPostRequestToWithTheBookDetails(String apiPath) {
        // Sample request body
        String requestBody = "{\n" +
                "  \"title\": \"New Book\",\n" +
                "  \"author\": \"Author Name\"\n" +
                "}";

        // Sending POST request based on user credentials
        response = given()
                .auth().basic("admin", "password")  // Use "admin" or "user" based on scenario
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(apiPath);
    }

    @Then("I should receive a response with status code {int}")
    public void iShouldReceiveAResponseWithStatusCode(int statusCode) {
        response.then().statusCode(statusCode); // Validate status code
    }

    @Then("the response should contain the book's id")
    public void theResponseShouldContainTheBooksId() {
        Assert.assertNotNull(response.jsonPath().get("id"), "The book ID should be present in the response");
    }


}


