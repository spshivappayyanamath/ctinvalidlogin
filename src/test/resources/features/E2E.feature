Feature: Testing restassured cases
  Background: user generates token
    Given authorised user

    Scenario: the authrorised user add and remove book
      Given list of books
      When add a book to reading list
      Then book should be added
      When remove book
      Then book should be removed