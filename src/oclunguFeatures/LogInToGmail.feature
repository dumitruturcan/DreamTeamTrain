Feature: Login to the gmail.

  Scenario: User login to the gmail.
    Given User access gmail.
    When User provide user name as "<username>" and password as "<password>".
      | username        | password        |
      | en.oclungu.test | test.oclungu.en |
    Then User should be logged in.