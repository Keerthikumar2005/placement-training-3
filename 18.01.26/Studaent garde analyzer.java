import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private Map<String, Integer> grades;
    
    public Student(String name, Map<String, Integer> grades) {
        this.name = name;
        this.grades = Map.copyOf(grades);
    }
    
    public String getName() { return name; }
    public Map<String, Integer> getGrades() { return grades; }
    public double getAverage() {
        return grades.values().stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
    }
}

public class GradeAnalyzer {
    public static void main(String[] args) {
        var students = Arrays.asList(
            new Student("Alice", Map.of("Math", 90, "Science", 85, "English", 92)),
            new Student("Bob", Map.of("Math", 75, "Science", 80, "English", 78)),
            new Student("Charlie", Map.of("Math", 88, "Science", 92, "English", 85)),
            new Student("Diana", Map.of("Math", 95, "Science", 89, "English", 94))
        );
        
        System.out.println("Student Report:");
        System.out.println("===============");
        
        students.forEach(s -> {
            System.out.printf("%s: Average = %.1f%%%n", 
                s.getName(), s.getAverage());
            s.getGrades().forEach((subject, grade) -> 
                System.out.printf("  %s: %d%%%n", subject, grade));
        });
        
        var classAverage = students.stream()
            .mapToDouble(Student::getAverage)
            .average()
            .orElse(0.0);
        
        System.out.printf("%nClass Average: %.1f%%%n", classAverage);
        
        var topStudent = students.stream()
            .max(Comparator.comparingDouble(Student::getAverage))
            .orElseThrow();
        
        System.out.printf("Top Student: %s (%.1f%%)%n", 
            topStudent.getName(), topStudent.getAverage());
    }
}
