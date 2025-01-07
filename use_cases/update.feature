Feature: Update Program in Fitness Management System
  Scenario Outline: Successfully update a program's details
    When the user updates the program with the following details:
      | ProgramName   | Duration | Fee   | Description               |
      | <programName> | <duration> | <fee> | <description>             |
    Then the program should be updated successfully
    Examples:
      | programName | duration | fee  | description            |
      | Yoga Basics | 45       | 60   | Advanced yoga program  |
      | CrossFit    | 60       | 80   | High-intensity workout |
  Scenario Outline: Attempting to update a non-existent program
    When the user attempts to update a program with the following details:
      | ProgramName   | Duration | Fee   | Description               |
      | <programName> | <duration> | <fee> | <description>             |
    Then the system should show an error "Program not found"
    Examples:
      | programName | duration | fee  | description               |
      | NonExistent | 45       | 60   | Non-existent program      |
      | Unknown     | 30       | 50   | Program does not exist    |
  Scenario: Update a program with missing details
    Given the following program exists:
      | ProgramName  | Duration | Fee | Description       |
      | Yoga Basics  | 6 weeks  | 150 | Beginner-friendly |
    When the user attempts to update a program with the following missing details:
      | ProgramName  | Duration | Fee | Description |
      | Yoga Basics  |          | 130 |             |
    Then the program should not be updated
  Scenario Outline: Attempting to update a program with invalid data
    When the user attempts to update a program with the following invalid details:
      | ProgramName   | Duration | Fee   | Description             |
      | <programName> | <duration> | <fee> | <description>           |
    Then the system should show an error "Invalid data"
    Examples:
      | programName   | duration | fee  | description             |
      | Yoga Basics   | -30      | 60   | Invalid duration        |
      | CrossFit      | 60       | -50  | Negative fee            |