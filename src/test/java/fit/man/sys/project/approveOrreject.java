package fit.man.sys.project;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.datatable.DataTable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class approveOrreject {
    // Explicitly specifying the types for the Map
    private Map<String, String> contentStatus = new HashMap<String, String>();
    @Given("the system has the following shared content:")
    public void theSystemHasTheFollowingSharedContent(DataTable dataTable) {
        // Populate contentStatus map with the content titles and their statuses
        List<Map<String, String>> contentData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : contentData) {
            String contentTitle = row.get("Content Title");
            String status = row.get("Status");
            contentStatus.put(contentTitle, status);
        }
        System.out.println("System initialized with shared content: " + contentStatus);
    }
    @When("the user views the list of pending content")
    public void theUserViewsTheListOfPendingContent() {
        // Simulate fetching pending content
        // contentStatus map is already populated from the Given step
    }
    @Then("the pending content should be:")
    public void thePendingContentShouldBe(DataTable dataTable) {
        List<String> expectedPendingContent = dataTable.asList(String.class);
        for (String content : expectedPendingContent) {
            if (!"Pending".equals(contentStatus.get(content))) {
                throw new AssertionError("Content " + content + " is not pending.");
            }
        }
        System.out.println("Verified pending content: " + expectedPendingContent);
    }
    @When("the user approves the content {string}")
    public void theUserApprovesTheContent(String contentTitle) {
        // Simulate approving content
        if (contentStatus.containsKey(contentTitle)) {
            contentStatus.put(contentTitle, "Approved");
        } else {
            throw new AssertionError("Content " + contentTitle + " not found.");
        }
    }
    @Then("{string} should have the status {string}")
    public void shouldHaveTheStatus(String contentTitle, String expectedStatus) {
        String actualStatus = contentStatus.get(contentTitle);
        if (!expectedStatus.equals(actualStatus)) {
            throw new AssertionError("Expected status for " + contentTitle + ": " + expectedStatus + ", but got: " + actualStatus);
        }
        System.out.println("Verified status for " + contentTitle + ": " + expectedStatus);
    }
    @When("the user rejects the content {string}")
    public void theUserRejectsTheContent(String contentTitle) {
        // Simulate rejecting content
        if (contentStatus.containsKey(contentTitle)) {
            contentStatus.put(contentTitle, "Rejected");
        } else {
            throw new AssertionError("Content " + contentTitle + " not found.");
        }
    }
    @When("the user checks the status of {string}")
    public void theUserChecksTheStatusOf(String contentTitle) {
        if (!contentStatus.containsKey(contentTitle)) {
            throw new AssertionError("Content " + contentTitle + " not found.");
        }
        System.out.println("Status of " + contentTitle + ": " + contentStatus.get(contentTitle));
    }
}
