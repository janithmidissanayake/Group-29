Feature: Customer Care Page Testing

  Scenario: Navigate to Customer Care page
    When the user navigates to the Customer Care page
    Then the Customer Care page title should be "ParaBank | Customer Care"

  Scenario: Submit a message to Customer Care
    Given the user navigates to the Customer Care page
    When the user submits a message with name "John Doe", email "johndoe@example.com", and message "I need assistance with my account."
    Then a confirmation message should be displayed
