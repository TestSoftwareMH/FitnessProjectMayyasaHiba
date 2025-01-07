Feature: Handle user feedback and complaints
  Background:
    Given the system has the following feedback and complaints:
      | User Name | Feedback Type    | Feedback Content                       | Status     |
      | Alice     | Complaint        | "Program was too difficult"            | Pending    |
      | Bob       | Feedback         | "Great class, would recommend!"        | Reviewed   |
      | Carol     | Complaint        | "Instructor was late to the session"   | Pending    |
      | Dave      | Feedback         | "Loved the music selection!"           | Reviewed   |
  Scenario: View all pending complaints
    When the user views the list of pending complaints
    Then the pending complaints should be:
      | Alice     |
      | Carol     |
  Scenario: View all reviewed feedback
    When the user views the list of reviewed feedback
    Then the reviewed feedback should be:
      | Bob       |
      | Dave      |
  Scenario: Check if a user has a pending complaint
    When the user checks if "Alice" has a pending complaint
    Then "Alice" should have a pending complaint
  Scenario: Check if a user has reviewed feedback
    When the user checks if "Bob" has reviewed feedback
    Then "Bob" should have reviewed feedback