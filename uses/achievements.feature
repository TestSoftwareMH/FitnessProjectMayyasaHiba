Feature: View achievements or badges
  As a user, I want to view achievements or badges for completing fitness programs so that I can celebrate my progress and stay motivated.

  Scenario: View achievements for completed programs
    Given the user has the following achievements:
      | Program          | Achievement Badge       |
      | Weight Loss      | Gold Star              |
      | Strength Training| Iron Champion          |
      | Yoga Basics      | Zen Master             |
    When the user views their achievements
    Then the achievements should be:
      | Program          | Achievement Badge       |
      | Weight Loss      | Gold Star              |
      | Strength Training| Iron Champion          |
      | Yoga Basics      | Zen Master             |

  Scenario: Add a new achievement
    When the user adds a new achievement for the program "Cardio Blast" with the badge "Heart Racer"
    Then the achievement should be added successfully

  Scenario: Update an existing achievement badge
    Given the user has the following achievements:
      | Program          | Achievement Badge       |
      | Yoga Basics      | Zen Master             |
    When the user updates the badge for the program "Yoga Basics" to "Yoga Guru"
    Then the badge should be updated successfully

  Scenario: Add an invalid achievement
    When the user adds a new achievement for the program "Strength Training" with the badge ""
    Then the achievement should not be added due to invalid data
