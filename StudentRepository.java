
package thefinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository 
{
    private final List<Student> students = new ArrayList<>();


    public void addStudent(Student student) {
        students.add(student);
    }


    public List<Student> getAllStudents() {
        return students;
    }


    public Optional<Student> findByNumber(long number) {

        return students.stream().filter(s -> s.getStudentNumber() == number).findFirst();
    }

  
    public List<Student> findByName(String first, String last) 
    {
        return students.stream().filter(s -> s.getFullName() .equalsIgnoreCase(first + " " + last)).toList();
    }
}
