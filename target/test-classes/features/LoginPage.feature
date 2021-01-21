Feature: As a user, I should be able to login with the provided credentials.

  Scenario: User should be able to enter the credentials provided to the text boxex, click submit button and see the main page
    Given user is on login page
    And user enters username to username text box
    And user enters password to password text box
    When user clicks on submit button
    Then user should be able to see "View / Edit Subscriber (v1.124)"
