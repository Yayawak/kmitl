// package CS.PostMidterm.LabW13.Q_ArrList_Class.Learn;
// package CS.PostMidterm.LabW13.Q_ArrList_Class;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,4,6,15,7,10,13,18,3,20,21,23,1,5,8,22};
        // int[] arr = {2,4,6,15,7,10,13,18,3,20,21,23,1,5,8,22,32,34,36,315,37,310,313,318,33,320,321,323,31,35,38,322};
        System.out.println("Before sort");
        System.out.println(Arrays.toString(arr));
        System.out.println();
        // mergeRun(arr, 3, 2);
        mergeRun(arr, 2, 2);
        System.out.println();
        // mergeRun(arr, 3, 2);
        System.out.println("After sort");
        System.out.println(Arrays.toString(arr));
        // int[] k = Arrays.copyOfRange(arr, 0, arr.length / 2);
        // System.out.println(Arrays.toString(k));

    }

    static void mergeRun(int[] x, int p, int q)
    {
        // int[] ab = new int[x.length];
        while (p != 0)
        {
            // just 2 times
            // a = 0; a < (4 / 2) = 2; a++;
            for (int a = 0; a < (int)Math.pow(2, p) / 2; a++)
            {
                int multiplier = a * (int)Math.pow(2, q) * 2;
                int firstLength = multiplier + (int)(Math.pow(2, q)); // 4
                int lastLenght = multiplier + (int)(Math.pow(2, q)) * 2; // 8
                int[] left = Arrays.copyOfRange(x,
                    (a * (int)Math.pow(2, q) * 2), firstLength);
                int[] right = Arrays.copyOfRange(x, firstLength, lastLenght);

                int i = 0; int j = 0; int k = 0;
                while (i < left.length && j < right.length)
                {
                    // ab[multiplier + k++] =
                    x[multiplier + k++] =
                        (left[i] <= right[j]) ? left[i++]
                                                : right[j++];
                }
                while (i < left.length)
                    x[multiplier + k++] = left[i++];
                    // ab[multiplier + k++] = left[i++];
                while (j < right.length)
                    x[multiplier + k++] = right[j++];
                    // ab[multiplier + k++] = right[j++];
            }
            System.out.println(Arrays.toString(x));
            // x = ab;
            p--;
            q++;
        }
    }
}
