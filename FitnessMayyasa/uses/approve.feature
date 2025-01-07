Feature: Approve New Instructor Registrations
  Scenario: Admin approves a new instructor registration
    Given the following instructor registration requests exist:
      | ID       | Name        | Email              | Phone         | Status     |
      | inst001  | omar   | omar@email.com | 123-456-7890  | Pending    |
    When the admin approves the instructor registration with ID "inst001"
    Then the status of the instructor registration with ID "inst001" should be "Approved"
  Scenario: Admin rejects a new instructor registration
    Given the following instructor registration requests exist:
      | ID       | Name        | Email              | Phone         | Status     |
      | inst002  | eyad  | eyad@email.com | 987-654-3210 | Pending    |
    When the admin rejects the instructor registration with ID "inst002"
    Then the status of the instructor registration with ID "inst002" should be "Rejected"