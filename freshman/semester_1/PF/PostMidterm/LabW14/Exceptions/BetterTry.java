import java.util.InputMismatchException;
import java.util.Scanner;


class BetterTry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        do {
            double top, bot;
            try (sc) {
                System.out.println("Please enter a / b");    ;
                top = sc.nextInt();
                bot = sc.nextInt();
                // goto a
                System.out.println(top / bot);
            }
            catch (InputMismatchException e) {
                System.err.println("Your input is not valid " + e);
                System.exit(1);
            }
            catch(ArithmeticException e)
            {
                System.out.println("Can't devide by 0" + e);
            }
            finally {
                System.out.println("Finally");
                sc.close();
                run = false;
            }

        } while (run);
        System.out.println("Good bye");
    }
}
