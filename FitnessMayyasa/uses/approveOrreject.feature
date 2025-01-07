Feature: Approve or Reject Wellness Content
  Background:
    Given the system has the following shared content:
      | Content Title       | Type       | Author       | Status   |
      | Healthy Breakfast   | Recipe     | Alice        | Pending  |
      | Meditation Tips     | Tips       | Bob          | Pending  |
      | Yoga for Beginners  | Article    | Charlie      | Approved |
      | Vegan Desserts      | Recipe     | Dana         | Rejected |
  Scenario: View all pending content
    When the user views the list of pending content
    Then the pending content should be:
      | Healthy Breakfast |
      | Meditation Tips   |
  Scenario: Approve a pending recipe
    When the user approves the content "Healthy Breakfast"
    Then "Healthy Breakfast" should have the status "Approved"
  Scenario: Reject a pending tip
    When the user rejects the content "Meditation Tips"
    Then "Meditation Tips" should have the status "Rejected"
  Scenario: Check the status of an article
    When the user checks the status of "Yoga for Beginners"
    Then "Yoga for Beginners" should have the status "Approved"