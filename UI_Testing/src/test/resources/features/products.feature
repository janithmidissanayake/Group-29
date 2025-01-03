Feature: Products Page Functionality
  As a logged-in user
  I want to verify the products page

  @smoke
  Scenario: Verify products page title
    Given I am on the products page
    Then the page title should be "Products"


    @smoke @functional
    Scenario: Add a single item to the cart
      Given I am on the products page
      When I add the first item to the cart
      Then the cart badge count should be "1"


    @smoke @functional
    Scenario: Add multiple items to the cart
      Given I am on the products page
      When I add the first item to the cart
      And I add the second item to the cart
      Then the cart badge count should be "2"

