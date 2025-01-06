package teest;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import static org.junit.Assert.assertEquals;

import java.util.*;

public class submit {

    private Map<String, List<String>> improvementSuggestions = new HashMap<String, List<String>>();
    private String errorMessage = "";
    @Given("the program {string} has improvement suggestions")
    public void theProgramHasImprovementSuggestions(String programName) {
        // Add some initial improvement suggestions for the program
        improvementSuggestions.put(programName, Collections.singletonList("Add more advanced poses for experienced practitioners."));
        improvementSuggestions.put(programName, Collections.singletonList("Include a cooldown/stretching session at the end."));

        System.out.println("Improvement suggestions added for " + programName);
    }

    @When("the user submits an improvement suggestion for the program {string} with the message {string}")
    public void theUserSubmitsAnImprovementSuggestionForTheProgramWithTheMessage(String programName, String message) {
        // Check if the message is empty
        if (message == null || message.trim().isEmpty()) {
            errorMessage = "Suggestion message cannot be empty.";
        } else {
            // Initialize the list if no suggestions exist yet for the program
            improvementSuggestions.putIfAbsent(programName, new ArrayList<String>());

            // Add the suggestion to the list
            improvementSuggestions.get(programName).add(message);
            System.out.println("Improvement suggestion submitted for " + programName + ": " + message);
        }
    }

    @Then("the suggestion should be submitted successfully")
    public void theSuggestionShouldBeSubmittedSuccessfully() {
        // Assert that there is no error message
        assertEquals("Error while submitting suggestion: " + errorMessage, "", errorMessage);

        // Confirmation of successful submission
        System.out.println("Suggestion submitted successfully.");
    }






    @Then("the suggestion should not be submitted due to empty content")
    public void theSuggestionShouldNotBeSubmittedDueToEmptyContent() {
        // Assert that there is an error message
        assertEquals("Expected error, but suggestion was submitted.", true, errorMessage != null && !errorMessage.isEmpty());

        System.out.println("Error while submitting suggestion: " + errorMessage);
    }

}
