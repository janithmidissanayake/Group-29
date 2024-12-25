Feature: Add new book to the system

  Scenario: Admin adds a new book successfully
    Given I am an admin user
    When I send a POST request to "/api/books" with the book details
    Then I should receive a response with status code 201
    And the response should contain the book's id

  Scenario: User tries to add a new book (Unauthorized)
    Given I am a user
    When I send a POST request to "/api/books" with the book details
    Then I should receive a response with status code 208
