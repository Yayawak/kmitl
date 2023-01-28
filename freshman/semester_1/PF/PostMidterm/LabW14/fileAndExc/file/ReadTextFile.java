import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ReadTextFile {
   public static void main(String[] args) {
      try(Scanner input = new Scanner(Paths.get("employee.txt"))) {
         System.out.printf("%-10s%-12s%-12s%10s%n", "Emp Id",
            "First Name", "Last Name", "Salary");
         while (input.hasNext()) { 
            System.out.printf("%-10d%-12s%-12s%10.2f%n", input.nextInt(),
               input.next(), input.next(), input.nextDouble());
            /*int employeeId = input.nextInt();
            String firstName = input.next();
            String lastName = input.next();
            double salary = input.nextDouble();
            System.out.printf("%-10d%-12s%-12s%10.2f%n", employeeId,
               firstName, lastName, salary);*/
         }       
      } 
      catch (InputMismatchException e) {
         System.err.printf("Data format error: %s%n", e);
      }
      catch (NoSuchFileException e) {
         System.err.printf("File not found: %s%n", e);
      }
      catch (IOException e) {
         System.err.printf("Unknown I/O error: %s%n", e);
         e.printStackTrace();
      }
   } 
} 
