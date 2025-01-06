Feature: Generate reports for revenue, attendance, and client progress

  Scenario: The user views the revenue report for all programs
    When the user views the revenue report
    Then the total revenue should be 5000.00

  Scenario: The user views the attendance report for all programs
    When the user views the attendance report
    Then the attendance for program "Yoga Basics" should be 100

  Scenario: The user views the client progress report for all programs
    When the user views the client progress report
    Then the progress for program "Yoga Basics" should be displayed
