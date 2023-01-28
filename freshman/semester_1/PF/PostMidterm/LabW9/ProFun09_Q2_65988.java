import java.util.Arrays;

public class ProFun09_Q2_65988 {
    public static void main(String[] args)
    {
        int[][] data = new int[5][4];
        // 11 12 13 14, 15 16 17 18
        // 0  1  2 . 3, 0 .1 .2 .3
        // int start = 11;
        // for (int i = 0 + start; i < data.length+start; i++)
        // for (int i = 0 + start; i < 16+start; i++)
        // {
        //     int x = data[(i % 5)-1][i - start] = i;
        //     System.out.println(x);
        // }
        int start = 10;
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < data[0].length; j++)
            {
                data[i][j] = ++start;
                // System.out.println(data[i][j]);
            }
        }

        int[][] hori = flipHorizontal(data);
        for (int row = 0; row < data.length; row++)
        {
            System.out.println(Arrays.toString(hori[row]));
        }
        // System.out.println(Arrays.toString(data));
    }

    static int[][] flipHorizontal(int[][] data)
    {
        // ? data.length = n_row = 5
        // * data[0].lenght = n_col = sizeof(second_dim_array) = 4
        int[][] aRef = new int[data.length][data[0].length];
        // 0 -> 4 => 4 - 4 = 0
        // 1 -> 3 => 4 - 3 = 1
        // 2 -> 2
        // 3 -> 1
        // 4 -> 0

        for (int row = 0; row < data.length; row++)
        {
            // aRef[4 - row] = data[row];
            aRef[(data.length - 1 ) - row] = data[row];
        }

        return aRef;
    }
}
