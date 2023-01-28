// package Round2.WarpP3;
// import java.util.Arrays;
import java.util.Scanner;

public class Old {
    static Scanner scanner = new Scanner(System.in);
    static int[] getKeyboardInput(int size, String desc)
    {
        // System.out.printf("Desc : %s\n", desc);
        int[] ret = new int[size];
        for (int i = 0; i < size; i++)
        {
            int num = scanner.nextInt();
            ret[i] = num;
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {

        int[] RC = getKeyboardInput(2, "Enter number of row & column : ");
        // if (RC[0] < 5) throw new Exception("r must >= 5");
        if (RC[0] < 5) return;
        // if (!(RC[1] > 1 && RC[1] < 500)) throw new Exception("c must be in between 0 to 500");
        if (!(RC[1] > 1 && RC[1] < 500)) return;
        // int[] RC = {6, 10};
        int[][] grid = new int[RC[0]][RC[1]];
        for (int i = 0; i < RC[0]; i++)
        {
            grid[i] = getKeyboardInput(RC[1], "Enter element of this row");
        }
        Map map = new Map(grid);
        // Map map = new Map();
        // System.out.println(map.getDualPosition(4));
        // System.out.println(map.getDualPosition(5)[0][0]);
        int[] starPos = getKeyboardInput(2, "Enter start position : ");
        // int[] starPos = {0,0};
        // int[] starPos = {2, 9};
        int firstWarp = map.findFirstWarp(starPos);
        // System.out.printf("First wrap found : %d\n", firstWarp);

        System.out.println(firstWarp);
        int[] startWarpPos = map.getDualPosition(firstWarp)[0];
        int[] endWarpPos = map.getDualPosition(firstWarp)[1];
        System.out.printf("%d %d\n",
            startWarpPos[0] + 1, startWarpPos[1] + 1
            );
        // System.out.printf("%d %d\n",
        System.out.printf("%d %d",
            endWarpPos[0] + 1, endWarpPos[1] + 1
            );
        // System.out.println(
        //     Arrays.toString(map.getDualPosition(firstWarp)[0])
        // );
        // System.out.println(
        //     Arrays.toString(map.getDualPosition(firstWarp)[1])
        // );
    }
}

class Map
{
    private int[][] map = {
        {0,1,0,0,0,5,0,0,0,5},
        {6,0,0,0,3,0,0,0,0,0},
        {0,2,0,0,0,0,0,4,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,2,0,0,0,1},
        {6,4,0,0,0,0,0,3,0,0}
    };
    Map() { }
    Map(int[][] map)
    {
        this.map = map;
    }
    int[][] getMap()
    {
        return this.map;
    }
    int[][] getDualPosition(int findingWarpNum)
    {
        // dual = { {x, y}, {x, y} }
        int[][] dual = new int[2][2];
        int k = 0;
        for (int i = 0; i < this.map.length; i++)
            for (int j = 0; j < this.map[0].length; j++)
            {
                if (this.map[i][j] == findingWarpNum)
                {
                    int[] xy = {i, j};
                    dual[k] = xy;
                    k++;
                }
            }
        return dual;
    }

    int findFirstWarp(int[] starPos)
    {
        int i = starPos[0], j = starPos[1];
        boolean isEndTraversing = false;
        int findingWarpNum = -1; // if not found warp
        while (isEndTraversing == false)
        {
            // System.out.println("here");
            // System.out.printf("i = %d\n", i);
            // System.out.printf("j = %d\n", j);
            j = 0;
            while (j < this.map[0].length)
            {
                // System.out.println("Jeer");
                // System.out.printf("(x,y) = (%d,%d) : ", i, j);
                // System.out.printf("value = %d\n", this.map[i][j]);
                if (i > this.map.length &&
                    j > this.map[0].length)
                {
                    i = 0; j = 0;
                }
                if (this.map[i][j] != 0)
                {
                    findingWarpNum = this.map[i][j];
                    isEndTraversing = true;
                    break;
                }
                j++;
            }
            i++;
        }
        return findingWarpNum;
    }
}
