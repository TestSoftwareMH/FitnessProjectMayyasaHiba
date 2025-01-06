package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class notificationsTest {

    private String result;

    @Given("User has logged in as instructor to notify")
    public void user_has_logged_in_as_instructor_to_notify() {
        assertTrue("The user is not instructor", mainProgram.login("Instructor"));
    }


    @When("User updates the schedule for the program {int} and notify {int} with the following details:")
    public void userUpdatesTheScheduleForTheProgramAndNotifyWithTheFollowingDetails(Integer PId,Integer CId, io.cucumber.datatable.DataTable dataTable) {
        result=mainProgram.notifyResult(PId,CId);
    }


    @Then("The notify should be sent to all enrolled clients {int} in the program {int}")
    public void the_notify_should_be_sent_to_all_enrolled_clients_in_the_program(Integer CId,Integer PId) {
        mainProgram.notify(CId,PId);
        assertEquals("Fail to send the notification","Success",result);
    }


    @When("User tries to notify clients {int} not enrolled in the program {int}")
    public void userTriesToNotifyClientsNotEnrolledInTheProgram(Integer CId,Integer PId) {
        result=mainProgram.notifyResult(PId,CId);
    }


    @Then("The notify should not be sent to anyone")
    public void the_notify_should_not_be_sent_to_anyone() {
        assertEquals("Success to send the notification","Fail",result);
    }


    @When("User cancels the schedule for the program {int} and notify {int} with the following details:")
    public void userCancelsTheScheduleForTheProgramAndNotifyWithTheFollowingDetails(Integer PId,Integer CId, io.cucumber.datatable.DataTable dataTable) {
        result=mainProgram.notifyResult(PId,CId);
    }
}
