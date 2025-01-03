package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class ProductSteps {
    private final ProductPage productPage;

    public ProductSteps() {
        productPage = new ProductPage(WebDriverManager.getDriver());
    }

    @Given("I am on the inventory page")
    public void onInventoryPage() {
        Assert.assertTrue(WebDriverManager.getDriver().getCurrentUrl().contains("/inventory.html"),
                "User is not on the inventory page.");
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


