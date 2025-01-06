package teest;

import mainpack.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;


import static org.junit.Assert.*;

public class reports {

    private ProgramService programService;
    private double totalRevenue;
    private Map<String, Integer> attendanceReport;
    private Map<String, String> progressReport;
    private String reportStatus = "";

    // Constructor
    public reports() {
        programService = new ProgramService();
    }

    @When("the user views the revenue report")
    public void theUserViewsTheRevenueReport() {
        // Call the method in ProgramService to generate the revenue report
        totalRevenue = programService.generateRevenueReport();
        reportStatus = "Revenue Report Generated";
    }

    @Then("the total revenue should be {double}")
    public void theTotalRevenueShouldBe(Double expectedRevenue) {
        // Assert that the generated revenue matches the expected revenue using assertEquals
        assertEquals("Revenue report mismatch. Expected: " + expectedRevenue + ", but got: " + totalRevenue,
                expectedRevenue, totalRevenue, 0.001); // Added a small delta for floating point comparison
        System.out.println("Revenue report matches expected value: " + expectedRevenue);
    }



    @When("the user views the attendance report")
    public void theUserViewsTheAttendanceReport() {
        // Call the method in ProgramService to generate the attendance report
        attendanceReport = programService.generateAttendanceReport();
        reportStatus = "Attendance Report Generated";
    }

    @Then("the attendance for program {string} should be {int}")
    public void theAttendanceForProgramShouldBe(String programName, Integer expectedAttendance) {
        // Check if the program exists and assert the attendance
        Integer actualAttendance = attendanceReport.get(programName);
        assertNotNull("Attendance data for " + programName + " should not be null", actualAttendance);
        assertEquals("Attendance mismatch for " + programName + ". Expected: " + expectedAttendance + ", but got: " + actualAttendance,
                expectedAttendance, actualAttendance);
        System.out.println("Attendance for " + programName + " matches expected value: " + expectedAttendance);
    }
    @When("the user views the client progress report")
    public void theUserViewsTheClientProgressReport() {
        // Call the method in ProgramService to generate the client progress report
        progressReport = programService.generateClientProgressReport();
        reportStatus = "Client Progress Report Generated";
    }


    @Then("the progress for program {string} should be displayed")
    public void theProgressForProgramShouldBeDisplayed(String programName) {
        // Check if the program exists and display the progress message
        String progressMessage = progressReport.get(programName);
        assertNotNull("No progress report found for " + programName, progressMessage);
        System.out.println("Progress for " + programName + ": " + progressMessage);
    }
}
