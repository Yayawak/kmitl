import java.util.Arrays;

class ProFunc09_A1_65988{
    public static void main(String[] args)
    {
        int[] data = {0, 1, 0, 1, 1, 0, 0, 0, 1};
        shake(data);
        System.out.println(Arrays.toString(data));
    }

    static void shake(int[] data)
    {
        int count0 = 0, count1 = 0;

        // count 0, 1
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == 0) count0++;
            if (data[i] == 1) count1++;
        }

        // fill all
        for (int i = 0; i < data.length; i++)
        {
            if (i < count0) data[i] = 0;
            else if (i >= count0) data[i] = 1;
        }

    }
}
