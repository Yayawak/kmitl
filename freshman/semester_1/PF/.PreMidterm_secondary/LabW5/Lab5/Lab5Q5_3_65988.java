package PF.LabW5.Lab5;

public class Lab5Q5_3_65988 {
    public static void main(String[] args) {
        int n = 4;
        // int k = 7;
        for (int row=0; row<n; row++) {
            // for(int col=0; col<k-row; col++) {
            // for(int col=0; row>col; col++) {
            for(int j=0; j<row-1; j++) {
                System.out.print("P");
                // if(row>col) {
                //     System.out.print("P");
                //
            }

            for(int j=0; j<row+1; j++) {
                System.out.print("P");
            }
            System.out.println();
        }
    }
}
