package com.group_29.ui_testing.stepdefinitions;


import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.ProductsPage;
import com.group_29.ui_testing.pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ResetAppStateSteps {
    private WebDriver driver;
    private ProductsPage productsPage;
//    private ProfilePage profilePage;
    public ResetAppStateSteps() {
        driver = WebDriverManager.getDriver(); // Get driver instance
    }
        @Given("I am logged in as problem_user")
    public void i_am_on_the_products_page() {
        // Login is handled in Hooks, no additional verification needed
    }
    @When("i add item to the cart")
    public void addItemToCart() {
        productsPage = new ProductsPage(driver);
        productsPage.addItemToCart(0);
    }

    @Then("product page cart should show red icon")
    public void verifyCartIcon() {
        Assert.assertTrue(productsPage.isCartBadgeVisible());
    }

    @Given("I have added items to the cart")
    public void addItemsToCartAndStayOnProductPage() {
        productsPage = new ProductsPage(driver);
        productsPage.addItemToCart(0);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Then("the cart should be empty")
    public void verifyEmptyCartPage() {
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertEquals(0, driver.findElements(By.className("cart_item")).size());
    }

    @When("I reset the app state")
    public void resetAppState() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openMenu();
        profilePage.resetAppState();
    }

    @And("all items on the product page should be unselected")
    public void verifyUnselectedItems() {
        List<WebElement> addButtons = driver.findElements(By.cssSelector("[data-test^='add-to-cart']"));
        for (WebElement button : addButtons) {
            Assert.assertTrue(button.isDisplayed());
        }
    }

}
