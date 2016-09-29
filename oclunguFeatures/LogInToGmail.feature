Feature: Login Action

  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Login page
    When User provide user name as "<username>"
    And User click next button
    And User provide password name as "<password>"
    And User click sign in button
    Then User should be logged in

    Examples:
      | username        | password        |
      | en.oclungu.test | test.oclungu.en |