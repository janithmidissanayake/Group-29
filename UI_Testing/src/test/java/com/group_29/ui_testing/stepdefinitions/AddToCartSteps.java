package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.AddToCartPage;
import com.group_29.ui_testing.pages.InventoryPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddToCartSteps {
    private WebDriver driver;
    private InventoryPage productsPage;
    private AddToCartPage addToCartPage;

    public AddToCartSteps() {
        driver = WebDriverManager.getDriver();
        productsPage = new InventoryPage(driver);
        addToCartPage = new AddToCartPage(driver);
    }

    @Given("I am already on the products page")
    public void navigateToProductsPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(productsPage.getPageTitle(), "Products");
    }

    @Then("I press {string} button of {string}")
    public void addProductToCart(String buttonLabel, String productName) {
        productsPage.addProductToCart(productName);
    }

    @When("I navigate to the cart page")
    public void navigateToCartPage() {
        productsPage.goToCart();
        Assert.assertEquals(addToCartPage.getAddToCartPageTitle(), "Your Cart");
    }

    @Then("{string} should display as cart item")
    public void verifyProductInCart(String productName) {
        Assert.assertTrue(addToCartPage.isProductInCart(productName));
    }

    @When("I remove {string} from cart page")
    public void removeFromCartPage(String productName) {
        addToCartPage.removeProduct(productName);
    }

    @Then("{string} should not be in the cart")
    public void verifyProductNotInCart(String productName) {
        Assert.assertFalse(addToCartPage.isProductInCart(productName));
    }

    @When("I remove {string} from products page")
    public void removeFromProductsPage(String productName) {
        productsPage.removeProduct(productName);
    }
}