import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
public class ReadBinaryFile {
   public static void main(String[] args) {
      try(FileInputStream fis = new FileInputStream("employee.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);) {
            System.out.printf("%-10s%-12s%-12s%10s%n", "Emp Id",
                "First Name", "Last Name", "Salary");
            while (fis.available() > 0) { // while there is more to read
                int employeeId = ois.readInt();
                String firstName = (String) ois.readObject();
                String lastName = (String) ois.readObject();
                double salary = ois.readDouble();
                System.out.printf("%-10d%-12s%-12s%10.2f%n", employeeId,
                firstName, lastName, salary);            
            }       
        }
        catch(FileNotFoundException e) {
            System.err.printf("File not found: %s%n", e);
        } 
        catch(ClassNotFoundException e) {
            System.err.printf("Invalid data: %s%n", e);
        }
        catch (IOException e) {
            System.err.printf("Unknown I/O error: %s%n", e);
            e.printStackTrace();
        } 
        
    } 
} 

