Feature: Deactivate accounts for instructors and clients
  As an admin,
  I want to deactivate accounts
  So that instructors and clients who are no longer active cannot access the system.
  Scenario: Successfully deactivate an instructor's account
    Given the following instructor exists:
      | ID    | Name          | Status  |
      | I123  | Mayyasa      | Active  |
    When the admin deactivates the instructor account with ID "I123"
    Then the status of the instructor account with ID "I123" should be "Inactive"
  Scenario: Successfully deactivate a client's account
    Given the following client exists:
      | ID    | Name          | Status  |
      | C456  | Omar    | Active  |
    When the admin deactivates the client account with ID "C456"
    Then the status of the client account with ID "C456" should be "Inactive"
  Scenario: Attempt to deactivate a non-existent account
    When the admin attempts to deactivate an account with ID "X999"
    Then the system should display an error message "Account not found or already deactivated."