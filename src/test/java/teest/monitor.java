package teest;

import mainpack.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class monitor {

    private List<User> users;
    @Given("the following active users have participated in various actions:")
    public void theFollowingActiveUsersHaveParticipatedInVariousActions(io.cucumber.datatable.DataTable dataTable) {
        // Initialize the users list if it's null
        if (users == null) {
            users = new ArrayList<>();
        }

        List<Map<String, String>> usersData = dataTable.asMaps(String.class, String.class);

        // Populate the users list with the data from the DataTable
        for (Map<String, String> user : usersData) {
            String userName = user.get("User");
            String action = user.get("Action");
            String timestamp = user.get("Timestamp");

            // Create a new User object (assuming you have a User class)
            User newUser = new User(userName, action, timestamp);
            users.add(newUser); // Add the user to the list
        }
    }


    @Given("the following users are registered:")
    public void theFollowingUsersAreRegistered(io.cucumber.datatable.DataTable dataTable) {
        if (users == null) {
            users = new ArrayList<>();  // Initialize the list to prevent NullPointerException
        }
        List<List<String>> data = dataTable.asLists(String.class);
        users = new ArrayList<User>();

        for (List<String> row : data.subList(1, data.size())) {
            String id = row.get(0);
            String name = row.get(1);
            String lastLogin = row.get(2);
            users.add(new User(id, name, lastLogin));
        }
    }

    @Given("the following users have made the following number of actions:")
    public void theFollowingUsersHaveMadeTheFollowingNumberOfActions(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : rows) {
            String userId = row.get("UserID");
            String userName = row.get("Name");
            String actionsTaken = row.get("ActionsTaken");
            if (users == null) {
                users = new ArrayList<>();  // Initialize the list to prevent NullPointerException
            }
            // Here we can process the actions data (store it in user or perform additional operations)
            for (User user : users) {
                if (user.getId().equals(userId)) {
                    user.setActionsTaken(Integer.parseInt(actionsTaken));
                }
            }
        }
    }

    @When("the admin views the user activity statistics")
    public void theAdminViewsTheUserActivityStatistics() {
        // Simulate viewing the user activity statistics
        System.out.println("Admin is viewing user activity statistics...");
    }

    @Then("the system should display the number of active users")
    public void theSystemShouldDisplayTheNumberOfActiveUsers() {
        long activeUsers = users.stream().filter(user -> user.getLastLogin() != null).count();
        System.out.println("Number of Active Users: " + activeUsers);
        assertTrue("Active users count should be > 0", activeUsers > 0);
    }

    @Then("the system should display the most recent login timestamps for each user")
    public void theSystemShouldDisplayTheMostRecentLoginTimestampsForEachUser() {
        for (User user : users) {
            System.out.println(user.getName() + "'s last login: " + user.getLastLogin());
        }
    }

    @Given("the following users have logged in within different date ranges:")
    public void theFollowingUsersHaveLoggedInWithinDifferentDateRanges(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        users = new ArrayList<User>();

            for (List<String> row : data.subList(1, data.size())) {
                String id = row.get(0);
            String name = row.get(1);
            String lastLogin = row.get(2);
            users.add(new User(id, name, lastLogin));
        }
    }


    @When("the admin views the user engagement statistics")
    public void theAdminViewsTheUserEngagementStatistics() {
        System.out.println("Admin is viewing the engagement statistics...");
    }

    @Then("the system should display the number of actions taken by each user")
    public void theSystemShouldDisplayTheNumberOfActionsTakenByEachUser() {
        for (User user : users) {
            int actionCount = user.getActionsTaken();
            System.out.println("User " + user.getName() + " has taken " + actionCount + " actions.");
            assertTrue("Action count should be >= 0", actionCount >= 0);
        }
    }

    @Then("the system should display the total number of actions taken across all users")
    public void theSystemShouldDisplayTheTotalNumberOfActionsTakenAcrossAllUsers() {
        int totalActions = users.stream().mapToInt(User::getActionsTaken).sum();
        System.out.println("Total actions taken across all users: " + totalActions);
        assertTrue("Total actions should be >= 0", totalActions >= 0);
    }

    @When("the admin views the engagement insights for active users")
    public void theAdminViewsTheEngagementInsightsForActiveUsers() {
        System.out.println("Admin is viewing engagement insights for active users...");
    }

    @Then("the system should display insights such as the most engaged user and their actions")
    public void theSystemShouldDisplayInsightsSuchAsTheMostEngagedUserAndTheirActions() {
        User mostEngagedUser = users.stream()
                .max((u1, u2) -> Integer.compare(u1.getActionsTaken(), u2.getActionsTaken()))
                .orElse(null);

        if (mostEngagedUser != null) {
            System.out.println("Most engaged user: " + mostEngagedUser.getName());
            System.out.println("Actions taken: " + mostEngagedUser.getActionsTaken());
            assertNotNull("Most engaged user should not be null", mostEngagedUser);
        } else {
            System.out.println("No users found.");
        }
    }

    @Then("the system should highlight users who have the highest engagement rate")
    public void theSystemShouldHighlightUsersWhoHaveTheHighestEngagementRate() {
        double maxEngagementRate = users.stream()
                .mapToDouble(user -> (double) user.getActionsTaken() / (user.getActionsTaken() + 1))
                .max()
                .orElse(0);

        List<User> highlyEngagedUsers = users.stream()
                .filter(user -> (double) user.getActionsTaken() / (user.getActionsTaken() + 1) == maxEngagementRate)
                .collect(Collectors.toList());

        System.out.println("Users with the highest engagement rate: " + highlyEngagedUsers);
        assertTrue("There should be highly engaged users", !highlyEngagedUsers.isEmpty());
    }
}
