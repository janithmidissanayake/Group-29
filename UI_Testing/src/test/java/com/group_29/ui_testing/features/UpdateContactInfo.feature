#Feature: Customer Management
#
#  Scenario: Search for an existing customer
#    Given I am on the customers list page
#    When I enter a customer's email into the search box
#    And I click the search button
#    Then I should see the customer in the result

#Feature: Search functionality on the Academy Bugs store homepage
#
#  Scenario: Searching for a product
#    Given I am on the Academy Bugs store homepage
#    When I enter "Laptop" in the search bar and click the search button
#    Then I should see search results related to "Laptop"

Feature: Update User Information
  Scenario: Successfully updating user contact details
    Given I am logged into ParaBank
    When I navigate to the "Update Contact Info" page
    And I update my phone number to "d"
    Then I should see a success message confirming the update