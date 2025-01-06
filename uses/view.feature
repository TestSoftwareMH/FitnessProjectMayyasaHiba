Feature: View statistics on the most popular programs by enrollment

  Scenario Outline: Viewing statistics of programs by enrollment
    Given the following programs have been added:
      | ProgramName       | Duration | Fee    | Description           | Enrollments |
      | <programName>     | <duration> | <fee>  | <description>         | <enrollments> |
    When the user views the statistics of programs by enrollment
    Then the program "<programName>" should have <enrollments> enrollments

    Examples:
      | programName       | duration | fee     | description          | enrollments |
      | Yoga Basics       | 30       | 50.00   | Introductory yoga    | 150         |
      | Advanced Fitness  | 60       | 100.00  | Strength and endurance| 80          |
      | Pilates           | 45       | 60.00   | Core strength        | 120         |


  Scenario Outline: Viewing programs with low enrollment
    Given the following programs have been added:
      | ProgramName       | Duration | Fee     | Description           | Enrollments |
      | <programName>     | <duration> | <fee>  | <description>         | <enrollments> |
    When the user views programs with low enrollment (less than <threshold>)
    Then the program "<programName>" should be displayed

    Examples:
      | programName       | duration | fee     | description          | enrollments | threshold |
      | Yoga Basics       | 30       | 50.00   | Introductory yoga    | 150         | 100       |
      | Advanced Fitness  | 60       | 100.00  | Strength and endurance| 80          | 100       |
      | Pilates           | 45       | 60.00   | Core strength        | 120         | 100       |
