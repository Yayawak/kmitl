package Test;

import java.util.Arrays;

public class MainV3 {
    static final int n_col = 12;
    static final int n_row = 8;
    static final boolean isDisplayArrayForm = !true;

    public static void main(String[] args) {
        // todo 1 : plant bombs
        int mapWithMine[][] = generateMineMap(n_row, n_col, true);
        int map_mine_warning[][] = markMap(mapWithMine);
        displayMap(map_mine_warning, "Map after mark warning", isDisplayArrayForm);
    }

    static  int[][] markMap(int[][] mineMap)
    {
        displayMap(mineMap, "Map before counting mines", isDisplayArrayForm);
        countMine(mineMap);
        return mineMap;
    }

    static void countMine(int[][] mineMap)
    {
        for (int i = 0; i < mineMap.length; i++)
            for (int j = 0; j < mineMap[0].length; j++)
                if (mineMap[i][j] == 0)
                    mineMap[i][j] = surroundingMine(mineMap, i, j);
    }

    // ! Most Important part
    static int surroundingMine(int[][] mineMap, int x, int y)
    {
        int mines = 0;
        mines += getMineAmount(mineMap, x - 1, y - 1);
        mines += getMineAmount(mineMap, x - 1, y);
        mines += getMineAmount(mineMap, x - 1, y + 1);
        mines += getMineAmount(mineMap, x, y - 1);
        mines += getMineAmount(mineMap, x, y + 1);
        mines += getMineAmount(mineMap, x + 1, y - 1);
        mines += getMineAmount(mineMap, x + 1, y);
        mines += getMineAmount(mineMap, x + 1, y + 1);
        return mines;
    }

    static int getMineAmount(int[][] mineMap, int x, int y)
    {
        if (x >= 0 && x < mineMap.length
            && y >= 0 && y < mineMap[0].length
            && mineMap[x][y] == 9
            )
            return 1;
        else
            return 0;
    }

    static  int[][] generateMineMap(int row, int col, boolean withMine)
    {
        int[][] mineMap = new int[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                float prob_get_mine = 0.30f;
                mineMap[i][j] = withMine
                    ?  Math.random() > prob_get_mine ? 0 : 9
                    : 0 ;
            }
        }
        return mineMap;
    }
    static void displayMap(int[][] map, String desc,
        boolean arrayForm)
    {
        if (arrayForm)
        {
            System.out.println(desc);
            for (int row = 0; row < map.length; row ++)
            {
                long sleep = 1000L * 9;
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Arrays.toString(map[row]));
            }
        }
        else
        {
            System.out.println(Colors.ANSI_YELLOW +  desc);
            for (int i = 0; i < map.length; i++)
            {
                for (int j = 0; j < map[0].length; j++)
                {
                    if (map[i][j] == 9)
                        System.out.printf("%s, ", Colors.ANSI_RED + String.valueOf(9));
                    else
                    {
                        int valueOfTile = map[i][j];
                        for (int k = 0; k < 9; k++)
                        {
                            if (valueOfTile == k)
                            System.out.printf("%s, ", Colors.SORTED_COLORS[k] + String.valueOf(valueOfTile));
                        }
                        // valueOfTile ==
                        // if (i == 0 || i == map.length - 1 )
                        //     System.out.printf("%s, ", Colors.ANSI_GREEN + String.valueOf(valueOfTile));
                        // else
                        //     System.out.printf("%s, ", Colors.ANSI_GREEN + String.valueOf(valueOfTile));
                    }
                }
                System.out.println();
            }
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


        // High Intensity
        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        public static final String[] SORTED_COLORS = {
            ANSI_WHITE, ANSI_PURPLE, ANSI_CYAN,
            ANSI_BLUE, ANSI_GREEN, ANSI_YELLOW,
            YELLOW_BRIGHT, BLACK_BRIGHT, ANSI_RESET
        };

    }
}
