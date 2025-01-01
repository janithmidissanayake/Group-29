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

    // Scenario 1: User attempts to delete a book with a valid ID
    @Given("I am a user deleting a book with valid id")
    public void iAmAUserInDeleteForValidID() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    @When("I send a DELETE request to {string} with a valid book ID as a user")
    public void iSendADeleteRequestToWithAValidBookIDAsAUser(String apiPath) {
        response = RestAssured.given()
                .auth().basic("user", "password") // User credentials
                .when()
                .delete(apiPath.replace("{id}", "1")); // Replace {id} with a valid book ID
    }

    @Then("I should receive a response for deleting a book with valid ID with status code {int}")
    public void iShouldReceiveADeleteResponseWithStatusCodeUserValid(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Unexpected status code!");
    }

    // Scenario 2: User attempts to delete a non-existing book
    @Given("I am a user in deleting a non-excisting book")
    public void iAmAUserInDelete() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    @When("I send a DELETE request to {string} with a non-existing book ID as a user")
    public void iSendADeleteRequestToWithANonExistingBookIDAsAUser(String apiPath) {
        response = RestAssured.given()
                .auth().basic("user", "password") // User credentials
                .when()
                .delete(apiPath.replace("{id}", "100")); // Replace {id} with a non-existing book ID
    }

    @Then("I should receive a  response for deleting a non-excisting book with status code {int}")
    public void iShouldReceiveADeleteResponseWithStatusCode(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Unexpected status code!");
    }

    // Scenario 3: Admin attempts to delete a valid book
    @Given("I am an admin user deleting a book with valid id")
    public void iAmAnAdminUserInDelete() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    @When("I send a DELETE request to {string} with a valid book ID as an admin")
    public void iSendADeleteRequestToWithAValidBookIDAsAnAdmin(String apiPath) {
        response = RestAssured.given()
                .auth().basic("admin", "password") // Admin credentials
                .when()
                .delete(apiPath.replace("{id}", "1")); // Replace {id} with a valid book ID
    }

    @Then("I should receive a response for a book deletion with valid ID with status code {int}")
    public void iShouldReceiveADeleteResponseWithStatusCodeAsAdmin(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Unexpected status code!");
    }

    // Scenario 4: Admin attempts to delete a non-existing book
    @Given("I am an admin user deleting a non-existing book")
    public void iAmAnAdminUserForNonExistingBookInDelete() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    @When("I send a DELETE request to {string} with a non-existing book ID as an admin")
    public void iSendADeleteRequestToWithANonExistingBookIDAsAnAdmin(String apiPath) {
        response = RestAssured.given()
                .auth().basic("admin", "password") // Admin credentials
                .when()
                .delete(apiPath.replace("{id}", "100")); // Replace {id} with a non-existing book ID
    }

    @Then("I should receive a  response for the deletion of non-excisting book with status code {int}")
    public void iShouldReceiveADeleteResponseWithStatusCodeNonExistingAdmin(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Unexpected status code!");
    }

    // Scenario 5: Admin user passing an invalid parameter for ID in deletion
    @Given("I am an admin user passing an invalid parameter")
    public void iAmAnAdminUserForInvalidParameterTypeInDelete() {
        RestAssured.baseURI = "http://localhost:7081"; // Base URI for API
    }

    @When("I send a DELETE request to {string} with an invalid parameter type for ID as an admin")
    public void iSendADeleteRequestToWithAnInvalidParameterTypeForIDAsAnAdmin(String apiPath) {
        response = RestAssured.given()
                .auth().basic("admin", "password") // Admin credentials
                .when()
                .delete(apiPath.replace("{id}", "gg")); // Replace {id} with an invalid parameter type
    }

    @Then("I should receive a  response for passing an invalid parameter with status code {int}")
    public void iShouldReceiveADeleteResponseWithStatusCodeInvalidParam(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Unexpected status code!");
    }
}