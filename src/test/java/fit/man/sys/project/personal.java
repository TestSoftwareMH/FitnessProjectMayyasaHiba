package fit.man.sys.project;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class personal {
    private Map<String, String> milestones = new HashMap<>();
    private String validationError = "";
    @Given("the user has the following milestones:")
    public void theUserHasTheFollowingMilestones(DataTable dataTable) {
        milestones.clear(); // Clear existing milestones before adding new ones
        Map<String, String> initialMilestones = dataTable.asMap(String.class, String.class);
        milestones.putAll(initialMilestones);
        System.out.println("Initialized milestones: " + milestones);
    }
    @Given("the user has no milestones")
    public void theUserHasNoMilestones() {
        // Clear all milestones to simulate the user having no milestones
        milestones.clear();
        validationError = ""; // Reset any previous validation errors
        System.out.println("All milestones have been cleared. The user has no milestones.");
    }
    @When("the user adds a new milestone with the following details:")
    public void theUserAddsANewMilestoneWithTheFollowingDetails(DataTable dataTable) {
        validationError = "";  // Reset the error before processing new data
        // Skip the header row by treating the data as a list of lists
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String milestone = row.get("Milestone");
            String value = row.get("Value");
            boolean isValid = true; // Track if the milestone is valid
            // Validation for milestones
            if (milestone.equalsIgnoreCase("Weight")) {
                if (value.matches("-?\\d+ kg")) {
                    int weight = Integer.parseInt(value.split(" ")[0]);
                    if (weight < 0) {
                        validationError = "Weight must be a non-negative number.";
                        isValid = false;
                    } else {
                        milestones.put(milestone, value);
                    }
                } else {
                    validationError = "Invalid weight format.";
                    isValid = false;
                }
            } else if (milestone.equalsIgnoreCase("BMI")) {
                if (value.matches("\\d+(\\.\\d+)?")) {
                    double bmi = Double.parseDouble(value);
                    if (bmi <= 0) {
                        validationError = "BMI must be a positive number.";
                        isValid = false;
                    } else {
                        milestones.put(milestone, value);
                    }
                } else {
                    validationError = "Invalid BMI format.";
                    isValid = false;
                }
            } else if (milestone.equalsIgnoreCase("Attendance")) {
                if (value.matches("\\d+ days")) {
                    int attendance = Integer.parseInt(value.split(" ")[0]);
                    if (attendance < 0) {
                        validationError = "Attendance must be a non-negative number.";
                        isValid = false;
                    } else {
                        milestones.put(milestone, value);
                    }
                } else {
                    validationError = "Invalid attendance format.";
                    isValid = false;
                }
            } else {
                validationError = "Invalid milestone type: " + milestone;
                isValid = false;
            }
            // Stop further checks if an error occurred
            if (!isValid) {
                break;
            }
        }
    }
    @Then("the milestone should be added successfully")
    public void theMilestoneShouldBeAddedSuccessfully() {
        assertEquals("Milestone was not added successfully. Error: " + validationError, "", validationError);
        System.out.println("Milestones added successfully: " + milestones);
    }
    @When("the user views their fitness milestones")
    public void theUserViewsTheirFitnessMilestones() {
        System.out.println("Current milestones: " + milestones);
    }
    @Then("the milestones should be:")
    public void theMilestonesShouldBe(DataTable dataTable) {
        Map<String, String> expectedMilestones = dataTable.asMap(String.class, String.class);
        assertEquals("Milestones do not match.", expectedMilestones, milestones);
        System.out.println("Milestones match the expected data.");
    }
    @When("the user updates the milestone {string} to {string}")
    public void theUserUpdatesTheMilestoneTo(String milestone, String newValue) {
        if (milestones.containsKey(milestone)) {
            milestones.put(milestone, newValue);
        } else {
            throw new AssertionError("Milestone " + milestone + " does not exist.");
        }
    }
    @Then("the milestone should be updated successfully")
    public void theMilestoneShouldBeUpdatedSuccessfully() {
        System.out.println("Milestone updated successfully: " + milestones);
    }
}
