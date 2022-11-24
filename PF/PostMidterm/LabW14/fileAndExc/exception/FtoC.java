import java.util.Scanner;
public class FtoC {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        double fahrenheit, celsius;
        System.out.print("Please enter degree in fahrenheit ");
        fahrenheit = inp.nextDouble();
        celsius = (5.0/9.0) * (fahrenheit - 32);
        System.out.printf("%6.2f fahrenheit is %6.2f celsius\n", fahrenheit, celsius);
        System.out.println("Good Bye");
        inp.close();
    }
}
