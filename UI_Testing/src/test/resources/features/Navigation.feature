@navigation
Feature: Navigation functionality

  @smoke
  Scenario: Verify menu button functionality
    When I click on the menu button
    Then I should see the All Items link

  @smoke
  Scenario: Verify cart navigation
    When I click on the cart link
    Then I should be on the cart page


  @smoke
  Scenario: Verify logout functionality
    When I click on the menu button
    Then I click on the logout link
    And I should be back on the login page

