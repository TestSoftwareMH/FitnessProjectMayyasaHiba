@tag
Feature: Program Exploration

  @tag1
  Scenario Outline: Browse programs by difficulty level
    Given User has logged in to system as client
    When The user wants to filter programs by difficulty level with following details:
    |   Difficulty level   |   Program title   |    Duration   |     Goals     |   Description  |   Price   |   Schedule type   |   Schedule time   |
    |  <Difficulty level>  |  <Program title>  |   <Duration>  |    <Goals>    |  <Description> |  <Price>  |  <Schedule type>  |  <Schedule time>  |
    Then The system should display all programs with selected difficulty level

    Examples:
    |   Difficulty level   |   Program title   |    Duration   |     Goals     |   Description  |   Price   |   Schedule type   |   Schedule time   |
    |Intermediate|      Cardio       |       60      |  Weight loss  |      video     |     70    |     In-Person     |Sunday-Tuesday , 7:00pm-8:00pm|

  @tag2
  Scenario Outline: Browse programs by Focus area
    Given User has logged in to system as client
    When The user wants to filter programs by Focus area with following details:
    |     Goals     |   Program title   |    Duration   |   Difficulty level   |   Description  |   Price   |   Schedule type   |   Schedule time   |
    |    <Goals>    |  <Program title>  |   <Duration>  |  <Difficulty level>  |  <Description> |  <Price>  |  <Schedule type>  |  <Schedule time>  |
    Then The system should display all programs with selected Focus area

     Examples:
     |     Goals     |   Program title   |    Duration   |   Difficulty level   |   Description  |   Price   |   Schedule type   |   Schedule time   |
     |Weight loss|      Cardio       |       60      |     Intermediate     |      video     |     70    |     In-Person     |Sunday-Tuesday , 7:00pm-8:00pm|
