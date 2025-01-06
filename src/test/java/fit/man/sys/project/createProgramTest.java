package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.mainProgram;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class createProgramTest {

    private mainProgram program;
    private String result;

    @Given("User has logged in as instructor")
    public void user_has_logged_in_as_instructor() {
        assertTrue("The user is not instructor",mainProgram.login("Instructor"));
    }

    @When("User creates program with the following details:")
    public void user_creates_program_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programDetailsList = dataTable.asMaps(String.class, String.class);
            for (Map<String, String> programDetails : programDetailsList) {
                try {
                    if (programDetails.get("Program ID") == null || programDetails.get("Duration") == null || programDetails.get("Price") == null) {
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
                        result = mainProgram.createResult(program);
                    }

                } catch (Exception e) {
                    result = "Fail";
                }
            }

    }

    @Then("The program <Program title> should be created successfully")
    public void the_program_program_title_should_be_created_successfully() {
        mainProgram.createProgram(program);
        assertEquals("Fail to create a program","Success",result);
    }

    @Then("The program  should not be created")
    public void the_program_should_not_be_created() {
        assertEquals("Creation program done","Fail",result);
    }

    @Then("The program Pilates should be created successfully")
    public void the_program_pilates_should_be_created_successfully() {

        mainProgram.createProgram(program);
        assertEquals("Fail to create a program","Success",result);
    }

    @Then("The program Yoga should be created successfully")
    public void the_program_yoga_should_be_created_successfully() {

        mainProgram.createProgram(program);
        assertEquals("Fail to create a program","Success",result);
    }

    @Then("The program Cardio should not be created")
    public void the_program_cardio_should_not_be_created() {

        assertEquals("Creation program done","Fail",result);
    }

    @Then("The program Yoga should not be created")
    public void the_program_yoga_should_not_be_created() {

        assertEquals("Creation program done","Fail",result);
    }

    @Then("The program Swimming should be created successfully")
    public void the_program_swimming_should_be_created_successfully() {
        mainProgram.createProgram(program);
        assertEquals("Fail to create a program","Success",result);
    }

}
