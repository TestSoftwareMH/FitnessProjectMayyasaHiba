package mainpack;

import java.util.*;
import java.util.stream.Collectors;

public class ProgramService {
    private Map<String, Program> programs;
    public List<Program> programList;

    public ProgramService() {
        this.programList = new ArrayList<>(); // or use another appropriate collection
        programs = new HashMap<>();
        initializeSampleData();
    }

    // Initialize programs with sample data
    private void initializeSampleData() {
        addProgram(new Program("Yoga Basics", 100));
        addProgram(new Program("CrossFit", 200));
        addProgram(new Program("Pilates", 50));
        addProgram(new Program("Zumba", 150));
    }

    // Add a new program
    public void addProgram(Program program) {
        if (program == null || program.getName() == null || program.getName().isEmpty()) {
            throw new IllegalArgumentException("Program name cannot be null or empty.");
        }
        programs.put(program.getName(), program);
        programList.add(program);
        System.out.println("Added program: " + program.getName());
        System.out.println("Current program list size: " + programs.size());
        System.out.println("Programs in list: " + programs.keySet());
    }

    public void sortProgramsByEnrollments() {
        Collections.sort(programList, (p1, p2) -> Integer.compare(p2.getEnrollments(), p1.getEnrollments()));
    }

    public Program getTopProgram() {
        return programList.isEmpty() ? null : programList.get(0);
    }

    public List<Program> getPrograms() {
        return programList;
    }

    // Remove an existing program by name
    public void removeProgram(String programName) {
        if (programName == null || programName.isEmpty()) {
            throw new IllegalArgumentException("Program name cannot be null or empty.");
        }
        programs.remove(programName);
    }

    // Retrieve all programs
    public Map<String, Program> getAllPrograms() {
        return new HashMap<>(programs);
    }

    // Retrieve a program by its name
    public Program getProgramByName(String programName) {
        return programs.get(programName);
    }

    // Get top N programs sorted by enrollment
    public List<Program> getTopNProgramsByEnrollment(int topN) {
        System.out.println("Program list before sorting: " + programList);
        return programList.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getEnrollments(), p1.getEnrollments()))
                .limit(topN)
                .collect(Collectors.toList());
    }

    // Get programs with low enrollment
    public List<Program> getProgramsWithLowEnrollment(int threshold) {
        return programs.values().stream()
                .filter(p -> p.getEnrollments() < threshold)
                .collect(Collectors.toList());
    }

    // Update the enrollment of a specific program
    public void updateEnrollments(String programName, int newEnrollment) {
        Program program = programs.get(programName);
        if (program == null) {
            throw new IllegalArgumentException("Program not found: " + programName);
        }
        program.setEnrollments(newEnrollment);
    }

    // Generate the revenue report by calculating the total revenue from all programs
    public double generateRevenueReport() {
        double totalRevenue = 0.0;
        double pricePerEnrollment = 10.0;
        for (Program program : programList) {
            totalRevenue += program.getEnrollments() * pricePerEnrollment;
        }
        return totalRevenue;
    }

    // Generate the attendance report
    public Map<String, Integer> generateAttendanceReport() {
        Map<String, Integer> attendanceReport = new HashMap<>();
        for (Program program : programList) {
            attendanceReport.put(program.getName(), program.getEnrollments());
        }
        return attendanceReport;
    }

    // Generate the client progress report
    public Map<String, String> generateClientProgressReport() {
        Map<String, String> progressReport = new HashMap<>();
        for (Program program : programList) {
            progressReport.put(program.getName(), "Progress for " + program.getName() + ": Ongoing");
        }
        return progressReport;
    }
}
