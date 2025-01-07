package mainpack;
import java.util.ArrayList;
import java.util.List;
public class ProgramStorage {
    private List<Program> programs = new ArrayList<>();
    // Method to add a new program
    public void addProgram(Program program) {
        if (!isValidDuration(program.getDuration())) {
            throw new IllegalArgumentException("Invalid duration format");
        }
        programs.add(program);
    }
    // Validation method for duration
    private boolean isValidDuration(String duration) {
        // Example regex for "X weeks"
        return duration != null && duration.matches("\\d+ weeks");
    }
    // Method to update an existing program
    public String updateProgram(String programName, String duration, String fee, String description) {
        for (Program program : programs) {
            if (program.getProgramName().equals(programName)) {
                if (duration != null && !duration.isEmpty()) program.setDuration(duration);
                if (fee != null && !fee.isEmpty()) program.setFee(fee);
                if (description != null && !description.isEmpty()) program.setDescription(description);
                return "Success";
            }
        }
        return "Program not found";
    }
    // Method to check if a program exists
    public boolean programExists(String programName) {
        return programs.stream()
                .anyMatch(program -> program.getProgramName().equals(programName));
    }
}