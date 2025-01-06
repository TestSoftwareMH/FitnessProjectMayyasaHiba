package teest;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

import java.util.*;

public class manage {
    private Map<String, List<String>> subscriptionPlans = new HashMap<String, List<String>>();
    private List<String> filteredPlans = new ArrayList<String>();
    private String planTypeChecked;
    private boolean isClientPlan;
    private boolean isInstructorPlan;

    public manage() {
        // Initialize the subscription plans
        subscriptionPlans.put("Client", Arrays.asList("Basic", "Premium"));
        subscriptionPlans.put("Instructor", Arrays.asList("Standard", "Pro"));
    }
    @Given("the system has the following subscription plans:")
    public void theSystemHasTheFollowingSubscriptionPlans(DataTable dataTable) {
        // Convert DataTable to a List of Maps
        List<Map<String, String>> subscriptionList = dataTable.asMaps(String.class, String.class);

        // Initialize the map to store mutable lists
        subscriptionPlans = new HashMap<>();

        // Populate the subscriptionPlans map with client and instructor plans
        for (Map<String, String> row : subscriptionList) {
            String planName = row.get("Plan Name");
            String planType = row.get("Type");

            // Ensure the map's lists are mutable and ready for adding values
            subscriptionPlans.computeIfAbsent(planType, k -> new ArrayList<>()).add(planName);
        }

        // Print out to confirm plans are initialized correctly
        System.out.println("Subscription plans initialized: " + subscriptionPlans);
    }




    @When("the user views the list of client subscription plans")
    public void theUserViewsTheListOfClientSubscriptionPlans() {
        filteredPlans = subscriptionPlans.getOrDefault("Client", new ArrayList<String>());
    }

    @Then("the client subscription plans should be:")
    public void theClientSubscriptionPlansShouldBe(DataTable dataTable) {
        List<String> expectedPlans = dataTable.asList(String.class);
        // Use assertEquals for validation
        assertEquals("Expected client plans: " + expectedPlans + ", but got: " + filteredPlans,
                expectedPlans, filteredPlans);
        System.out.println("Client subscription plans are as expected: " + filteredPlans);
    }

    @When("the user views the list of instructor subscription plans")
    public void theUserViewsTheListOfInstructorSubscriptionPlans() {
        filteredPlans = subscriptionPlans.getOrDefault("Instructor", new ArrayList<String>());
    }

    @Then("the instructor subscription plans should be:")
    public void theInstructorSubscriptionPlansShouldBe(DataTable dataTable) {
        List<String> expectedPlans = dataTable.asList(String.class);
        // Use assertEquals for validation
        assertEquals("Expected instructor plans: " + expectedPlans + ", but got: " + filteredPlans,
                expectedPlans, filteredPlans);
        System.out.println("Instructor subscription plans are as expected: " + filteredPlans);
    }

    @When("the user checks if {string} is a client plan")
    public void theUserChecksIfIsAClientPlan(String planName) {
        planTypeChecked = planName;
        isClientPlan = subscriptionPlans.getOrDefault("Client", new ArrayList<String>()).contains(planName);
    }

    @Then("{string} should be a client plan")
    public void shouldBeAClientPlan(String planName) {
        // Use assertEquals for validation
        assertEquals(planName + " is not a client plan.", true, isClientPlan);
        System.out.println(planName + " is confirmed as a client plan.");
    }

    @When("the user checks if {string} is an instructor plan")
    public void theUserChecksIfIsAnInstructorPlan(String planName) {
        planTypeChecked = planName;
        isInstructorPlan = subscriptionPlans.getOrDefault("Instructor", new ArrayList<String>()).contains(planName);
    }

    @Then("{string} should be an instructor plan")
    public void shouldBeAnInstructorPlan(String planName) {
        // Use assertEquals for validation
        assertEquals(planName + " is not an instructor plan.", true, isInstructorPlan);
        System.out.println(planName + " is confirmed as an instructor plan.");
    }
}
