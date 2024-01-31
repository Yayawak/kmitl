package MergeSort;
import java.util.Arrays;

public class MergeSort 
{
    static int pass = 0;
    



    static void mergeSort(int [] a){
        int size = a.length;
        if (size > 1) {
            int mid = a.length/2;
            int [] b = new int[mid];
            int [] c = new int [size - mid];
            pass++;

            // copy A[0..floor(size/2) - 1] to B[0..floor(size/2) - 1]
            for (int i = 0; i < mid; i++) {
                b[i] = a[i];
            }
            // copy A[floor(size/2) .. n - 1] to C[0..ceil(size/2) - 1]
            int size2 = c.length;
            for (int j = 0; j < size2; j++) {
                c[j] = a[j + mid];
            }
            
            System.out.println("pass " + pass + " " + Arrays.toString(b));
            System.out.println("pass " + pass + " " + Arrays.toString(c));
        }
    }


    static void merge(int [] b, int [] c, int [] a){
        int p =b.length;
        int q = c.length;
        int i = 0, j = 0, k = 0;
        while ((i < p) && (k < q)) {
            if (b[i] <= c[j]){
                a[k++] = b[i++];
            }else{
                a[k++] = c[j++];
            }
        }

        if (i == p){
            while (j < q) {
                a[k++] = c[j++];
            }
        }else{
            while (i < p) {
                a[k++] = b[i++];
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
