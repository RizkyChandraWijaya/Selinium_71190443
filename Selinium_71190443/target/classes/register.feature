Feature: feature to test register functionality
  Scenario Outline: Cek register dengan credential valid
    Given browser terbuka
    And user berada di page register
    When user memasukan <email> dan <password>
    And button create diklik
    Then user diarahkan ke login page
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