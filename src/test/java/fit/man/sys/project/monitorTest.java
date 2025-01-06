package fit.man.sys.project;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Client;
import org.example.mainProgram;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class monitorTest {

   /* @Before
    public void setUp() {
        mainProgram.initializePrograms();
    }*/

    @Given("User has logged in as instructor to monitor")
    public void user_has_logged_in_as_instructor_to_monitor() {
        mainProgram.login("Instructor");
        assertTrue("The user is not instructor", mainProgram.login("Instructor"));
    }


    @When("User views the progress report for {int}")
    public void user_views_the_progress_report_for(Integer CId) {
        mainProgram.getClientProgress(CId);

    }


    @Then("The system should show the following details:")
    public void the_system_should_show_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList=dataTable.asMaps(String.class,String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            Client client = mainProgram.getClientDetails(Integer.parseInt(programDetails.get("Client ID")));
            assertEquals("Client ID mismatch", Integer.valueOf(programDetails.get("Client ID")), client.getClientId());
            assertEquals("Client name mismatch", programDetails.get("Client name"), client.getClientName());
            assertEquals("Attendance mismatch", programDetails.get("Attendance"), client.getAttendance());
            assertEquals("Completion rate mismatch", programDetails.get("Completion rate"), client.getCompletionRate());
            assertEquals("Activity mismatch", programDetails.get("Activity"), client.getActivity());
        }
    }


    @When("User views attendance for a program {int}")
    public void user_views_attendance_for_a_program(Integer PId) {
        mainProgram.getGroupAttendance(PId);
    }


    @Then("The system should show the following details for monitor:")
    public void the_system_should_show_the_following_details_for_monitor(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            mainProgram program = mainProgram.getProgramDetails(Integer.parseInt(programDetails.get("Program ID")));
            assertEquals("Program ID mismatch", Integer.valueOf(programDetails.get("Program ID")), program.getProgramId());
            assertEquals("Program name mismatch", programDetails.get("Program name"), program.getProgramTitle());
            assertEquals("Date of program mismatch", programDetails.get("Date of program").trim(), program.getScheduleTime().trim());
            assertEquals("Total number of client mismatch", Integer.valueOf(programDetails.get("Total number of client")), program.getTotalNumberOfClient());
            assertEquals("Number of attended clients mismatch", Integer.valueOf(programDetails.get("Number of attended clients")), program.getNumberOfAttendedClients());
        }
    }

}
