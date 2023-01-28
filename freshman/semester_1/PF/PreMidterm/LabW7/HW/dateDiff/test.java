package PF.LabW7.HW.dateDiff;

public class test {
    public static void main(String[] args) {
        for (int i=0; i<1000; i++)  {
            boolean k = isLeapYear(i);
            System.out.println(k);
        }
    }
    static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0);
    }

}
