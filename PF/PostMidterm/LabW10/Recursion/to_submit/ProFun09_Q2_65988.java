package to_submit;

public class ProFun09_Q2_65988 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 4, 2};
        int to_find_nb = 2;
        int freq = freq_occurence(arr, to_find_nb);

        System.out.printf("Frequency : %d", freq);
    }

    // static boolean
    static int freq_occurence(int[] A, int to_find)
    {
        return occurence(A, to_find, 0, 0);
    }

    static int occurence(int[] A, int to_find, int cur_idx,
        int freq)
    {
        System.out.printf("current freq : %d\n", freq);
        if (A[cur_idx] == to_find)
            freq++;
        if (cur_idx == (A.length - 1))
            return freq;
        return occurence(A, to_find, cur_idx + 1, freq);
    }
}
