package PF.LabW7.HW;

public class Lab7Q2_65988 {
    public static void main(String[] args) {
        int[] data = {7, 1, 2, -1, 3, 4, 10, -12, 3, 21, -9};
        System.out.println(maxElement(data));
    }
    private static int maxElement(int[] arr) {
        int curMax = Integer.MIN_VALUE;
        int curValue;
        for (int i=0; i<arr.length; i++) {
            curValue = arr[i];
            if (curValue > curMax) {
                curMax = curValue;
            }
        }
        return curMax;
    }
}
