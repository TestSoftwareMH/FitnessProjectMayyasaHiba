package mainpack;




import java.util.HashMap;
import java.util.Map;

public class InstructorService {

    // Simulating a database of instructor registrations
    private Map<String, Instructor> instructorDatabase = new HashMap<>();

    // Add a new instructor registration
    public void addInstructorRegistration(Instructor instructor) {
        instructorDatabase.put(instructor.getId(), instructor);
    }

    // Find an instructor by their ID
    public Instructor findInstructorById(String instructorId) {
        return instructorDatabase.get(instructorId);
    }

    // Approve an instructor registration
    public void approveInstructorRegistration(String instructorId) {
        Instructor instructor = findInstructorById(instructorId);
        if (instructor != null) {
            instructor.setStatus("Approved");
        }
    }

    // Reject an instructor registration
    public void rejectInstructorRegistration(String instructorId) {
        Instructor instructor = findInstructorById(instructorId);
        if (instructor != null) {
            instructor.setStatus("Rejected");
        }
    }

    // Get the current status of an instructor
    public String getInstructorStatus(String instructorId) {
        Instructor instructor = findInstructorById(instructorId);
        return (instructor != null) ? instructor.getStatus() : "Instructor registration not found.";
    }
}
