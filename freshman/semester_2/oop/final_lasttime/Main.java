import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        try {

            // Scanner sc = new Scanner("/Users/rio/Desktop/kmitl/freshman/semester_2/oop/final_lasttime");
            Scanner sc = new Scanner(Paths.get("./subFolder/movies.txt"));
            System.out.println(sc.nextLine());
        } catch (Exception e) {
        }

        // try (Scanner input = new Scanner(
        //     Paths.get("Main.java")
        // ))
        // {
        //     while (input.hasNext()) {
        //         System.out.println(input.next());
        //     }
        // } catch (Exception e) {
        //     System.out.println("cannot read file");
        // }
    }
}
