package mainpack;

public class Program {
    private String programName;
    private String duration;
    //private int duration2;
    //private double fee2;

    private String fee;
    private String description;
    private int enrollments;
    private String name;
    public Program(String name, int enrollments) {
        this.name = name;
        this.enrollments = enrollments;
    }
    public Program(String name, String duration, String fee, String description, int enrollments) {
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.description = description;
        this.enrollments = enrollments;
    }


    public String getName() {
        return name;
    }
    public void setEnrollments(int enrollments) {
        this.enrollments = enrollments;
    }
    public int getEnrollments() {
        return enrollments;
    }

    // Constructor
    public Program(String programName, String duration, String fee, String description) {
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
        this.description = description;
    }

    // Getters and setters
    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
