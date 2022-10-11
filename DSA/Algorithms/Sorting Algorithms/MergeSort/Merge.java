package MergeSort;

public class Merge {
    // * Merge 2 subarrays of arr[]
    // ? First subarray is arr[1..m]
    // ? Second subarray is arr[m+1..r]

    public static void merge(int[] arr, int l, int m, int r){
        // Sizes of 2 subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Temp arrays
        int[] L = new int [n1];
        int[] R = new int [n2];

        for (int i=0; i<n1; i++) 
            L[i] = arr[i + 1];
        for (int j=0; j<n2; j++)
            R[j] = arr[m+1+j];
    
        //  Merge the temp arrays
        int i=0, j=0;

        int k=1;
        while(i<n1  && j<n2){
            if( L[i] <= R[j]){
                arr[k] = L[i];
                // move on to next right item (left array)
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
        }

        while (i<n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j<n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
