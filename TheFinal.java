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

import java.util.Scanner;

public class TheFinal
{
    public static Scanner keyboard  = new Scanner(System.in);
    public static Scanner str  = new Scanner(System.in);
    
    public static int size = 8;
    public static final int MAXSIZE = 12;
    
/*******************************************************************************
 * Method Main 
 * 
 * Calls the method printMyStudentDetails method
 * printMyStudentDetails - prints all of William Halling Howards Details
 * 
 * Main performs a switch case statement
 * Switch case displays a menu to tell the client what each option does
 * The user has to enter a letter between a - q, however q quits the program.
 * The switch case will continue to loop as long as the client doesn't enter the letter 'q'
 ******************************************************************************/
    
    public static void main(String[] args)
    {
        Student[] details;
        
        details = new Student[MAXSIZE];
        
        details[0] = new Student("Mr", "Joe", "Blogs", 34566678, 2, 03, 1995, 60, 50, 40, 5, 52);
        details[1] = new Student("Mrs", "Stephanie", "Edgley", 34566101, 2, 3, 1994, 85, 60, 90, 9, 90);
        details[2] = new Student("Dr", "Skullduggery", "Pleasant", 34566712, 14, 9, 1992, 90, 85, 90, 9 , 69);
        details[3] = new Student("Miss", "Valkyrie", "Cain", 34566698, 23, 9, 1993, 90, 90, 85, 9, 92);
        details[4] = new Student("Miss", "Tanith", "Low", 34566692, 23, 9, 1993, 60, 59, 72, 7, 90);
        details[5] = new Student("Dr", "China", "Sorrows", 34566824, 12, 12, 1995, 67, 72, 50, 8, 90);
        details[6] = new Student("Ms", "Kindred", "Howard", 34566824, 12, 12, 1995, 50, 50, 50, 7, 90);
        details[7] = new Student("Mistress", "Sylvanas", "Windrunner", 34566999, 12, 12, 1995, 82, 79, 93, 6, 60);
        
        System.out.println("Please enter a letter between a - q to perfom from the following options");
        char selection = '\0';
        
        String userInput = "";
        printMyStudentDetails();
        
        while(selection != 'q')
        {
            displayChoices();
        
            userInput = str.nextLine().toLowerCase().trim();
            if(userInput.isEmpty())
                
                selection = '\0';
            
            else
                selection = userInput.charAt(0);
             
            switch(selection)
            {
                case 'a':
                    obtainStudentInfo(details);
                    break;
        
                case 'b':
                    printAllStudentDetails(details);
                    break;
        
                case 'c':
                    numberOfAverage(details);
                    break;
        
                case 'd':
                    distributionOfGrades(details);
                    break;
            
                case 'e':
                    viewDetails(details);
                    break;
                
                case 'f':
                    viewDetailsName(details);
                    break;
                    
                case 'g':
                    obtainSmartestStudents(details);
                    break;
                    
                case 'h':
                    displayStudentIDAscendingOrder(details);
                    break;
                
                case 'i':
                    displayNameAscendingOrder(details);
                    break;
                    
                case 'q':
                    break;
                    
                default:
                    System.out.println("Invalid selection");     
                    
                    size = size +1;
            }
            
            if(selection !='q')

                System.out.println("");
        }
    }
    
/*******************************************************************************
 * pubic printMyStudentDetails Method does the following 
 * 
 * Method displays my student details 
 * William Halling Howard, 32233703
 * 
 * Students enrollment type
 * Tutorial time and tutor 

 * returns nothing
 ******************************************************************************/

    public static void printMyStudentDetails()
    {
        System.out.println("Student Name and Number: William Halling Howard 32233703");
        System.out.println("Student Enrolment Type: Internal ");
        System.out.println("Tutorial Time and Tutor: Mark Abernethy Thursday 3.30");
    }    
    
/*******************************************************************************
 * public displayChoices Method does the following 
 * 
 * Method displays each of the choices and what they each of the choices do
 * for example a = add new student
 
 * returns nothing
 ******************************************************************************/
    
    public static void displayChoices()
    {
        System.out.println("Option 'a' or 'A' Add new student, and information about a student to the array ");
        
        System.out.println("Option 'b' or 'B' Display all details about the students");
        
        System.out.println("Option 'c' or 'C' Display how many students obtained an overal mark equal to or above average, and how many obtained an overal mark  below the average");
        
        System.out.println("Option 'd' or 'D' Display the distribution of grades, number of HDs, Ds, Cs, Ps");
        
        System.out.println("Option 'e' or 'E' Give the students number for the student you are looking for to see their details");
        
        System.out.println("Option 'f' or 'F' Give the students name, for the student you are looking for to see all details of that student");
        
        System.out.println("Option 'g' or 'G' Displays names of students with highest overal mark and second highest overal mark");
        
        System.out.println("Option 'h' or 'H' Displays students in ascending order via student number");
        
        System.out.println("Option 'i' or 'I' Dispalys students in ascending alphabetical order by their last name");
        
        System.out.println("Quit option, Please press Q or q to quit"); 
    }
        

/*******************************************************************************
 * public obtainStudentInfo Method does the following 
 * 
 * Method allows the user of the program to code in the following
 * Students first name, last name, studentNum and the students birthday, 
 * Method tells the user if two students are the same 
 * Method also calls in the getGradeValues method
 *      getGradesValues method asks the user for the % value of grades for each of  the assignments
 
 * The for loop goes through the array and prints "The students that have the same details are _  and _ 
 
 * Returns nothing
 ******************************************************************************/
    
    public static void obtainStudentInfo(Student[] details)
    {
        int birthDay = -1;
        int birthYear = -1;
        int birthMonth = -1;
        
        if(size >= MAXSIZE)
        {   
            System.out.println("There is no more room left in the array for a new student");
            return;
        }
        
        else
        {
            details[size] = new Student();

            System.out.println("Please enter the students title : ");
            String title = str.nextLine().toLowerCase().trim();
            details[size].setTitle(title);
            
            System.out.print("Please enter students first name  : ");
            String givenName = str.nextLine().toLowerCase().trim();
            details[size].setFirstName(givenName);

            System.out.print("Please enter students last name  : ");
            String lastName = str.nextLine().toLowerCase().trim();
            details[size].setLastName(lastName);            
    
            System.out.print("Please enter student number as a long : ");
            long studentNum = keyboard.nextInt();
            details[size].setStudentNum(studentNum);
            
            while(birthDay < 1 || birthDay > 31)
            {    
                System.out.print("Please enter the date for the day  as an int the student was born as an integer  : ");
                birthDay = keyboard.nextInt();
                details[size].setDayOfBirth(birthDay);
            
            if(birthDay < 1 || birthDay > 31)
                
                System.out.println("Please enter a valid date for the birth date between the range of 1 and 31 as an integer: ");
            }
                
            while(birthMonth < 1 || birthMonth > 12)
            {
                System.out.print("Please enter  the date for the month as an int the student was born  : ");
                birthMonth = keyboard.nextInt();
                details[size].setMonthOfBirth(birthMonth);
            
                if(birthMonth < 1 || birthMonth > 12)
                    
                    System.out.println("Please enter a valid month value between 1 and 12 for students month of birth as an interger");
            }
            
            while(birthYear < 1938 || birthYear > 2018)
            {    
                System.out.print("Please enter  the year the student was born between 1938 to 2018 as an integerr : ");
                birthYear = keyboard.nextInt();
                details[size].setYearOfBirth(birthYear);
                
                if(birthYear < 1900 || birthYear > 2018)
                    
                    System.out.println("Please enter a valid year between 1938 and 2018 for students year of birth");
            }
            
        obtainGradeValues(details);
        
        size = size + 1;
        }
    }
    
    
/*******************************************************************************
 * private void getGradeValues is a helper method of the method obtainStudentInfo
 * allows the programmer to program the grades for each assignment for the new student added
 * 
 * The method will try to do assignmentOneGrade as long as the value is between 0 - 100 else it will set it to -1
 * The method will try to do assignmentTwoGrade as long as the value is between 0 - 100 else it will set it to -1
 * The method will try to do assignmentThreeGrade as long as the value is between 0 - 100 else it will set it to -1
 * The method will try to do labResults as long as the value is between 0 - 10 else it will set it to -1
 * The method will try to do ExamResults as long as the value is between 0 - 100 else it will set it to -1
 * 
 * Returns nothing
 ******************************************************************************/
    
    public static void obtainGradeValues(Student[] details)
    {  
        double assignmentOne = -1;
        double assignmentTwo = -1;
        double assignmentThree = 1;
        double labResults = -1;
        double examResults = -1;
        
        
            System.out.print("Please enter students grade for Assignment One as a double value between 0 - 100 : ");
            try
            {
                assignmentOne = Integer.valueOf(str.nextLine());
            }
            catch(NumberFormatException e)
            {
                assignmentOne = -1;
            }
            details[size].setAssignmentOneGrade(assignmentOne);
            
            
            
            System.out.print("Please enter students grade for Assignment Two as a double value between 0 - 100 : ");
            try
            {
                assignmentTwo = Integer.valueOf(str.nextLine());
            }
            catch(NumberFormatException e)
            {
                assignmentTwo = -1;
            }
            details[size].setAssignmentTwoGrade(assignmentTwo);
            
            
            System.out.print("Please enter students grade for Assignment Three as a double value between 0 - 100 : ");
            try
            {
                assignmentThree = Integer.valueOf(str.nextLine());
            }
            catch(NumberFormatException e)
            {
                assignmentThree = -1;
            }
            details[size].setAssignmentThreeGrade(assignmentThree);
            
           
            System.out.print("Please enter students lab results as an double value between 0 - 10 ");
            try
            {
                labResults = Integer.valueOf(str.nextLine());
            }
            catch(NumberFormatException e)
            {
                labResults = -1;
            }
            details[size].setLabResults(labResults);
        
           
            System.out.print("Please enter students Exam Results as a double value between 0 - 100: " );
            try
            {
                examResults = Integer.valueOf(str.nextLine());
            }
            catch(NumberFormatException e)
            {
                examResults = -1;
            }
            details[size].setExamResults(examResults);   
    }   
    

/*******************************************************************************
 * Method printAllStudentDetails, takes in the array type student and its details
 * The method prints all students details in the array.
 
 * The method returns the averageGrade achieved
 ******************************************************************************/    
    
    public static void printAllStudentDetails(Student[] details)
    {
        for(int i = 0; i < size; i++)
        {  
            printStudent(details[i]);
        }
    }
        
      
/*******************************************************************************
 * Method getAverage, takes in the array type student and its details
 * The method Calculates the average scores in the for loop.
 * Method also calls getOveralGrade
 * 
 * The method returns the averageGrade achieved
 ******************************************************************************/    
    
    public static double calcAverage(Student[] details)
    {
        double average = 0;
        double averageGrade = 0;

        for(int i = 0; i < size; i ++)
        {    
            average += details[i].getOveralGrade();
        }
        averageGrade = (double)average / size;             

        return averageGrade;
    }

    
/*******************************************************************************
 * Public Method numberOfAverage, takes in the array type student and its details
 * The method prints out the number of students who scored aboveAverage
 * The method prints out the number of students who scored belowAverage
 *  
 * The method returns the number of belowAverage grades achieved
 ******************************************************************************/    
    
    public static void numberOfAverage(Student[] details)
    {
        System.out.println("The number of students who scored above average is : " +aboveAverage(details));

        System.out.println("The number of students who scored below average is : " +belowAverage(details));
    }

    
/*******************************************************************************
 * Public Method belowAverage, takes in the array type student and its details
 * The method compares the average against grades at position[i] in the details array
 * If the grade is below average belowAverage will increment
 *  
 * The method returns the number of belowAverage grades achieved
 ******************************************************************************/
    
    public static int belowAverage(Student[] details)
    {
        int belowAverage = 0;
        double averageGrade = calcAverage(details);

        for(int i = 0; i < size; i++)

            if(details[i].getOveralGrade() < averageGrade)

                belowAverage++;

        return belowAverage;
    }

    
/*******************************************************************************
 * Method aboveAverage, takes in the array type student and its details
 * The method compares the average against grades at position[i] in the details array
 * If the grade is greater than average aboveAverage will increment
 *  
 * The method returns the number of aboveAverage grades achieved
 ******************************************************************************/
    
    public static int aboveAverage(Student[] details)
    {
        int aboveAverage = 0;
        double averageGrade = calcAverage(details);

        for(int i = 0; i < size; i++)
        
            if(details[i].getOveralGrade() >= averageGrade)

                aboveAverage++;

        return aboveAverage;
    }

    
/*******************************************************************************
 * Method distributionOfGrades, takes in the array type student and its details
 * The method increments grades according to what grade they achieve, 
 * Grade lettering is determined in the Student class
 * The method then prints out how many HDs, Ds, Cs, Ps and Ns are achieved
 * 
 * Method has no return value
 ******************************************************************************/
        
    public static void distributionOfGrades(Student[] details)
    {
        int HD = 0;
        int D = 0;
        int C = 0;
        int P = 0;
        int N = 0;

        for(int i = 0; i < size; i++)
        { 
            String studentGrade = details[i].calcFinalGrade();

            if(studentGrade.equals("HD"))

                HD++;

            else if(studentGrade.equals("D"))

                D++;

            else if(studentGrade.equals("C"))

                C++;

            else if(studentGrade.equals("P"))

                P++;

            else if(studentGrade.equals("N"))

                N++;
        }

        System.out.println("The number of HDs is : " +HD);
        System.out.println("The number of Ds is : " +D);
        System.out.println("The number of Cs is : " +C);
        System.out.println("The number of Ps is : " +P);
        System.out.println("The number of Ns is : " +N);
    }


/*******************************************************************************
 * viewDetails method,      
 * Gets user to enter in the student number
 * The array will then search for the student and print the students details
 * If the student number is not in the array the appropriate error message is displayed
 * 
 * Method has no return value
 ******************************************************************************/    
    
    
    public static void viewDetails(Student[] details)
    {
        long studentNumber;

        System.out.println("Please enter the students number : ");
        studentNumber = keyboard.nextInt();

        for(int i = 0; i < size; i++)
        {
            details[i].getStudentNum();

            if(studentNumber == details[i].getStudentNum())
            {    
                printStudent(details[i]);
                return;
            }
        }
        System.out.println("Student not found : ");
    }

    
/*******************************************************************************
 * public viewDetailsName method 
 * 
 * gets user to enter the following details of the person, 
 * User of program can enter the firstName, lastName 
 
 * if the first name and last name match the method will call printStudent()
 * If the student name is not in the array the array will print student not found
 
 * Method has no return value
 ******************************************************************************/        
        
    public static void viewDetailsName(Student[] details)
    {
        String studentFirstName;
        String studentLastName;

        System.out.print("Please enter students first name : ");
        studentFirstName = str.nextLine().toLowerCase();
        
        System.out.print("Please enter students last name : ");
        studentLastName = str.nextLine().toLowerCase();

        for(int i = 0; i < size; i++)
        {
            int firstName = studentFirstName.compareToIgnoreCase(details[i].getFirstName());
            
            int lastName = studentLastName.compareToIgnoreCase(details[i].getLastName());
            
            if(firstName == 0 && lastName == 0)
            {     
                printStudent(details[i]);
                return;
            }
        }       
        System.out.println("Student not found in the array : ");
    }

  
/*******************************************************************************
 * private printStudent method prints out the details of the person.
 * The method gets the getStudentNum(), getFirstName(), getLastName(), BirthDate(), getFinalGrade(), getOveralGrade()
 * The method is then called by the viewDetails method

 * Method has no return value
 ******************************************************************************/        

    public static void printStudent(Student data)
    {
        System.out.println("the student ID number is  : " +data.getStudentNum()); 
        System.out.println("the given name of the student is : " +data.getFirstName());
        System.out.println("the last name of the student is : " +data.getLastName());

        System.out.println("The students data of birth is : " +data.birthDate());

        System.out.println("The students letter grade is : " +data.getFinalGrade());
        
        String overalGrade = String.format("%.2f", data.getOveralGrade());
        System.out.println("The students grade is : % "  +overalGrade);
    }

    
/*******************************************************************************
 * public obtainSmartestStudents method 
 *  
 * Calls the getGenius() method from the class student
 * The program then prints the best student and second best student along with all their details
 
 * Method has no return value
 ******************************************************************************/        
        
    public static void obtainSmartestStudents(Student[] details)
    {
        Student bestStudents[] = Student.obtainGenius(details, size);
        
        System.out.println("The best student is  " +bestStudents[0].getFirstName() + " " + bestStudents[0].getLastName());
        System.out.println("The Second best Student is " +bestStudents[1].getFirstName()+  " " + bestStudents[1].getLastName());
    }
 
    
/*******************************************************************************
 * public displayStudentIDAscendingOrder method 
 *  
 * Sorts the array into order via calling the StudentNumAscending method in the class student
 * Prints the list of students in ascending order depending their ID number 
 * Method has no return value
 ******************************************************************************/        
    
    public static void displayStudentIDAscendingOrder(Student[] details)
    {
        Student.sortStudentNumAscending(details, size);
        System.out.println("Array is now sorted in ascending order ");
        
        System.out.println("The list of students in ascending order is " );
        printAllStudentDetails(details);
    }

    
/*******************************************************************************
 * public displayNameAscendingOrder method 
 *  
 * Sorts the array into ascending order via calling the sortStudentNameAscending method in the class student
 * Prints the list of students in ascending order via character value
 * Method has no return value
 ******************************************************************************/        

    public static void displayNameAscendingOrder(Student[] details)
    {
        Student.sortStudentNameAscending(details, size);
        System.out.println("Array is now sorted in ascending order ");
        
        System.out.println("The list of students in ascending order is " );
        printAllStudentDetails(details);
    }
}