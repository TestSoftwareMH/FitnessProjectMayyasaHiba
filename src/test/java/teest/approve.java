package teest;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mainpack.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class approve {

    private InstructorService instructorService;
    private String approvalStatusMessage;

    public approve() {
        this.instructorService = new InstructorService(); // Simulated service layer
    }

    @Given("the following instructor registration requests exist:")
    public void theFollowingInstructorRegistrationRequestsExist(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps();
        for (Map<String, String> row : rows) {
            String id = row.get("ID");
            String name = row.get("Name");
            String email = row.get("Email");
            String phone = row.get("Phone");
            String status = row.get("Status");
            instructorService.addInstructorRegistration(new Instructor(id, name, email, phone, status));
        }
    }

    @When("the admin approves the instructor registration with ID {string}")
    public void theAdminApprovesTheInstructorRegistrationWithID(String instructorId) {
        Instructor instructor = instructorService.findInstructorById(instructorId);
        if (instructor != null) {
            instructorService.approveInstructorRegistration(instructorId);
            approvalStatusMessage = "Approved";
        } else {
            approvalStatusMessage = "Instructor registration not found.";
        }
    }

    @When("the admin rejects the instructor registration with ID {string}")
    public void theAdminRejectsTheInstructorRegistrationWithID(String instructorId) {
        Instructor instructor = instructorService.findInstructorById(instructorId);
        if (instructor != null) {
            instructorService.rejectInstructorRegistration(instructorId);
            approvalStatusMessage = "Rejected";
        } else {
            approvalStatusMessage = "Instructor registration not found.";
        }
    }

    @Then("the status of the instructor registration with ID {string} should be {string}")
    public void theStatusOfTheInstructorRegistrationWithIDShouldBe(String instructorId, String expectedStatus) {
        String actualStatus = instructorService.getInstructorStatus(instructorId);
        assertEquals("Expected: " + expectedStatus + " but got: " + actualStatus, expectedStatus, actualStatus);
    }
}


