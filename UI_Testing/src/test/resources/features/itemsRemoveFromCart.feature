Feature: Remove from Cart
  As a logged-in user
  I want to remove products from my cart
  So that I can update my purchase items

  @smoke
  Scenario: Remove product from cart page
    Given I am already on the products page
    When I press "Add to cart" button of "Sauce Labs Backpack"
    And I navigate to the cart page
    And I remove "Sauce Labs Backpack" from cart page
    Then "Sauce Labs Backpack" should not be in the cart

  Scenario: Remove product from products page
    Given I am already on the products page
    When I press "Add to cart" button of "Sauce Labs Backpack"
    And I remove "Sauce Labs Backpack" from products page
    And I navigate to the cart page
    Then "Sauce Labs Backpack" should not be in the cart