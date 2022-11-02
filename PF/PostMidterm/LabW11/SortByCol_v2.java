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

class SortByCol_v2 {
    static Scanner sc = new Scanner(System.in);

    public static int[] get_keyboard_input(int size, String desc, int arg) {
        System.out.printf(desc, arg);
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(ret));
        return ret;
    }
    public static void main(String[] args) {
        // todo 1 : get information
        // M = 3; N = 3; S = 1;
        int[] MN = get_keyboard_input(2, "Enter number of columns and rows\n", -1);
        int M = MN[0];
        int N = MN[1];
        int S = get_keyboard_input(1, "Enter index of column to sort\n", -1)[0];
        int[][] A = new int[N][M];
        for (int row = 0; row < N; row++) {
            A[row] = get_keyboard_input(M, "Enter %d row\n", row);
        }

        // todo 2 : convert raw data to information
        Data[] datas = get_organized_datas(N, M, S, A);

        System.out.println("Before sort");
        display_sort_Datas(datas);

        selection_sort_Data(datas);

        System.out.println("======================");
        System.out.println("After sort");
        display_sort_Datas(datas);

        for (int row = 0; row < N; row++) {
            A[row] = datas[row].A;
        }
        System.out.println("**********************");
        System.out.println(Arrays.toString(A[0]));
        System.out.println(Arrays.toString(A[1]));
        System.out.println(Arrays.toString(A[2]));

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
    static void display_sort_Datas(Data[] datas) {
        for (int i = 0; i < datas.length; i++) {
            System.out.println("partial array : " + Arrays.toString(datas[i].A));
            System.out.println("VAL : " + datas[i].pivot);
            System.out.println("--------------------");
        }
    }
}
