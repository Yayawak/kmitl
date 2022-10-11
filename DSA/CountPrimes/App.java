package CountPrimes;

public class App {
    public static void main(String[] args) {
        int hundredThousand = (int)Math.exp(5);
        int ht = hundredThousand;
        int million = (int)Math.exp(6);
        for(int N=ht; N<million; N+=ht){
            long start = System.currentTimeMillis();
            int counter = 0;
            for(int n=1; n<N; n++) {
                if(CountPrime.isPrime0(n)) counter++;
                // if(CountPrime.isPrime1(n)) counter++;
                // if(CountPrime.isPrime2(n)) counter++;
            }
            long time = (System.currentTimeMillis() - start);
            System.out.printf("N : %d\tCounts : %d\tTimes : %d\n", N, counter, time);
        }

    // public static void main(String[] args) {
    //     int counter = 0;
    //     int N = 100;
    //     for (int n=1; n<N; n++) {
    //         if(CountPrime.isPrime2(n)) counter++;
    //     }
    //     System.out.printf("%n%nNumber of prime between [0,%d] is %d",
    //         N, counter);
    // }
    }
}
