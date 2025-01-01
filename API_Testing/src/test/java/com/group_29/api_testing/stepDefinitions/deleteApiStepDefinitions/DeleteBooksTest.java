package com.group_29.api_testing.stepDefinitions.deleteApiStepDefinitions;

import com.group_29.utils.ApiUtils;
import com.group_29.utils.ConfigLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class DeleteBooksTest {
    private Response response;

    @Given("Delete book API is running")
    public void deleteApiIsUpAndRunning() {
        RestAssured.baseURI = ConfigLoader.getProperty("base_url");
    }

    @When("I send a DELETE request to {string} with valid user credentials and valid book id")
    public void iSendADeleteRequestToWithAValidBookIDAsAUser(String apiPath) {
        String username = ConfigLoader.getProperty("valid_user_username");
        String password = ConfigLoader.getProperty("valid_user_password");
        response = ApiUtils.sendDeleteRequest(apiPath.replace("{id}", "2"), username, password);
    }

    @When("I send a DELETE request to {string} with valid user credentials and non-existing book id")
    public void iSendADeleteRequestToWithANonExistingBookIDAsAUser(String apiPath) {
        String username = ConfigLoader.getProperty("valid_user_username");
        String password = ConfigLoader.getProperty("valid_user_password");
        response = ApiUtils.sendDeleteRequest(apiPath.replace("{id}", "100"), username, password);
    }

    @When("I send a DELETE request to {string} with valid admin credentials and valid book id")
    public void iSendADeleteRequestToWithAValidBookIDAsAnAdmin(String apiPath) {
        String username = ConfigLoader.getProperty("valid_admin_username");
        String password = ConfigLoader.getProperty("valid_admin_password");
        response = ApiUtils.sendDeleteRequest(apiPath.replace("{id}", "1"), username, password);
    }

    @When("I send a DELETE request to {string} with valid admin credentials and non-existing book id")
    public void iSendADeleteRequestToWithANonExistingBookIDAsAnAdmin(String apiPath) {
        String username = ConfigLoader.getProperty("valid_admin_username");
        String password = ConfigLoader.getProperty("valid_admin_password");
        response = ApiUtils.sendDeleteRequest(apiPath.replace("{id}", "100"), username, password);
    }

    @When("I send a DELETE request to {string} with valid admin credentials and invalid parameter type")
    public void iSendADeleteRequestToWithAnInvalidParameterTypeForIDAsAnAdmin(String apiPath) {
        String username = ConfigLoader.getProperty("valid_admin_username");
        String password = ConfigLoader.getProperty("valid_admin_password");
        response = ApiUtils.sendDeleteRequest(apiPath.replace("{id}", "ff"), username, password);
    }

    @Then("I should receive a response for deleting a book with status code {int}")
    public void iShouldReceiveADeleteResponseWithStatusCodeUserValid(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode, "Unexpected status code! This is a BUG");
}


}