package teest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mainpack.AccountService;
public class deactivate {
    private Map<String, Map<String, String>> instructors = new HashMap<>();
    private Map<String, Map<String, String>> clientStore = new HashMap<>();
    private AccountService accountService = new AccountService(); // Create an AccountService instance
    private String deactivationErrorMessage;
    @Given("the following instructor exists:")
    public void theFollowingInstructorExists(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> instructorList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> instructorData : instructorList) {
            String instructorId = instructorData.get("ID");
            String name = instructorData.get("Name");
            String status = instructorData.get("Status");
            Map<String, String> instructorDetails = new HashMap<>();
            instructorDetails.put("Name", name);
            instructorDetails.put("Status", status);
            instructors.put(instructorId, instructorDetails);
        }
    }
    @Given("the following client exists:")
    public void theFollowingClientExists(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> clientList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> clientData : clientList) {
            String clientId = clientData.get("ID");
            String name = clientData.get("Name");
            String status = clientData.get("Status");
            Map<String, String> clientDetails = new HashMap<>();
            clientDetails.put("Name", name);
            clientDetails.put("Status", status);
            clientStore.put(clientId, clientDetails);
        }
    }
    @When("the admin deactivates the instructor account with ID {string}")
    public void theAdminDeactivatesTheInstructorAccountWithID(String instructorId) {
        if (instructors.containsKey(instructorId)) {
            Map<String, String> instructor = instructors.get(instructorId);
            if ("Active".equalsIgnoreCase(instructor.get("Status"))) {
                instructor.put("Status", "Inactive");
            } else {
                throw new IllegalStateException("Account is already inactive");
            }
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }
    @Then("the status of the instructor account with ID {string} should be {string}")
    public void theStatusOfTheInstructorAccountWithIDShouldBe(String instructorId, String expectedStatus) {
        if (instructors.containsKey(instructorId)) {
            String actualStatus = instructors.get(instructorId).get("Status");
            assertEquals(expectedStatus, actualStatus);
        } else {
            throw new IllegalArgumentException("Account not found");
        }
    }
    @When("the admin deactivates the client account with ID {string}")
    public void theAdminDeactivatesTheClientAccountWithID(String clientId) {
        if (!clientStore.containsKey(clientId)) {
            throw new IllegalArgumentException("Client ID not found: " + clientId);
        }
        clientStore.get(clientId).put("Status", "Inactive");
    }
    @Then("the status of the client account with ID {string} should be {string}")
    public void theStatusOfTheClientAccountWithIDShouldBe(String clientId, String expectedStatus) {
        if (!clientStore.containsKey(clientId)) {
            throw new IllegalArgumentException("Client ID not found: " + clientId);
        }
        String actualStatus = clientStore.get(clientId).get("Status");
        assertEquals(expectedStatus, actualStatus);
    }
    @When("the admin attempts to deactivate an account with ID {string}")
    public void theAdminAttemptsToDeactivateAnAccountWithID(String accountId) {
        try {
            boolean success = AccountService.deactivateAccount(accountId);
            if (!success) {
                deactivationErrorMessage = "Account not found or already deactivated.";
            }
        } catch (Exception e) {
            deactivationErrorMessage = e.getMessage();
        }
    }
    @Then("the system should display an error message {string}")
    public void theSystemShouldDisplayAnErrorMessage(String expectedMessage) {
        // Update expectedMessage to match the actual message from the deactivation method
        assertEquals("Expected: " + expectedMessage + " but got: " + deactivationErrorMessage, expectedMessage, deactivationErrorMessage);
    }
}