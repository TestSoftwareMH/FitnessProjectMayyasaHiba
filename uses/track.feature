Feature: Track active and completed programs

  Background:
    Given the system has the following programs:
      | Program Name    | Status     | Enrollments |
      | Yoga Basics     | Active     | 100         |
      | CrossFit        | Completed  | 200         |
      | Pilates         | Active     | 50          |
      | Zumba           | Completed  | 150         |

  Scenario: View all active programs
    When the user views the list of active programs
    Then the active programs should be:
      | Yoga Basics  |
      | Pilates      |

  Scenario: View all completed programs
    When the user views the list of completed programs
    Then the completed programs should be:
      | CrossFit |
      | Zumba    |

  Scenario: Check if a program is active
    When the user checks if "Yoga Basics" is active
    Then "Yoga Basics" should be active

  Scenario: Check if a program is completed
    When the user checks if "CrossFit" is completed
    Then "CrossFit" should be completed
