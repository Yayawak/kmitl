package PF.Playground;

import java.util.Scanner;

public class Constant2 {
    public static void main(String[] args)     {
        final int SIZE = 10;
        int[] n = new int[SIZE];

        Scanner reader = new Scanner(System.in);
    
        for(int i=0; i< SIZE; i++) {
            System.out.print("n[" + i + "] = " );
            n[i] = reader.nextInt();
        }

        System.out.print(SIZE + " nubers in array: ");
        for (int i=0; i < SIZE; i++ ){
            System.out.print(n[i] + ", ");
        }
    }
}
