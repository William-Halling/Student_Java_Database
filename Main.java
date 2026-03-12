package thefinal;

public class Main 
{
    public static void main(String[] args) 
    {
        StudentRepository repo = new StudentRepository();

        repo.addStudent(new Student(
                "Mr","Joe","Blogs",
                34566678,
                2,3,1995,
                60,50,40,5,52));

        StudentService service = new StudentService(repo);

        StudentCLI cli new StudentCLI(repo, service);

        cli.run();
    }
}
