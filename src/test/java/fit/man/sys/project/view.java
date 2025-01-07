package fit.man.sys.project;

import java.util.*;
import java.util.stream.Collectors;
import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import org.example.Program;
import org.example.ProgramService;

public class view {
    private ProgramService programService;
    private List<Program> topPrograms;
    private List<Program> lowEnrollmentPrograms;
    public view() {
        programService = new ProgramService();
    }
    @Given("the following programs have been added:")
    public void theFollowingProgramsHaveBeenAdded(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> programs = dataTable.asMaps();
        for (Map<String, String> programData : programs) {
            String name = programData.get("ProgramName");
            String duration = String.valueOf(Integer.parseInt(programData.get("Duration")));
            String fee = String.valueOf(Double.parseDouble(programData.get("Fee")));
            String description = programData.get("Description");
            int enrollments = Integer.parseInt(programData.get("Enrollments"));
            // Debugging log to ensure the program is added
            System.out.println("Adding program: " + name);
            programService.addProgram(new Program(name, duration, fee, description, enrollments));
        }
    }
    @When("the user views the statistics of programs by enrollment")
    public void theUserViewsTheStatisticsOfProgramsByEnrollment() {
        // Just ensure the programs are viewable
        assertFalse("No programs found!", programService.getAllPrograms().isEmpty());
    }
    @Then("the program {string} should have {int} enrollments")
    public void theProgramShouldHaveEnrollments(String programName, int expectedEnrollments) {
        Optional<Program> programOptional = Optional.ofNullable(programService.getAllPrograms().get(programName));
        assertTrue("Program should be present in the list", programOptional.isPresent());
        int actualEnrollments = programOptional.get().getEnrollments();
        assertEquals("Enrollment count mismatch!", expectedEnrollments, actualEnrollments);
    }
    @Then("the program {string} should be displayed")
    public void theProgramShouldBeDisplayed(String programName) {
        List<Program> displayedPrograms = programService.getAllPrograms().values().stream()
                .filter(program -> program.getName().equals(programName))
                .collect(Collectors.toList());
        // Assert the program is found
        assertTrue("Program not found!", displayedPrograms.size() > 0);
    }
    @When("the user views programs with low enrollment \\(less than {int})")
    public void theUserViewsProgramsWithLowEnrollmentLessThan(Integer threshold) {
        lowEnrollmentPrograms = programService.getProgramsWithLowEnrollment(threshold);
    }
    private List<Program> sortedPrograms;
    @Then("the program with the highest enrollments should be {string}")
    public void theProgramWithTheHighestEnrollmentsShouldBe(String expectedProgramName) {
        List<Program> topPrograms = programService.getTopNProgramsByEnrollment(1);
        // Debugging: Print programList and topPrograms size
        System.out.println("Program list size: " + programService.programList.size());
        System.out.println("Top programs size: " + topPrograms.size());
        if (topPrograms.isEmpty()) {
            fail("No programs found in the top list");
        }
        assertEquals("Top program mismatch!", expectedProgramName, topPrograms.get(0).getName());
    }
}
