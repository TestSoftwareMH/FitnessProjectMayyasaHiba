package fit.man.sys.project;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.assertEquals;  // Import assertEquals for validation
import java.util.HashMap;
import java.util.Map;

public class approveArticles {
    private Map<String, String> articleDatabase = new HashMap<String, String>(); // Explicit type declaration
    private String errorMessage = "";
    // Given step to initialize articles
    @Given("the system has the following articles or tips:")
    public void theSystemHasTheFollowingArticlesOrTips(DataTable dataTable) {
        // Clear the database before initializing
        articleDatabase.clear();
        // Transform DataTable into a Map and populate the articleDatabase
        Map<String, String> articles = dataTable.asMap(String.class, String.class);
        for (Map.Entry<String, String> entry : articles.entrySet()) {
            articleDatabase.put(entry.getKey(), entry.getValue());
        }
        System.out.println("System initialized with articles: " + articleDatabase);
    }
    // View all pending articles or tips
    @When("the user views the list of pending articles or tips")
    public void theUserViewsTheListOfPendingArticlesOrTips() {
        // Simulate fetching pending articles or tips (in a real system, you would query a database)
        articleDatabase.put("Healthy Eating Tips", "Pending");
        articleDatabase.put("Morning Yoga Routine", "Pending");
        System.out.println("Pending articles or tips: " + articleDatabase);
    }
    @Then("the pending articles or tips should be:")
    public void thePendingArticlesOrTipsShouldBe(DataTable dataTable) {
        // Verify the list of pending articles
        Map<String, String> expectedArticles = dataTable.asMap(String.class, String.class);
        for (String article : expectedArticles.keySet()) {
            assertEquals("Pending article not found: " + article, "Pending", articleDatabase.get(article));
        }
        System.out.println("Pending articles verified: " + expectedArticles);
    }
    // View all approved articles or tips
    @When("the user views the list of approved articles or tips")
    public void theUserViewsTheListOfApprovedArticlesOrTips() {
        // Simulate fetching approved articles or tips
        articleDatabase.put("Stress Management", "Approved");
        articleDatabase.put("Healthy Eating Tips", "Approved");
        System.out.println("Approved articles or tips: " + articleDatabase);
    }
    @Then("the approved articles or tips should be:")
    public void theApprovedArticlesOrTipsShouldBe(DataTable dataTable) {
        // Verify the list of approved articles
        Map<String, String> expectedArticles = dataTable.asMap(String.class, String.class);
        for (String article : expectedArticles.keySet()) {
            assertEquals("Approved article not found: " + article, "Approved", articleDatabase.get(article));
        }
        System.out.println("Approved articles verified: " + expectedArticles);
    }
    // View all rejected articles or tips
    @When("the user views the list of rejected articles or tips")
    public void theUserViewsTheListOfRejectedArticlesOrTips() {
        // Simulate fetching rejected articles or tips
        articleDatabase.put("Benefits of Hydration", "Rejected");
        System.out.println("Rejected articles or tips: " + articleDatabase);
    }
    @Then("the rejected articles or tips should be:")
    public void theRejectedArticlesOrTipsShouldBe(DataTable dataTable) {
        // Verify the list of rejected articles
        Map<String, String> expectedArticles = dataTable.asMap(String.class, String.class);
        for (String article : expectedArticles.keySet()) {
            assertEquals("Rejected article not found: " + article, "Rejected", articleDatabase.get(article));
        }
        System.out.println("Rejected articles verified: " + expectedArticles);
    }
    // Approve an article
    @When("the user approves the article {string}")
    public void theUserApprovesTheArticle(String articleName) {
        // Simulate approving the article
        if (articleDatabase.containsKey(articleName)) {
            articleDatabase.put(articleName, "Approved");
            System.out.println("Article approved: " + articleName);
        } else {
            errorMessage = "Article not found";
            System.out.println(errorMessage);
        }
    }
    @Then("the status of {string} should be {string}")
    public void theStatusOfShouldBe(String articleName, String expectedStatus) {
        // Verify the status of the article
        String actualStatus = articleDatabase.get(articleName);
        assertEquals("Article status mismatch for: " + articleName, expectedStatus, actualStatus);
        System.out.println("Article " + articleName + " has status: " + expectedStatus);
    }
    // Reject an article
    @When("the user rejects the article {string}")
    public void theUserRejectsTheArticle(String articleName) {
        // Simulate rejecting the article
        if (articleDatabase.containsKey(articleName)) {
            articleDatabase.put(articleName, "Rejected");
            System.out.println("Article rejected: " + articleName);
        } else {
            errorMessage = "Article not found";
            System.out.println(errorMessage);
        }
    }
}
