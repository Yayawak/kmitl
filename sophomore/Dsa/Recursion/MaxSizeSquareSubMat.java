package Recursion;

public class MaxSizeSquareSubMat {
    private static int[][] matrix;
    private static int rows;
    private static int cols;
    private static int max_so_far_for_rec = -1;

    public static int find_max_area_entry(int[][] mat)
    {
        matrix = mat;
        rows = matrix.length;
        cols = matrix[0].length;

        q1_1_find_max_area_recures(matrix, 0, 0);
        return (max_so_far_for_rec * max_so_far_for_rec);
    }

    private static boolean isValidPos(int r, int c)
    {
        return !(r < 0 || c < 0 || r >= matrix.length || c >= matrix[0].length);

    }

    private static int helper(int r, int c)
    {
        if (!isValidPos(r, c) || matrix[r][c] == 0)
        {
            return (0);
        }
        return (
            1 + 
            Math.min(helper(r + 1, c + 1), 
                Math.min(helper(r + 1, c), helper(r, c + 1))
            )
        );
    }

    private static int q1_1_find_max_area_recures(int[][] mat, int r, int c)
    {
        if (r == rows || c == cols)
            return (0);
        
        return -99;
        // for (int int )
        // return (size)
    }

    public static void main(String[] args) {
        int[][] binMap = {
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1},
            {1, 1, 1, 1, 0},
        };
    }
}
