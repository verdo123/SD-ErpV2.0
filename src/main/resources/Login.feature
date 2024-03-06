Feature: Proses User Login
#1
  Scenario: Success Login
    Given User on login page
    When User input username
    And User input password
    And User click button login
    Then User go to home page
