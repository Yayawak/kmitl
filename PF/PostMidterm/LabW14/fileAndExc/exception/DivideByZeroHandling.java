//Adapted from Java How to Program, Early Objects, 11th Edition
//By Paul J. Deitel, Harvey Deitel
import java.util.InputMismatchException;
import java.util.Scanner;
public class DivideByZeroHandling {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true; // determines if more input is needed
        do {  
            try { // read two numbers and calculate quotient  
               System.out.print("Please enter an integer numerator: ");
               int numerator = scanner.nextInt();
               System.out.print("Please enter an integer denominator: ");
               int denominator = scanner.nextInt();
               int result = quotient(numerator, denominator);  
               System.out.printf("\nResult: %d / %d = %d\n", numerator, denominator, result);
               continueLoop = false; // input successful; end looping
            }
            catch (InputMismatchException inputMismatchException) {
               System.err.println("\nException: " + inputMismatchException);
               scanner.nextLine(); // discard input so user can try again
               System.out.println("You must enter integers. Please try again.\n");
            }
            catch (ArithmeticException arithmeticException) {
               System.err.println("\nException: " + arithmeticException);
               System.out.println("Zero is an invalid denominator. Please try again.\n");
            }
        } while (continueLoop);
        scanner.close();
    }
    // demonstrates throwing an exception when a divide-by-zero occurs
    public static int quotient(int numerator, int denominator) throws ArithmeticException {
         return numerator / denominator; // possible division by zero
    }
}