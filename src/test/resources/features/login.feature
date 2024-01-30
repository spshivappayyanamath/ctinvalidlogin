Feature: Login Page validations

  Scenario: login with valid credentials
    Given user navigates to login page
    When user enters correct <username> AND <password> values
    Then user directs to home page