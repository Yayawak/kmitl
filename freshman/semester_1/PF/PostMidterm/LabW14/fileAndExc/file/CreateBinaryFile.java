import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;   
public class CreateBinaryFile {
   public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int employeeId = 0;
    String firstName="", lastName="";
    double salary = 0.0;
    Path path = Paths.get("employee.bin");
    try (FileOutputStream fos = new FileOutputStream(path.getFileName().toString()); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); input) {
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
               oos.writeInt(employeeId);
               oos.writeObject(firstName); 
               oos.writeObject(lastName);
               oos.writeDouble(salary);
            } 
            catch (InputMismatchException e) {   
               System.err.println("Your data is invalid. Please try again.");
               input.nextLine(); // // clear input buffer so that user can try again.
            } 
         } while (true);
      }
      catch (SecurityException | IOException e) {
         e.printStackTrace();
         System.exit(1); 
      }
   } 
}

