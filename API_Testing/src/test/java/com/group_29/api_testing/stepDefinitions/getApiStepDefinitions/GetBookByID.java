package com.group_29.api_testing.stepDefinitions.getApiStepDefinitions;

import com.group_29.utils.ApiUtils;
import com.group_29.utils.ConfigLoader;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class GetBookByID {
    private Response response;

    @Given("the GetBookByID API is up and running")
    public void apiIsUpAndRunning() {
        RestAssured.baseURI = ConfigLoader.getProperty("base_url");}

    @When("I send a GETBooksByID request to {string} with admin credentials")
    public void sendGetBookByIDRequest(String endpoint) {
        String username = ConfigLoader.getProperty("valid_admin_username");
        String password = ConfigLoader.getProperty("valid_admin_password");
        response = ApiUtils.sendGetRequest(endpoint.replace("{id}", "1"), username, password);
    }

    @When("I send a GETBooksByID request to {string} with user credentials")
    public void sendGetBookByIDRequestWithValidUserCredentials(String endpoint) {
        String username = ConfigLoader.getProperty("valid_user_username"); // Load valid user credentials
        String password = ConfigLoader.getProperty("valid_user_password");

        response = ApiUtils.sendGetRequest(endpoint.replace("{id}", "1"), username, password);
    }

    @Then("the GetBookByID response status code should be {int} or {int} not {int}")
    public void verifyGetBookByIDStatusCode(int expectedStatusCode1, int expectedStatusCode2,int forbiddenCode) {
        int actualStatusCode = response.getStatusCode();

        if (actualStatusCode == forbiddenCode) {

            Assert.fail("Received 403 Forbidden with valid user credentials, which is a bug!");
        }

        // Validate that the status code is either expected value
        boolean isValidStatusCode = (actualStatusCode == expectedStatusCode1 || actualStatusCode == expectedStatusCode2);

        Assert.assertTrue(isValidStatusCode,
                "Unexpected status code! Expected: " + expectedStatusCode1 + " or " + expectedStatusCode2
                        + " but got: " + actualStatusCode);

    }

    @Then("the response should contain the book details")
    public void verifyResponseContainsCorrectDetailsIfFound() {
        int actualStatusCode = response.getStatusCode();

        if (actualStatusCode == 200) {
            // Validate response body for existing book
            String bookTitle = response.jsonPath().getString("title");
            Assert.assertNotNull(bookTitle, "Book title should not be null for existing book!");
            System.out.println("Book details: " + response.getBody().asString());
        } else if (actualStatusCode == 404) {
            // Validate message for non-existing book
            String errorMessage = response.getBody().asString();
            Assert.assertEquals(errorMessage, "Book not found", "Unexpected error message!");
            System.out.println("Error message: " + errorMessage);
        }
    }

    @When("I send a invalid formatted GET request to {string}")
    public void sendInvalidFormattedGetBookByIDRequest(String endpoint) {
        String username = ConfigLoader.getProperty("valid_admin_username");
        String password = ConfigLoader.getProperty("valid_admin_password");
        response = ApiUtils.sendGetRequest(endpoint.replace("{id}", "b"), username, password);

    }

    @Then("the invalid formatted GET request response status code should be {int}")
    public void verifyInvalidFormattedGetBookByIDStatusCode(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }


}


