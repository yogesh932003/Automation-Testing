@feature05
Feature: To validate the search functionality of myntra application

Scenario: To validate searchbox with valid keyword
    Given To launch the edge browser and maximize window
    When To launch the URL of the myntra application
    And To pass valid keyword in input field
    And To click search button
    Then To close the browser