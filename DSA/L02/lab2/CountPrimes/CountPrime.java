package DSA.L02.lab2.CountPrimes;

public class CountPrime {
    public static boolean isPrime2(int n){
        if(n==1) return false;
        if(n<=3) return true;
        
        if((n%2==0) || (n%3==0)) return false;
        int m = (int)Math.sqrt(n);
        for(int i=5; i<=m; i+=6) {
            if(n%i==0) return false;
            if(n%(i+2)==0) return false;
        }
        return true;

    }
    public static boolean isPrime1(int n) {
        if (n==1) return false;
        if (n<=3) return true;
        int m = (int)Math.sqrt(n);
        for(int i=2; i<=m; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    public static boolean isPrime0(int testNum) {
        // testNum = {1,2,...,100}
        if (testNum == 1) return false;
        if (testNum <= 3) return true;

        // ถ้ามากกว่าครึ่ง ยังไงมันก็หารไม่ลงตัว
        int m = testNum/2; // divind half

        // ? i start from 2,  2->m
        // จำนวนเต็มที่น้อยกวา m ไม่สามารถหารมันลงตัว
        for (int i=2; i<=m; i++) {
            if (testNum % i == 0) return false;
        }
        return true;
    }
    
}
