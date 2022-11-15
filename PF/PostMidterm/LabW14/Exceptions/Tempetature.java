import java.util.InputMismatchException;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

class Tempetature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double f, c;
        try {
            System.out.println("Please eneter degree in fahrenheith");    ;
            f = sc.nextInt();
            c = (5.0 / 9.0) * (f + 32.0);
            System.out.println("F : " + f);
            System.out.println("C : " + c);
        // } catch (MissingFormatArgumentException e) {
        } catch (InputMismatchException e) {
            System.err.println("Your input is not valid " + e);
            System.exit(1);
        }
        finally {
            System.out.println("Finally");
            sc.close();
        }
        System.out.println("Good bye");
    }
}
