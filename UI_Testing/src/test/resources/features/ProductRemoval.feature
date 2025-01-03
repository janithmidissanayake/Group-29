
@regression
Feature: Product Removal
  As a user
  I want to be able to remove products from the cart
  And verify removal functionality works correctly

  @smoke
  Scenario: Verify product removal functionality (BUG EXPECTED)
    Given I am on the inventory page
    When I add a product to cart
    Then the cart count should be 1
    When I click remove button for the product
    Then the new cart count should be 0






