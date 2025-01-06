package teest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class rate {

    private Map<String, Map<String, Object>> programRatings = new HashMap<String, Map<String, Object>>();
    private String errorMessage = "";
    private Map<String, String> ratingsAndReviews = new HashMap<>();

    @Given("the program {string} exists")
    public void theProgramExists(String programName) {
        // Ensure the program is in the system with no ratings initially
        if (!programRatings.containsKey(programName)) {
            programRatings.put(programName, new HashMap<>());
            System.out.println("Program added: " + programName + " (initial state, no ratings or reviews).");
        }
    }

    @When("the user rates the program {string} with a score of {string} and writes the review {string}")
    public void theUserRatesTheProgramWithAScoreOfAndWritesTheReview(String programName, String score, String review) {
        try {
            int rating = Integer.parseInt(score);
            if (rating < 1 || rating > 5) {
                errorMessage = "Invalid rating. Rating must be between 1 and 5.";
            } else if (review == null || review.trim().isEmpty()) {
                errorMessage = "Review cannot be empty.";
            } else {
                // Initialize program data if not present
                programRatings.putIfAbsent(programName, new HashMap<>());
                Map<String, Object> programData = programRatings.get(programName);
                programData.put("Rating", rating);
                programData.put("Review", review);

                System.out.println("Added rating and review: " + programName + " - " + rating + ", " + review);
            }
        } catch (NumberFormatException e) {
            errorMessage = "Invalid score. Score must be a number.";
        }
    }



    @Then("the rating and review should be added successfully")
    public void theRatingAndReviewShouldBeAddedSuccessfully() {
        assertEquals("Error while adding rating/review: " + errorMessage, "", errorMessage);
        System.out.println("Rating and review added successfully.");
    }



    @Then("the rating and review should not be added due to invalid data")
    public void theRatingAndReviewShouldNotBeAddedDueToInvalidData() {
        assertEquals("Expected error, but rating/review was added.", true, errorMessage != null && !errorMessage.isEmpty());
        System.out.println("Error while adding rating/review: " + errorMessage);
    }
}
