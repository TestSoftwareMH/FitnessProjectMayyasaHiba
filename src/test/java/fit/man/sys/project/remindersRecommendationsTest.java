package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class remindersRecommendationsTest {

    private String result;

    @Given("User has logged in as instructor to send reminder or recommendations")
    public void user_has_logged_in_as_instructor_to_send_reminder_or_recommendations() {
        mainProgram.login("Instructor");
        assertTrue("The user is not instructor", mainProgram.login("Instructor"));
    }


    @When("User want to remind {int} that there is a program {int}")
    public void user_want_to_remind_that_there_is_a_program(Integer CId,Integer PId) {
        result=mainProgram.motRemRecResults(CId,PId);
    }


    @Then("The client {int} should receive the message {string}")
    public void the_client_should_receive_the_message(Integer CId,String Mot) {
        mainProgram.sendMotRemRec(CId,Mot);
        assertEquals("Fail to send a motivational reminder or recommendations","Success",result);
    }


    @When("The client {int} has been inactive or not in progress")
    public void theClientHasBeenInactiveOrNotInProgress(Integer CId) {
        result=mainProgram.motRemRecResult(CId);
    }


    @Then("Automatic motivational reminders or recommendations {string} should be sent to {int}")
    public void automatic_motivational_reminders_or_recommendations_should_be_sent_to(String Mot,Integer CId) {
        mainProgram.sendMotRemRec(CId,Mot);
        assertEquals("Success to send a motivational reminder or recommendations","Success",result);
    }
}
