import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;   
public class CreateTextFile {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int employeeId = 0;
      String firstName="", lastName="";
      double salary = 0.0;
      Path path = Paths.get("employee.txt");
      /*try (FileWriter fileWriter = new FileWriter(path.getFileName().toString(), true); 
            PrintWriter output = new PrintWriter(fileWriter); input) {*/
      try (PrintWriter output = new PrintWriter(path.getFileName().toString()); input) {
         do {
            try {
               System.out.printf("Enter employee id (0 to finish): ");
               employeeId = input.nextInt();
               if (employeeId == 0) {
                  break;
               }
               System.out.printf("Enter first name: ");
               firstName = input.next();
               System.out.printf("Enter last name: ");
               lastName = input.next();
               System.out.printf("Enter salary: ");
               salary = input.nextDouble();
               output.printf("%d %s %s %.2f%n", employeeId, firstName, lastName, salary);         
            } 
            catch (InputMismatchException e) {   
               System.err.println("Your data is invalid. Please try again.");
               input.nextLine(); // clear input buffer so that user can try again.
            }        
         } while (true);
      }
      catch (SecurityException | FileNotFoundException e) {
         System.out.println("File permission issues or File Not found");
         e.printStackTrace();
         System.exit(1);
      } 
      /*catch (IOException e) {
         System.out.println("Unknon I/O Error");
         e.printStackTrace();
         System.exit(1);
      }*/
   } 
}

