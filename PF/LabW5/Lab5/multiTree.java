package PF.LabW5.Lab5;

public class multiTree {
    public static void main(String[] args) {
        boolean[][] mat;
        int which_tree_segment = 0; // count from 0,1,2,...
        int height_each_sub_tree = 4;
        int n_sub_tree = 4;
        int n_row=n_sub_tree*height_each_sub_tree;
        int n_col = 11;
        for (int row=0; row<n_row; row++) {
            for(int col=0; col<n_col; col++) {
                // System.out.print("*");
            }
            // int n_exist_star = 2*row + 1;
            // int n_exist_star = 2*(row-3*0) + 1;
            // int n_exist_star = 2*(row-3*1) + 1;
            // int n_exist_star = 2*(row-3*2) + 1;
            int n_exist_star = 2*(row-3*which_tree_segment) + 1;

            int n_half_empty =
                getSumOfEmptyEachRow(11, n_exist_star) / 2;
            // System.out.println("nhe : " + n_half_empty);

            // * Draw 3 parts
            for(int g=0; g<n_half_empty; g++) {
                System.out.print(" ");
            }
            for(int g=0; g<n_exist_star; g++) {
                System.out.print("X");
            }
            for(int g=0; g<n_half_empty; g++) {
                System.out.print(" ");
            }
            // System.out.print();

            if((row+1)%4 == 0) {
                // System.out.println("\n---------------");
                which_tree_segment ++;
            }
            System.out.println();
        }
    }
    static int getSumOfEmptyEachRow(int n_base, int n_exist_star) {
        // k = n_exist_star
        // n_base = n_exist_star
        // 5 + k + 5 == 11(base)
        // 5 + 5 = 11 - k
        // n_empty = 11 - k = base - k
        int n_empty = 11 - n_exist_star; // n_empty always even number
        return n_empty;
    }
}
