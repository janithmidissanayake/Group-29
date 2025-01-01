Feature: Find Transactions
  As a ParaBank user
  I want to find transactions based on date and amount
  So that I can view my transaction history easily.

  Scenario: Search transactions by date
    Given user is logged in to ParaBank
    When user navigates to Find Transactions page
    And user searches for transactions by date "2023-12-25"
    Then transactions for the date "2023-12-25" are displayed

  Scenario: Search transactions by amount
    Given user is logged in to ParaBank
    When user navigates to Find Transactions page
    And user searches for transactions by amount "100.00"
    Then transactions for the amount "100.00" are displayed
