package com.group_29.ui_testing.stepDefinitions;

import com.group_29.ui_testing.pages.LoginPage;
import com.group_29.utils.BrowserDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class CheckoutSteps {
    private WebDriverWait wait;
    private LoginPage loginPage;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = BrowserDriver.getDriver(); // Initialize the driver from BrowserDriver
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set up WebDriverWait
        loginPage = new LoginPage(driver); // Create an instance of LoginPage
    }

    @Given("I need to go cart")
    public void executeLogin() {
        // Call the login method from LoginPage
        loginPage.login();
        WebElement addCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")));
        addCart.click();
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"shopping_cart_container\"]/a")));
        cartIcon.click();
    }

    @When("If cart is empty")
    public void iBillPay() {
        // Navigate to the Bill Pay page

        WebElement cartContainer = driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]"));
        Assert.assertTrue(cartContainer.isDisplayed(), "Cart container is visible, but it should not be when the cart is empty.");

    }

    @Then("I place oreder button should be disable")
    public void iShouldSeefAConfirmationMessage() {
        // Verify the confirmation message is displayed
        WebElement placeOrderButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"checkout\"]")));
        Assert.assertTrue(placeOrderButton.isEnabled(), "Place order button is not disabled.");
       }
}
