import java.util.Arrays;
import java.util.Scanner;

class Data {
    int[] A;
    int pivot;
    public Data(int[] A, int pivot) {
        this.pivot = pivot;
        this.A = A;
    }
}

class SortByCol_v3 {
    static Scanner sc = new Scanner(System.in);
    static final int MIL = 1000000;

    public static int[] get_keyboard_input(int size, String desc, int arg) throws Exception {
    // public static int[] get_keyboard_input(int size, String desc, int arg) {
        // System.out.printf(desc, arg);
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = sc.nextInt();
            if (ret[i] < -MIL || ret[i] > MIL)
                throw new Exception("Number must in range -1,000,000 to +1,000,000");
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {
        // todo 1 : get information
        int[] MN = get_keyboard_input(2, "Enter number of columns and rows\n", -1);
        int M = MN[0];
        if (!(M >= 1 && M <= MIL)) throw new Exception("M must >= 1 and <= 1,000,000");

        int N = MN[1];
        if (!(N >= 1 && N <= MIL)) throw new Exception("N must >= 1 and <= 1,000,000");

        int[][] A = new int[N][M];
        for (int row = 0; row < N; row++)
            A[row] = get_keyboard_input(M, "Enter %d row\n", row);
        // int[][] A = {
        //     {1, 9, 2},
        //     {3, -2, 4},
        //     {5, 3, 5}
        // };

        int S = get_keyboard_input(1, "Enter index of column to sort\n", -1)[0];
        if (!(0 <= S && S <= (M - 1))) throw new Exception("S must in range 0 to M - 1");
        // System.out.print("\n\n\n");

        // todo 2 : convert raw data to information
        Data[] datas = get_organized_datas(N, M, S, A);

        // todo 3 : sort
        selection_sort_Data(datas);

        // todo 4 : display end output
        display_sorted_Datas(datas);

        sc.close();
    }


    static Data[] get_organized_datas(int N, int M, int S, int[][] A)
    {
        Data[] datas = new Data[N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (col == S)
                {
                    Data data = new Data(A[row], A[row][col]);
                    datas[row] = data;
                }
            }
        }
        return datas;
    }

    static void selection_sort_Data(Data[] datas)
    {
        for (int i = 0; i < datas.length; i++) {
            for (int j = i + 1; j < datas.length; j++)
            {
                int min_index = i;
                if (datas[j].pivot < datas[i].pivot) {
                    min_index = j;
                }
                // Swap
                Data tmp = datas[min_index];
                datas[min_index] = datas[i];
                datas[i] = tmp;
            }
        }
    }
    static void display_sorted_Datas(Data[] datas) {
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[0].A.length; j++) {
                if (j == datas[0].A.length - 1)
                    System.out.printf("%d", datas[i].A[j]);
                else
                    System.out.printf("%d ", datas[i].A[j]);
            }
            System.out.println();
        }
    }
}
