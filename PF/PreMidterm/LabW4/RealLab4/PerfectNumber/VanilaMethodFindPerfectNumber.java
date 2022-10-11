// package PF.LabW5.PerfectNumber;
package PF.LabW4.RealLab4.PerfectNumber;

public class VanilaMethodFindPerfectNumber {
    // 6 = 1 + 2 + 3 (!+ 6)
    public static void getFirstNPerfectNumber(int N) {

    // public static void main(String[] args) {
        int testNumber = 1;
        // int endTestNumer = 9000;
        int endTestNumer = (int)1e5;
        // int endTestNumer = (int)1e6; bad performance if N > 4
        int countPerfect = 0;
        while (testNumber < endTestNumer) {
            if (isPerfectNumber(testNumber)) {
                System.out.println(testNumber + " is a Perfect number.");
                countPerfect++;
            }
            if (countPerfect >= N) break;
            testNumber ++;
        }
    }
    private static boolean isPerfectNumber(int num) {
        int sumOfFactors = 0;
        for (int i=1; i<num; i++) {
            if (num%i == 0) {
                // System.out.println(i + " is factor of " + num);
                sumOfFactors += i;
                // return true;
            }
        }

        if (sumOfFactors == num) return true;
        else return false;
        // System.out.println("Sum of factors is : " + sumOfFactors);

    }
}

