Feature: Track personal fitness milestones
  As a user, I want to track my personal fitness milestones so that I can monitor my progress.

  Scenario: Add a new fitness milestone
    Given the user has no milestones
    When the user adds a new milestone with the following details:
      | Milestone   | Value    |
      | Weight      | 70 kg    |
      | BMI         | 23.5     |
      | Attendance  | 15 days  |
    Then the milestone should be added successfully

  Scenario: View existing fitness milestones
    Given the user has the following milestones:
      | Milestone   | Value  |
      | Weight      | 70 kg  |
      | BMI         | 23.5   |
      | Attendance  | 15 days |
    When the user views their fitness milestones
    Then the milestones should be:
      | Milestone   | Value  |
      | Weight      | 70 kg  |
      | BMI         | 23.5   |
      | Attendance  | 15 days |

  Scenario: Update an existing milestone
    Given the user has the following milestones:
      | Milestone   | Value  |
      | Weight      | 70 kg  |
    When the user updates the milestone "Weight" to "68 kg"
    Then the milestone should be updated successfully
