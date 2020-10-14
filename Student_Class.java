package thefinal;

public class Student
{
    private String studentTitle;

    private String givenName, lastName;

    private long studentNum;

    private int birthDay, birthMonth, birthYear;

    private double assignmentOne, assignmentTwo, assignmentThree, labResults, examResults, finalmark;
    
    private String finalgrade;
     
    
    public Student()
    {
        studentTitle = "";
        
        studentNum = 0;

        birthDay = 1;

        birthMonth = 1;

        birthYear = 1953;

        assignmentOne = -1;

        assignmentTwo = -1;

        assignmentThree = -1;

        labResults = -1;

        examResults = -1;
    
        finalmark = 0;
        
        finalgrade = "";
    }
    
    public Student(String studentTitle, String firstName, String lastName, long studentNum, int dayDate, int monthDate, int yearDate, double assignmentOne, double assignmentTwo, double assignmentThree, double labResults, double examResults)
    {
        this.studentTitle = studentTitle;
        
        this.studentNum = studentNum;
        
        this.givenName = firstName;
        
        this.lastName = lastName;
        
        this.birthDay = dayDate;

        this.birthMonth = monthDate;

        this.birthYear = yearDate;

        this.assignmentOne = assignmentOne;

        this.assignmentTwo = assignmentTwo;

        this.assignmentThree = assignmentThree;

        this.labResults = labResults;

        this.examResults = examResults;
    
        calcOveralGrade();
        
    }        
    
    public String getTitle()
    {
        return(studentTitle);
    }
    
    public String getFirstName()
    {
        return(givenName);
    }
    
    public String getLastName()
    {
        return(lastName);
    }
    
    public long getStudentNum()
    {
        return(studentNum);
    }

    public int getBirthDateDay()
    {
        return(birthDay);
    }
    
    public int getBirthMonth()
    {
        return(birthMonth);
    }
    
    public int getBirthYear()
    {
        return(birthYear);
    }
    
    public double getAssignmentOneGrade()
    {
        return(assignmentOne);
    }
    
    public double getAssignmentTwoGrade()
    {
        return(assignmentTwo);
    }
    
    public double getAssignmentThreeGrade()
    {
        return(assignmentThree);
    }
    
    public double getLabResults()
    {
        return(labResults);
    }
    
    public double getExamResult()
    {
        return(examResults);
    }
    
    public double getOveralGrade()
    {
        return(finalmark);
    }
    
    public double getFinalGrade()
    {
        return(finalmark);
    }
    
    public void setTitle(String studentTitle)
    {
        this.studentTitle = studentTitle;
    }
    
    public void setFirstName(String givenName)
    {
        this.givenName = givenName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setStudentNum(long studentNum)
    {
        this.studentNum = studentNum;
    }
    
    public void setDayOfBirth(int birthDay)
    {
        this.birthDay = birthDay;
    }
    
    public void setMonthOfBirth(int birthMonth)
    {
        this.birthMonth = birthMonth;
    }
    
    public void setYearOfBirth(int birthYear)
    {
        this.birthYear = birthYear;
    }
    
    
/*******************************************************************************
 * setAssignmentOneGrade is setting assignment one
 * Method is also error testing by printing accordingly if a value too high or low entered 
 ******************************************************************************/    
    
    public void setAssignmentOneGrade(double assignmentOne)
    {
                
        if(assignmentOne < 0 || assignmentOne > 100 )
        {
            System.out.println("Assignment grade is now set to default value of -1 ");
        
            assignmentOne = -1;
        }
        
        else
            this.assignmentOne = assignmentOne;
        
        calcOveralGrade();
        
    }
    
    
/*******************************************************************************
 * setAssignmentTwoGrade is setting assignment two
 * Method is also error testing by printing accordingly if a value too high or low entered 
 ******************************************************************************/    
    
    public void setAssignmentTwoGrade(double assignmentTwo)
    {
        if(assignmentTwo < 0 || assignmentTwo > 100)
        {
            System.out.println("Assignment Two grade is now set to default value of -1 ");
        
            assignmentTwo = -1;
        }
        
        else
            this.assignmentTwo = assignmentTwo;
        
        calcOveralGrade();  
    }
    
    
/*******************************************************************************
 * setAssignmentThreeGrade is setting assignment three
 * Method is also error testing by printing accordingly if a value too high or low entered 
 ******************************************************************************/    
    
    public void setAssignmentThreeGrade(double assignmentThree)
    {
        if(assignmentThree < 0 || assignmentThree > 100)
        {
            System.out.println("Assignment Three grade is now set to default value of -1 ");
        
            assignmentThree = -1;
        }
        
        else
            this.assignmentThree = assignmentThree;
        
        calcOveralGrade();   
    }
    
    
/*******************************************************************************
 * setAssignmentOneGrade is setting assignment one
 * Method is also error testing by printing accordingly if a value too high or low entered 
 ******************************************************************************/   
    
    public void setLabResults(double labResults)
    {
        
        if(labResults < 0 || labResults > 100)
        {
            System.out.println("Lab Results Grade is now set to default value of -1 ");
        
            labResults = -1;
        }
        
        else
            this.labResults = labResults;
        
        calcOveralGrade();
    }
    
    
/*******************************************************************************
 * setAssignmentOneGrade is setting assignment one
 * Method is also error testing by printing accordingly if a value too high or low entered 
 ******************************************************************************/    
    
    public void setExamResults(double examResults)
    {
        if(examResults < 0 || examResults > 100)
        {
            System.out.println("Exam Grade is now set to default value of -1 ");
        
            examResults = -1;
        }
        else
            
            this.examResults = examResults;
            
        calcOveralGrade();
    }
        
    
/*******************************************************************************
 * calOveralGrade method does the following
 * 
 * takes mark as a float, mark then takes the value of each assessed piece of work 
 *
 * Once the marks are stored in mark, this.finalmark will take the value of mark 
 ******************************************************************************/    
    
    private void calcOveralGrade()    
    {
        if(assignmentOne != -1 && assignmentTwo != -1 && assignmentThree !=-1 && labResults !=-1 && examResults !=1)
        {
            float mark = 0;

            mark += assignmentOne * .15;
            mark += assignmentTwo * .15;
            mark += assignmentThree * .15;
            mark += labResults * .1;
            mark += examResults * .45;

            this.finalmark =  mark;
            getFinalGrade();
        }
        
    }
    
    
/*******************************************************************************
 * calcFinalGrade method does the following
 * 
 * getFinalGrade takes in getOveralGrade to calculate what the final grade is 
 
 * If the final mark is less than or equal to .8 final grade is HD
 * If the final mark is less than or equal to .7 final grade is D
 * If the final mark is less than or equal to .6 final grade is a C
 * If the final mark is less than or equal to .5 final grade is a P
 * Else the grade is N due to scoring below 50
 * Has no Return value
 ******************************************************************************/
 
    public String calcFinalGrade()
    {
        getOveralGrade();
        
        if(this.finalmark >= 80)

            finalgrade = "HD";

        else if(this.finalmark >= 70)

            finalgrade = "D";

        else if(this.finalmark >= 60)

            finalgrade = "C";

        else if(this.finalmark >= 5)

            finalgrade = "P";
        
        else
            
            finalgrade = "N";
        
        return finalgrade;
    }

    
/*******************************************************************************    
* BirthDate Method is for coverting the three integers into a string 
* dateOfBirth will now print as follows 
* day entered(as an int)/ month entered(as an int) year entered(as an int)
* *****************************************************************************/
    
    public String birthDate()
    {
        String dateOfBirth = this.birthDay + "/" +this.birthMonth + "/" +this.birthYear;
        return dateOfBirth;
    }
    
    
/*******************************************************************************
 * equalsSameDetails Method does the following 
 * 
 * If two students have the same of the following data Student names, & Student number, the same date of birth
 * If two student objects are identical the boolean return will be true 
 * Otherwise the return will be false 
 * 
 * 
 * Check if this should use compare to method
 ******************************************************************************/
     
    public boolean equalssameDetails(Student student2)
    {
        if(!(this.birthDay == student2.birthDay && this.birthMonth == student2.birthMonth && this.birthYear == student2.birthYear))
            
            return false;
       
        if(!(this.givenName.equals(student2.givenName) && this.lastName.equals(student2.lastName)))
                 
            return false;
        
        if(this.studentNum == student2.studentNum)
            
            return true;
        
        else 
            return false;
    }
 
/*******************************************************************************
 * obtainGenius Method does the following 
 * 
 * Searches through the array and if the data in getOveralGrade is larger than largest
 * Best student is the student at the ith position in the array  
 * The best student is the student with the best grades and is stored in position 0 of the array
 * The second best student is the student with the second highest grades and is stored in position 1
 ******************************************************************************/

    
    public static Student[] obtainGenius(Student[] details, int SIZE)
    {
        double largest = 0;
        double secondLargest = 0;
        
        int bestStudentIndex = 0;
        int secondBestStudentIndex = 0;
        
        
        for(int i = 0 ; i < SIZE; i++)
        {    
            if(details[i].getOveralGrade() > largest)
            {  
                largest = details[i].getOveralGrade();
                
                bestStudentIndex = i;
            }
            
            else if(details[i].getOveralGrade() > secondLargest)
            {
                secondLargest = details[i].getOveralGrade();
                
                secondBestStudentIndex = i;
            }       
        }
        
        Student bestResults[] = new Student[2];
        bestResults[0] = details[bestStudentIndex];
        bestResults[1]= details[secondBestStudentIndex];
        
        return bestResults;
    }
    
    
/*******************************************************************************
 * sortStudentNumAsscending Method does the following 
 * 
 * Searches through the array and if the studentNum is less than details at position they are stored at position 0
 * This continues throughout the array until the students are sorted from lowest student number to highest student number
 * 
 * Method returns details
 ******************************************************************************/
    
    public static Student[] sortStudentNumAscending(Student[] details, int SIZE)
    {
        for(int i = 1; i < SIZE; i++)
        {
            Student temp = details[i];
            int j = 0;
            
            while(temp.getStudentNum() > details[j].getStudentNum())
            {
                j++;
            }
            
            for(int k = i; k > j; k--)
            {
                details[k] = details[k-1];
            }
            details[j] = temp;
        }
        return details;
    }   

 
/*******************************************************************************
* sortStudentNameAsscending Method does the following 
* 
* Searches through the array and if the lastName comes before the other it is stored at position 0 to the size of the array
* This continues throughout the array until the students are sorted from lowest first alphabetical letter to last alphabetical number of the last name
* 
* Method returns details
******************************************************************************/

    public static Student[] sortStudentNameAscending(Student[] details, int SIZE)
    {
        for(int i = 1; i < SIZE; i++)
        {    
            for(int j = 0; j < SIZE -1; j++)
            {    
                if(details[j].getLastName().compareTo(details[j+1].getLastName()) > 0) 
                    
                    exchange(details, j, j+1); 
            }   
        }
        return details;
    }


/*******************************************************************************
 * Method exchange is a private method as it is only used in the sortStudentNameAsscending and the user doesn't need to interact with it
 * @param details
 * @param firstStudent
 * @param secondStudent 
 * 
 ******************************************************************************/    
    private static void exchange(Student[] details, int firstStudent, int secondStudent)
    {
        Student exchange; 
        exchange = details[firstStudent];
        details[firstStudent] = details[secondStudent]; 
        details[secondStudent] = exchange;    
    }
}

