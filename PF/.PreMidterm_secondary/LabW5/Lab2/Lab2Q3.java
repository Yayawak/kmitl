package PF.PreMidterm.LabW5.Lab2;

public class Lab2Q3 {
    public static void main(String[] args) {
        int n = 5;
        for(int i=1; i<n; i++) {
            for (int j=1; j<= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
