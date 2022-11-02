package GCD;

public class Euclid {
    public static void main(String[] args)
    {
        euclid_gcd(21, 3);
    }

    // public static int[] swap_num(int a, int b)
    public static int get_itself(int a, int b)
    {
        return a;
    }

    public static void swap_num(int a, int b)
    {
            // int arr[2];
            int tmp = a;
            a = b;
            b = tmp;
            // return arr;
    }
    public static int euclid_gcd(int a, int b)
    {
        if (b > a)
        {
            // swap_num(a, b);
        }
        while (!(b % a == 0))
        {
            int q = a / b;
            // swap_num(b, (a - q * b));
        }
        return b;
    }
}
