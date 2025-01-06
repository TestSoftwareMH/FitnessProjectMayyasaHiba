Feature: Submit improvement suggestions to instructors
  As a user, I want to submit improvement suggestions for fitness programs so that instructors can make enhancements.

  Scenario: Submit a valid improvement suggestion
    When the user submits an improvement suggestion for the program "Yoga Basics" with the message "Add more advanced poses for experienced practitioners."
    Then the suggestion should be submitted successfully


  Scenario: Submit an empty improvement suggestion
    When the user submits an improvement suggestion for the program "Yoga Basics" with the message ""
    Then the suggestion should not be submitted due to empty content


