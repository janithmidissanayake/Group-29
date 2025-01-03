package com.group_29.ui_testing.stepdefinitions;

import com.group_29.ui_testing.base.WebDriverManager;
import com.group_29.ui_testing.pages.InventoryPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import java.util.List;

public class ProductSortSteps {
    private InventoryPage productsPage;

    public ProductSortSteps() {
        productsPage = new InventoryPage(WebDriverManager.getDriver());
    }

    @When("I select {string} from sort dropdown")
    public void selectSortOption(String option) {
        productsPage.selectSortOption(option);
    }

    @Then("products should not be sorted by price in ascending order")
    public void verifySortingNotWorking() {
        Assert.assertTrue(productsPage.isPriceSortingIncorrect(),
                "Sort functionality is working correctly when it should be broken");
    }

    @And("I should see incorrect price ordering")
    public void verifyIncorrectPriceOrder() {
        List<Double> prices = productsPage.getProductPrices();
        System.out.println("Actual price order: " + prices);
        boolean hasIncorrectOrder = false;
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                hasIncorrectOrder = true;
                break;
            }
        }
        Assert.assertTrue(hasIncorrectOrder, "Expected incorrect price ordering not found");
    }
}