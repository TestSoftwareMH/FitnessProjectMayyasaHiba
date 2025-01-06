@tag
Feature: Notify clients

  @tag1
  Scenario Outline: Notify clients about changes to program schedules
    Given User has logged in as instructor to notify
    When User updates the schedule for the program <Program ID> and notify <Client ID> with the following details:
    |  Program ID  |  Program name  |  New schedule  |  Old schedule  |  Client ID  |
    | <Program ID> | <Program name> | <New schedule> | <Old schedule> | <Client ID> |
    Then The notify should be sent to all enrolled clients <Client ID> in the program <Program ID>

    Examples:
     |  Program ID  |  Program name  |  New schedule  |  Old schedule  |  Client ID  |
     |     100      |    Cardio      |Sunday-Tuesday , 6:00pm-7:00pm|Sunday-Tuesday , 7:00pm-8:00pm|  10  |

  @tag2
  Scenario Outline: Fail to notify clients because there is no clients enrolled in the program <Program ID>
    Given User has logged in as instructor to notify
    When User tries to notify clients <Client ID> not enrolled in the program <Program ID>
    Then The notify should not be sent to anyone

    Examples:
     |  Program ID  |  Program name  |  New schedule  |  Old schedule  |  Client ID  |
     |     100      |    Cardio      |Sunday-Tuesday , 6:00pm-7:00pm|Sunday-Tuesday , 7:00pm-8:00pm|  55  |

   @tag3
   Scenario Outline: Notify clients about cancellation the program <Program ID>
     Given User has logged in as instructor to notify
     When User cancels the schedule for the program <Program ID> and notify <Client ID> with the following details:
     |  Program ID  |  Program name  |  Schedule Time  |  Client ID  |
     | <Program ID> | <Program name> | <Schedule Time> | <Client ID> |
     Then The notify should be sent to all enrolled clients <Client ID> in the program <Program ID>

     Examples:
     |  Program ID  |  Program name  |  Schedule Time  |  Client ID  |
     |     100      |    Cardio      |Sunday-Tuesday , 7:00pm-8:00pm|  10  |