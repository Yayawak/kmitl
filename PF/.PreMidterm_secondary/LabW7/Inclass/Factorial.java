package PF.PreMidterm.LabW7.Inclass;

public class Factorial {
    // long int x;
    public static void main(String[] args) {
        System.out.println(factorial(Integer.parseInt(args[0])));
    }
    static long factorial(int n) {
        if (n>1) {
            // n *= (n-1);
            // n = factorial(n);
            // n = factorial(n);
            // return factorial(n);
            long products = (long)(n * factorial(n-1));
            return Math.abs(products);

        }else {
            // return n;
            return 1l;
        }
    }
}
