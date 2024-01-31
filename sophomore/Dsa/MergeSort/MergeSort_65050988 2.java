package MergeSort;
import java.util.Arrays;

public class MergeSort_65050988 {

    static void m_sort(int [] input, int pass){
        if (input.length > 1) {
            int mid = input.length / 2;
            int[] left = Arrays.copyOfRange(input, 0, mid);
            int[] right = Arrays.copyOfRange(input, mid, input.length);
            m_sort(left, pass);
            m_sort(right, pass);
            merge(input, left, right);
        }
    }

    static void m_sort(int[][] input, int pass) {
        if (input.length > 1) {
            Arrays.sort(input, (a, b) -> Integer.compare(b[0], a[0]));
            System.out.println("Sorted 2D array based on key1 in pass " + pass + ":");
            for (int i = 0; i < input.length; i++) {
                System.out.println(Arrays.toString(input[i]));
            }
        }
    }
    

    static void m_sort(int [][] input, int key1, int key2, int pass){
        if (input.length > 1) {
            // Implement a custom sort based on specific keys (e.g., key1 and key2)
            Arrays.sort(input, (a, b) -> {
                if (a[key1] == b[key1]) {
                    return Integer.compare(a[key2], b[key2]);
                }
                return Integer.compare(a[key1], b[key1]);
            });
            System.out.println("Sorted 2D array based on key1 and key2 in pass " + pass + ":");
            for (int i = 0; i < input.length; i++) {
                System.out.println(Arrays.toString(input[i]));
            }
        }
    }

    static void merge(int [] input, int [] left, int [] right){
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                input[k++] = left[i++];
            } else {
                input[k++] = right[j++];
            }
        }

        while (i < left.length) {
            input[k++] = left[i++];
        }

        while (j < right.length) {
            input[k++] = right[j++];
        }
    }

    static void merge(int [][] input, int [][] left, int [][] right){
        int i = left.length - 1;  
        int j = right.length - 1;  
        int k = input.length - 1;  

        while (i >= 0 && j >= 0) {
            if (left[i][0] >= right[j][0]) {
                input[k--] = left[i--];
            } else {
                input[k--] = right[j--];
            }
        }
        while (i >= 0) {
            input[k--] = left[i--];
        }
        while (j >= 0) {
            input[k--] = right[j--];
        }
        System.out.println("Merged 2D arrays in descending order:");
        for (int m = 0; m < input.length; m++) {
            System.out.println(Arrays.toString(input[m]));
        }
    }

    static void merge(int [][] input, int [][] left, int [][] right, int key1, int key2){
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i][key1] <= right[j][key1] && left[i][key2] <= right[j][key2]) {
                input[k++] = left[i++];
            } else {
                input[k++] = right[j++];
            }
        }

        while (i < left.length) {
            input[k++] = left[i++];
        }

        while (j < right.length) {
            input[k++] = right[j++];
        }
    }
}
