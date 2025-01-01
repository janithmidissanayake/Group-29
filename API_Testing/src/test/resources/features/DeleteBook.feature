@DELETEBook
Feature: Delete a book from the system

  Scenario: User attempts to delete a book with a valid ID
    Given I am a user deleting a book with valid id
    When I send a DELETE request to "/api/books/{id}" with a valid book ID as a user
    Then I should receive a response for deleting a book with valid ID with status code 403


  Scenario: User attempts to delete a non-existing book
    Given I am a user in deleting a non-excisting book
    When I send a DELETE request to "/api/books/{id}" with a non-existing book ID as a user
    Then I should receive a  response for deleting a non-excisting book with status code 403


  Scenario: Admin attempts to delete a valid book
    Given I am an admin user deleting a book with valid id
    When I send a DELETE request to "/api/books/{id}" with a valid book ID as an admin
    Then I should receive a response for a book deletion with valid ID with status code 200


  Scenario: Admin attempts to delete a non-existing book
    Given I am an admin user deleting a non-existing book
    When I send a DELETE request to "/api/books/{id}" with a non-existing book ID as an admin
    Then I should receive a  response for the deletion of non-excisting book with status code 404


  Scenario: Invalid parameter type for ID in DELETE request
    Given I am an admin user passing an invalid parameter
    When I send a DELETE request to "/api/books/{id}" with an invalid parameter type for ID as an admin
    Then I should receive a  response for passing an invalid parameter with status code 400