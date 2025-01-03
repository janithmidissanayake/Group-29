//package com.group_29.ui_testing.stepdefinitions;
//
//import com.group_29.ui_testing.base.WebDriverManager;
//import com.group_29.ui_testing.pages.NavigationPage;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//public class NavigationSteps {
//    private NavigationPage navigationPage;
//    private WebDriver driver;
//
//    @Before
//    public void setup() {
//        driver = WebDriverManager.getDriver();
//        navigationPage = new NavigationPage(driver);
//    }
//
//    @When("I click on the menu button")
//    public void i_click_on_the_menu_button() {
//        navigationPage.clickMenuButton();
//    }
//
//    @Then("I should see the All Items link")
//    public void i_should_see_the_all_items_link() {
//        Assert.assertTrue(navigationPage.checkAllItemsLink(),
//                "All Items link should be visible after clicking menu button");
//    }
//
//    @When("I click on the cart link")
//    public void i_click_on_the_cart_link() {
//        navigationPage.navigateToCart();
//    }
//
//    @Then("I should be on the cart page")
//    public void i_should_be_on_the_cart_page() {
//        Assert.assertTrue(navigationPage.getUrl().contains("/cart.html"),
//                "Should be redirected to cart page");
//    }
//
//    @And("I should be redirected to the Sauce Labs website")
//    public void i_should_be_redirected_to_the_sauce_labs_website() {
//        navigationPage.waitForUrlChange();
//        Assert.assertTrue(navigationPage.getUrl().contains("saucelabs.com"),
//                "Should be redirected to Sauce Labs website");
//    }
//
//    @Then("I click on the logout link")
//    public void i_click_on_the_logout_link() {
//        navigationPage.clickLogoutLink();
//    }
//
//    @And("I should be back on the login page")
//    public void i_should_be_back_on_the_login_page() {
//        Assert.assertTrue(navigationPage.isOnLoginPage(),
//                "Should be redirected to login page");
//    }
//}