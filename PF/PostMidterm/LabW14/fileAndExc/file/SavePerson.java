import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SavePerson {
  public static void main(String args[]) {
    try(FileOutputStream fos = new FileOutputStream("person.bin");
      ObjectOutputStream oos = new ObjectOutputStream(fos);) {
      Person person1 = new Person("John", "Henry");
      Person person2 = new Person("Marry", "Jane");
      oos.writeObject(person1);
      oos.writeObject(person2);
      oos.flush();
    }
    catch(IOException e) {
      System.out.println("Exception: " + e);
    }
  }
}

