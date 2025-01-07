package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.example.Program;
import org.example.ProgramStorage;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class update {
    private Map<String, Map<String, Object>> programsDatabase = new HashMap<>();
    private String updateStatus = "";
    private String errorMessage = "";
    private ProgramStorage programStorage = new ProgramStorage();
    public update() {
        // Initial setup: populate database with existing programs
        Map<String, Object> yogaProgram = new HashMap<>();
        yogaProgram.put("ProgramName", "Yoga Basics");
        yogaProgram.put("Duration", 30);
        yogaProgram.put("Fee", 50.0);
        yogaProgram.put("Description", "Introductory yoga");
        programsDatabase.put("Yoga Basics", yogaProgram);
        Map<String, Object> crossFitProgram = new HashMap<>();
        crossFitProgram.put("ProgramName", "CrossFit");
        crossFitProgram.put("Duration", 45);
        crossFitProgram.put("Fee", 70.0);
        crossFitProgram.put("Description", "Intense strength training");
        programsDatabase.put("CrossFit", crossFitProgram);
    }
    @Given("the following program exists:")
    public void theFollowingProgramExists(DataTable dataTable) {
        List<Map<String, String>> programList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programData : programList) {
            String programName = programData.get("ProgramName");
            String duration = programData.get("Duration");
            String fee = programData.get("Fee");
            String description = programData.get("Description");
            try {
                Program program = new Program(programName, duration, fee, description);
                programStorage.addProgram(program);
            } catch (IllegalArgumentException e) {
                System.out.println("Program was not added. Error: " + e.getMessage());
            }
        }
    }
    @When("the user updates the program with the following details:")
    public void the_user_updates_the_program_with_the_following_details(DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            String programName = programDetails.get("ProgramName");
            if (programsDatabase.containsKey(programName)) {
                Map<String, Object> program = programsDatabase.get(programName);
                program.put("Duration", Integer.parseInt(programDetails.get("Duration")));
                program.put("Fee", Double.parseDouble(programDetails.get("Fee")));
                program.put("Description", programDetails.get("Description"));
                updateStatus = "Success";
            } else {
                updateStatus = "Program not found";
            }
        }
    }
    @Then("the program should be updated successfully")
    public void the_program_should_be_updated_successfully() {
        assertEquals("Success", updateStatus);
        System.out.println("The program was updated successfully.");
    }
    @When("the user attempts to update a program with the following details:")
    public void the_user_attempts_to_update_a_program_with_the_following_details(DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            String programName = programDetails.get("ProgramName");
            if (programsDatabase.containsKey(programName)) {
                Map<String, Object> program = programsDatabase.get(programName);
                String durationStr = programDetails.get("Duration");
                String feeStr = programDetails.get("Fee");
                if (durationStr == null || durationStr.isEmpty() || feeStr == null || feeStr.isEmpty()) {
                    updateStatus = "Failure";
                    errorMessage = "Missing fields";
                } else {
                    try {
                        int duration = Integer.parseInt(durationStr);
                        double fee = Double.parseDouble(feeStr);
                        String description = programDetails.get("Description");
                        if (duration < 0 || fee < 0) {
                            updateStatus = "Failure";
                            errorMessage = "Invalid data";
                        } else {
                            program.put("Duration", duration);
                            program.put("Fee", fee);
                            program.put("Description", description);
                            updateStatus = "Success";
                        }
                    } catch (NumberFormatException e) {
                        updateStatus = "Failure";
                        errorMessage = "Invalid data";
                    }
                }
            } else {
                updateStatus = "Failure";
                errorMessage = "Program not found";
            }
        }
    }
    @Then("the program update attempt should result in the status {string}")
    public void the_program_update_attempt_should_result_in_the_status(String expectedStatus) {
        // Debugging: Print the actual values
        System.out.println("Expected status: " + expectedStatus);
        System.out.println("Actual status: " + updateStatus);
        System.out.println("Expected error message: Missing details");
        System.out.println("Actual error message: " + errorMessage);
        assertEquals(expectedStatus, updateStatus);
        System.out.println("Program update status: " + updateStatus);
    }
    @When("the user attempts to update a program with the following invalid details:")
    public void theUserAttemptsToUpdateAProgramWithTheFollowingInvalidDetails(DataTable dataTable) {
        List<Map<String, String>> programDetails = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> detail : programDetails) {
            String programName = detail.get("ProgramName");
            String durationStr = detail.get("Duration");
            String feeStr = detail.get("Fee");
            String description = detail.get("Description");
            if (programsDatabase.containsKey(programName)) {
                Map<String, Object> program = programsDatabase.get(programName);
                if (durationStr == null || durationStr.isEmpty() || feeStr == null || feeStr.isEmpty()) {
                    updateStatus = "Failure";
                    errorMessage = "Missing fields";
                } else {
                    try {
                        int duration = Integer.parseInt(durationStr);
                        double fee = Double.parseDouble(feeStr);
                        if (duration < 0 || fee < 0) {
                            updateStatus = "Failure";
                            errorMessage = "Invalid data";
                        } else {
                            program.put("Duration", duration);
                            program.put("Fee", fee);
                            program.put("Description", description);
                            updateStatus = "Success";
                        }
                    } catch (NumberFormatException e) {
                        updateStatus = "Failure";
                        errorMessage = "Invalid data";
                    }
                }
            } else {
                updateStatus = "Failure";
                errorMessage = "Program not found";
            }
        }
    }
    @Then("the system should show an error {string}")
    public void theSystemShouldShowAnError(String expectedErrorMessage) {
        if (expectedErrorMessage.equals(errorMessage)) {
            System.out.println("Error displayed: " + expectedErrorMessage);
        } else {
            throw new AssertionError("Expected error message: " + expectedErrorMessage + ", but got: " + errorMessage);
        }
    }
    @When("the user attempts to update a program with the following missing details:")
    public void theUserAttemptsToUpdateAProgramWithTheFollowingMissingDetails(DataTable dataTable) {
        List<Map<String, String>> missingDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> detail : missingDetailsList) {
            String programName = detail.getOrDefault("ProgramName", "");
            String duration = detail.getOrDefault("Duration", null);
            String fee = detail.getOrDefault("Fee", null);
            String description = detail.getOrDefault("Description", null);
            // Check if any required fields are missing
            if (programName.isEmpty() || duration == null || fee == null || description == null) {
                updateStatus = "Failure";
                errorMessage = "Missing details";
            } else {
                // Continue updating logic if no missing fields
                String result = programStorage.updateProgram(programName, duration, fee, description);
                if (!"Success".equals(result)) {
                    updateStatus = "Failure";
                    errorMessage = result;
                }
            }
        }
    }
    @Then("the program should not be updated")
    public void theProgramShouldNotBeUpdated() {
        // Debugging: Print the actual values
        System.out.println("Expected status: Failure");
        System.out.println("Actual status: " + updateStatus);
        System.out.println("Expected error message: Missing details");
        System.out.println("Actual error message: " + errorMessage);
        assertEquals("Failure", updateStatus);
        assertEquals("Missing details", errorMessage);
    }
    @Given("no program exists with the name {string}")
    public void noProgramExistsWithTheName(String programName) {
        programsDatabase.remove(programName);
        System.out.println("No program exists with the name: " + programName);
    }
}
