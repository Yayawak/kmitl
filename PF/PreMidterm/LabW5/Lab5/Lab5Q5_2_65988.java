package PF.LabW5.Lab5;

public class Lab5Q5_2_65988 {
    public static void main(String[] args) {
        int n = 4;
        for(int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                // if(row == n-col)
                // System.out.println();
                // if(row == col)
                // if(row + col > 0)
                // if(col+row < 0)
                if(col < row + 1)
                    System.out.print(n - col);
                else
                    System.out.print(" ");

            }
            System.out.println();
        }
    }
}
