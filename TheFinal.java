/*******************************************************************************
 * Assignment 2 
 * Purpose: 
 * Author: William Halling Howard
 * Date: October 2018
 * 
 * Assumptions
 * User will enter data of the correct type
 * Assumed the dates entered are valid 
 *      for example day is between 1 - 31
 *      for example month student is between 1 - 12
 *      for example birth year is between the years of 1900 and 2018
 * Assumed 12 students are the max needed
 * Students cant have a negative assignment mark
 * 
 * 
 * Limitations
 * The array can not expand its maximum cap of 12 students
 * The first eight are hard coded so they are always there
 * Have to change the assignment values every year
 ******************************************************************************/

package thefinal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TheFinal
{
    public static Scanner keyboard  = new Scanner(System.in);
    public static Scanner str  = new Scanner(System.in);
    
    public static int size = 8;
    public static final int MAXSIZE = 12;

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static final int MAX_SIZE = 12;

    
    public static void main(String[] args) 
    {
        initializeStudents();
        System.out.println("Welcome to the Student Management System. Please select an option (q to quit):");
        while (true)
        {
            displayChoices();
            String input = scanner.nextLine().trim().toLowerCase();
            if ("q".equals(input)) 
            {
                System.out.println("Exiting the system.");
                break;
            }
            processCommand(input);
        }
        scanner.close();
    }


    private static void initializeStudents() 
    {
        // Preload some students
        students.add(new Student("Mr", "Joe", "Blogs", 34566678, 2, 3, 1995, 60, 50, 40, 5, 52));
        students.add(new Student("Mrs", "Stephanie", "Edgley", 34566101, 2, 3, 1994, 85, 60, 90, 9, 90));
        students.add(new Student("Mrs", "Stephanie", "Edgley", 34566101, 2, 3, 1994, 85, 60, 90, 9, 90));
        students.add(new Student("Dr", "Skullduggery", "Pleasant", 34566712, 14, 9, 1992, 90, 85, 90, 9 , 69));
        students.add(new Student("Miss", "Valkyrie", "Cain", 34566698, 23, 9, 1993, 90, 90, 85, 9, 92));
    }

    
    private static void displayChoices() 
    {
        System.out.println("\na: Add new student");
        System.out.println("b: Display all students");
        System.out.println("c: Display students above/below average grades");
        System.out.println("d: Display grade distribution");
        System.out.println("e: View details by student number");
        System.out.println("f: View details by name");
        System.out.println("g: Display top performing students");
        System.out.println("h: Sort by student number");
        System.out.println("i: Sort by name");
        System.out.println("q: Quit");
    }


    private static void processCommand(String command)
    {
        switch (command) 
        {
            case "a":
                if (students.size() < MAX_SIZE) 
                {
                    addStudent();
                } 
                else 
                {
                    System.out.println("Cannot add more students. Maximum capacity reached.");
                }
                break;
                
            case "b":
                printAllStudents();
                break;
                
            case "c":
                displayStudentsBasedOnAverage();
                break;
                
            case "d":
                displayGradeDistribution();
                break;
                
            case "e":
                viewDetailsByStudentNumber();
                break;
                
            case "f":
                viewDetailsByName();
                break;
                
            case "g":
                displayTopStudents();
                break;
                
            case "h":
                sortStudentsByNumber();
                break;
                
            case "i":
                sortStudentsByName();
                break;
                
            default:
                System.out.println("Invalid choice, please select again.");
                break;
        }
    }    

    
    private static void addStudent() 
    {
        System.out.println("Adding a new student:");
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        
        System.out.print("Enter student number: ");
        long studentNum = Long.parseLong(scanner.nextLine());

        
        System.out.print("Enter day of birth: ");
        int day = Integer.parseInt(scanner.nextLine());

        
        System.out.print("Enter month of birth: ");
        int month = Integer.parseInt(scanner.nextLine());

        
        System.out.print("Enter year of birth: ");
        int year = Integer.parseInt(scanner.nextLine());

        
        System.out.print("Enter grades for Assignment One, Two, Three, Lab results, and Exam results: ");
        double a1 = Double.parseDouble(scanner.nextLine());
        double a2 = Double.parseDouble(scanner.nextLine());
        double a3 = Double.parseDouble(scanner.nextLine());
        double lab = Double.parseDouble(scanner.nextLine());
        double exam = Double.parseDouble(scanner.nextLine());

        students.add(new Student(title, firstName, lastName, studentNum, day, month, year, a1, a2, a3, lab, exam));
        System.out.println("Student added successfully.");
    }

    
    private static void printAllStudents() 
    {
        for (Student student : students) 
        {
            System.out.println(student);
        }
    }
    

    private static void displayStudentsBasedOnAverage() 
    {
        double average = students.stream()
                                 .mapToDouble(Student::getFinalMark)
                                 .average()
                                 .orElse(0.0);
        System.out.println("Average grade: " + average);
        System.out.println("Students above average:");
        students.stream()
                .filter(s -> s.getFinalMark() > average)
                .forEach(System.out::println);
        System.out.println("Students below average:");
        students.stream()
                .filter(s -> s.getFinalMark() < average)
                .forEach(System.out::println);
    }

    
    private static void displayGradeDistribution() 
    {
        long counts[] = students.stream()
                                .map(Student::calcFinalGrade)
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                .values()
                                .toArray(new Long[0]);
        System.out.println("Grade distribution:");
        System.out.println("HD: " + counts[0] + ", D: " + counts[1] + ", C: " + counts[2] + ", P: " + counts[3] + ", F: " + counts[4]);
    }

    
    private static void viewDetailsByStudentNumber() 
    {
        System.out.print("Enter student number: ");
        long num = Long.parseLong(scanner.nextLine());
        students.stream()
                .filter(s -> s.getStudentNum() == num)
                .findFirst()
                .ifPresent(System.out::println);
    }

    
    private static void viewDetailsByName() 
    {
        System.out.print("Enter first name: ");
        String fName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lName = scanner.nextLine();
        students.stream()
                .filter(s -> s.getFirstName().equalsIgnoreCase(fName) && s.getLastName().equalsIgnoreCase(lName))
                .findFirst()
                .ifPresent(System.out::println);
    }

    
    private static void displayTopStudents() 
    {
        System.out.println("Top performing students:");
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getFinalMark).reversed())
                .limit(2)
                .forEach(System.out::println);
    }

    
    private static void sortStudentsByNumber() 
    {
        students.sort(Comparator.comparingLong(Student::getStudentNum));
        System.out.println("Students sorted by number:");
       
        printAllStudents();
    }

    
    private static void sortStudentsByName() 
    {
        students.sort(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName));
        System.out.println("Students sorted by name:");
        
        printAllStudents();
    }
}
