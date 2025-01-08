package org.example;

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
 
