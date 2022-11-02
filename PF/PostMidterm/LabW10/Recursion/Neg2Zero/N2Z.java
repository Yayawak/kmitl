package Neg2Zero;

import java.util.Arrays;

public class N2Z {
    public static void main(String[] args) {
        int[] A = {1, -2, 3, -4, -5, -6};
        // n2z(A);
        System.out.println("Before n2z");
        System.out.println(Arrays.toString(A));

        System.out.println("After n2z");
        System.out.println(Arrays.toString(n2z(A)));
    }

    static int[] n2z(int[] A)
    {
        return n2z_rec(A, 0);
    }
    static int[] n2z_rec(int[] A, int idx)
    {
        // System.out.println("index : " + idx);
        // System.out.println(Arrays.toString(A));
        // System.out.println();
        if (A[idx] < 0)
            A[idx] = 0;
        // if (idx == (A.length))
        if (idx == (A.length - 1))
            return A;
        // return n2z_rec(A, idx++);
        return n2z_rec(A, ++idx);
        // idx++;
        // return n2z_rec(A, idx);
    }
}
