import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RestorePerson {
  public static void main(String args[]) {
    try(FileInputStream fis = new FileInputStream("person.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);) {
        while(fis.available() > 0) {
          Person person = (Person) ois.readObject();
          System.out.println(person);
        }
    }
    catch (ClassNotFoundException e) {
      System.err.println("Cannot read object: " + e);
    }
    catch(IOException e) {
      System.out.println("Exception: " + e);
    }
  }
}


