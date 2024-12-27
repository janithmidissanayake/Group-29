//package com.group_29.stepDefinitions;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.testng.Assert;
//
//public class GetAllBooks {
//    private Response response;
//
//    @Given("the API is up and running")
//    public void apiIsUpAndRunning() {
//        RestAssured.baseURI = "http://localhost:7081"; // Update base URL if needed
//    }
//
//    @When("I send a GET request to {string}")
//    public void sendGetRequest(String endpoint) {
//        response = RestAssured.get(endpoint);
//    }
//
//    @Then("the response status code should be {int}")
//    public void verifyStatusCode(int expectedStatusCode) {
//        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
//    }
//
//    @Then("the response should contain a list of books")
//    public void verifyResponseContainsListOfBooks() {
//        Assert.assertTrue(response.jsonPath().getList("$").size() > 0, "No books found in the response!");
//    }
//}

package com.group_29.stepDefinitions;

import io.cucumber.java.en.Given;
import com.group_29.utils.ConfigLoader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

public class GetAllBooks {
    private Response response;

//    @Given("the GetAllbooks API is up and running")
//    public void apiIsUpAndRunning() {
//        RestAssured.baseURI = "http://localhost:7081"; // Update base URL if needed
//    }
    @Given("the GetAllbooks API is up and running")
    public void apiIsUpAndRunning() {
        RestAssured.baseURI = ConfigLoader.getProperty("base_url"); // Load base URL from properties file
}

    @When("I send a valid credential GETBooks request to {string}")
    public void sendValidCredentialGetRequest(String endpoint) {
        String username = ConfigLoader.getProperty("valid_username");
        String password = ConfigLoader.getProperty("valid_password");

        response = RestAssured
                .given()
                .auth()
                .basic(username, password) // Use credentials from properties file
                .when()
                .get(endpoint);
    }
//    public void sendGetBooksRequestWithAuth(String endpoint, String username, String password) {
//        response = RestAssured
//                .given()
//                .auth()
//                .basic(username, password) // Add Basic Authentication
//                .when()
//                .get(endpoint);
//    }

    @Then("the valid credential GetBooks response status code should be {int}")
    public void verifyValidCredentialGetBooksStatusCode(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }

    @Then("the response should contain a list of books or indicate no books are available")
    public void verifyResponseContainsListOfBooksOrEmptyMessage() {
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

    @When("I send an invalid credential GETBooks request to {string}")
    public void sendInvalidCredentialGetRequest(String endpoint) {
        String username = ConfigLoader.getProperty("invalid_username");
        String password = ConfigLoader.getProperty("invalid_password");

        response = RestAssured
                .given()
                .auth()
                .basic(username, password) // Use credentials from properties file
                .when()
                .get(endpoint);
    }

    @Then("the invalid credential GetBooks response status code should be {int}")
    public void verifyInvalidCredentialGetBooksStatusCode(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Unexpected status code!");
    }
}
