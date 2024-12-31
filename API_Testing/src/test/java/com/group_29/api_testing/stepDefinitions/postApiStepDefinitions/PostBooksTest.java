package com.group_29.api_testing.stepDefinitions.postApiStepDefinitions;

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

    @When("I send a POST request to {string} with the book details as user")
    public void iSendAPostRequestToWithTheBookDetailsAsUser(String apiPath) {
        // Sample request body
        String requestBody = "{\n" +
                "  \"title\": \"New Book\",\n" +
                "  \"author\": \"Author Name\"\n" +
                "}";

        // Sending POST request with user credentials
        response = given()
                .auth().basic("user", "password")  // Use "user" credentials here
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(apiPath);
    }
    @When("I send a POST request to {string} with the book details as admin")
    public void iSendAPostRequestToWithTheBookDetailsAsAdmin(String apiPath) {
        // Sample request body
        String requestBody = "{\n" +
                "  \"title\": \"New Book two\",\n" +
                "  \"author\": \"Author Name two\"\n" +
                "}";

        // Sending POST request based on user credentials
        response = given()
                .auth().basic("admin", "password")  // Use "admin" or "user" based on scenario
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(apiPath);
    }
    @When("I send a POST request to {string} with an integer as the author")
    public void iSendAPostRequestToWithAnIntegerAsTheAuthor(String apiPath) {
        // Request body with an integer for the "author" field
        String requestBody = "{\n" +
                "  \"title\": \"Book With Invalid Author\",\n" +
                "  \"author\": 12345\n" +
                "}";

        // Sending POST request
        response = given()
                .auth().basic("admin", "password")  // Assuming admin credentials
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(apiPath);
    }


    @When("I send a POST request to {string} with the book details and additional attributes")
    public void iSendAPostRequestToWithTheBookDetailsAndAdditionalAttributes(String apiPath) {
        // Request body with additional unexpected attribute
        String requestBody = "{\n" +
                "  \"title\": \"New Book\",\n" +
                "  \"author\": \"Author Name\",\n" +
                "  \"extraAttribute\": \"Unexpected Value\"\n" +
                "}";

        // Sending POST request
        response = given()
                .auth().basic("admin", "password")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(apiPath);
    }
    @When("I send a POST request to {string} with missing values")
    public void iSendAPostRequestToWithMissingValues(String apiPath) {
        String requestBody = "{\n" +
                "  \"title\": null,\n" +
                "  \"author\": null\n" +
                "}";

        response = given()
                .auth().basic("admin", "password")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(apiPath);
    }

@Then("the response should contain the message {string}")
public void theResponseShouldContainTheMessage(String expectedMessage) {
    // Extract the actual message from the response body
//    String actualMessage = response.jsonPath().getString("message");
    String actualMessage = response.asString();

    Assert.assertEquals(actualMessage, expectedMessage, "The error message does not match.");
}
    @Then("the response should contain an error message {string}")
    public void theResponseShouldContainAnErrorMessage(String errorMessage) {
        // Validate that the response contains the expected error message
        Assert.assertTrue(response.body().asString().contains(errorMessage),
                "Expected error message not found in response: " + errorMessage);
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


