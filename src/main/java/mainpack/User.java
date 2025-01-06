package mainpack;

public class User {
    private String id;
    private String name;
    private String lastLogin;
    private int actionsTaken;
private String email;
    // Constructor
    public User(String id, String name, String lastLogin, int actionsTaken, String email) {
        this.id = id;
        this.name = name;
        this.lastLogin = lastLogin;
        this.actionsTaken = 0;  // Default actions taken to 0
        this.email=email;
    }
    public User(String id, String name, String lastLogin) {
        this.id = id;
        this.name = name;
        this.lastLogin = lastLogin;
        this.actionsTaken = 0;  // Default actions taken to 0
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getActionsTaken() {
        return actionsTaken;
    }

    public void setActionsTaken(int actionsTaken) {
        this.actionsTaken = actionsTaken;
    }

    // Method to add actions taken
    public void addActions(int actions) {
        this.actionsTaken += actions;
    }

    // Method to get the engagement rate
    public double getEngagementRate() {
        // Assuming that engagement rate is calculated as actions taken / (actions taken + 1)
        return (double) actionsTaken / (actionsTaken + 1);
    }

    @Override
    public String toString() {
        return "User{id='" + id + "', name='" + name + "', lastLogin='" + lastLogin + "', actionsTaken=" + actionsTaken + "}";
    }

    public String getEmail() {
        return email;
    }
}
