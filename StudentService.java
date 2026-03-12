package thefinal;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }


    public double calculateAverage() {

        return repo.getAllStudents().stream().mapToDouble(Student::getFinalMark).average().orElse(0);
    }


    public Map<String,Long> gradeDistribution() {

        return repo.getAllStudents().stream().collect(Collectors.groupingBy(Student::getFinalGrade,Collectors.counting()));
    }

    public List<Student> topStudents(int count) {

        return repo.getAllStudents().stream().sorted(Comparator.comparingDouble(Student::getFinalMark).reversed()).limit(count).toList();
    }

    public void sortByNumber() {

        repo.getAllStudents().sort(Comparator.comparingLong(Student::getStudentNumber));
    }

    public void sortByName() {

        repo.getAllStudents().sort(Comparator.comparing(Student::getFullName));
    }
}
