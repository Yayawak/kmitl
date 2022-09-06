package PF.LabW5.Lab5;
// import java.util.Scanner;

public class Lab5Q5_4_65988 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // System.out.print("Please Enter Chirstmas Tree Width = ");
        // int width = sc.nextInt();
        // System.out.print("Please Enter Chirstmas  Height = ");
        // int height = sc.nextInt();
        int width = 7, height = 3;

        int space = width * height;
        int i, j, k, n = 1;

        for (int x = 1; x <= height; x = x + 1) {

            for (i = n; i <= width; i = i + 1) {
                for (j = space; j >= i; j = j - 1) {

                    System.out.print(" ");
                }
                for (k = 1; k <= i; k = k + 1) {

                    System.out.print("* ");
                }
                System.out.println();
            }
            n = n + 2;
            width = width + 2;
        }
        for (i = 1; i <= height - 1; i = i + 1) {
            for (j = space - 3; j >= 0; j--) {
                System.out.print(" ");
            }
            for (k = 1; k <= height - 1; k = k + 1) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
