package PF.LabW3.Lab3Q3;

import java.util.Scanner;


public class VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert your banknote");
        int money = Integer.parseInt(sc.nextLine());
        // int money = 108;
        int c10 = 0, c5 = 0, c1 = 0;

        while (true) {
            // money <= 0 ? break : continue ;

            int rem10 = money % 10;
            money -= 10;
            c10++;
            printOut(money, rem10, 10);

            if (money < 10 ) {
                int rem5 = money % 5;
                money -= 5;
                if (money > 0) c5++;
                if (money <= 0) break;
                printOut(money, rem5, 5);


                if (money < 5) {
                    int rem1 = money;
                    c1 = rem1;
                    printOut(money, rem1, 1);
                }
                break;
            }
        }
        System.out.printf("c10 : %d\nc5 : %d\n c1 : %d\n", c10, c5, c1);
        sc.close();
    }
    private static void printOut(int money, int rem, int coinType) {
        System.out.println("money : " + money);
        System.out.printf("rem %d : %d\n", coinType, rem);
        System.out.println("---------------");
    }
}
