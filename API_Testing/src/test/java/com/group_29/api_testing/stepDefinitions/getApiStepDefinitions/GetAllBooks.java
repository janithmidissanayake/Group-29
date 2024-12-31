package com.group_29.api_testing.stepDefinitions.getApiStepDefinitions;

import com.group_29.utils.ApiUtils;
import com.group_29.utils.ConfigLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

public class GetAllBooks {
    private Response response;

    @Given("the GetAllBooks API is up and running")
    public void apiIsUpAndRunning() {
        RestAssured.baseURI = ConfigLoader.getProperty("base_url"); // Load base URL from properties file
    }

    @When("I send a {string} GETBooks request to {string}")
    public void sendGetBooksRequest(String credentialType, String endpoint) {
        String username, password;

        if ("valid".equalsIgnoreCase(credentialType)) {
            username = ConfigLoader.getProperty("valid_admin_username");
            password = ConfigLoader.getProperty("valid_admin_password");
        } else {
            username = "invalid_user";
            password = "invalid_pass";
        }

        response = ApiUtils.sendGetRequest(endpoint, username, password);
    }

    @Then("the {string} GetBooks response status code should be {int}")
    public void verifyGetBooksResponseStatusCode(String credentialType, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
                "For credential type: " + credentialType + " expected status code " + expectedStatusCode +
                        " but got " + response.getStatusCode());
    }

    @Then("the {string} response should contain a list of books or indicate no books are available")
    public void verifyResponseContainsListOfBooksOrEmptyMessage(String credentialType) {
        if ("valid".equalsIgnoreCase(credentialType)) {
            List<Object> books = response.jsonPath().getList("$");

            if (books.isEmpty()) {
                System.out.println("No books are available in the system.");
                Assert.assertTrue(books.isEmpty(), "Expected no books, but the list is not empty!");
            } else {
                System.out.println("Books are available in the system.");
                System.out.println("Book details: " + response.getBody().asString());
                Assert.assertTrue(books.size() > 0, "Expected books, but found none!");
            }
        }
    }

}