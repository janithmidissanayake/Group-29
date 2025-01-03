package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.ProductsPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SocialMediaRedirects {
    private ProductsPage productsPage;

    public SocialMediaRedirects() {
        productsPage = new ProductsPage(WebDriverManager.getDriver());
    }

    @When("I click on {string} link")
    public void clickSocialLink(String platform) {
        productsPage.clickSocialLink(platform);
    }

    @Then("I should be redirected to {string}")
    public void verifyRedirection(String expectedUrl) {
        String currentUrl = productsPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl),
                "Expected URL: " + expectedUrl + ", but got: " + currentUrl);
    }
}