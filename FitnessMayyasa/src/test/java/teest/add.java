package teest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
public class add {
    private Map<String, Object> addedProgram = new HashMap<>();
    private boolean isProgramAddedSuccessfully = false;
    private String errorMessage = "";
    // Step for providing program details (valid case)
    @When("the user provides the following program details:")
    public void theUserProvidesTheFollowingProgramDetails(DataTable dataTable) {
        Map<String, String> programDetails = dataTable.asMap(String.class, String.class);
        try {
            String programName = programDetails.get("ProgramName");
            String programType = programDetails.get("ProgramType");
            int duration = Integer.parseInt(programDetails.get("Duration"));
            String instructor = programDetails.get("Instructor");
            String startDate = programDetails.get("StartDate");
            addedProgram.put("ProgramName", programName);
            addedProgram.put("ProgramType", programType);
            addedProgram.put("Duration", duration);
            addedProgram.put("Instructor", instructor);
            addedProgram.put("StartDate", startDate);
            isProgramAddedSuccessfully = true;
        } catch (Exception e) {
            isProgramAddedSuccessfully = false;
            errorMessage = e.getMessage();
        }
    }
    // Step for successfully adding a program (valid case)
    @Then("the program should be added successfully")
    public void theProgramShouldBeAddedSuccessfully() {
        Assert.assertTrue("Program was not added successfully!", isProgramAddedSuccessfully);
        assertFalse("Added program details are empty!", addedProgram.isEmpty());
        System.out.println("Program added successfully: " + addedProgram);
    }
    // Step for adding a program with invalid duration format
    @When("the user tries to add a program with these details:")
    public void theUserTriesToAddAProgramWithInvalidDetails(DataTable dataTable) {
        Map<String, String> programDetails = dataTable.asMap(String.class, String.class);
        try {
            String programName = programDetails.get("ProgramName");
            String durationStr = programDetails.get("Duration");
            // Validate invalid duration
            if (durationStr != null && !durationStr.matches("\\d+")) {
                throw new IllegalArgumentException("Invalid duration format");
            }
            // Check for other details and add them to the map
            String fee = programDetails.get("Fee");
            String description = programDetails.get("Description");
            if (programName == null || programName.isEmpty() ||
                    durationStr == null || durationStr.isEmpty() ||
                    fee == null || fee.isEmpty() ||
                    description == null || description.isEmpty()) {
                isProgramAddedSuccessfully = false;
                errorMessage = "All fields are required";
                return;  // Exit if validation fails
            }
            // Add valid details to the map
            addedProgram.put("ProgramName", programName);
            addedProgram.put("Duration", durationStr);
            addedProgram.put("Fee", fee);
            addedProgram.put("Description", description);
            isProgramAddedSuccessfully = true;
        } catch (IllegalArgumentException e) {
            isProgramAddedSuccessfully = false;
            errorMessage = e.getMessage();
        }
    }
    // Step to ensure program is not added
    @Then("the program should not be added")
    public void theProgramShouldNotBeAdded() {
        assertFalse("Program was added despite errors!", isProgramAddedSuccessfully);
        System.out.println("Program was not added. Error: " + errorMessage);
    }
    // Step to verify error message for invalid duration format
    @Then("the system should display an error {string}")
    public void theSystemShouldDisplayAnError(String expectedError) {
        assertEquals("Error message did not match!", expectedError, errorMessage);
        System.out.println("Error displayed: " + errorMessage);
    }
    // Step for adding a program with incomplete details
    @When("the user tries to add a program with incomplete details:")
    public void theUserTriesToAddAProgramWithIncompleteDetails(DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        // Process each row in the List
        for (Map<String, String> programDetails : programDetailsList) {
            try {
                String programName = programDetails.get("ProgramName");
                String durationStr = programDetails.get("Duration");
                String fee = programDetails.get("Fee");
                String description = programDetails.get("Description");
                // Check for missing fields
                if (programName == null || programName.isEmpty() ||
                        durationStr == null || durationStr.isEmpty() ||
                        fee == null || fee.isEmpty() ||
                        description == null || description.isEmpty()) {
                    // Set error flag and message
                    isProgramAddedSuccessfully = false;
                    errorMessage = "All fields are required";
                    return;
                }
                // If all fields are valid, add program details to the map
                addedProgram.put("ProgramName", programName);
                addedProgram.put("Duration", durationStr);
                addedProgram.put("Fee", fee);
                addedProgram.put("Description", description);
                isProgramAddedSuccessfully = true;
            } catch (Exception e) {
                isProgramAddedSuccessfully = false;
                errorMessage = e.getMessage();
            }
        }
    }
    // Step for adding program with invalid details (empty program name)
    @When("the user tries to add a program with invalid details:")
    public void theUserTriesToAddAProgramWithInvalidDetails2(DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        try {
            // Process each row in the List
            for (Map<String, String> programDetails : programDetailsList) {
                String programName = programDetails.get("ProgramName");
                String durationStr = programDetails.get("Duration");
                // Check for missing or invalid fields
                if (programName == null || programName.isEmpty()) {
                    throw new IllegalArgumentException("Program name is required");
                }
                if (durationStr == null || durationStr.isEmpty() || !durationStr.matches("\\d+")) {
                    throw new IllegalArgumentException("Invalid details provided");
                }
                addedProgram.put("ProgramName", programName);
                addedProgram.put("Duration", durationStr);
                isProgramAddedSuccessfully = true; // Though this should not happen in invalid cases
            }
        } catch (IllegalArgumentException e) {
            isProgramAddedSuccessfully = false;
            errorMessage = e.getMessage();
        }
    }
    // Step to ensure invalid details result in not adding the program
    @Then("the program should nott be added")
    public void theProgramShouldNottBeAdded() {
        assertFalse("Program was added despite errors!", isProgramAddedSuccessfully);
        assertEquals("Invalid details provided", errorMessage);
        System.out.println("Error displayed: " + errorMessage);
    }
}