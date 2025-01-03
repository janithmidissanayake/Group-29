Feature: Add to Cart
  As a logged-in user
  I want to add a product to the cart
  I want to verify product adding to a cart

  @smoke
  Scenario: Add a product to the cart
    Given I am already on the products page
    Then I press "Add to cart" button of "Sauce Labs Backpack"
    When I navigate to the cart page
    Then "Sauce Labs Backpack" should display as cart item
