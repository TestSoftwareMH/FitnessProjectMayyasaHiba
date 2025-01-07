Feature: Monitor User Activity and Engagement Statistics
  Scenario: Admin views user activity statistics
    Given the following users are registered:
      | UserID  | Name    | Email              | LastLogin       |
      | user001 | Sarah  | sarah@email.com    | 2024-12-09 10:00 |
      | user002 | ahmad   | ahmad@email.com     | 2024-12-09 09:00 |
    When the admin views the user activity statistics
    Then the system should display the number of active users
    And the system should display the most recent login timestamps for each user
  Scenario: Admin views user engagement statistics
    Given the following users have made the following number of actions:
      | UserID  | Name    | ActionsTaken |
      | user001 | Sarah  | 5           |
      | user002 | ahmad   | 3           |
    When the admin views the user engagement statistics
    Then the system should display the number of actions taken by each user
    And the system should display the total number of actions taken across all users
  Scenario: Admin receives engagement insights for active users
    Given the following active users have participated in various actions:
      | UserID  | Name    | ActionsTaken |
      | user001 | Sarah  | 5           |
      | user002 | ahmad   | 3           |
    When the admin views the engagement insights for active users
    Then the system should display insights such as the most engaged user and their actions
    And the system should highlight users who have the highest engagement rate