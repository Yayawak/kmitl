package PF.LabW4.HW4_Scanner;

import java.util.Scanner;

public class SumOfInstantEvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(true) {
            System.out.println("Enter any number (but add only even number)");
            int currentEvenNum = sc.nextInt();
            if (currentEvenNum < 0 ) {
                System.out.println("Enter Positive Integer only!!!");
                continue;
            }
            if (currentEvenNum % 2 == 0) {
                sum += currentEvenNum;
                System.out.printf("Summary of even numbers is : %d\n", sum);
            }else {
                System.out.println();
            }
        }
    }
}
