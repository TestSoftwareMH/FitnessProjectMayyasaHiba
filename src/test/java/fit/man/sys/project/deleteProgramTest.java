package fit.man.sys.project;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class deleteProgramTest {

    private mainProgram program;
    private String result;

    /*@Before
    public void setUp() {
        mainProgram.initializePrograms();
    }*/

    @Given("User has logged in as instructor to delete program")
    public void user_has_logged_in_as_instructor_to_delete_program() {
        assertTrue("The user is not instructor", mainProgram.login("Instructor"));
    }


    @Given("The program <Program ID> exists in the system")
    public void the_program_program_id_exists_in_the_system() {
        assertTrue("The program does not exist in the system",mainProgram.programExist(program.getProgramId()));
    }


    @When("User deletes program with the following details:")
    public void user_deletes_program_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programDetails : programDetailsList){
        result=mainProgram.deleteResult(Integer.parseInt(programDetails.get("Program ID")));
        }
    }


    @Then("The program {int} should be deleted successfully")
    public void theProgramShouldBeDeletedSuccessfully(Integer programId) {
        mainProgram.deleteProgram(programId);
        assertEquals("Fail to delete a program","Success",result);
    }


    @Given("The program {int} does not exist in the system to be deleted")
    public void theProgramDoesNotExistInTheSystemToBeDeleted(Integer programId) {
        assertFalse("The program exists in the system",mainProgram.programExist(programId));
    }


    @When("User tries to delete the program {int}")
    public void userTriesToDeleteTheProgram(Integer programId) {
        if( !mainProgram.programExist(programId)  || !mainProgram.login("Client")){
            result ="Fail";
        }
        else {
            result = mainProgram.deleteResult(programId);
        }
    }


    @Then("The program should not be deleted")
    public void the_program_should_not_be_deleted() {
        assertEquals("Delete program done","Fail",result);
    }


    @Given("User has logged in as client")
    public void user_has_logged_in_as_client() {
        mainProgram.login("Client");
    }

}
