@feature04
Feature: To validate the login functionality of amazon application

Scenario: To validate login page with valid email address
    Given To launch the edge browser and maximize window
    When To launch the URL of the amazon application
    And To click the login button
    And To pass valid email in input field
    |yy1732003@gmail.com|yogeshperuvai242@gmail.com|
    And To click login button
    Then To close the browsers