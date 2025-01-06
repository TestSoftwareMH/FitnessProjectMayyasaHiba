package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class programExplorationTest {

    private List<mainProgram> byDifficultyLevel;
    private List<mainProgram> byFocusArea;
    private boolean result;

    @Given("User has logged in to system as client")
    public void user_has_logged_in_to_system_as_client() {
        assertTrue(!mainProgram.login("Client"));
        mainProgram.initializePrograms();
    }


    @When("The user wants to filter programs by difficulty level with following details:")
    public void theUserWantsToFilterProgramsByDifficultyLevelWithFollowingDetails(io.cucumber.datatable.DataTable dataTable) {
        mainProgram.addPro();
        result=false;
        byDifficultyLevel=new ArrayList<mainProgram>();
        List<Map<String,String>> diffDetails=dataTable.asMaps(String.class,String.class);
        for(Map<String,String> detail:diffDetails) {
            byDifficultyLevel = mainProgram.filterByDifficultyLevel(detail.get("Difficulty level"));
            assertEquals(diffDetails.size(), byDifficultyLevel.size());
            result=true;
        }
    }


    @Then("The system should display all programs with selected difficulty level")
    public void theSystemShouldDisplayAllProgramsWithSelectedDifficultyLevel() {
        assertTrue(result);
    }


    @When("The user wants to filter programs by Focus area with following details:")
    public void theUserWantsToFilterProgramsByFocusAreaWithFollowingDetails(io.cucumber.datatable.DataTable dataTable) {
        result=false;
        byFocusArea=new ArrayList<mainProgram>();
        List<Map<String,String>> goalDetails=dataTable.asMaps(String.class,String.class);
        List<List<String>> expData = dataTable.asLists();
        for(Map<String,String> detail:goalDetails) {
            byFocusArea = mainProgram.filterByFocusArea(detail.get("Goals"));
            assertEquals(expData.size(), byFocusArea.size());
            result=true;
        }
    }


    @Then("The system should display all programs with selected Focus area")
    public void theSystemShouldDisplayAllProgramsWithSelectedFocusArea() {
        assertTrue(result);
    }
}
