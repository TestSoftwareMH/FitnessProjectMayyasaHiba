package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class accountManagementTest {

    private List<Map<String, String>> accounts;
    private boolean result;

    @Given("User wants to create new account")
    public void user_wants_to_create_new_account() {
        accounts = new ArrayList<Map<String, String>>();
    }


    @When("The user provides the following details:")
    public void the_user_provides_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        accounts=dataTable.asMaps(String.class,String.class);
        for(Map<String, String> account:accounts)
            mainProgram.createAccount(account);
    }


    @Then("The account should be created successfully")
    public void the_account_should_be_created_successfully() {
        for(Map<String, String> account:accounts) {
            Map<String, String> createdAccount = mainProgram.getAccountDet(account.get("Email"));
            assertNotNull("Account creation failed", createdAccount);
            assertEquals("Creation incomplete", account, createdAccount);
            mainProgram.createAccount(account);
        }
    }


    @Given("The user already has an account")
    public void theUserAlreadyHasAnAccount() {
        // mainProgram.initializePrograms();
    }


    @When("User put user name {string} and password in true and has the following details:")
    public void userPutUserNameAndPasswordInTrueAndHasTheFollowingDetails(String email, io.cucumber.datatable.DataTable dataTable) {
        result=false;
        Map<String, String> loggedAccount = mainProgram.getAccountDet(email);
        List<Map<String, String>> expDetailsList=dataTable.asMaps(String.class,String.class);
        for(Map<String, String> expDetails:expDetailsList) {
            assertNotNull("Account does not exist", loggedAccount);
            assertEquals("Invalid username", expDetails.get("Client name"), loggedAccount.get("Client name"));
            assertEquals("Invalid password", expDetails.get("Password"), loggedAccount.get("Password"));
            assertEquals("Invalid phone number", expDetails.get("Phone number"), loggedAccount.get("Phone number"));
            assertEquals("Invalid age", expDetails.get("Age"), loggedAccount.get("Age"));
            assertEquals("Invalid weight", expDetails.get("Weight"), loggedAccount.get("Weight"));
            result =true;
        }
    }


    @Then("The account should be open and the details should be shown")
    public void theAccountShouldBeOpenAndTheDetailsShouldBeShown() {
        assertTrue("Fail to open the account", result);
    }


    @Given("User logged in as client")
    public void user_logged_in_as_client() {
        assertTrue(!mainProgram.login("Client"));
    }


    @When("The user {string} wants to view dietary preferences or restrictions with the following details:")
    public void theUserWantsToViewDietaryPreferencesOrRestrictionsWithTheFollowingDetails(String email, io.cucumber.datatable.DataTable dataTable) {
        result=false;
        Map<String, String> loggedAccount = mainProgram.getAccountDet(email);
        List<Map<String, String>> expDetailsList=dataTable.asMaps(String.class,String.class);
        for(Map<String, String> expDetails:expDetailsList) {
            assertNotNull("Account does not exist", loggedAccount);
            assertEquals("Invalid dietary preferences", expDetails.get("Dietary preferences"), loggedAccount.get("Dietary preferences"));
            assertEquals("Invalid restrictions", expDetails.get("Restrictions"), loggedAccount.get("Restrictions"));
            result =true;
        }
    }


    @Then("The system should display the details")
    public void theSystemShouldDisplayTheDetails() {
        assertTrue("Fail to view", result);
    }
}
