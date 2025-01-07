package org.example;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;
import java.util.HashMap;
import java.util.Map;

public class AccountService {

    // Static account store shared across all instances
    private  Map<String, Map<String, String>> accountStore = new HashMap<>();

    // Method to set the account store externally if needed
    public static void setAccountStore(Map<String, Map<String, String>> newAccountStore) {
        if (newAccountStore != null) {
            accountStore = newAccountStore;
        }
    }

    // Deactivate an account by accountId
    public static boolean deactivateAccount(String accountId) {
        if (accountId == null || accountId.isEmpty()) {
            return false; // Invalid accountId
        }
        Map<String, String> accountData = accountStore.get(accountId);
        if (accountData != null && "Active".equals(accountData.get("Status"))) {
            accountData.put("Status", "Inactive");
            return true;
        }
        return false;
    }

    // Method to deactivate an instructor
    public boolean deactivateInstructor(String instructorId) {
        return deactivateAccount(instructorId); // Delegate to static method
    }

    // Method to find an instructor by their ID
    public Instructor findInstructorById(String instructorId) {
        if (instructorId == null || instructorId.isEmpty()) {
            return null; // Invalid instructorId
        }
        Map<String, String> account = accountStore.get(instructorId);
        if (account != null && "Instructor".equals(account.get("Role"))) {
            return new Instructor(instructorId); // Return Instructor object if found
        }
        return null; // Return null if not found or not an instructor
    }
}
