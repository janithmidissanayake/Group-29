package com.group_29.ui_testing.stepDefinition;

import com.group_29.ui_testing.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageNavigationStep {





    private WebDriver driver;


@Before
    public void setup() {
        driver = DriverManager.getDriver();
        //driver.get("https://parabank.parasoft.com/parabank/index.htm");
        //loginToParaBank("john", "demo");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @When("the user clicks on {string}")
    public void theUserClicksOn(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Navigation to the expected page failed");
    }
}



