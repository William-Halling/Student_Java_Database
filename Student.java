```java
package thefinal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Student {

    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String title;
    private String firstName;
    private String lastName;
    private long studentNumber;
    private LocalDate birthDate;

    private double[] grades = new double[5];

    private double finalMark;
    private String finalGrade;

    public Student(String title, String firstName, String lastName,
                   long studentNumber, int day, int month, int year,
                   double... grades) {

        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.birthDate = LocalDate.of(year, month, day);

        System.arraycopy(grades,0,this.grades,0,5);

        calculateFinalMark();
    }

    public long getStudentNumber() { return studentNumber; }

    public String getFullName() { return firstName + " " + lastName; }

    public double getFinalMark() { return finalMark; }

    public String getFinalGrade() { return finalGrade; }

    private void calculateFinalMark() {

        finalMark =
                (grades[0] + grades[1] + grades[2]) * 0.20 +
                grades[3] * 0.10 +
                grades[4] * 0.50;

        if(finalMark >= 80) finalGrade = "HD";
        else if(finalMark >= 70) finalGrade = "D";
        else if(finalMark >= 60) finalGrade = "C";
        else if(finalMark >= 50) finalGrade = "P";
        else finalGrade = "N";
    }

    @Override
    public String toString() {

        return title + " " + getFullName() +
                " (" + studentNumber + ")" +
                "\nDOB: " + birthDate.format(FORMAT) +
                "\nFinal Mark: " + finalMark +
                " Grade: " + finalGrade +
                "\nGrades: " + Arrays.toString(grades) + "\n";
    }
}
```
