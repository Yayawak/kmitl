package MergeSort;

public class Sort {
    public static void sort(int[] arr, int l, int r) {
        if (l<r) {
            int m = (1+r) / 2;
            sort(arr, l, m);
            sort(arr, m+1, r);

            Merge.merge(arr, l, m, r);
        }
    }
}
