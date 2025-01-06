Feature: Add Program
  As an administrator
  I want to add programs to the system
  So that users can enroll and participate

  Scenario: The user adds a program with valid details
    When the user provides the following program details:
      | Key           | Value        |
      | ProgramName   | Fitness Pro  |
      | ProgramType   | Online       |
      | Duration      | 6            |
      | Instructor    | John Doe     |
      | StartDate     | 2025-01-15   |
    Then the program should be added successfully

  Scenario: Adding a program with an invalid duration format
    When the user tries to add a program with these details:
      | Key           | Value        |
      | ProgramName   | Yoga         |
      | Duration      | 6 months     |
      | Fee           | 50.0         |
      | Description   | Yoga program |

    Then the program should not be added
    And the system should display an error "Invalid duration format"

  Scenario: The user tries to add a program with incomplete details
    When the user tries to add a program with incomplete details:
      | ProgramName | Duration | Fee  | Description |
      |             | 30       |      |             |
    Then the program should not be added
    And the system should display an error "All fields are required"

  Scenario: Adding a program with invalid details
    When the user tries to add a program with invalid details:
      | ProgramName | Duration | Fee  | Description     |
      | Yoga        |          |      | Yoga program    |
    Then the program should nott be added
    And the system should display an error "Invalid details provided"
