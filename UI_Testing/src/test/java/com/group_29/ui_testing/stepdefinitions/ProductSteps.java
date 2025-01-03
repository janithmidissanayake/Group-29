package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(productsPage.getPageTitle(), expectedTitle);
    }
}