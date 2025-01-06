package teest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class track {

    private Map<String, String> programsStatus = new HashMap<>();
    private String statusMessage = "";

    @Given("the system has the following programs:")
    public void theSystemHasTheFollowingPrograms(DataTable dataTable) {
        List<Map<String, String>> programData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : programData) {
            String programName = row.get("Program Name");
            String status = row.get("Status");
            programsStatus.put(programName, status);
        }
        System.out.println("System initialized with programs: " + programsStatus);
    }

    @When("the user views the list of active programs")
    public void theUserViewsTheListOfActivePrograms() {
        StringBuilder activePrograms = new StringBuilder();
        for (Map.Entry<String, String> entry : programsStatus.entrySet()) {
            if ("Active".equals(entry.getValue())) {
                activePrograms.append(entry.getKey()).append("\n");
            }
        }
        statusMessage = activePrograms.toString();
    }

    @Then("the active programs should be:")
    public void theActiveProgramsShouldBe(DataTable dataTable) {
        List<String> expectedActivePrograms = dataTable.asList(String.class);
        String[] actualPrograms = statusMessage.split("\n");
        for (String expectedProgram : expectedActivePrograms) {
            boolean found = false;
            for (String actualProgram : actualPrograms) {
                if (expectedProgram.equals(actualProgram.trim())) {
                    found = true;
                    break;
                }
            }
            assertTrue("Active program " + expectedProgram + " not found.", found);
        }
        System.out.println("Active programs match expected values.");
    }

    @When("the user views the list of completed programs")
    public void theUserViewsTheListOfCompletedPrograms() {
        StringBuilder completedPrograms = new StringBuilder();
        for (Map.Entry<String, String> entry : programsStatus.entrySet()) {
            if ("Completed".equals(entry.getValue())) {
                completedPrograms.append(entry.getKey()).append("\n");
            }
        }
        statusMessage = completedPrograms.toString();
    }

    @Then("the completed programs should be:")
    public void theCompletedProgramsShouldBe(DataTable dataTable) {
        List<String> expectedCompletedPrograms = dataTable.asList(String.class);
        String[] actualPrograms = statusMessage.split("\n");
        for (String expectedProgram : expectedCompletedPrograms) {
            boolean found = false;
            for (String actualProgram : actualPrograms) {
                if (expectedProgram.equals(actualProgram.trim())) {
                    found = true;
                    break;
                }
            }
            assertTrue("Completed program " + expectedProgram + " not found.", found);
        }
        System.out.println("Completed programs match expected values.");
    }

    @When("the user checks if {string} is active")
    public void theUserChecksIfIsActive(String programName) {
        String programStatus = programsStatus.get(programName);
        statusMessage = programStatus;
    }

    @Then("{string} should be active")
    public void shouldBeActive(String programName) {
        assertEquals("Program " + programName + " should be active.", "Active", statusMessage);
    }

    @When("the user checks if {string} is completed")
    public void theUserChecksIfIsCompleted(String programName) {
        String programStatus = programsStatus.get(programName);
        statusMessage = programStatus;
    }

    @Then("{string} should be completed")
    public void shouldBeCompleted(String programName) {
        assertEquals("Program " + programName + " should be completed.", "Completed", statusMessage);
    }
}
