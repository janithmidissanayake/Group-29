package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductSteps {
    private ProductsPage productsPage;

    public ProductSteps() {
        productsPage = new ProductsPage(WebDriverManager.getDriver());
    }

    @Given("I am on the products page")
    public void i_am_on_the_products_page() {
        // Login is handled in Hooks, no additional verification needed
    }

    @Given("I have added an item to the cart")
    public void i_have_added_an_item_to_the_cart() {
        productsPage.addFirstItemToCart();
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1", "Item was not added to the cart");
    }

    @When("I add the first item to the cart")
    public void i_add_the_first_item_to_the_cart() {
        productsPage.addFirstItemToCart();
    }
    @When("I add the second item to the cart")
    public void i_add_the_second_item_to_the_cart() {
        productsPage.addSecondItemToCart();
    }

    @Then("the cart badge count should be {string}")
    public void the_cart_badge_count_should_be(String expectedCount) {
        String actualCount = productsPage.getCartBadgeCount();
        Assert.assertEquals(actualCount, expectedCount, "Cart badge count does not match the expected value!");
    }
    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(productsPage.getPageTitle(), expectedTitle);
    }
}