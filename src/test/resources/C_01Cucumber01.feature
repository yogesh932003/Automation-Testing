@feature01
Feature: To validate the login functionality of flipkart application

Scenario: To validate login page with valid username
    Given To launch the edge browser and maximize window
    When To launch the URL of the flipkart application
    And To click login button
    And To pass valid username in input field
    And To click otp button
    Then To close the browser