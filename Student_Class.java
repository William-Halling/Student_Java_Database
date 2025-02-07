package thefinal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private String title;
    private String firstName;
    private String lastName;
    private long studentNumber;
    private LocalDate birthDate;
    private double[] grades = new double[5]; // Array for grades (assignments 1-3, lab results, exam results)
    private double finalMark;
    private String finalGrade;

    // Constructor for initializing a new student with all details
    public Student(String title, String firstName, String lastName, long studentNumber,
                   int day, int month, int year, double... grades) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.birthDate = LocalDate.of(year, month, day);
        if (grades.length == 5) {
            System.arraycopy(grades, 0, this.grades, 0, 5);
        }
        calculateFinalMarkAndGrade();
    }

    // Default constructor for default student initialization
    public Student() {
        this("", "", "", 0, 1, 1, 1953);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int day, int month, int year) {
        this.birthDate = LocalDate.of(year, month, day);
    }

    public String getFormattedBirthDate() {
        return birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public double getGrade(int assignmentIndex) {
        if (assignmentIndex >= 0 && assignmentIndex < grades.length) {
            return grades[assignmentIndex];
        }
        return -1;
    }

    public void setGrade(int assignmentIndex, double grade) {
        if (assignmentIndex >= 0 && assignmentIndex < grades.length) {
            if (grade >= 0 && grade <= 100) {
                grades[assignmentIndex] = grade;
            } else {
                System.out.println("Invalid grade value. Must be between 0 and 100.");
                grades[assignmentIndex] = -1;
            }
            calculateFinalMarkAndGrade();
        }
    }

    private void calculateFinalMarkAndGrade() {
        double weightSum = 0.60 + 0.10 + 0.30; // weights for assignments, labs, and exam respectively
        finalMark = (grades[0] + grades[1] + grades[2]) * 0.20 + grades[3] * 0.10 + grades[4] * 0.50;
        determineFinalGrade();
    }

    private void determineFinalGrade() {
        if (finalMark >= 80) {
            finalGrade = "HD";
        } else if (finalMark >= 70) {
            finalGrade = "D";
        } else if (finalMark >= 60) {
            finalGrade = "C";
        } else if (finalMark >= 50) {
            finalGrade = "P";
        } else {
            finalGrade = "N";
        }
    }

    public double getFinalMark() {
        return finalMark;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    // Method to compare this student with another student
    public boolean equals(Student other) {
        return this.studentNumber == other.studentNumber &&
               this.firstName.equals(other.firstName) &&
               this.lastName.equals(other.lastName) &&
               this.birthDate.equals(other.birthDate);
    }
}
