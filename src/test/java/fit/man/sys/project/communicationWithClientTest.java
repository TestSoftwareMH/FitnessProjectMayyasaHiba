package fit.man.sys.project;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Client;
import org.example.mainProgram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class communicationWithClientTest {

    private String result;

    @Before
    public void setup() {
        mainProgram.initializePrograms();
    }
    @Given("User has logged in as instructor to communication")
    public void user_has_logged_in_as_instructor_to_communication() {
        mainProgram.login("Instructor");
        assertTrue("The user is not instructor", mainProgram.login("Instructor"));
    }


    @When("User send a message {string} to client with {int}")
    public void userSendAMessageToClientWith(String string, Integer CId) {
        result=mainProgram.sendMessResult(CId);
    }


    @Then("The message {string} should be sent to client with {int} successfully")
    public void the_message_should_be_sent_to_client_with_successfully(String message,Integer CId) {
        mainProgram.sendMessage(message, CId);
        assertEquals("Fail to send a message","Success",result);
    }


    @When("User post a message {string} to the discussion forums with {int}")
    public void userPostAMessageToTheDiscussionForumsWith(String string, Integer DId) {
        result=mainProgram.postMessResult(DId);
    }


    @Then("The message {string} should be post to the discussion forums successfully with {int}")
    public void theMessageShouldBePostToTheDiscussionForumsSuccessfullyWith(String message,int DId) {
        mainProgram.postMessage(message, DId);
        assertEquals("Fail to send a message","Success",result);
    }


    @When("User tries to send a message to a client not enrolled {int}")
    public void userTriesToSendAMessageToAClientNotEnrolled(Integer CId) {
        result=mainProgram.sendMessResult(CId);
    }


    @Then("The message should not be sent")
    public void the_message_should_not_be_sent() {
        assertEquals("Success to send a message","Fail",result);
    }


    @Given("User has logged in as client to communicat")
    public void user_has_logged_in_as_client_to_communicat() {
        mainProgram.login("Client");
    }


    @When("User tries to post a message {string} to the discussion forums with {int}")
    public void userTriesToPostAMessageToTheDiscussionForumsWith(String string,Integer DId) {
        result=mainProgram.postMessResult(DId);
        if(!mainProgram.login("Client")){
            result="Fail";
        }
    }
}
