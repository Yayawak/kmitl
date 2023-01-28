import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
public class ReadCSVFile {
   public static void main(String[] args) {
      try(Scanner input = new Scanner(Paths.get("employee.csv"))) {
         System.out.printf("%-10s%-12s%-12s%10s%n", "Emp Id",
            "First Name", "Last Name", "Salary");
         while (input.hasNext()) {
            String row = input.nextLine();
            String[] dataFields = row.split(",");
            int employeeId = Integer.parseInt(dataFields[0]);
            String firstName = dataFields[1];
            String lastName = dataFields[2];
            double salary = Double.parseDouble(dataFields[3]);
            System.out.printf("%-10d%-12s%-12s%10.2f%n", employeeId,
               firstName, lastName, salary);
         }       
      } 
      catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
         System.out.printf("Data format error: %s%n", e);
      }
      catch (NoSuchFileException e) {
         System.out.printf("File not found: %s%n", e);
      }
      catch (IOException e) {
         System.out.printf("Unknown I/O error: %s%n", e);
         e.printStackTrace();
      } 
   } 
} 