package mainpack;

class Account {
    private String id;
    private String role;
    private boolean active;

    public Account(String id, String role, boolean active) {
        this.id = id;
        this.role = role;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }
}

