@tag
Feature: Monitor client progress

  @tag1
  Scenario Outline: View client progress details
    Given User has logged in as instructor to monitor
    When User views the progress report for <Client ID>
    Then The system should show the following details:
    |  Client ID  |  Client name  |  Attendance  |  Completion rate  |  Activity  |
    | <Client ID> | <Client name> | <Attendance> | <Completion rate> | <Activity> |

    Examples:
     |  Client ID  | Client name | Attendance | Completion rate | Activity |
     |     10      |Hiba Zawatieh|     90%    |       80%       |  Cardio  |
     |     20      |Mayyasa Shaka|     55%    |       30%       |  Cardio  |

  @tag2
  Scenario Outline: Monitor group attendance for a <Program ID>
    Given User has logged in as instructor to monitor
    When User views attendance for a program <Program ID>
    Then The system should show the following details for monitor:
    | Program ID | Program name | Date of program | Total number of client | Number of attended clients |
    |<Program ID>|<Program name>|<Date of program>|<Total number of client>|<Number of attended clients>|

    Examples:
    | Program ID | Program name | Date of program | Total number of client | Number of attended clients |
    |    100     |    Cardio    |Sunday-Tuesday , 7:00pm-8:00pm|    10     |             9              |