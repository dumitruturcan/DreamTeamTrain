Feature: Login to the gmail.

  Scenario: User login to the gmail.
    Given User access gmail.
    When User provide user name as "en.oclungu.test".
    And User click next button.
    And User provide password name as "test.oclungu.en".
    And User click sign in button.
    Then User should be logged in.