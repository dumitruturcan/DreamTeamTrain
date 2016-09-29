Feature: User logs in.

  Scenario: LogIn on gmail.com

    Given User navigates to login page

    When User types the username as "dimaturcan96@gmail.com"

    And User clicks the next button

    And User types in the valid password

    And Clicks the Sign-In button

    Then The user can see the Inbox page