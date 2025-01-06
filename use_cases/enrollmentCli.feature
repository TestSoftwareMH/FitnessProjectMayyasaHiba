@tag
Feature: Enroll in programs and view schedules

  @tag1
  Scenario Outline: Enroll in program
    Given User has logged in as client for enrollment
    When User select program <Program ID> to enroll in and the user <Client ID> puts the true details
    | Program ID | Client ID |
    |<Program ID>|<Client ID>|
    Then The confirmation message should be displayed

    Examples:
    |Program ID|Client ID|
    |205       |10       |

  @tag2
  Scenario Outline: Show enrolled programs
    Given User has logged in as client for enrollment
    When The user <Client ID> wants to show his/her enrolled programs with the following details:
    | Client ID |  Program title  |  Duration  |  Difficulty level  |  Price  |  Schedule type  |  Schedule time  |
    |<Client ID>| <Program title> | <Duration> | <Difficulty level> | <Price> | <Schedule type> | <Schedule time> |
    Then The system should display all programs that the user enrolled in
    Examples:
    | Client ID |  Program title  |  Duration  |  Difficulty level  |  Price  |  Schedule type  |  Schedule time  |
    |10         |Cardio           |60          |Intermediate        |70       |In-Person        |Sunday-Tuesday , 7:00pm-8:00pm|

  @tag3
  Scenario Outline: Enroll in program has same schedule time with other program already the user enrolled in
    Given User has logged in as client for enrollment
    When User <Client ID> tries to enroll in program <Program you want> with conflict schedule
    | Client ID | Program you want |
    |<Client ID>|<Program you want>|
    Then The system should display error message

    Examples:
    | Client ID | Program you want |
    | 10        |505               |

