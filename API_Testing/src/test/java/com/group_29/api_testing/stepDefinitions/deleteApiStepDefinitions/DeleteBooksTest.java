package com.group_29.api_testing.stepDefinitions.deleteApiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class DeleteBooksTest {
    private Response response;

    @Given("I am an admin user")
    public void iAmAnAdminUser() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    @Given("I am a user")
    public void iAmAUser() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    // Scenario 1: User tries to delete a book (should be forbidden)
    @When("I send a DELETE request to {string} with a valid book ID as a user")
    public void iSendADeleteRequestToWithAValidBookIDAsAUser(String apiPath) {
        response = given()
                .auth().basic("user", "password") // User credentials
                .when()
                .delete(apiPath.replace("{id}", "1")); // Replace {id} with a valid book ID
    }

    // Scenario 2: User tries to delete a non-existing book (should return forbidden instead of not found)
    @When("I send a DELETE request to {string} with a non-existing book ID as a user")
    public void iSendADeleteRequestToWithANonExistingBookIDAsAUser(String apiPath) {
        response = given()
                .auth().basic("user", "password") // User credentials
                .when()
                .delete(apiPath.replace("{id}", "100")); // Replace {id} with a non-existing book ID
    }

    // Scenario 3: Admin tries to delete a valid book (should be successful)
    @When("I send a DELETE request to {string} with a valid book ID as an admin")
    public void iSendADeleteRequestToWithAValidBookIDAsAnAdmin(String apiPath) {
        response = given()
                .auth().basic("admin", "password") // Admin credentials
                .when()
                .delete(apiPath.replace("{id}", "1")); // Replace {id} with a valid book ID
    }

    // Scenario 4: Admin tries to delete a non-existing book (should return 404 not found)
    @When("I send a DELETE request to {string} with a non-existing book ID as an admin")
    public void iSendADeleteRequestToWithANonExistingBookIDAsAnAdmin(String apiPath) {
        response = given()
                .auth().basic("admin", "password") // Admin credentials
                .when()
                .delete(apiPath.replace("{id}", "100")); // Replace {id} with a non-existing book ID
    }

    // Scenario 5: Admin sends DELETE request with invalid parameter as ID
    @When("I send a DELETE request to {string} with a non-integer ID as a parameter")
    public void iSendADeleteRequestToWithANonIntegerIDAsAParameter(String apiPath) {
        response = given()
                .auth().basic("admin", "password") // Admin credentials
                .when()
                .delete(apiPath.replace("{id}", "invalidString")); // Replace {id} with a non-integer value
    }

    // Validating status code for all scenarios
    @Then("I should receive a response with status code {int}")
    public void iShouldReceiveAResponseWithStatusCode(int statusCode) {
        response.then().statusCode(statusCode); // Validate status code
    }

    // Validating response messages for all scenarios
    @Then("the response should contain the error message {string}")
    public void theResponseShouldContainTheErrorMessage(String expectedMessage) {
        String actualMessage = response.body().asString();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Expected error message not found in response.");
    }

    @Then("the response should contain the success message {string}")
    public void theResponseShouldContainTheSuccessMessage(String successMessage) {
        String actualMessage = response.body().asString();
        Assert.assertTrue(actualMessage.contains(successMessage), "Expected success message not found in response.");
    }
}
