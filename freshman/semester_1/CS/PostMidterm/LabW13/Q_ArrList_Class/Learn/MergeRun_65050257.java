package CS.PostMidterm.LabW13.Q_ArrList_Class.Learn;
import java.util.Arrays;

public class MergeRun_65050257 {
    public static void main(String[] args) {
        //65050257
        int[] arr = {2,4,6,15,7,10,13,18,3,20,21,23,1,5,8,22};
        int p = 2;// 2^p = run size
        int q = 2;// 2^q = run amount
        System.out.println("Array before merge : "+Arrays.toString(arr));
        mergeRun(arr, p, q);
        System.out.println("Array after  merge : "+Arrays.toString(arr));
    }
    static void copy(int[] arr,int startIdx,int lastIdx,int[] subArr){
        for (int i = startIdx; i <= lastIdx; i++)
            subArr[i-startIdx] = arr[i];
    }

    static void mergeRun(int [] x, int p, int q){
        System.out.println("\nMerging Array");
        int m = (int) Math.pow(2, p);
        // n = 4 : n = 2^q = 2^2 = 4
        int n = (int) Math.pow(2, q);
        int half = n/2;
        int plus = half/2;
        int start = 0;
        for (int round = 1; round < n; round++) {
            int [] left = new int[m];
            int [] right = new int[m];
            // dup to left array / dup to supArray
            copy(x, start, start+m-1, left);
            copy(x, start+m, start+(2*m)-1, right);

            int i = 0, j = 0;
            int k = start;
            while (i < m && j < m) {
                if (left[i] <= right[j])
                    x[k++] = left[i++];
                else
                    x[k++] = right[j++];
            }
            while (i < m) { //Either copy tail of a
                x[k++] = left[i++];
            }
            while (j < m) { //or copy tail of b
                x[k++] = right[j++];
            }
            System.out.printf("Merging Round %d : %s%n",round,Arrays.toString(x));

            if(round == half){
                start = 0;
                m *= 2;
                half += plus;
                plus /= 2;
            }
            else
                start += 2*m;
            // System.out.println("xxxxxxxxxxxxxx");
        }
        // after for
        System.out.println("Merge Complete\n");
    }
}
