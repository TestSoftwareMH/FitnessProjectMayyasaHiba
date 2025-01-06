Feature: Rate and review completed programs
  As a user, I want to rate and review the fitness programs I have completed so that I can share feedback and help others.

  Scenario: Add a new rating and review for a completed program
    When the user rates the program "Yoga Basics" with a score of "5" and writes the review "Excellent program, highly recommend!"
    Then the rating and review should be added successfully



  Scenario: Add a rating with invalid data
    When the user rates the program "Yoga Basics" with a score of "6" and writes the review "Amazing!"
    Then the rating and review should not be added due to invalid data
