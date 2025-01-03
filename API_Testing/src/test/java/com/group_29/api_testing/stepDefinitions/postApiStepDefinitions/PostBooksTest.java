package com.group_29.api_testing.stepDefinitions.postApiStepDefinitions;

import com.group_29.utils.ApiUtils;
import com.group_29.utils.ConfigLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PostBooksTest {

    private Response response;

    @Given("POST book API is running")
    public void postApiIsUpAndRunning() {
        RestAssured.baseURI = ConfigLoader.getProperty("base_url");
    }


    @When("I send a POST request to {string} with the book details as user")
    public void iSendAPostRequestToWithTheBookDetailsAsUser(String apiPath) {

        // Sample request body
        String requestBody = """
            {
              "title": "New Book",
              "author": "Author Name"
            }
        """;

        // Sending POST request with user credentials
        response= ApiUtils.sendPostRequest(apiPath,ConfigLoader.getProperty("valid_user_username") , ConfigLoader.getProperty("valid_admin_password"),requestBody);}

    @When("I send a POST request to {string} with the book details as admin")
    public void iSendAPostRequestToWithTheBookDetailsAsAdmin(String apiPath) {

        // Sample request body
        String requestBody = """
            {
              "title": "New Book Two",
              "author": "Author Name Two"
            }
        """;

        // Sending POST request based on user credentials
        response= ApiUtils.sendPostRequest(apiPath,ConfigLoader.getProperty("valid_admin_username") , ConfigLoader.getProperty("valid_admin_password"),requestBody);}

    @When("I send a POST request to {string} with an integer as the author")
    public void iSendAPostRequestToWithAnIntegerAsTheAuthor(String apiPath) {

        // Request body with an integer for the "author" field
        String requestBody = """
            {
              "title": "Book With Invalid Author",
              "author": 12345
            }
        """;

        // Sending POST request
        response= ApiUtils.sendPostRequest(apiPath,ConfigLoader.getProperty("valid_admin_username") , ConfigLoader.getProperty("valid_admin_password"),requestBody);}



    @When("I send a POST request to {string} with the book details and additional attributes")
    public void iSendAPostRequestToWithTheBookDetailsAndAdditionalAttributes(String apiPath) {

        // Request body with additional unexpected attribute
        String requestBody = """
            {
              "title": "New Book",
              "author": "Author Name",
              "extraAttribute": "Unexpected Value"
            }
        """;

        response= ApiUtils.sendPostRequest(apiPath,ConfigLoader.getProperty("valid_admin_username") , ConfigLoader.getProperty("valid_admin_password"),requestBody);}
    @When("I send a POST request to {string} with missing values")
    public void iSendAPostRequestToWithMissingValues(String apiPath) {

        String requestBody = """
            {
              "title": null,
              "author": null
            }
        """;
        response= ApiUtils.sendPostRequest(apiPath,ConfigLoader.getProperty("valid_admin_username") , ConfigLoader.getProperty("valid_admin_password"),requestBody);}


    @Then("the response should contain the message {string}")
public void theResponseShouldContainTheMessage(String expectedMessage) {

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


