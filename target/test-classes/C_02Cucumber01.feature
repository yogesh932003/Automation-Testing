@feature02
Feature: To validate the login functionality of Gmail application

Scenario: To validate login page with valid username
    Given To launch the edge browser and maximize window
    When To launch the URL of the Gmail application
    And To pass valid username in input field
    And To click login button
    Then To close the browser