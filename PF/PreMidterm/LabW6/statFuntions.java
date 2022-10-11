package PF.PreMidterm.LabW6;

public class statFuntions {
    public static void main(String[] args) {
        int[] data = {7, 1, 2, -1, 3, 4, 10, -12, 3, 21, -9};
        // System.out.println(xBar(data));
        System.out.println(sd(data));
    }
    public static double sd(int[] arr) {
        double mean = xBar(arr);
        double sumOfDeviations = 0;

        int n = arr.length;
        for (int i=0; i<n; i++) {
            double deviation = arr[i] - mean;
            double squareDev = deviation * deviation;
            sumOfDeviations += squareDev;
        }
        double sd = sumOfDeviations / n - 1;

        return sd;
    }
    private static double xBar(int[] arr) {
        double sum = 0;
        for (int element: arr) {
            sum += element;
        }
        double mean = sum/arr.length;
        return mean;
    }

}
