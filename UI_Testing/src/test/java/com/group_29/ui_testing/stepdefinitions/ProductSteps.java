package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.ProductsPage;
import com.group_29.ui_testing.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class ProductSteps {
    private ProductsPage productsPage;
    private ProductPage productPage;

    public ProductSteps() {
        productsPage = new ProductsPage(WebDriverManager.getDriver());
        productPage = new ProductPage(WebDriverManager.getDriver());
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
    @When("I add a product to cart")
    public void addProduct() {
        productPage.addProductToCart();
    }

    @Then("the cart count should be {int}")
    public void verifyCartCount(int expectedCount) {
        Assert.assertEquals(productPage.getCartCount(), expectedCount, "Cart count does not match expected value.");
    }

    @When("I click remove button for the product")
    public void clickRemoveButton() {
        productPage.removeProduct();
    }

    @Then("the new cart count should be {int}")
    public void verifyNewCartCount(int expectedCount) {
        int actualCount = productPage.getCartCount();
        if (actualCount != expectedCount) {
            Assert.fail("Bug detected: Product is not being removed. Expected count: " + expectedCount +
                    ", Actual count: " + actualCount);
        }
    }

    @When("I get all product images source URLs")
    public void getAllProductImagesSourceURLs() {
        List<String> imageSources = productPage.getAllProductImageSources();
        Assert.assertNotNull(imageSources, "Failed to retrieve product images.");
        System.out.println("Retrieved image sources: " + imageSources);
    }

    @Then("each product should have a unique image")
    public void verifyUniqueProductImages() {
        int uniqueImageCount = productPage.getUniqueImageCount();
        int totalImageCount = productPage.getAllProductImageSources().size();

        System.out.println("Total images: " + totalImageCount + ", Unique images: " + uniqueImageCount);

        // Check if all products have unique images
        if (uniqueImageCount != totalImageCount) {
            Assert.fail("Bug detected: All products have same image. " +
                    "Total images: " + totalImageCount + ", Unique images: " + uniqueImageCount);
        }
    }
}