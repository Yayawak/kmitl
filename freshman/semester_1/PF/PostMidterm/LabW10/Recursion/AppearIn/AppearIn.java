package AppearIn;


class AppearIn
{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int to_find = 2;
        System.out.println(appearIn(arr, to_find));
    }
    public static boolean appearIn(int[] A, int to_find)
    {
        return appearInRec(A, to_find, 0);
    }
    private static boolean appearInRec(int[] A, int to_find, int idx)
    {
        if (A[idx] == to_find)
            return true;
        if (idx == (A.length - 1))
        {
            System.out.printf("Element %d Not found !\n", to_find);
            return false;
        }
        return appearInRec(A, to_find, ++idx); // next index before send to new recursion
        // return appearInRec(A, to_find, idx++); // bug
    }
}
