public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int C = 16;
        int[] itemsW = {2, 10, 5, 5};
        int[] itemsV = {20, 50, 30, 10};

        int[][] table = new int[itemsW.length + 1][C + 1];

        for (int item = 1; item <= itemsV.length; item++)
        {
            for (int weightSoFar = 0;
                weightSoFar <= C; weightSoFar++
            )
            {
                int curWeight = itemsW[item - 1] ;
                int curVal = itemsV[item - 1];
                table[item][weightSoFar] = table[item - 1][weightSoFar];

                if (weightSoFar - curWeight >= 0)
                {
                    if (curVal + table[item - 1][weightSoFar - curWeight] > table[item - 1][weightSoFar])
                    {
                        table[item][weightSoFar] = curVal + table[item - 1][weightSoFar - curWeight];
                    }
                }
                else
                    System.out.println("negative index");
            }
        }

        for (int i = 0; i < table.length; i++)
        {
            for (int j = 0; j < table[0].length; j++)
                System.out.print(table[i][j] + " ");
            System.out.println();
        }

    }
}