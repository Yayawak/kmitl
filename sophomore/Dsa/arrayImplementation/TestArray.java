import java.util.List;
import java.util.stream.LongStream;

import netscape.javascript.JSObject;

class RowData
{
    public int idx;
    public long[] roundsTime;
    public long avg;
    public long avgByN;

    public RowData() {
        roundsTime = new long[5];
    }
}

public class TestArray {

    private static long subtest(int N)
    {
        long start = System.currentTimeMillis();
        MyArray mArray = new MyArray(N);
        for (int n = 1; n < N; n++)
            mArray.add((int)(Math.random() * 1000));
        // System.out.println(mArray.toString());
        long time = (System.currentTimeMillis() - start);
        // System.out.format("N : %d\ttime used : %d\n", N, time);
        return time;
    }



    public static RowData[] getRowDatas()
    {
        int N = 10_000_000;
        // int N = 100000;
        int n_round = 5;
        RowData[] rowDatas = new RowData[10];
        for (int i = 1; i < 10; i++)
        // for (int i = 1; i < 2; i++)
        {
            rowDatas[i - 1] = new RowData();
            rowDatas[i - 1].idx = i - 1;
            long times[] = new long[n_round];
            for (int j = 0; j < n_round; j++)
            {
                times[j] = subtest(N * i);
                System.out.format("round %d use time %d\n", j, times[j]);

                rowDatas[i - 1].roundsTime[j] = times[j];
            }
            long average = LongStream.of(times).sum() / 5;
            long averageByN = average / N;
            System.out.format("avg : %d\navg/n : %d\n", average, averageByN);
            System.out.println("--------------------------------------");

            rowDatas[i - 1].avg = average;
            rowDatas[i - 1].avgByN = averageByN;
        }

        return rowDatas;
    }

    public static void main(String[] args) {
        // RowData[] data = getRowDatas();
        // for (RowData rowData : data) {
        //     System.out.print("row :  " + rowData.idx + "\t");
        //     for (long l : rowData.roundsTime) {
        //         System.out.printf("%d\t", l);
        //     }
        //     System.out.format("avg : %d\t\tavgByN : %d\n", rowData.avg, rowData.avgByN);
        // }
        getRowDatas();
    }
}
