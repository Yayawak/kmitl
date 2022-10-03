package PF.LabW6.HW;

import java.util.Arrays;

public class Lab6Q2_1_65988 {
    public static void main(String[] args) {
        int[] data = {7, 1, 2, -1, 3, 4, 10, -12, 3, 21, -9};
        Arrays.sort(data);
        // System.out.println(Arrays.sort(data)[0]);
        int curMax = Integer.MIN_VALUE;
        int n = data.length;
        for (int i=0; i<n; i++) {
            if (curMax < data[i]) {
                curMax = data[i];
            }
        }
        System.out.println(curMax);


    }
}
