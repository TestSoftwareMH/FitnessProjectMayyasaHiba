package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;

import static org.junit.Assert.*;

public class interactWithClientTest {

    private String result;

    @Given("User has logged in as instructor to interact")
    public void user_has_logged_in_as_instructor_to_interact() {
        assertTrue("The user is not instructor", mainProgram.login("Instructor"));
    }


    @When("User provides feedback or progress report to {int}")
    public void userProvidesFeedbackOrProgressReportTo(int ClientID ) {
        result=mainProgram.provideFeedbackResult(ClientID);
    }


    @Then("The feedback {string} should be provided successfully to {int}")
    public void theFeedbackShouldBeProvidedSuccessfullyTo(String feedback,int ClientID) {
        mainProgram.provideFeedback(ClientID,feedback);
        assertEquals("Fail to provide a feedback","Success",result);
    }


    @When("User tries to provide feedback or progress report to {int} but not in progress")
    public void user_tries_to_provide_feedback_or_progress_report_to_client_id_but_not_in_progress(int ClientID) {
        result=mainProgram.provideFeedbackResult(ClientID);
    }


    @Then("The feedback should not be provided successfully")
    public void the_feedback_should_not_be_provided_successfully() {
        assertEquals("Success to provide a feedback","Fail",result);
    }


    @Given("User has logged in as client to interact")
    public void userHasLoggedInAsClientToInteract() {
        assertFalse("The user is not admin",mainProgram.login("Client"));
    }


    @When("User tries to provide feedback or progress report to {int}")
    public void user_tries_to_provide_feedback_or_progress_report_to_client_id(int ClientID) {
        result=mainProgram.provideFeedbackResult(ClientID);
        if(!mainProgram.login("Client"))
            result="Fail";
    }
}
