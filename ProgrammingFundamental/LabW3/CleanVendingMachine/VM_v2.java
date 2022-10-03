package PF.LabW3.CleanVendingMachine;

import java.util.Scanner;

public class VM_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your banknotes");
        changeOut(sc.nextInt());
        sc.close();
    }
    public static void changeOut(int charge) {
        int c10=0, c5=0, c1=0;
        while (charge >= 10 ) {
            c10++;
            charge -= 10;
        }
        while (charge >= 5 ) {
            c5++;
            charge -= 5;
        }
        while (charge >= 1 ) {
            c1++;
            charge -= 1;
        }
        System.out.printf("c10 : %d\nc5 : %d\n c1 : %d\n", c10, c5, c1);

    }
}
