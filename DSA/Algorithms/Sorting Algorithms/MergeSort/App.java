package MergeSort;
public class App{
    public static void main(String[] args) {
        int arr[] = {12, 11,13,5,6,7};
        System.out.println("Given Array");
        printArray(arr);

        // MergeSort.Sort()

    }
    static void printArray(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) 
            System.out.println(arr[i] + " ");
        System.out.println();
    }
}