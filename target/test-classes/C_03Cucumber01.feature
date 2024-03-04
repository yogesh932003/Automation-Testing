@feature03
Feature: To validate the singup functionality of facebook application

Scenario: To validate signup page with valid username, email, password
    Given To launch the edge browser and maximize window
    When To launch the URL of the facebook application
    And To click create account button
    And To pass valid username in input field
    And To pass valid email in input field
    And To pass valid password in input field
    And To click signup button
    Then To close the browser