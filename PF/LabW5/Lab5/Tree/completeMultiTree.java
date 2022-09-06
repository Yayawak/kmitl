package PF.LabW5.Lab5.Tree;

import java.util.Scanner;

public class completeMultiTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (true) {
            System.out.print("Enter Number of sub-tree : ");
            int height_each_sub_tree = sc.nextInt();

            System.out.print("Enter Height of each sub-tree :");
            int n_sub_tree = sc.nextInt();

            // drawTree(5, 4);
            drawTree(height_each_sub_tree, n_sub_tree);
            i++;
            if(i==4) break;
        }
        sc.close();
    }
    static void drawTree(int height_each_sub_tree, int n_sub_tree) {
        int n_row = n_sub_tree * height_each_sub_tree;
        int n_col = (int)(1.25*n_row);

        System.out.println();
        System.out.println("Height of tree : " + n_row);
        System.out.println("Width of tree : " + n_col);
        System.out.println();

        int which_tree_segment = 0; // count from 0,1,2,...

        // bushes
        for (int row=0; row<n_row; row++) {
            int n_exist_star = 2*(row-3*which_tree_segment) + 1;
            int n_half_empty =
                getSumOfEmptyEachRow(n_col, n_exist_star) / 2;

            drawEachRowAllCol(n_half_empty, n_exist_star);

            if((row+1)%4 == 0) {
                which_tree_segment ++;
            }
            System.out.println();
        }

        // body of tree
        int body_height = n_row / 4; // 25%
        int body_width = n_col / 3; // 33%
        if((n_col % 2 == 0) && (body_width % 2 == 0))
            body_width --;
        for(int row=0; row<body_height; row++) {
            int n_half_empty =
                getSumOfEmptyEachRow(n_col, body_width) / 2;
            drawEachRowAllCol(n_half_empty, body_width);
            System.out.println();
        }

    }
    static int getSumOfEmptyEachRow(int n_base, int n_exist_star) {
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
