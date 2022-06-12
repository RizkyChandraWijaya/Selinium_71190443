Feature: feature to test login functionality
  Scenario Outline: Check login with valid credentials
    Given browser opened
    And user in login page
    When user insert <email> and <password>
    And login button clicked
    Then user redirect to main screen
    Examples:
      |email              |password               |
      |                   |                       |
      |chan@gmail.com     |                       |
      |                   |chan1234               |
      |chan@gmail.com     |chan1234               |
      |chan@gmail.com     |chan123456789          |
      |                   |chan123456789          |
      |chan@gmail.com     |chan1234?              |
      |                   |chan1234?              |