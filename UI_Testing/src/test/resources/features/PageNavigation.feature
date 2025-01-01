Feature: Navigation Bar Testing

  Scenario: Navigate to Accounts Overview
    When the user clicks on "Accounts Overview"
    Then the page title should be "ParaBank | Accounts Overview"

  Scenario: Navigate to Transfer Funds
    When the user clicks on "Transfer Funds"
    Then the page title should be "ParaBank | Transfer Funds"

  Scenario: Navigate to Request Loan
    When the user clicks on "Request Loan"
    Then the page title should be "ParaBank | Request Loan"

  Scenario: Navigate to Find Transactions
    When the user clicks on "Find Transactions"
    Then the page title should be "ParaBank | Find Transactions"
