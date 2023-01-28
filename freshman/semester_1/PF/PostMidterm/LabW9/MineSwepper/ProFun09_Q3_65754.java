
import java.util.Arrays;

public class ProFun09_Q3_65754 {
    public static void main(String[] args) {
        int[][] minesweeperMap = new int[8][13];

        int[][] mMap = markMap(minesweeperMap);
        System.out.println("Map : after Counted the bomb");
        for (int row = 0; row < mMap.length; row++) {
            System.out.println(Arrays.toString(mMap[row]));
        }
    }

    static int[][] markMap(int[][] bMap) {
        plantBomb(bMap);
        System.out.println("Map : before Count the bomb");
        for (int row = 0; row < bMap.length; row++) {
            System.out.println(Arrays.toString(bMap[row]));
        }
        System.out.println();
        countBomb(bMap);
        return bMap;
    }

    static void plantBomb(int[][] bMap) {
        for (int i = 0; i < bMap.length; i++) {
            for (int j = 0; j < (int) (Math.random() * 5); j++) {
                bMap[i][(int) (Math.random() * 13)] = 9;
            }
        }
    }

    static void countBomb(int[][] bMap) {
        for (int i = 0; i < bMap.length; i++) {
            for (int j = 0; j < bMap[0].length; j++) {
                if (bMap[i][j] == 0) {
                    bMap[i][j] = bombNear(bMap, i, j);
                }
            }
        }
    }

    static int bombNear(int[][] bMap, int x, int y) {
        int bombs = 0;
        bombs += checkAt(bMap, x - 1, y - 1);
        bombs += checkAt(bMap, x - 1, y);
        bombs += checkAt(bMap, x - 1, y + 1);
        bombs += checkAt(bMap, x, y - 1);
        bombs += checkAt(bMap, x, y + 1);
        bombs += checkAt(bMap, x + 1, y - 1);
        bombs += checkAt(bMap, x + 1, y);
        bombs += checkAt(bMap, x + 1, y + 1);
        return bombs;
    }

    static int checkAt(int[][] bMap, int x, int y) {
        if (x >= 0 && x < bMap.length && y >= 0 && y < bMap[0].length && bMap[x][y] == 9) {
            return 1;
        } else {
            return 0;
        }
    }
}
