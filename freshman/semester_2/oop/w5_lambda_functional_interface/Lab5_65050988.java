import java.util.Arrays;

public class Lab5_65050988 {
    // static int[] data = {28, 85, 8, 77, 48, 39, 2, 2, 2};
    static int[] data = {28, 58, 8, 77, 48, 39};
    // staticc ArrayP
    static ArrayProcessor q1NumberOfEvenElement; // 4
    static ArrayProcessor q2IndexOfLargestEvenValue; // 1
    static ArrayProcessor myMedian; // n / 2th element

    public static void main(String[] args) {
        // q1();
        // q2();
        oneline();
    }

    static void q1() {
        q1NumberOfEvenElement = data_arr -> {
            return Arrays.stream(data_arr).
                filter(e -> e % 2 == 0).toArray().length + 1;
        };
        System.out.println(q1NumberOfEvenElement.calculate(data));
    }

    static void q2() {
        q2IndexOfLargestEvenValue = data_ -> {
            int idx = 0;
            int largestValue = Integer.MIN_VALUE;
            for (int i = 0; i < data_.length; i++) {
                if (data_[i] > largestValue && data_[i] % 2 == 0) {
                    idx = i;
                    largestValue = data_[i];
                }
            }
            return idx;
        };
        System.out.println(q2IndexOfLargestEvenValue.calculate(data));
    }

    static void oneline() {
        int[] tmp = Arrays.copyOf(data, data.length);
        Arrays.sort(tmp);

        // todo : Q3
        myMedian = data_ -> data_[data_.length / 2];
        // myMedian = data_ -> {
        //     int len = data_.length;
        //     int median;
        //     if (len % 2 != 0)
        //         median = data_[((len - 1) + 1) / 2];
        //         // median = data_[(len + 1) / 2];
        //     else
        //         median = (data_[len / 2] + data_[(len - 1) / 2]) / 2;
        //     return median;
        // };
        System.out.println(myMedian.calculate(tmp));

    }

}
