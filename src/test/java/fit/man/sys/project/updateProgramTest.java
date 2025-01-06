package fit.man.sys.project;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class updateProgramTest {

    private mainProgram program;
    private String result;

    @Given("User has logged in as instructor to update program")
    public void user_has_logged_in_as_instructor_to_update_program() {
        assertTrue("The user is not instructor",mainProgram.login("Instructor"));
    }


    @Given("The program {int} exists in the system")
    public void the_program_exists_in_the_system(Integer programId) {
        assertTrue("The program does not exist in the system",mainProgram.programExist(programId));
    }


    @When("User updates program with the following details:")
    public void user_updates_program_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            try {
                if (programDetails.get("Program ID") == null || programDetails.get("Duration") == null || programDetails.get("Price") == null ||
                        programDetails.get("Program title")==null || programDetails.get("Difficulty level")==null ||
                        programDetails.get("Goals")==null || programDetails.get("Description")==null || programDetails.get("Schedule type")==null ||
                        programDetails.get("Schedule time")==null || Integer.parseInt(programDetails.get("Duration"))<=0 ||
                        Double.parseDouble(programDetails.get("Price"))<0) {
                    result = "Fail";
                    return;
                } else {
                    program = new mainProgram(
                            Integer.parseInt(programDetails.get("Program ID")),
                            programDetails.get("Program title"),
                            Integer.parseInt(programDetails.get("Duration")),
                            programDetails.get("Difficulty level"),
                            programDetails.get("Goals"),
                            programDetails.get("Description"),
                            Double.parseDouble(programDetails.get("Price")),
                            programDetails.get("Schedule type"),
                            programDetails.get("Schedule time")
                    );
                    result = mainProgram.updateResult(program.getProgramId());
                }

            } catch (Exception e) {
                result = "Fail";
            }
        }
    }


    @Then("The program should be updated successfully")
    public void the_program_should_be_updated_successfully() {
        mainProgram.updateProgram(program);
        assertEquals("Fail to update a program","Success",result);
    }


    @Given("The program {int} does not exist in the system")
    public void the_program_does_not_exist_in_the_system(Integer programId) {
        assertFalse("The program exists in the system",mainProgram.programExist(programId));
    }


    @When("User attempts to update program with the following details but this program does not exist:")
    public void user_attempts_to_update_program_with_the_following_details_but_this_program_does_not_exist(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList=dataTable.asMaps(String.class,String.class);
        for (Map<String, String> programDetails : programDetailsList) {
            if (!mainProgram.programExist(Integer.parseInt(programDetails.get("Program ID")))) {
                result = "Fail";
                return;
            } else {
                program = new mainProgram(Integer.parseInt(programDetails.get("Program ID")), programDetails.get("Program title"),
                        Integer.parseInt(programDetails.get("Duration")), programDetails.get("Difficulty level"), programDetails.get("Goals"),
                        programDetails.get("Description"), Double.parseDouble(programDetails.get("Price")), programDetails.get("Schedule type"),
                        programDetails.get("Schedule time"));
                result = mainProgram.updateResult(program.getProgramId());
            }
        }
    }


    @Then("The program should not be updated")
    public void the_program_should_not_be_updated() {
        assertEquals("Update program done","Fail",result);
    }

}
