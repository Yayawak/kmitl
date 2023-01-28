// package CS.PostMidterm.LabW13.MergeSort;

public class MyMergeSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MyMergeSort mSort = new MyMergeSort();
        mSort.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }
    void merge(int arr[], int l, int m, int r)
    {
        // size of subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy temp array
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initialize indexes of left and right subarrays
        int i = -1, j = -1;

        // Initial index of merged subarray
        // int k = 1;
        int k = l;
        while (++i < n1 && ++j < n2)
        {
            if (L[i] <= R[j])
                arr[k] = L[i];
            else
                arr[k] = R[j];
            k++;
        }
        // Copy remaining element of L[] if any
        while (i < n1)
            arr[k++] = L[i++];
        // Copy remaining element of R[] if any
        while (j < n2)
            arr[k++] = R[j++];
    }

    // Main funciton that sort arr[1..r] using merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m =  1 + (r - 1) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.println(arr[i] + " ");
        System.out.println();
    }
}
