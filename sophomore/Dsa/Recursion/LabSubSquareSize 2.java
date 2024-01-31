package Recursion;

import java.util.Arrays;

class LabSubSquareSize {
    private static int[][] matrix;
    private static int rows;
    private static int cols;
    private static int max_so_far_for_recursion = -1;

    public static int find_max_area_recurse_entry(int[][] mat) {
        // begin preparation
        matrix = mat;
        rows = matrix.length;
        cols = matrix[0].length;
        // end preparation
        q1_1_find_max_area_recurse(matrix, 0, 0);
        return max_so_far_for_recursion * max_so_far_for_recursion;
    }

    private static int q1_1_find_max_area_recurse(int[][] mat, int r, int c) {
        if (r == rows || c == cols)
            return 0;
        
        // your code        
        int size = 0;
        
        int down = q1_1_find_max_area_recurse(mat, r + 1, c);
        int right = q1_1_find_max_area_recurse(mat, r, c + 1);
        int diagonal = q1_1_find_max_area_recurse(mat, r + 1, c + 1);

        if (mat[r][c] == 1) {
            size = 1 + Math.min(Math.min(down, right), diagonal);
        }

        max_so_far_for_recursion = Math.max(max_so_far_for_recursion, size);

        return size;
    }

    public static void q1_2_maximum_size_square_sub_matrix(int[][] data) {
    int m = data.length;
    int n = data[0].length;
    
    int[][] sub = new int[m + 1][n + 1];
    
    for (int i = 0; i <= m; i++) {
        sub[i][0] = 0;
    }
    for (int j = 0; j <= n; j++) {
        sub[0][j] = 0;
    }
    
    int maxLength = 0; 
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (data[i - 1][j - 1] == 1) {
                sub[i][j] = Math.min(Math.min(sub[i - 1][j], sub[i][j - 1]), sub[i - 1][j - 1]) + 1;
                maxLength = Math.max(maxLength, sub[i][j]);
            } else {
                sub[i][j] = 0;  
            }
        }
    }
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            System.out.print(sub[i][j] + " ");
        }
        System.out.println();
    }
    
    System.out.println("Longest Length of Square Submatrix: " + maxLength);
}

    private static int q2_string_edit_distance(String str1, String str2) {
    // begin preparation
    int [][] cache = new int[str1.length() + 1][str2.length() + 1];
    for (int [] row : cache)
        Arrays.fill(row, Integer.MAX_VALUE);
    int r;
    for (r = 0; r < cache.length; r++) {
        cache[r][str2.length()] = str2.length() - r;
    }
    for (int c = 0; c < cache[0].length; c++) {
        cache[str1.length()][c] = str1.length() - c;
    }
    // end preparation
    for (int i = str1.length() - 1; i >= 0; i--) {
        for (int j = str2.length() - 1; j >= 0; j--) {
    // your code
        if (str1.charAt(i) == str2.charAt(j)) {
            cache[i][j] = cache[i + 1][j + 1];
        }   else {
            int insert = 1 + cache[i][j + 1];
            int delete = 1 + cache[i + 1][j];
            int replace = 1 + cache[i + 1][j + 1];

            cache[i][j] = Math.min(insert, Math.min(delete, replace));
            }
        }
    }
    return cache[0][0];
    }

    public static void main(String[] args) {
        int[][] data = {
            {0,1,1,0,1},
            {1,1,0,1,0},
            {0,1,1,1,0},
            {1,1,1,1,0},
            {1,1,1,1,1},
            {0,0,0,0,0}
        };

        int result = find_max_area_recurse_entry(data);
        System.out.println("Maximum size square sub-matrix: " + result);
        q1_2_maximum_size_square_sub_matrix(data);

        System.out.println("\nQ2 -------------");
        String str1 = "comsci";
        String str2 = "comedy";
        
        int editDistance = q2_string_edit_distance(str1, str2);
        
        System.out.println("Edit Distance: " + editDistance);

    }
}