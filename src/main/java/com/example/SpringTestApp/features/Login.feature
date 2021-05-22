Feature: Login

  Scenario: Login with correct username and password
    Given Open the application login page
    And Set user name and password
      | user     | pass      |
      | Admin    | admin123  |
    And Click login button
    Then Home page url is correct
    And Then welcome is displayed