public class test {
    static int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args){
        System.out.println(binarySearch(6, 0, 8));
    }

    static int binarySearch(int d, int curIdx, int nextIdx)
    {
        // int mid_idx = size / 2;
        // int mid_idx = idx / 2;

        if (d == data[curIdx])
        {
            return curIdx;
        }
        else if (d < data[curIdx])
        {
            // left
            binarySearch(d, curIdx, (nextIdx - curIdx) / 2);
        }
        else
        {
            binarySearch(d, curIdx, (nextIdx - curIdx) / 2);
        }
        return nextIdx;

    }
}
