Feature: Request Loan

  Scenario: Successful loan request submission
    Given I am on the loan request page
    When I enter a loan amount of "10000" and a down payment of "2000"
    And I submit the loan request
    Then I should see a confirmation message "Loan Request Submitted"