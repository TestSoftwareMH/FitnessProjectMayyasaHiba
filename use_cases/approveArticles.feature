Feature: Approve articles or tips shared on health and wellness
  Background:
    Given the system has the following articles or tips:
      | Article Name          | Status   |
      | Healthy Eating Tips   | Pending  |
      | Morning Yoga Routine  | Pending  |
      | Stress Management     | Approved |
      | Benefits of Hydration | Rejected |
  Scenario: View all pending articles or tips
    When the user views the list of pending articles or tips
    Then the pending articles or tips should be:
      | Healthy Eating Tips |
      | Morning Yoga Routine |
  Scenario: View all approved articles or tips
    When the user views the list of approved articles or tips
    Then the approved articles or tips should be:
      | Stress Management |
  Scenario: View all rejected articles or tips
    When the user views the list of rejected articles or tips
    Then the rejected articles or tips should be:
      | Benefits of Hydration |
  Scenario: Approve an article or tip
    When the user approves the article "Healthy Eating Tips"
    Then the status of "Healthy Eating Tips" should be "Approved"
  Scenario: Reject an article or tip
    When the user rejects the article "Morning Yoga Routine"
    Then the status of "Morning Yoga Routine" should be "Rejected"