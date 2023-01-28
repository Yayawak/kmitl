package PF.LabW4.RealLab4.PerfectNumber;
//

public class Lab4Q465988 {
    public static void main(String[] args) {
        int numberOfPerfect = 3;
        // ? Bad performance
        // VanilaMethodFindPerfectNumber.getFirstNPerfectNumber(numberOfPerfect);
        // * Better performance
        EuclidMethodPerfectNumber.getFirstNPerfectNumber(numberOfPerfect);
    }
    public class EuclidMethodPerfectNumber {
        public static void main(String[] args) {
            getFirstNPerfectNumber(8);
        }
        static void getFirstNPerfectNumber(int N) {
            int k = 0;
            int countPerfect = 0;
            while(k<20) {
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

}



}
