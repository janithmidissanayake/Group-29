Feature: Customer Management

Scenario: Search for an existing customer
Given I am on the customers list page
When I enter a customer's email into the search box
And I click the search button
Then I should see the customer in the results