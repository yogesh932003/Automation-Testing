@feature06
Feature: To validate the login functionality of ICICI netbanking application

Scenario: To validate login page with valid username and password
    Given To launch the edge browser and maximize window
    When To launch the URL of the ICICI netbanking application
    And To pass valid userId in input field
    And To pass valid password in input field
    And To click login button
    Then To close the browser