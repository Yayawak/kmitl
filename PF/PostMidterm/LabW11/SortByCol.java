
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class IdxVal {
    int idx;
    int val;
    public IdxVal(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

class SortByCol
{
    public static void main(String[] args) {
        int M;
        int N;
        int S;

        M = 3; N = 3; S = 1;
        // int[][] A = new int[N][M];
        int[][] A = {
            {1, 9, 7},
            {3, 5, 4},
            {2, 8, 6}
        };
        // HashMap<Integer, Integer> hm = new HashMap<>();
        IdxVal[] idxVals = new IdxVal[3];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (col == 1)
                {
                    IdxVal iv = new IdxVal(row, A[row][col]);
                    idxVals[row] = iv;
                }
            }
        }


        System.out.println("Before sort");
        display_sort_IdxVals(idxVals);
        selection_sort_IdxVals(idxVals);
        System.out.println("After sort");
        display_sort_IdxVals(idxVals);
    }
    static void display_sort_IdxVals(IdxVal[] idxVals) {
        for (int i = 0; i < idxVals.length; i++) {
            System.out.println("IDX : " + idxVals[i].idx);
            System.out.println("VAL : " + idxVals[i].val);
            System.out.println("--------------------");
        }

    }
    static void selection_sort_IdxVals(IdxVal[] idxVals)
    {
        // selection sort // insert to beginning of array
        for (int i = 0; i < idxVals.length; i++) {
            for (int j = i + 1; j < idxVals.length; j++)
            {
                int min_index = i;
                if (idxVals[j].val < idxVals[i].val) {
                    min_index = j;
                // if (idxVals[j].val > idxVals[i].val) {
                    // idxVals[i]
                }

                // swap IdxVal Class
                IdxVal tmp = idxVals[min_index];
                idxVals[min_index] = idxVals[i];
                idxVals[i] = tmp;
            }
        }

    }

    static void display_hashmap(HashMap hm)
    {
        // for (var entry : hm.entrySet())
        for (var key : hm.keySet())
        // for (: hm.entrySet())
        // for auto complete
        // for (Map.Entry<Integer, Integer> entry : hm.entrySet())
        {
            // int key = entry.getKey();
            // int val = entry.getValue();
            // int val = key.getValue();
            int val = (int)hm.get(key);
            // hm.get
            System.out.printf("Key : %d\tValue : %d\n", key, val);
            // System.out.printf("Key : %d\tValue : %d\n", key, hm.get(key));
            // System.out.printf("Key : %d\n", key);
            // System.out.printf("Key : %d\tValue : %d\n", entry.getKey(), entry.getValue());
        }
    }

    static void display_1d_arr(int[] A)
    {
        for (int i = 0; i < A.length; i++)
        {
            System.out.printf("A[%d] = %d\n", i, A[i]);
        }
    }
}
