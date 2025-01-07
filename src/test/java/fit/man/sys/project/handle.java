package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.assertEquals; // Import assertEquals for validation
import java.util.*;

public class handle {
    private Map<String, String> pendingComplaints = new HashMap<String, String>();
    private Map<String, String> reviewedFeedback = new HashMap<String, String>();
    private String currentComplaintStatus = null;
    private String currentFeedbackStatus = null;
    public handle() {
        // Initializing with sample data
        pendingComplaints.put("Complaint1", "Pending");
        pendingComplaints.put("Complaint2", "Pending");
        reviewedFeedback.put("Feedback1", "Reviewed");
        reviewedFeedback.put("Feedback2", "Reviewed");
    }
    @Given("the system has the following feedback and complaints:")
    public void theSystemHasTheFollowingFeedbackAndComplaints(DataTable dataTable) {
        // Clear previous data (if any)
        pendingComplaints.clear();
        reviewedFeedback.clear();
        // Transform DataTable into a list of maps for each entry
        List<Map<String, String>> feedbackAndComplaints = dataTable.asMaps(String.class, String.class);
        // Initialize pending complaints and reviewed feedback from the dataTable
        for (Map<String, String> entry : feedbackAndComplaints) {
            String userName = entry.get("User Name");
            String feedbackType = entry.get("Feedback Type");
            String content = entry.get("Feedback Content");
            String status = entry.get("Status");
            // Add to the appropriate map based on feedback type and status
            if ("Complaint".equalsIgnoreCase(feedbackType)) {
                pendingComplaints.put(userName, status);
            } else if ("Feedback".equalsIgnoreCase(feedbackType)) {
                reviewedFeedback.put(userName, status);
            }
        }
        // Log the initialized data
        System.out.println("System initialized with feedback and complaints: ");
        System.out.println("Pending Complaints: " + pendingComplaints);
        System.out.println("Reviewed Feedback: " + reviewedFeedback);
    }
    @When("the user views the list of pending complaints")
    public void theUserViewsTheListOfPendingComplaints() {
        System.out.println("Pending Complaints: " + pendingComplaints.keySet());
    }
    @Then("the pending complaints should be:")
    public void thePendingComplaintsShouldBe(DataTable dataTable) {
        List<String> expectedComplaints = dataTable.asList(String.class);
        // Check if expected complaints are in the pending complaints list
        assertEquals("Pending complaints mismatch!", expectedComplaints.size(), pendingComplaints.size());
        for (String complaint : expectedComplaints) {
            assertEquals("Complaint " + complaint + " not found in pending complaints.", "Pending", pendingComplaints.get(complaint));
        }
        System.out.println("Pending complaints match expected list.");
    }
    @When("the user views the list of reviewed feedback")
    public void theUserViewsTheListOfReviewedFeedback() {
        System.out.println("Reviewed Feedback: " + reviewedFeedback.keySet());
    }
    @Then("the reviewed feedback should be:")
    public void theReviewedFeedbackShouldBe(DataTable dataTable) {
        List<String> expectedFeedback = dataTable.asList(String.class);
        // Check if expected feedback are in the reviewed feedback list
        assertEquals("Reviewed feedback mismatch!", expectedFeedback.size(), reviewedFeedback.size());
        for (String feedback : expectedFeedback) {
            assertEquals("Feedback " + feedback + " not found in reviewed feedback.", "Reviewed", reviewedFeedback.get(feedback));
        }
        System.out.println("Reviewed feedback matches expected list.");
    }
    @When("the user checks if {string} has a pending complaint")
    public void theUserChecksIfHasAPendingComplaint(String complaintId) {
        currentComplaintStatus = pendingComplaints.get(complaintId);
    }
    @Then("{string} should have a pending complaint")
    public void shouldHaveAPendingComplaint(String complaintId) {
        // Ensure that the complaint status is "Pending"
        assertEquals(complaintId + " does not have a pending complaint.", "Pending", currentComplaintStatus);
        System.out.println(complaintId + " has a pending complaint.");
    }
    @When("the user checks if {string} has reviewed feedback")
    public void theUserChecksIfHasReviewedFeedback(String feedbackId) {
        currentFeedbackStatus = reviewedFeedback.get(feedbackId);
    }
    @Then("{string} should have reviewed feedback")
    public void shouldHaveReviewedFeedback(String feedbackId) {
        // Ensure that the feedback status is "Reviewed"
        assertEquals(feedbackId + " does not have reviewed feedback.", "Reviewed", currentFeedbackStatus);
        System.out.println(feedbackId + " has reviewed feedback.");
    }
}
