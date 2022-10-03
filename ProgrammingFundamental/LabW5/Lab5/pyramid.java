package PF.LabW5.Lab5;

public class pyramid {
    public static void main(String[] args) {
        for(int row=0; row<3; row++) {
            for(int col=0; col<2-row; col++) {
                if(row>col) {
                // if(col>row) {
                    System.out.print(" ");
                }

            }
            for(int col=0; col<2*row+1; col++) {
                System.out.print("P");
            }
            System.out.println();
        }
    }
}
