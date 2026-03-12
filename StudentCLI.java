package thefinal;

import java.util.Scanner;

public class StudentCLI {

    private final StudentRepository repo;
    private final StudentService service;

    private final Scanner scanner = new Scanner(System.in);

  
    public StudentCLI(StudentRepository repo, StudentService service) {
        this.repo = repo;
        this.service = service;
    }

  
    public void run() 
    {
        while(true) 
        {
            menu();

            String cmd = scanner.nextLine();

          
            if(cmd.equals("q")) 
            {  
              return;
            }
         
            switch(cmd) 
            {
                case "a" -> repo.getAllStudents().forEach(System.out::println);

                case "b" -> service.topStudents(3).forEach(System.out::println);

                case "c" -> 
                {
                    double avg = service.calculateAverage();
                    System.out.println("Average: " + avg);
                }

                default -> System.out.println("Invalid command");
            }
        }
    }
  

    private void menu() 
    {
        System.out.println("""
        a : display students
        b : show average
        c : top students
        q : quit""");
    }
}
