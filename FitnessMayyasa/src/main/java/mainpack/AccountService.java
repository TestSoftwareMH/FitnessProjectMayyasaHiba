package mainpack;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;
import java.util.HashMap;
import java.util.Map;
public class AccountService {
    private static Map<String, Map<String, String>> accountStore = new HashMap<>();
    // Constructor to initialize accountStore
    public AccountService() {
        // accountStore is already initialized with the static variable
    }
    // Method to set the account store externally if needed
    public void setAccountStore(Map<String, Map<String, String>> accountStore) {
        AccountService.accountStore = accountStore;
    }
    // Deactivate an account by accountId
    public static boolean deactivateAccount(String accountId) {
        JsonArray AccountStore;
        Account account = (Account) accountStore.get(accountId);
        if (account != null && account.isActive()) {
            account.setActive(false);
            return true;
        }
        return false; // Modify this to return a more specific message if needed
    }
    // Method to deactivate an instructor
    public boolean deactivateInstructor(String instructorId) {
        return deactivateAccount(instructorId); // Delegate to deactivateAccount
    }
    // Method to find an instructor by their ID
    public Instructor findInstructorById(String instructorId) {
        Map<String, String> account = accountStore.get(instructorId);
        if (account != null && "Instructor".equals(account.get("Role"))) {
            return new Instructor(instructorId); // Return Instructor object if found
        }
        return null; // Return null if not found or not an instructor
    }
    // A helper class for Instructor (assuming the 'Instructor' class exists)
    public static class Instructor {
        private String instructorId;
        public Instructor(String instructorId) {
            this.instructorId = instructorId;
        }
        // Getter for instructorId
        public String getInstructorId() {
            return instructorId;
        }
    }
    // A helper class for Account (assuming Account class has fields for ID, Status, Role)
    public static class Account {
        private String accountId;
        private String status;
        private String role;
        public Account(String accountId, String status, String role) {
            this.accountId = accountId;
            this.status = status;
            this.role = role;
        }
        // Getter and setter for status
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        // Getter for role
        public String getRole() {
            return role;
        }
        // Check if the account is active
        public boolean isActive() {
            return "Active".equals(this.status);
        }
        // Set the account status to inactive
        public void setActive(boolean active) {
            this.status = active ? "Active" : "Inactive";
        }
    }
}