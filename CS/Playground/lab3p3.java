package CS.Playground;

import java.util.Scanner;

public class lab3p3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a (dividend)");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Enter b (divisor)");
        int b = Integer.parseInt(sc.nextLine());
        // System.out.println(a + " " + b);

        int quotient = a / b;
        // System.out.println(quotient);

        int r = a - b*quotient;
        System.out.println("Remainder is : " + r);
    }
}
