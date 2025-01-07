package fit.man.sys.project;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class achievements {
    private Map<String, String> achievementMap = new HashMap<String, String>();
    private String errorMessage;

    @Given("the user has the following achievements:")
    public void theUserHasTheFollowingAchievements(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> row : rows) {
            String program = row.get(0);
            String badge = row.get(1);
            achievementMap.put(program, badge);
        }
        System.out.println("Achievements initialized: " + achievementMap);
    }

    @When("the user views their achievements")
    public void theUserViewsTheirAchievements() {
        // Simulated viewing of achievements
        System.out.println("Viewing achievements: " + achievementMap);
    }

    @Then("the achievements should be:")
    public void theAchievementsShouldBe(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> row : rows) {
            String program = row.get(0);
            String badge = row.get(1);
            // Validate achievement
            assertEquals("Achievement mismatch for program: " + program, badge, achievementMap.get(program));
        }
    }

    @When("the user adds a new achievement for the program {string} with the badge {string}")
    public void theUserAddsANewAchievementForTheProgramWithTheBadge(String program, String badge) {
        if (badge == null || badge.trim().isEmpty()) {
            errorMessage = "Invalid badge data";
        } else {
            achievementMap.put(program, badge);
            errorMessage = null;
        }
    }

    @Then("the achievement should be added successfully")
    public void theAchievementShouldBeAddedSuccessfully() {
        // Assert that there is no error message
        assertEquals("Achievement was not added: " + errorMessage, null, errorMessage);
    }

    @When("the user updates the badge for the program {string} to {string}")
    public void theUserUpdatesTheBadgeForTheProgramTo(String program, String newBadge) {
        if (achievementMap.containsKey(program)) {
            achievementMap.put(program, newBadge);
            errorMessage = null;
        } else {
            errorMessage = "Program not found";
        }
    }

    @Then("the badge should be updated successfully")
    public void theBadgeShouldBeUpdatedSuccessfully() {
        // Assert that there is no error message
        assertEquals("Badge was not updated: " + errorMessage, null, errorMessage);
    }

    @Then("the achievement should not be added due to invalid data")
    public void theAchievementShouldNotBeAddedDueToInvalidData() {
        // Assert that an error message exists
        assertEquals("Invalid achievement data was accepted.", true, errorMessage != null);
    }

}
