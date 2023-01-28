package PF.LabW5.Lab5.Tree;

public class multiTree {
    public static void main(String[] args) {
        // * Must input these 2 variables
        // must fix for recieve all any input
        int height_each_sub_tree = 4;
        int n_sub_tree = 4;

        int n_row = n_sub_tree * height_each_sub_tree;
        int n_col = (int)(1.25*n_row);
        // int n_col = 18;
        // if(n_col < 0.5*n_row) {
        //     n_col *= .5;
        // }
        int which_tree_segment = 0; // count from 0,1,2,...
        // (n_row, n_col) ที่กำลังดีคือ (20,15)
        System.out.println("N col : " + n_col);
        System.out.println("N row : " + n_row);
        for (int row=0; row<n_row; row++) {
            // int n_exist_star = 2*row + 1;
            // int n_exist_star = 2*(row-3*0) + 1;
            // int n_exist_star = 2*(row-3*1) + 1;
            // int n_exist_star = 2*(row-3*2) + 1;
            int n_exist_star = 2*(row-3*which_tree_segment) + 1;

            int n_half_empty =
                getSumOfEmptyEachRow(n_col, n_exist_star) / 2;
            // System.out.println("nhe : " + n_half_empty);

            // * Draw 3 parts
            drawEachRowAllCol(n_half_empty, n_exist_star);
            // System.out.print();

            if((row+1)%4 == 0) {
                // System.out.println("\n---------------");
                which_tree_segment ++;
            }
            System.out.println();
        }

        // body of tree
        int body_height = n_row / 4; // 25%
        int body_width = n_col / 3; // 33%
        if((n_col % 2 == 0) && (body_width % 2 == 0))
            body_width --;
        // System.out.println("bh : " + body_height);
        // System.out.println("bw : " + body_width);
        for(int row=0; row<body_height; row++) {
            int n_half_empty =
                getSumOfEmptyEachRow(n_col, body_width) / 2;
            drawEachRowAllCol(n_half_empty, body_width);
            // System.out.print("V");
            System.out.println();
        }

    }
    static int getSumOfEmptyEachRow(int n_base, int n_exist_star) {
        // k = n_exist_star
        // n_base = n_exist_star
        // 5 + k + 5 == 11(base)
        // 5 + 5 = 11 - k
        // n_empty = 11 - k = base - k
        int n_empty = n_base - n_exist_star; // n_empty always even number
        return n_empty;
    }
    // * Draw 3 parts
    static void drawEachRowAllCol(int n_half_empty, int n_exist_star){
        for(int col=0; col<n_half_empty; col++) {
            System.out.print(" ");
        }
        for(int col=0; col<n_exist_star; col++) {
            System.out.print("X");
        }
        for(int col=0; col<n_half_empty; col++) {
            System.out.print(" ");
        }
    }
}
