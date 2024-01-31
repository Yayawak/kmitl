package MergeSort;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // int [] arr = {8, 3, 2, 9, 7, 1, 5, 4};
        int [] arr = {1, 5, 9, 3, 10, 2, 3, 4, 5, -5};

        MergeSort.mergeSort(arr);

        System.out.println(Arrays.toString(arr));

        System.out.println("---demo1---");
        demo1();
        System.out.println("---demo2---");
        demo2_descending();
        System.out.println("---demo3---");
        demo3_multi_key();
    }

    static void demo1(){
        int [] data = {8, 3, 2, 9, 7, 1, 4};
        MergeSort_65050988.m_sort(data, 0);
        System.out.println(Arrays.toString(data));
    }

    static void demo2_descending(){
        int [][] data = { {11, 88}, {33, 99}, {22,77}};
        MergeSort_65050988.m_sort(data, 0);
    }

    static void demo3_multi_key(){
        int [][] data = {
            {11, 22, 33, 44},
            {19, 17, 63, 57},
            {17, 22, 18, 15},
            {12, 18, 73, 84},
            {14, 27, 33, 55}
        };
        MergeSort_65050988.m_sort(data, 1, 2, 0);
    }
}
