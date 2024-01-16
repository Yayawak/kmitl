package DynamicPrograming_DNA;

import java.util.Arrays;

enum DnaType {
    A, B, C, D
}

public class DnaSeqSolver {

    private String seq0;
    private String seq1;
    private int[][] mat;
    int n, m;

    public String solve(String seq0, String seq1) {
        this.seq0 = seq0;
        this.seq1 = seq1;

        forward();
        return backward();
    }

    private int findMax(int... args) {
        int max = Integer.MIN_VALUE;
        for (int x : args) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    // private void forward(String seq0, String seq1)
    private void forward() {
        // final int n = seq0.length() + 1;
        // final int m = seq1.length() + 1;
        n = seq0.length() + 1;
        m = seq1.length() + 1;
        // mat = new int[n][m];
        mat = new int[m][n];

        int j;
        int i;
        // set first row to 0
        for (j = 0; j < n; j++)
            mat[0][j] = 0;
        // set first col to 0
        for (i = 0; i < m; i++)
            mat[i][0] = 0;

        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                char xi = seq1.charAt(i - 1);
                char yj = seq0.charAt(j - 1);
                // System.out.printf("x vs y = {%c,%c}\n", xi, yj);
                if (xi == yj)
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                else {
                    mat[i][j] = findMax(
                            mat[i - 1][j],
                            mat[i][j - 1]);
                }
            }
        }

        for (int[] arr : mat) {
            System.out.println(Arrays.toString(arr));
        }

    }

    private String backward() {
        int x;
        int y;
        // m = nrow; n = ncol;
        // for (j = m - 1; j > 0; j--)
        // {
        // // for (i = n - 1; j )
        // }
        // return "";

        y = m - 1;
        x = n - 1;

        // int[] maxPosXY = {
        //         // mat[m - 1][n - 1]
        //         n - 1,
        //         m - 1
        // };

        StringBuilder ret = new StringBuilder("");

        while (x > 0 && y > 0) {

            int max = Integer.MIN_VALUE;



            int newx = x;
            int newy = y;
            // * check left
            if (mat[y][x - 1] >= max) {
                // max = mat[y][x - 1];
                newy = y;
                newx = x - 1;
                max = mat[newy][newx];
            }
            // * check top
            if (mat[y - 1][x] >= max) {
                // max = mat[y - 1][x];
                // max = mat[y - 1][x];
                newy = y - 1;
                newx = x;
                max = mat[newy][newx];
            }
            // * check topleft
            if (mat[y - 1][x - 1] >= max) {
                // max = mat[y - 1][x - 1];
                newy = y - 1;
                newx = x - 1;
                max = mat[newy][newx];
            }
            x = newx;
            y = newy;

            if (x > 0 && y > 0)
            {
                char xi = seq0.charAt(x - 1);
                char yj = seq1.charAt(y - 1);
                if (xi == yj)
                {
                    // System.out.println(xi);
                    // ret.append(String.valueOf(xi));
                    ret.insert(0, (String.valueOf(xi)));
                }
            }

            System.out.printf("mat[%d,%d] = %d\n", y, x, max);

        }
        // return "";
        return ret.toString();
    }

    public static void main(String[] args) {
        // DnaType[] seq0 = {A, B, C};
        String seq0;
        String seq1;

        seq1 = "abcbdab";
        seq0 = "bdcaba";

        // seq0 = "abcbdab";
        // seq1 = "bdcabb";

        // String seq1 = "abcbdab";
        // String seq0 = "bdcabb";

        // seq1 = "abcbdab";
        // seq0 = "bdcaba";

        DnaSeqSolver dnaSolver = new DnaSeqSolver();
        String lcs = dnaSolver.solve(seq0, seq1);
        System.out.println("Longest Common Sequence is ...");
        System.out.println(lcs);

    }
}
