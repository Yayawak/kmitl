// package PF.LabW5.PerfectNumber;
package PF.LabW4.RealLab4.PerfectNumber;

import java.math.BigInteger;

import javax.naming.ldap.ManageReferralControl;

public class EuclidMethodPerfectNumber {
    public static void main(String[] args) {
        getFirstNPerfectNumber(8);
    }
    static void getFirstNPerfectNumber(int N) {
        int k = 0;
        int countPerfect = 0;
        while(k<100) {
            if(isPrime(k)) {
                System.out.println(k + " is prime number");
                getPerfectFromPrime(k);
                System.out.println();
                countPerfect++;
            }else{
                // System.out.println(k + " is not prime number");
            }
            k++;
            if(countPerfect == N) break;

        }
    }
    static long getPerfectFromPrime(int prime) {
        // int prime = 7;
        long q = (long)Math.pow(2, prime) - 1;
        // System.out.println("q : " + q);

        long perfectNum = q * (q+1) / 2;
        System.out.println("perfect number : " + perfectNum);
        return perfectNum;

    }
    static boolean isPrime(int num2Check) {
        // num2Check = 49 , sqrt(49) == 7
        // return true;
        if(num2Check<=1) return false;
        // * even prime มีตัวเดียวคือเลข 2
        else if (num2Check == 2) return true;

        // * Check if num2Check is multiple of 2 ถ้าเป็นงั้นก็ไม่ใช่ prime แน่นอน
        else if (num2Check % 2 == 0) return false;

        for (int i=3; i<Math.sqrt(num2Check); i+=2) {
            if (num2Check % i == 0) {
                return false;
            }
        }
        return true;
    }
}
