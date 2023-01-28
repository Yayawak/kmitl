import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Formatter;
public class FtoCTryWithResource {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        double fahrenheit, celsius;
        try (inp) {
            System.out.print("Please enter degree in fahrenheit ");
            fahrenheit = inp.nextDouble();
            celsius = (5.0/9.0) * (fahrenheit - 32);
            System.out.printf("%6.2f fahrenheit is %6.2f celsius\n", fahrenheit, celsius);
        }
        catch(InputMismatchException ex) {
            System.err.println("Your input is not valid: " + ex);
            //return;
            System.exit(1);
        }
        finally {
            System.out.println("Finally");
        }
        System.out.println("Good Bye");
    }
}
