@tag
Feature: Update program in fitness management system

  @tag1
 Scenario Outline: Successfully updated a program with <Program ID>
    Given User has logged in as instructor
    And The program <Program ID> exists in the system
    When User updates program with the following details:
    |   Program ID  |    Program title    |    Duration    |    Difficulty level    |    Goals    |    Description    |    Price    |     Schedule type   |    Schedule time    |
    |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program should be updated successfully

    Examples:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |     100     | Cardio | 60 | Intermediate | Weight loss| video | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio | 30 | Advanced | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-7:30pm |
    |     100     | Cardio | 60 | Intermediate | Weight loss| image | 70 | Online | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio Blast | 60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio | 60 | Intermediate | Weight loss| image | 90 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |

  @tag2
  Scenario Outline: Update a program with missing details
    Given User has logged in as instructor
    And The program <Program ID> exists in the system
    When User updates program with the following details:
    |   Program ID  |    Program title    |    Duration    |    Difficulty level    |    Goals    |    Description    |    Price    |     Schedule type   |    Schedule time    |
    |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program should not be updated

    Examples:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |     100     |    | 60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio |  | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio | 60 |  | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio | 60 | Intermediate | | image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio | 60 | Intermediate | Weight loss|  | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio | 60 | Intermediate | Weight loss| image |  | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio | 60 | Intermediate | Weight loss| image | 70 |  | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio | 60 | Intermediate | Weight loss| image | 70 | In-Person |  |
    @tag3
    Scenario Outline: Update a program with invalid details
    Given User has logged in as instructor
    And The program <Program ID> exists in the system
    When User updates program with the following details:
     |   Program ID  |    Program title    |    Duration    |    Difficulty level    |    Goals    |    Description    |    Price    |     Schedule type   |    Schedule time    |
     |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program should not be updated

   Examples:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |     100     | Cardio        | -40      | Intermediate     | Weight loss| image  | 70    | In-Person      | Sunday-Tuesday , 7:00pm-8:00pm |
    |     100     | Cardio        | 60       | Intermediate     | Weight loss| image  | -50   | In-Person      | Sunday-Tuesday , 7:00pm-8:00pm |

    @tag4
    Scenario Outline: Update a program does not exist
    Given User has logged in as instructor
    And The program <Program ID> does not exist in the system
    When User attempts to update program with the following details but this program does not exist:
    |   Program ID  |    Program title    |    Duration    |    Difficulty level    |    Goals    |    Description    |    Price    |     Schedule type   |    Schedule time    |
    |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program should not be updated


   Examples:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |      750      |    BodyBar    |    60    |     Beginner     |   Target multiple muscles  | image |  120  |   Online  |  Wednesday , 8:30am-9:30am |


