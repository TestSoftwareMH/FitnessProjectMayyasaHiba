@tag
Feature: Delete program in fitness management system

  @tag1
  Scenario Outline: Successfully deleted a program <Program ID>
    Given User has logged in as instructor to delete program
    And The program <Program ID> exists in the system
    When User deletes program with the following details:
    |   Program ID   |  Program title  |  Duration  |  Difficulty level  |  Goals  |  Description  |  Price  |  Schedule type  |  Schedule time  |
    |  <Program ID>  | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program <Program ID> should be deleted successfully

  Examples:
  |   Program ID   |  Program title  |  Duration  |  Difficulty level  |  Goals  |  Description  |  Price  |  Schedule type  |  Schedule time  |
  |     100     |  Cardio | 60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
  @tag2
  Scenario Outline: Delete a program does not exist
  Given User has logged in as instructor to delete program
  And The program <Program ID> does not exist in the system to be deleted
  When User tries to delete the program <Program ID>
  Then The program should not be deleted

  Examples:
  |   Program ID   |  Program title  |  Duration  |  Difficulty level  |  Goals  |  Description  |  Price  |  Schedule type  |  Schedule time  |
  |      750      |    BodyBar    |    60    |     Beginner     |   Target multiple muscles  | image |  120  |   Online  |  Wednesday , 8:30am-9:30am |


  @tag3
  Scenario: Delete a program without permission
  Given User has logged in as client
  When User tries to delete the program <Program ID>
  Then The program should not be deleted

  Examples:
  |   Program ID   |  Program title  |  Duration  |  Difficulty level  |  Goals  |  Description  |  Price  |  Schedule type  |  Schedule time  |
  |     800     | Pilates | 60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Monday , 7:00pm-8:00pm |
