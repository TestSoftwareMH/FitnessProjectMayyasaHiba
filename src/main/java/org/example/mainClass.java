package org.example;

import fit.man.sys.project.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

public class mainClass {


    public static void main(String[] args) {
        System.out.println("Starting Fitness Management System Tests...");
        System.out.println("Running valid Add Program Test...");
        runAddProgramTest("Yoga", "Health", "30", "John", "2025-01-01");

        // Test 2: Trying to add a program with invalid duration format
        System.out.println("\nRunning invalid Add Program Test...");
        runAddProgramTest("Yoga", "Health", "abc", "John", "2025-01-01");

        // Test 3: Trying to add a program with missing details
        System.out.println("\nRunning incomplete Add Program Test...");
        runAddProgramTest("", "", "", "", "");
        // Run different test suites
        runUpdateProgramTests();
        runCreateProgramTests();
        runDeleteProgramTests();
        runCommunicationWithClientTests();
        runDeactivateAccountTests();
        runMonitorTests();
        runReportsTests();
        runTrackProgramTests();
        runApproveOrRejectTests();
        runFeedbackAndComplaintsTests();
        runNotificationsTests();
        runAnnouncementTests();
        runAccountManagementTests();
        runEnrollmentTests();

        // Integrate track class test cases
        runTrackTests();

        // Run new test cases for rate and submit
        runRateTests();

        System.out.println("All tests completed.");



    }

    // Replacing the runAddProgramTests method with logic from the 'add' class
    private static void runAddProgramTest(String programName, String programType, String duration, String instructor, String startDate) {
        // Initialize a DataTable to represent the program details
        DataTable dataTable = DataTable.create(
                List.of(
                        Map.of(
                                "ProgramName", programName,
                                "ProgramType", programType,
                                "Duration", duration,
                                "Instructor", instructor,
                                "StartDate", startDate
                        )
                )
        );

        // Create an instance of the 'add' class to use its methods
        add addProgramTest = new add();

        // Run the test with valid or invalid data
        if (programName.isEmpty() || programType.isEmpty() || duration.isEmpty()) {
            addProgramTest.theUserTriesToAddAProgramWithIncompleteDetails(dataTable);
        } else if (!duration.matches("\\d+")) {
            addProgramTest.theUserTriesToAddAProgramWithInvalidDetails(dataTable);
        } else {
            addProgramTest.theUserProvidesTheFollowingProgramDetails(dataTable);
            addProgramTest.theProgramShouldBeAddedSuccessfully();
        }
    }

    private static void runUpdateProgramTests() {
        System.out.println("Running Update Program Tests...");

        // Initialize the Update class (this contains all step definitions)
        update updateClass = new update();

        // Prepare data for the program existence
        DataTable programDataTable = DataTable.create(List.of(
                Map.of("ProgramName", "Yoga", "Duration", "30", "Fee", "50.0", "Description", "Introductory yoga")
        ));

        // Simulate the @Given step for the existing program
        updateClass.theFollowingProgramExists(programDataTable);

        // Prepare data for the update operation
        DataTable updateDetails = DataTable.create(List.of(
                Map.of("ProgramName", "Yoga", "Duration", "45", "Fee", "60.0", "Description", "Updated Yoga program")
        ));

        // Simulate the @When step for updating the program
        updateClass.the_user_updates_the_program_with_the_following_details(updateDetails);

        // Simulate the @Then step for verifying the update
        updateClass.the_program_should_be_updated_successfully();

        System.out.println("Update Program Test - PASSED");
    }

    private static void runCreateProgramTests() {
        System.out.println("Running Create Program Tests...");

        // Initialize the createProgramTest class (this contains all step definitions)
        createProgramTest createProgramTestClass = new createProgramTest();

        // Prepare data for the program creation
        DataTable programDetails = DataTable.create(List.of(
                Map.of("Program ID", "1", "Program title", "Pilates", "Duration", "60", "Difficulty level", "All Levels",
                        "Goals", "Fitness", "Description", "Pilates for beginners", "Price", "30.0",
                        "Schedule type", "Weekly", "Schedule time", "10:00 AM")
        ));

        // Simulate the @Given step for logged-in instructor
        createProgramTestClass.user_has_logged_in_as_instructor();

        // Simulate the @When step for creating the program
        createProgramTestClass.user_creates_program_with_the_following_details(programDetails);

        // Simulate the @Then step for verifying the creation of the program
        createProgramTestClass.the_program_pilates_should_be_created_successfully();

        System.out.println("Create Program Test - PASSED");
    }

    private static void runDeleteProgramTests() {
        System.out.println("Running Delete Program Tests...");

        // Initialize the deleteProgramTest class (this contains all step definitions)
        deleteProgramTest deleteProgramTestClass = new deleteProgramTest();

        // Prepare data for the program deletion
        DataTable programDetails = DataTable.create(List.of(
                Map.of("Program ID", "1", "Program title", "Pilates", "Duration", "60", "Difficulty level", "All Levels",
                        "Goals", "Fitness", "Description", "Pilates for beginners", "Price", "30.0",
                        "Schedule type", "Weekly", "Schedule time", "10:00 AM")
        ));

        // Simulate the @Given step for logged-in instructor
        deleteProgramTestClass.user_has_logged_in_as_instructor_to_delete_program();

        // Simulate the @Given step to check if the program exists
        deleteProgramTestClass.the_program_program_id_exists_in_the_system();

        // Simulate the @When step for deleting the program
        deleteProgramTestClass.user_deletes_program_with_the_following_details(programDetails);

        // Simulate the @Then step for verifying the program deletion
        deleteProgramTestClass.theProgramShouldBeDeletedSuccessfully(1);

        System.out.println("Delete Program Test - PASSED");
    }


    private static void runCommunicationWithClientTests() {
        System.out.println("Running Communication with Client Tests...");

        // Initialize the communicationWithClientTest class (this contains all step definitions)
        communicationWithClientTest communicationTestClass = new communicationWithClientTest();

        // Simulate the @Given step for logged-in instructor
        communicationTestClass.user_has_logged_in_as_instructor_to_communication();

        // Simulate the @When step for sending a message to the client
        communicationTestClass.userSendAMessageToClientWith("Welcome to Yoga Program!", 1);

        // Simulate the @Then step for verifying the message was sent
        communicationTestClass.the_message_should_be_sent_to_client_with_successfully("Welcome to Yoga Program!", 1);

        System.out.println("Communication with Client Test - PASSED");
    }

    private static void runDeactivateAccountTests() {
        System.out.println("Running Deactivate Account Tests...");

        // Initialize the deactivate class to simulate the Cucumber steps
        deactivate deactivateTest = new deactivate();

        // Simulate the @Given step for instructor data
        io.cucumber.datatable.DataTable instructorData = io.cucumber.datatable.DataTable.create(
                List.of(
                        Map.of("ID", "I001", "Name", "Instructor1", "Status", "Active")
                )
        );
        deactivateTest.theFollowingInstructorExists(instructorData);

        // Simulate the @Given step for client data
        io.cucumber.datatable.DataTable clientData = io.cucumber.datatable.DataTable.create(
                List.of(
                        Map.of("ID", "C001", "Name", "Client1", "Status", "Active")
                )
        );
        deactivateTest.theFollowingClientExists(clientData);

        // Simulate the @When step for deactivating instructor account
        deactivateTest.theAdminDeactivatesTheInstructorAccountWithID("I001");

        // Simulate the @Then step to check the instructor account status
        deactivateTest.theStatusOfTheInstructorAccountWithIDShouldBe("I001", "Inactive");

        // Simulate the @When step for deactivating client account
        deactivateTest.theAdminDeactivatesTheClientAccountWithID("C001");

        // Simulate the @Then step to check the client account status
        deactivateTest.theStatusOfTheClientAccountWithIDShouldBe("C001", "Inactive");

        // Simulate the @When step for attempting to deactivate an account (non-existent)
        deactivateTest.theAdminAttemptsToDeactivateAnAccountWithID("NonExistentID");

        // Simulate the @Then step to check for error message
        deactivateTest.theSystemShouldDisplayAnErrorMessage("Account not found or already deactivated.");

        System.out.println("Deactivate Account Test - PASSED");
    }

    private static void runMonitorTests() {
        System.out.println("Running Monitor Tests...");

        // Initialize the monitorTest class to simulate the Cucumber steps
        monitorTest monitorTestInstance = new monitorTest();

        // Simulate the @Given step for logging in as an instructor
        monitorTestInstance.user_has_logged_in_as_instructor_to_monitor();

        // Simulate the @When step for viewing progress report for a client
        Integer clientId = 1; // Example client ID
        monitorTestInstance.user_views_the_progress_report_for(clientId);

        // Simulate the @Then step to check client progress details
        io.cucumber.datatable.DataTable clientDetails = io.cucumber.datatable.DataTable.create(
                List.of(
                        Map.of("Client ID", "1", "Client name", "Client1", "Attendance", "85%", "Completion rate", "90%", "Activity", "Active")
                )
        );
        monitorTestInstance.the_system_should_show_the_following_details(clientDetails);

        // Simulate the @When step for viewing attendance for a program
        Integer programId = 101; // Example program ID
        monitorTestInstance.user_views_attendance_for_a_program(programId);

        // Simulate the @Then step to check program details
        io.cucumber.datatable.DataTable programDetails = io.cucumber.datatable.DataTable.create(
                List.of(
                        Map.of("Program ID", "101", "Program name", "Yoga Program", "Date of program", "2025-01-01", "Total number of client", "30", "Number of attended clients", "25")
                )
        );
        monitorTestInstance.the_system_should_show_the_following_details_for_monitor(programDetails);

        System.out.println("Monitor Test - PASSED");
    }

    private static void runReportsTests() {
        System.out.println("Running Reports Tests...");

        // Create an instance of the reports class to simulate the Cucumber steps
        reports reportsInstance = new reports();

        // Simulate the @When step for viewing the revenue report
        reportsInstance.theUserViewsTheRevenueReport();

        // Simulate the @Then step to check if the total revenue matches the expected value
        Double expectedRevenue = 10000.0; // Example expected revenue
        reportsInstance.theTotalRevenueShouldBe(expectedRevenue);

        // Simulate the @When step for viewing the attendance report
        reportsInstance.theUserViewsTheAttendanceReport();

        // Simulate the @Then step to check attendance for a program
        String programName = "Yoga Program"; // Example program name
        Integer expectedAttendance = 30; // Example expected attendance
        reportsInstance.theAttendanceForProgramShouldBe(programName, expectedAttendance);

        // Simulate the @When step for viewing the client progress report
        reportsInstance.theUserViewsTheClientProgressReport();

        // Simulate the @Then step to check if progress for a program is displayed
        reportsInstance.theProgressForProgramShouldBeDisplayed(programName);

        System.out.println("Reports Test - PASSED");
    }


    private static void runApproveOrRejectTests() {
        System.out.println("Running Approve or Reject Tests...");

        // Create an instance of the approveOrreject class to simulate the Cucumber steps
        approveOrreject approveOrRejectInstance = new approveOrreject();

        // Simulate the @Given step for setting up the shared content with initial statuses
        DataTable contentData = DataTable.create(List.of(
                Map.of("Content Title", "Article1", "Status", "Pending"),
                Map.of("Content Title", "Article2", "Status", "Pending")
        ));
        approveOrRejectInstance.theSystemHasTheFollowingSharedContent(contentData);

        // Simulate the @When step for the user viewing the list of pending content
        approveOrRejectInstance.theUserViewsTheListOfPendingContent();

        // Simulate the @Then step to verify the pending content
        DataTable expectedPendingContent = DataTable.create(List.of("Article1", "Article2"));
        approveOrRejectInstance.thePendingContentShouldBe(expectedPendingContent);

        // Simulate the @When step for approving the content "Article1"
        approveOrRejectInstance.theUserApprovesTheContent("Article1");

        // Simulate the @Then step to verify the status of "Article1"
        approveOrRejectInstance.shouldHaveTheStatus("Article1", "Approved");

        // Simulate the @When step for rejecting the content "Article2"
        approveOrRejectInstance.theUserRejectsTheContent("Article2");

        // Simulate the @Then step to verify the status of "Article2"
        approveOrRejectInstance.shouldHaveTheStatus("Article2", "Rejected");

        System.out.println("Approve or Reject Test - PASSED");
    }




    private static void runFeedbackAndComplaintsTests() {
        System.out.println("Running Feedback and Complaints Tests...");

        // Create an instance of the interactWithClientTest class to simulate the Cucumber steps
        interactWithClientTest feedbackTestInstance = new interactWithClientTest();

        // Simulate the @Given step for the user logged in as an instructor to interact
        feedbackTestInstance.user_has_logged_in_as_instructor_to_interact();

        // Simulate the @When step for providing feedback to a client with ClientID 101
        feedbackTestInstance.userProvidesFeedbackOrProgressReportTo(101);

        // Simulate the @Then step to verify that feedback was successfully provided
        feedbackTestInstance.theFeedbackShouldBeProvidedSuccessfullyTo("Great program!", 101);

        // Simulate the @When step for providing feedback to a client with ClientID 102, but the client is not in progress
        feedbackTestInstance.user_tries_to_provide_feedback_or_progress_report_to_client_id_but_not_in_progress(102);

        // Simulate the @Then step to verify that feedback was not successfully provided
        feedbackTestInstance.the_feedback_should_not_be_provided_successfully();

        // Simulate the @Given step for the user logged in as a client to interact
        feedbackTestInstance.userHasLoggedInAsClientToInteract();

        // Simulate the @When step for the user trying to provide feedback as a client
        feedbackTestInstance.user_tries_to_provide_feedback_or_progress_report_to_client_id(103);

        // No specific @Then for the client case as it checks if login fails, so it's verified within the steps

        System.out.println("Feedback and Complaints Test - PASSED");
    }

    private static void runNotificationsTests() {
        System.out.println("Running Notifications Tests...");

        // Create an instance of the notificationsTest class to simulate the Cucumber steps
        notificationsTest notificationsTestInstance = new notificationsTest();

        // Simulate the @Given step for the user logged in as an instructor to notify
        notificationsTestInstance.user_has_logged_in_as_instructor_to_notify();

        // Simulate the @When step for updating the schedule and notifying clients
        notificationsTestInstance.userUpdatesTheScheduleForTheProgramAndNotifyWithTheFollowingDetails(101, 201, null); // null for DataTable, assuming it's not used in this context

        // Simulate the @Then step to verify that the notification is sent successfully
        notificationsTestInstance.the_notify_should_be_sent_to_all_enrolled_clients_in_the_program(201, 101);

        // Simulate the @When step for trying to notify clients not enrolled in the program
        notificationsTestInstance.userTriesToNotifyClientsNotEnrolledInTheProgram(301, 101);

        // Simulate the @Then step to verify that no notification was sent
        notificationsTestInstance.the_notify_should_not_be_sent_to_anyone();

        // Simulate the @When step for canceling the schedule and notifying clients
        notificationsTestInstance.userCancelsTheScheduleForTheProgramAndNotifyWithTheFollowingDetails(101, 201, null); // null for DataTable, assuming it's not used in this context

        System.out.println("Notifications Test - PASSED");
    }


    private static void runAnnouncementTests() {
        System.out.println("Running Announcements Tests...");

        // Create an instance of the announcementTest class to simulate the Cucumber steps
        announcementTest announcementTestInstance = new announcementTest();

        // Simulate the @Given step for the user logged in as an instructor to announce
        announcementTestInstance.user_has_logged_in_as_instructor_to_announce();

        // Simulate the @When step for creating a new program and announcing it
        io.cucumber.datatable.DataTable dataTableForProgram = null; // Replace this with actual DataTable for program details
        announcementTestInstance.userCreateNewProgramWithTheFollowingDetailsAndWantClientsToKnowThat(dataTableForProgram);

        // Simulate the @Then step to verify the program announcement
        announcementTestInstance.the_announce_should_be_delivered();

        // Simulate the @When step for announcing a special offer
        io.cucumber.datatable.DataTable dataTableForOffer = null; // Replace this with actual DataTable for offer details
        announcementTestInstance.user_announce_about_special_offer_with_following_details(101, dataTableForOffer);

        // Simulate the @Then step to verify the special offer announcement
        announcementTestInstance.the_announce_of_offer_should_be_delivered();

        // Simulate the @When step for announcing a special offer with an invalid period
        io.cucumber.datatable.DataTable dataTableForInvalidOffer = null; // Replace this with actual DataTable for offer details
        announcementTestInstance.user_announce_about_special_offer_with_invalid_period_with_following_details(102, dataTableForInvalidOffer);

        // Simulate the @Then step to verify the invalid offer announcement is not delivered
        announcementTestInstance.the_announce_should_not_be_delivered();

        System.out.println("Announcements Test - PASSED");
    }

    private static void runAccountManagementTests() {
        System.out.println("Running Account Management Tests...");

        // Create an instance of the accountManagementTest class to simulate the Cucumber steps
        accountManagementTest accountManagementTestInstance = new accountManagementTest();

        // Simulate the @Given step for the user wanting to create a new account
        accountManagementTestInstance.user_wants_to_create_new_account();

        // Simulate the @When step for providing account details
        io.cucumber.datatable.DataTable dataTableForNewAccount = null; // Replace with actual DataTable for new account details
        accountManagementTestInstance.the_user_provides_the_following_details(dataTableForNewAccount);

        // Simulate the @Then step to verify account creation
        accountManagementTestInstance.the_account_should_be_created_successfully();

        // Simulate the @Given step for the user already having an account
        accountManagementTestInstance.theUserAlreadyHasAnAccount();

        // Simulate the @When step for user providing login credentials and account details
        io.cucumber.datatable.DataTable dataTableForAccountDetails = null; // Replace with actual DataTable for account details
        accountManagementTestInstance.userPutUserNameAndPasswordInTrueAndHasTheFollowingDetails("client@example.com", dataTableForAccountDetails);

        // Simulate the @Then step to verify account details display
        accountManagementTestInstance.theAccountShouldBeOpenAndTheDetailsShouldBeShown();

        // Simulate the @Given step for the user logged in as a client
        accountManagementTestInstance.user_logged_in_as_client();

        // Simulate the @When step for the user viewing dietary preferences or restrictions
        io.cucumber.datatable.DataTable dataTableForDietaryPreferences = null; // Replace with actual DataTable for dietary preferences
        accountManagementTestInstance.theUserWantsToViewDietaryPreferencesOrRestrictionsWithTheFollowingDetails("client@example.com", dataTableForDietaryPreferences);

        // Simulate the @Then step to verify the system displays the details
        accountManagementTestInstance.theSystemShouldDisplayTheDetails();

        System.out.println("Account Management Test - PASSED");
    }

    private static void runEnrollmentTests() {
        System.out.println("Running Enrollment Tests...");

        // Create an instance of the enrollmentTest class to simulate the Cucumber steps
        enrollmentTest enrollmentTestInstance = new enrollmentTest();

        // Simulate the @Given step for the user being logged in as a client for enrollment
        enrollmentTestInstance.user_has_logged_in_as_client_for_enrollment();

        // Simulate the @When step for the user selecting a program to enroll in and providing details
        io.cucumber.datatable.DataTable dataTableForEnrollment = null; // Replace with actual DataTable for enrollment details
        enrollmentTestInstance.userSelectProgramToEnrollInAndTheUserPutsTheTrueDetails(1, 101, dataTableForEnrollment);

        // Simulate the @Then step to verify the confirmation message is displayed
        enrollmentTestInstance.the_confirmation_message_should_be_displayed();

        // Simulate the @When step for the user wanting to show their enrolled programs
        io.cucumber.datatable.DataTable dataTableForEnrolledPrograms = null; // Replace with actual DataTable for enrolled programs
        enrollmentTestInstance.theUserWantsToShowHisHerEnrolledProgramsWithTheFollowingDetails(1, dataTableForEnrolledPrograms);

        // Simulate the @Then step to verify the system displays all programs the user has enrolled in
        enrollmentTestInstance.theSystemShouldDisplayAllProgramsThatTheUserEnrolledIn();

        // Simulate the @When step for the user trying to enroll in a program with a conflict schedule
        io.cucumber.datatable.DataTable dataTableForConflictSchedule = null; // Replace with actual DataTable for conflict schedule
        enrollmentTestInstance.userTriesToEnrollInProgramWithConflictSchedule(1, 102, dataTableForConflictSchedule);

        // Simulate the @Then step to verify the system displays the error message for the conflict
        enrollmentTestInstance.the_system_should_display_error_message();

        System.out.println("Enrollment Test - PASSED");
    }


    private static void runRateTests() {
        System.out.println("Running Rate Tests...");

        // Create an instance of the rate class to simulate the Cucumber steps
        rate rateTestInstance = new rate();

        // Simulate the @Given step to ensure the program exists
        rateTestInstance.theProgramExists("Yoga");

        // Simulate the @When step to rate the program and write the review
        rateTestInstance.theUserRatesTheProgramWithAScoreOfAndWritesTheReview("Yoga", "5", "Excellent program!");

        // Simulate the @Then step to verify the rating and review are added successfully
        rateTestInstance.theRatingAndReviewShouldBeAddedSuccessfully();

        System.out.println("Rate Test - PASSED");
    }

}}
