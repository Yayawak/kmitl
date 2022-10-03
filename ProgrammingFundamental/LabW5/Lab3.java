package PF.LabW5;

public class Lab3 {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1; i<200; i++) {
            if( i%10 ==0 ) {
                // System.out.println(i);
                sum += i;
            }else {
                // continue(18000);
                continue;
            }
        }
        System.out.println(sum);
    }
}
