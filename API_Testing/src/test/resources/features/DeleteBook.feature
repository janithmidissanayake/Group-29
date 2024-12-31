Feature: Delete a book from the system

  Scenario: User attempts to delete a book with a valid ID
    Given I am a user with the role "user"
    When I send a DELETE request to "/api/books/1"
    Then I should receive a response with status code 403
    And the response should indicate "Forbidden"

  Scenario: User attempts to delete a non-existing book
    Given I am a user with the role "user"
    When I send a DELETE request to "/api/books/100"
    Then I should receive a response with status code 403
    And the response should indicate "Forbidden"


  Scenario: Admin attempts to delete a valid book
    Given I am an admin user with the role "admin"
    When I send a DELETE request to "/api/books/1"
    Then I should receive a response with status code 200
    And the book should be deleted successfully


  Scenario: Admin attempts to delete a non-existing book
    Given I am an admin user with the role "admin"
    When I send a DELETE request to "/api/books/100"
    Then I should receive a response with status code 404
    And the response should indicate "Book not found"


  Scenario: Invalid parameter type for ID in DELETE request
    Given I am an admin user
    When I send a DELETE request to "/api/books/{id}" with a non-integer ID as a parameter
    Then I should receive a response with status code 400
    And the response should contain the error message "Invalid parameter type"
