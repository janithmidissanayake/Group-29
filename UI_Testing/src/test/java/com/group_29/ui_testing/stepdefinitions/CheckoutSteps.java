package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutSteps {
    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private CheckoutStepTwoPage checkout2Page;
    private ProfilePage profilePage;
    private final CartPage cartPage;
    private final ProductsPage productsPage;

    public CheckoutSteps() {
        driver = WebDriverManager.getDriver(); // Get driver instance
        this.productsPage = new ProductsPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkout2Page = new CheckoutStepTwoPage(driver);
    }
//    public CheckoutSteps(WebDriver driver) {
//        this.driver = driver;
//        this.productsPage = new ProductsPage(driver);
//    }
    @Given("I am logged in as problem_user for checkout")
    public void i_am_on_the_products_pagede() {
        // Login is handled in Hooks, no additional verification needed
    }
    @And("I have items in the cart and navigate to the cart page")
    public void checkItemsInCart() {
//        ProductsPage productsPage = new ProductsPage(driver);
//        productsPage.addItemToCart(0);
        // Verify item was added
        productsPage.navigateToCart();
        Assert.assertFalse(CartPage.isCartEmpty(),
                "Item should be added to cart");
    }
    @When("I proceed to checkout")
    public void proceedWithCheckout() {
        driver.findElement(By.id("checkout")).click();
        checkoutPage = new CheckoutPage(driver);
    }

    @Then("I should fill in the required details and reach the checkout page titled {string}")
    public void need_to_fill_input_and_continue(String expectedTitle) {
        checkoutPage.fillCheckoutInfo("Test", "User", "12345");
        checkoutPage.clickContinue();
        Assert.assertEquals(checkout2Page.getPageTitle(), expectedTitle);
    }
}
