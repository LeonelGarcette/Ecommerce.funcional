Feature:  Login OK.

  Scenario Outline:  Log-in with different credentials
    When Access to the URL
    And Type user name "<user>"
    And Type password "<password>"
    And Click in Login button
    Then Message "<status>" should be display

    Examples:
      | user            | password     | status   |
      | standard_user   | secret_sauce | Success  |
      | locked_out_user | secret_sauce | Locked   |
      | user            | secret_sauce | Error    |
      | standard_user   | password     | Password |