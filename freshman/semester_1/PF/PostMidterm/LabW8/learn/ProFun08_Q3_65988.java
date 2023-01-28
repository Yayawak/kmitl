package learn;
// package PF.PostMidterm.LabW8;
import java.util.Scanner;

import java.util.*;

public class ProFun08_Q3_65988 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        topK(arr);
    }

    private static void topK(int[] intArr) {
        Scanner input = new Scanner(System.in);
        int lengthArr = intArr.length;
        while (true) {
            System.out.print("Enter number : ");
            int inputInt = input.nextInt();
            if (inputInt == 0)
                break;
            int[] tmpArr = new int[lengthArr + 1];
            for (int i = 0; i < lengthArr; i++)
                tmpArr[i] = intArr[i];
            tmpArr[lengthArr] = inputInt;

            // == sort Reverse ==
            int[] arrDesc = Arrays.stream(tmpArr).boxed()
                    .sorted(Collections.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();
            // == sort Reverse ==

            for (int i = 0; i < lengthArr; i++) {
                intArr[i] = arrDesc[i];
            }
            // System.out.print(null);
        }
    }
}

// public class ProFun08_Q3_65988 {
// public static void main(String[] args) {

// Scanner sc = new Scanner(System.in);
// int intArr[] = new int[10];
// // int minVal = Integer.MIN_VALUE;
// int minVal = Integer.MAX_VALUE;
// for (int i=0; i<intArr.length; i++) {
// if (intArr[i] < minVal) {
// minVal = intArr[i];
// }
// System.out.print("Input : ");
// int fill = sc.nextInt();

// // intArr
// intArr[i] = fill;

// for (int elem : intArr) {
// System.out.print(elem + " ");
// }
// System.out.println();
// }
// topK(intArr);

// sc.close();
// }
// static void topK(int[] intArr) {

// }
// }
