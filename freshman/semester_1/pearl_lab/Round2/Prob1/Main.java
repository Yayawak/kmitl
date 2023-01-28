class Main
{
    static int abs(int a)
    {
        return a < 0 ? -a : a;
    }
    public static void main(String[] args) {
        final int exceed = Integer.MAX_VALUE;

        int n = 3;
        int[] a = {1, 2, 1};
        // int[] a = new int{1, 2, 1};
        for (int i = 0; i < n; i++)
            for (int j = i; i < n; j++)
            {
                // int diff = abs(a[i] - a[j]);
                if (a[i] - a[j] <= 1)
                {
                    if (a[i] > a[j])
                    {
                        // a[i] -= 99;
                        a[i] = exceed;
                    }
                }
            }
    }
}
