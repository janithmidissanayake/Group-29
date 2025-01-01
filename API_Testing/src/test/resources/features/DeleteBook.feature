@DELETEBook
Feature: Delete a book from the system

  Scenario: User attempts to delete a book with a valid ID
    Given Delete book API is running
    When I send a DELETE request to "/api/books/{id}" with valid user credentials and valid book id
    Then I should receive a response for deleting a book with status code 403


  Scenario: User attempts to delete a non-existing book
    Given Delete book API is running
    When I send a DELETE request to "/api/books/{id}" with valid user credentials and non-existing book id
    Then I should receive a response for deleting a book with status code 403


  Scenario: Admin attempts to delete a valid book
    Given Delete book API is running
    When I send a DELETE request to "/api/books/{id}" with valid admin credentials and valid book id
    Then I should receive a response for deleting a book with status code 200


  Scenario: Admin attempts to delete a non-existing book
    Given Delete book API is running
    When I send a DELETE request to "/api/books/{id}" with valid admin credentials and non-existing book id
    Then I should receive a response for deleting a book with status code 404


  Scenario: Invalid parameter type for ID in DELETE request
    Given Delete book API is running
    When I send a DELETE request to "/api/books/{id}" with valid admin credentials and invalid parameter type
    Then I should receive a response for deleting a book with status code 400