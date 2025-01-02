
Feature: Reset App State
#@smoke
#  Scenario: Add products to cart
#    Given I am logged in as problem_user
#    When i add item to the cart
#    Then product page cart should show red icon
  @smoke
  Scenario: Test reset app state removes all cart items and selections
    Given I am logged in as problem_user
    And I have added items to the cart
    When I reset the app state
    Then the cart should be empty
    And all items on the product page should be unselected