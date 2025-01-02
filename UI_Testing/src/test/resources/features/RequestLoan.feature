Feature: Request Loan

  Scenario: User successfully requests a loan
    Given user is logged in to ParaBank
    When user navigates to Request Loan page
    And user fills out the loan application with amount "5000", down payment "1000", and account "12345"
    Then a loan confirmation message is displayed
