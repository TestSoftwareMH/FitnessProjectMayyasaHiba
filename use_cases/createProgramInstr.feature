@tag
Feature: Create program in fitness management system

  @tag1
  Scenario Outline: Successfully created a new program
    Given User has logged in as instructor
    When User creates program with the following details:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program <Program title> should be created successfully

    Examples:
    |  Program ID | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |     800     | Pilates | 60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Monday , 7:00pm-8:00pm |
    |     200     | Yoga | 30 | Advanced | Relax | video | 50 | Online | Monday-Thursday , 8:00am-8:30am |

  @tag2
 Scenario Outline: Successfully created a new free program
     Given User has logged in as instructor
     When User creates program with the following details:
     |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
     |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
     Then The program <Program title> should be created successfully

     Examples:
     |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
     |      300      | Swimming | 30 | Beginner | Trial class| document | 0.0 | In-person | Saturday , 10:00am-10:30am |

    @tag3
 Scenario Outline: Create a new program with missing details
    Given User has logged in as instructor
    When User creates program with the following details:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program <Program title> should not be created

    Examples:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |  | Cardio | 60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |100|    | 60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |100| Cardio |  | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |100| Cardio | 60 |  | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |100| Cardio | 60 | Intermediate | | image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |100| Cardio | 60 | Intermediate | Weight loss|  | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |100| Cardio | 60 | Intermediate | Weight loss| image |  | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |100| Cardio | 60 | Intermediate | Weight loss| image | 70 |  | Sunday-Tuesday , 7:00pm-8:00pm |
    |100| Cardio | 60 | Intermediate | Weight loss| image | 70 | In-Person |  |

    @tag4
  Scenario Outline: Create a program have the same time with other program
    Given User has logged in as instructor
    When User creates program with the following details:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program <Program title> should not be created

    Examples:
    |  Program ID | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |     100     | Cardio | 60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    |     200     | Yoga | 60 | Advanced | Relax | video | 50 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |

     @tag5
  Scenario Outline: Create a program with invalid details
    Given User has logged in as instructor
    When User creates program with the following details:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |  <Program ID> | <Program title> | <Duration> | <Difficulty level> | <Goals> | <Description> | <Price> | <Schedule type> | <Schedule time> |
    Then The program <Program title> should not be created

   Examples:
    |   Program ID  | Program title | Duration | Difficulty level | Goals | Description | Price | Schedule type | Schedule time |
    |-100| Cardio | -60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    | 100| Cardio | -60 | Intermediate | Weight loss| image | 70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
    | 100| Cardio | 60 | Intermediate | Weight loss| image | -70 | In-Person | Sunday-Tuesday , 7:00pm-8:00pm |
