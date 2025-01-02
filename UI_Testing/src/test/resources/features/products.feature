Feature: Products Page Functionality
  As a logged-in user
  I want to verify the products page

  @smoke
  Scenario: Verify products page title
    Given I am on the products page
    Then the page title should be "Products"