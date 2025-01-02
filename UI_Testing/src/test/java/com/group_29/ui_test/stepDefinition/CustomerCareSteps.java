package com.group_29.ui_testing.stepDefinition;

import com.group_29.ui_testing.pages.CustomerCareTest;
import com.group_29.ui_testing.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerCareSteps {

    private WebDriver driver;
    private CustomerCareTest customerCareTest;


    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        customerCareTest = new CustomerCareTest(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    /*private void loginToParaBank(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Log Out")).isDisplayed(), "Login failed");
    }
    */


    @When("the user navigates to the Customer Care page")
    public void theUserNavigatesToTheCustomerCarePage() {
        driver.findElement(By.linkText("Contact Us")).click();
    }

    @Then("the Customer Care page title should be {string}")
    public void theCustomerCarePageTitleShouldBe(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Failed to navigate to the Customer Care page");
    }

    @When("the user submits a message with name {string}, email {string}, and message {string}")
    public void theUserSubmitsAMessage(String name, String email, String message) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("message")).sendKeys(message);
        driver.findElement(By.cssSelector("input[value='Send to Customer Care']")).click();
    }

    @Then("a confirmation message should be displayed")
    public void aConfirmationMessageShouldBeDisplayed() {
        String confirmationMessage = driver.findElement(By.cssSelector(".success")).getText();
        Assert.assertTrue(confirmationMessage.contains("Thank you"), "Message submission failed");
    }
}


