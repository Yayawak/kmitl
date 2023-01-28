import java.util.Scanner;

class Main {
    static final Scanner sc = new Scanner(System.in);
    static final int       MIL = 1000000;

    public static int[] get_keyboard_input(int size,
        String desc, int arg) throws Exception {
    // public static int[] get_keyboard_input(int size, String desc, int arg) {
        // System.out.printf(desc, arg);
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = sc.nextInt();
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {
        int MN[] = get_keyboard_input(2, "Enter M and N\n", MIL);
        final int M = MN[0];
        final int N = MN[1];

        if (!(M > 1 && M <= 1000000))
            throw new Exception("M must in range 1 to million");
        if (!(N > 1 && N <= 1000000))
            throw new Exception("N must in range 1 to million");

        //int[M][N] matrix;
        int[][] matrix = new int[M][N];

        for (int n = 0; n < N; n++)
        {
            matrix[n] = get_keyboard_input(M, "Enter elements of %d row : ", n);
        }
        // int matrix[][] = {
        //         { -1, 1, 0, 0, 0, 1, 1 },
        //         { 0, 1, 1, 1, 1, 1, 1 },
        //         { 1, 0, 0, 1, 0, 1, 1 },
        //         { 0, 1, 1, 1, 0, 0, 1 },
        //         { 0, 1, 0, 1, 1, 1, 1 },
        //         { 0, 1, 0, 0, 1, 0, 0 },
        //         { 1, 0, 1, 1, 1, 1, 9 }
        // };

        // int start[] = { 0, 0 };
        // int end[] = { 6, 6 };
        int start[] = getPositionOfSearchValue(-1, matrix);
        int end[] = getPositionOfSearchValue(9, matrix);

        Maze maze = new Maze(matrix, start, end);
        maze.findPath();

        if (maze.hasPath)
            System.out.println("Yes");
            // System.out.println("Shortest Path Length: " + maze.shortLength);
        else
            System.out.println("No");
    }

    static int[] getPositionOfSearchValue(int val, int[][] matrix)
    {
        int[] pos = {-555, -555};
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == val)
                {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
        return pos;
    }
}

class Maze {
    int matrix[][];
    int visited[][];
    int shortLength = Integer.MAX_VALUE;
    int length = 0;
    boolean hasPath = false;
    int start[];
    int end[];

    Maze(int matrix[][], int start[], int end[]) {
        this.matrix = matrix;
        this.start = start;
        this.end = end;
        this.visited = new int[matrix.length][matrix.length];
    }

    public void findPath() {
        visit(start[0], start[1]);
    }

    private void visit(int x, int y) {
        if (x == end[0] && y == end[1]) {
            hasPath = true;
            if (length < shortLength)
                shortLength = length;
            return;
        }
        visited[x][y] = 1;
        length++;
        // 1.Right
        if (canVisit(x + 1, y))
            visit(x + 1, y);
        // 2.Down
        if (canVisit(x, y + 1))
            visit(x, y + 1);
        // 3.Left
        if (canVisit(x - 1, y))
            visit(x - 1, y);
        // 4.Up
        if (canVisit(x, y - 1))
            visit(x, y - 1);

        // Backtrack - Unvisit the cell
        visited[x][y] = 0;
        length--;
    }

    private boolean canVisit(int x, int y) {
        if (x < 0 || y < 0 || x >= matrix[0].length || y >= matrix.length)
            return false;
        if (matrix[x][y] == 0 || visited[x][y] == 1)
            return false;
        return true;
    }
}
