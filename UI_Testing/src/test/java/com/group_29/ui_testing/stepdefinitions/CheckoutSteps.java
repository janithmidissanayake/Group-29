
package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.AddToCartPage;
import com.group_29.ui_testing.pages.CheckoutStepOnePage;
import com.group_29.ui_testing.pages.CheckoutStepTwoPage;
import com.group_29.ui_testing.pages.InventoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutSteps {
    private WebDriver driver;
    private CheckoutStepOnePage checkoutStepOnePage;
    private CheckoutStepTwoPage checkoutStepTwoPage;
    private AddToCartPage addToCartPage;


    private final InventoryPage productsPage;

    public CheckoutSteps() {
        driver = WebDriverManager.getDriver(); // Get driver instance
        productsPage = new InventoryPage(driver);
        addToCartPage = new AddToCartPage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
    }

    @Given("I am logged in as problem_user for checkout")
    public void i_am_on_the_products_page() {
    }
    @And("I have items in the cart and navigate to the cart page")
    public void checkItemsInCart() {
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.goToCart();
    }
    @When("I proceed to checkout")
    public void proceedWithCheckout() {
        addToCartPage.proceedCheckout();
    }

    @Then("I should fill in the required details and reach the checkout page titled {string}")
    public void need_to_fill_input_and_continue(String expectedTitle) {
        checkoutStepOnePage.fillCheckoutInfo("Test", "User", "12345");
        checkoutStepOnePage.clickContinue();
        Assert.assertEquals(checkoutStepTwoPage.getPageTitle(), expectedTitle);
    }
}
