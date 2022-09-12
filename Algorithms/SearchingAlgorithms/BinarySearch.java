package Algorithms.SearchingAlgorithms;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        // int[] arr = {1, 3, 5, 7, 9, 11};
        int[] arr = {3, 5, 3, 2, 1, 9, 11};
        Arrays.sort(arr);
        int toFind = 3;
        binarySearch(arr, toFind);
    }
    static void binarySearch(int arr[], int searchValue) {
        int lowIdx = 0, highIdx = arr.length -1 ;

        while (highIdx > lowIdx + 1) {
            int midIdx = (highIdx - lowIdx) / 2;
            // int midIdx = (int)Math.random();
            if (arr[midIdx] < searchValue) // pivot < searchVal //right sub-array
            {
                // lowIdx = midIdx;
                lowIdx = midIdx + 1;
            }else { // pivot < search // left sub-array
                highIdx = midIdx;
            }
        }

        if(arr[lowIdx] == searchValue) {
            System.out.println("Found at index : " + lowIdx);
        }
        else if (arr[highIdx] == searchValue) {
            System.out.println("Found at index : " + highIdx);
        }else {
            System.out.println("Not Found");
        }
    }

}


    // public static void main(String[] args) {
    //     // int[] arr = {17, 20, 3, 5, 0, 65, 3, 100, 99};
    //     int[] arr = {0, 3, 3, 5, 17, 20, 65, 99, 100};
    //     // Arrays.sort(arr);
    //     int search = 20;
    //     // for(int x: arr) System.out.println(x);

    //     int minIdx = 0;
    //     int maxIdx = arr.length - 1;
    //     int pivotIdx = getPivotIdx(minIdx, maxIdx);

    //     int currentSearch = -999;
    //     while (currentSearch != search) {
    //         // pivotIdx = getPivotIdx(minIdx, maxIdx);
    //         int pivotValue = arr[pivotIdx];

    //         if(currentSearch >= pivotValue) {
    //             pivotIdx = getPivotIdx(minIdx, maxIdx);

    //         }else {
    //             pivotIdx = getPivotIdx(minIdx, maxIdx);
    //         }
    //         System.out.println(pivotValue);
    //     }
    //     // System.out.println(currentSearch);
    //     // for(int i=0; i<arr.length; i++) {

    //     // }

    // }
    // static int getPivotIdx(int minIdx, int maxIdx) {
    //     int median = (int)(maxIdx - minIdx)/2;
    //     return median;
    // }
