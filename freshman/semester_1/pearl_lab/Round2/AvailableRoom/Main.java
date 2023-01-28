import java.util.Scanner;

class Main
{
    static Scanner scanner = new Scanner(System.in);
    static int[] getKeyboardInput(int size, String desc)
    {
        // System.out.printf("Desc : %s", desc);
        int[] ret = new int[size];
        for (int i = 0; i < size; i++)
        {
            int num = scanner.nextInt();
            ret[i] = num;
        }
        return ret;
    }
    public static void main(String[] args) {
        int N = getKeyboardInput(1, "Enter Number of rooms")[0];
        // if (!(N <= 100)) return;
        if (!(0 < N && N <= 100)) return ;
        // System.out.println("Enter each year commitment time : ");
        // int years = scanner.nextInt();
        int[] yearsArr = getKeyboardInput(N, "");
        int startYear = getKeyboardInput(1, "Enter start year")[0];
        int[] ends = new int[N];
        for (int i = 0; i < N; i++)
            // ends[i] = startYear + yearsArr[i] + 1;
            ends[i] = startYear + yearsArr[i];
        int numberyearAskingAvailable = getKeyboardInput(1, "Which year available you want to ask ? ")[0];
        // orange
        int[] asks = new int[numberyearAskingAvailable];
        for (int i = 0; i < numberyearAskingAvailable; i++)
        {
            asks[i] =
                getKeyboardInput(1, "Enter asking year : ")[0];
            // System.out.printf("endingYear[%d] : %d\n", i, ends[i]);
        }

        int[][] outputMtxToPrint = new int[numberyearAskingAvailable][N];

        for (int i = 0; i < numberyearAskingAvailable; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int diff =  asks[i] - ends[j];
                // int diff = ends[j] - asks[i];
                if (diff < 0)
                {
                    // System.out.printf("x,");
                }
                else
                {
                    // int diff =  asks[k] - (startYear + yearsArr[i]);
                    // int diff =  (startYear + yearsArr[k]) - asks[i];
                    // System.out.printf("%d,", diff);
                    // System.out.printf("%d_", diff);
                    // System.out.printf("%d_", j + 1);
                    outputMtxToPrint[i][j] = j + 1;
                }
            }
            // System.out.println();
        }
        for (int i = 0; i < outputMtxToPrint.length; i++)
        {
            int countEmptyInRow = 0;
            for (int j = 0; j < outputMtxToPrint[0].length; j++)
            {
                if (outputMtxToPrint[i][j] != 0)
                {
                    String endStr = (j == outputMtxToPrint[0].length - 1)
                        ? "" : " ";
                        // ? "" : "_";
                    System.out.printf("%d" + endStr, outputMtxToPrint[i][j]);
                    // if (i == outputMtxToPrint.length)
                        // System.out.println(" ");
                }
                else
                {
                    countEmptyInRow++;
                }

                if (countEmptyInRow == outputMtxToPrint[0].length)
                {
                    System.out.printf("full\n");
                }
            }
            if (i != outputMtxToPrint.length - 1)
                System.out.println();
        }
    }
}
// full
// 1 3
// 1 2 3

// 3 4 10
// 1 3 4 5 6 7 10
// 1 2 3 4 5 6 7 8 9 10
