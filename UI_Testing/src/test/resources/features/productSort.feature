Feature: Product Sorting
  As a user
  I want to sort products by price
  But the sorting functionality is not working correctly

  @smoke
  Scenario: Verify price sorting (low to high) not working
    Given I am already on the products page
    When I select "Price (low to high)" from sort dropdown
    Then products should not be sorted by price in ascending order
    And I should see incorrect price ordering