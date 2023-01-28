package CS.PostMidterm.LabW13.Q_ArrList_Class.Learn;
import java.lang.reflect.Array;
import java.util.Arrays;

class Q
{
    public static void main(String[] args) {

    }

    static void arrCopy(int[] retArr, int start, int end, int[] dupArr)
    {
        // for (int i = 0; i < dupArr.length; i++)
        // for (int i = 0; i < end - start + 1; i++)
        for (int i =  start; i <= end; i++)
        {
            retArr[i - start] = dupArr[i]
            // retArr[start + i] = dupArr[i];
        }
    }

    static void mergeRun(int[] x, int p, int q)
    {
        int m = (int)Math.pow(2, p);
        int n = (int)Math.pow(2, q);
        // int
        int start = 0;
        for (int round = 1; round < n; round++)
        {
            int[] left = new int[m];
            int[] right = new int[m];
            arrCopy(x, start, start + m - 1, left);
            arrCopy(x, start + m,
                (start + (2 * m)), right);

            int i = 0; j = 0, k = start;
            while (i < m && j < m)
            {
                if (left[i] <= right[j])
                    x[k++] = left[i++];
                else
                    x[k++] = right[j++];
            }

            while (i < m)
                x[k++] = left[i++];
            while (j < m)
                x[k++] = right[j++];
            System.out.println("Mergeing roudn %d : %s %d",
                round,
                Arrays.toString(x));
        }
    }
    static void driver()
    {
        int m = 5;
        int n = 5;
        int[] ab = new int[m + n];
        int[] left = new int[m];
        int[] right = new int[n];
        int i = 0, j = 0, k = 0;

        arrCopy(ab, 0, m - 1, left);
        arrCopy(ab, m, (m + n - 1), right);
        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
                ab[k++] = left[i++];
            else
                ab[k++] = right[j++];
        }
        while (i < left.length)
            ab[k++] = left[i++];
        while (j < right.length)
            ab[k++] = right[j++];

        System.out.println("arr " + Arrays.toString(ab));
    }
}
