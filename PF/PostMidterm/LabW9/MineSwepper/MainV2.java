
public class MainV2 {
    static final int n_col = 6;
    static final int n_row = 4;


    public static void main(String[] args) {
        int mapWithMine[][] = generateMineMap(n_row, n_col, true);
        displayMapWithColor(mapWithMine, "Map with mines");

        int map_mine_warning[][] = markMap(mapWithMine);
        // displayMapWithColor(map_mine_warning, "Map afterr mark warning");
    }
    static  int[][] markMap(int[][] mineMap)
    {
        int[][] oneTileExtendMap = generateMineMap(
            mineMap.length + 1 + 1, // left tile & right tile
            mineMap[0].length + 1 + 1,
            false
        );
        // displayMapWithColor(oneTileExtendMap, "extended one tiles map");

        int[][] to_mark_map = generateMineMap(mineMap.length, mineMap[0].length,
            false);
        // todo : added extra tiles
        for (int i = 1; i < oneTileExtendMap.length - 2; i++)
        {
            for (int j = 1; j < oneTileExtendMap[0].length - 2; j++)
            {
                // todo : check adjacent tile and filter to sum
                oneTileExtendMap[i][j] = mineMap[i-1][j-1];

                int countMine = 0;
                for (int x = i-1; x < i+3; x++)
                {
                    for (int y = j-1; y < j+3; y++)
                    {
                        if (oneTileExtendMap[x][y] == 9 && x != i && y != j) countMine++;
                    }
                }
                to_mark_map[i-1][j-1] = countMine;
            }

        }
        displayMapWithColor(to_mark_map, "Marked Map");



        displayMapWithColor(oneTileExtendMap, "extened one tiles after fill");

        return mineMap;
    }
    // static int getSumOfAdjacent(int[][] adjacentKernel)
    // {
    //     int sum = 0;
    //     for (int i = 0;  i < adjacentKernel.length; i++)
    //     {
    //         for (int j = 0; j < adjacentKernel[0].length; j++)
    //             sum += adjacentKernel[i][j];
    //     }
    //     return sum;
    // }


    static  int[][] generateMineMap(int row, int col, boolean withMine)
    {
        int[][] mineMap = new int[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                float prob_get_mine = 0.40f;
                // mineMap[i][j] = Math.random() > prob_get_mine ? 0 : 9;
                mineMap[i][j] = withMine
                    ?  Math.random() > prob_get_mine ? 0 : 9
                    : 0
                    ;

            }
        }
        return mineMap;
    }
    static void displayMapWithColor(int[][] map, String desc)
    {
        System.out.println(Colors.ANSI_YELLOW +  desc);
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            {
                // if (i == 0)
                if (map[i][j] == 9)
                {
                    System.out.printf("%s, ", Colors.ANSI_RED + String.valueOf(9));
                }
                else
                {
                    int valueOfTile = map[i][j];
                    if (i == 0 || i == map.length - 1 )
                    {
                        // System.out.printf("%s", Colors.ANSI_BLUE_BACKGROUND);
                        System.out.printf("%s, ",
                            // Colors.ANSI_BLUE_BACKGROUND +
                            Colors.ANSI_GREEN + String.valueOf(valueOfTile));
                    }
                    else
                    {
                        System.out.printf("%s, ",
                            // Colors.ANSI_YELLOW_BACKGROUND +
                            Colors.ANSI_GREEN + String.valueOf(valueOfTile));
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static class Colors {
        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

        // ? COLOR with no background
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";
    }
}
