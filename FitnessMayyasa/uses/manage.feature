Feature: Manage subscription plans for clients and instructors
  Background:
    Given the system has the following subscription plans:
      | Plan Name | Type        | Monthly Fee | Features                           |
      | Basic     | Client      | 20          | Access to group classes           |
      | Premium   | Client      | 50          | Group classes and personal trainer |
      | Standard  | Instructor  | 30          | Create up to 10 programs          |
      | Pro       | Instructor  | 60          | Unlimited programs and analytics  |
  Scenario: View all client subscription plans
    When the user views the list of client subscription plans
    Then the client subscription plans should be:
      | Basic   |
      | Premium |
  Scenario: View all instructor subscription plans
    When the user views the list of instructor subscription plans
    Then the instructor subscription plans should be:
      | Standard |
      | Pro      |
  Scenario: Check if a plan is available for clients
    When the user checks if "Basic" is a client plan
    Then "Basic" should be a client plan
  Scenario: Check if a plan is available for instructors
    When the user checks if "Pro" is an instructor plan
    Then "Pro" should be an instructor plan