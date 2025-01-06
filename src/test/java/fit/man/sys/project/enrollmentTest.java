package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class enrollmentTest {

    private List<mainProgram> enrolledPrograms;
    private mainProgram prog;
    private boolean result;

    @Given("User has logged in as client for enrollment")
    public void user_has_logged_in_as_client_for_enrollment() {
        assertTrue(!mainProgram.login("Client"));
    }


    @When("User select program {int} to enroll in and the user {int} puts the true details")
    public void userSelectProgramToEnrollInAndTheUserPutsTheTrueDetails(Integer CId, Integer PId, io.cucumber.datatable.DataTable dataTable) {
        result=mainProgram.EnrollmentResult(CId,PId);
    }


    @Then("The confirmation message should be displayed")
    public void the_confirmation_message_should_be_displayed() {
        assertTrue("Enrollment done", result);
    }


    @When("The user {int} wants to show his\\/her enrolled programs with the following details:")
    public void theUserWantsToShowHisHerEnrolledProgramsWithTheFollowingDetails(Integer CId, io.cucumber.datatable.DataTable dataTable) {
        enrolledPrograms=mainProgram.getEnrolledPrograms(CId);
    }


    @Then("The system should display all programs that the user enrolled in")
    public void theSystemShouldDisplayAllProgramsThatTheUserEnrolledIn() {

    }


    @When("User {int} tries to enroll in program {int} with conflict schedule")
    public void userTriesToEnrollInProgramWithConflictSchedule(Integer CId, Integer PId, io.cucumber.datatable.DataTable dataTable) {
        result=mainProgram.EnrollmentResult(CId,PId);
    }


    @Then("The system should display error message")
    public void the_system_should_display_error_message() {
        assertFalse("Enrollment failed due to scheduling conflict", result);
    }
}
