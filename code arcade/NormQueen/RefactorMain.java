package NormQueen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;
import java.lang.Math;

class UtilsClass
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static Scanner sc = new Scanner(System.in);;

    public static int randbet(int a, int b)
    {
        int ret =  (int)(Math.random() * (b - a) + a);
        // if (!(a < ret && b < ret))
        // if ((ret < a || b > ret))
        //     return randbet(a, b);
        return ret;
    }

    public static String getPrettyIntArray(int[] A)
    {
        StringBuilder sb = new StringBuilder("[");
        int i;
        for (i = 0; i < A.length - 1; i++)
            sb.append(A[i] + ", ");
        sb.append(A[i]);
        sb.append("]");
        return sb.toString();
    }

    // public static int getNumInput()
    public static int getNumInput(int start, int exclusiveEnd)
    {
        try {
            String input = sc.nextLine();
            int num = Integer.parseInt(input); // for try catch

            if (!(start < num && num < exclusiveEnd))
            {
                System.out.format("Constraint %d < %d %d\n", start, num, exclusiveEnd);
                getNumInput(start, exclusiveEnd);
            }
            // throw new Error(input, null)
            
            return (num);
        } 
        catch (NumberFormatException e)
        {
            System.out.println("You must enter a number, not a string.");
            // throw new Exception("invalide number");
            return getNumInput(start, exclusiveEnd);
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return (-666);
    }

    public static void print2DPointData(PointData[][] map)
    {

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < map.length; i++)
        {
            int j;
            sb.append("|");
            for ( j = 0; j < map[i].length - 1; j++)
            {
                if (map[i][j].marked == "T")
                    sb.append(ANSI_GREEN);
                else if (map[i][j].marked == "K")
                    sb.append(ANSI_YELLOW);
                else if (map[i][j].marked == "Q")
                    sb.append(ANSI_RED);
                else 
                    sb.append(ANSI_RESET);
                sb.append(map[i][j].marked + ANSI_RESET + "|");
            }
            sb.append(map[i][j].marked +"|\n");
            // sb.append("∟".repeat((pointDatas[i].length * 2) + 1) + "\n");
        }
        System.out.println(sb.toString());
    }

    public static String getOnlyLowerCaseStringInput()
    {
        String rawString = sc.nextLine();
        for (int i = 0; i < rawString.length(); i++)
        {
            char c = rawString.charAt(i);
            if (!(Character.isAlphabetic(c) && Character.isLowerCase(c)))
            {
                System.out.println("Error found : input only alphabet & lowercase characters");
                return getOnlyLowerCaseStringInput();
            }
        }
        return (rawString);
    }

    public static void closeScanner()
    {
        sc.close();
    }

    public static List<List<Integer>> genCombinations(int[] numbs, int r)
    {
        List<List<Integer>> res = new ArrayList<>();
        genCombRecursive(new ArrayList<>(), 0, numbs, res, r);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + ",");
            }
            // System.out.println(list);
            System.out.println();
        }
        return (res);
    }

    private static void genCombRecursive(List<Integer> currentComb, int curIdx, int[] numbs,
        List<List<Integer>> result, int combSize)
    {
        if (currentComb.size() == combSize)
        {
            result.add(new ArrayList<>(currentComb));
            return ;
        }
        for (int i = 0; i < numbs.length; i++)
        {
            currentComb.add(numbs[i]);
            genCombRecursive(currentComb, i + 1, numbs, result, combSize);
            currentComb.remove(currentComb.size() - 1);
        }
    }


}


class PointData
{
    int x;
    int y;
    public Piece whoIsOccupied;
    public String marked = " ";
    public int label = -1;

    public PointData(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(PointData other)
    {
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString()
    {
        // return (whoIsOccupied == null) ? " " : "x";
        return (whoIsOccupied != null) ? (whoIsOccupied.pieceName == "norminate")
            ? "Q" : "K"
            : "v";
    }

    public String posStr()
    {
        return String.format("[%d,%d]", x, y);
    }

}

class PointDataForAStart extends PointData
{
    public float h;
    public float g;
    public float f;

    public PointDataForAStart(int x, int y) {
        super(x, y);
    }
    public PointDataForAStart(PointData pointData) {
        super(pointData.x, pointData.y);
    }

}

class Piece
{
    PointData pointData;
    String pieceName;

    public Piece(PointData pointData, String pieceName) {
        this.pointData = pointData;
        this.pieceName = pieceName;
    }
}

class QueenPiece extends Piece 
{
    // public PointData[] queenLegalMoves;
    public List<PointData> queenLegalMoves;

    public QueenPiece(PointData pointData, String pieceName) {
        super(pointData, pieceName);
    }

    public void calcualteQueen(Board board)
    {
        this.queenLegalMoves = allLegalMovesPositionData(board);
    }

    private void addPointWithNoDuplicate(List<PointData> list, PointData newPoint)
    {
        for (PointData p : list)
        {
            if (p.equals(newPoint))
            {
                return;
            }
        }
        list.add(newPoint);

    }

    // public PointData[] allLegalMovesPositionData(Board boardQueenOn)
    public List<PointData> allLegalMovesPositionData(Board boardQueenOn)
    {
        final int queenX = pointData.x;
        final int queenY = pointData.y;
        final int rightVec[] = {1, 0};
        final int leftOffset = queenX - 0;
        final int rightOffset = boardQueenOn.N - 1 - queenX;
        final int topOffset = queenY - 0;
        final int botOffset = boardQueenOn.N - 1 - queenY;
        List<PointData> legalMoves = new ArrayList<PointData>();

        for (int dirIndex = 0; dirIndex < 8; dirIndex++)
        {
            int degree = 45 * dirIndex;
            float rad = (float)Math.toRadians((float)degree);
            float Rv_x = (float)Math.cos(rad) * rightVec[0] - (float)Math.sin(rad) * rightVec[1];
            float Rv_y = (float)Math.sin(rad) * rightVec[0] + (float)Math.cos(rad) * rightVec[1];
            int scaleX = (Math.abs(Rv_x - 0.000f) < 0.001f) ? 0 : (Rv_x > 0) ? 1 : -1;
            int scaleY = (Math.abs(Rv_y - 0.000f) < 0.001f) ? 0 : (Rv_y > 0) ? -1 : +1;
            int nx = (scaleX >= 0) ? rightOffset : leftOffset;
            int ny = (scaleY >= 0) ? botOffset : topOffset;
            nx++;
            ny++;
            if (dirIndex % 2 == 0)
            {
                int offset;
                if (dirIndex == 0)
                    offset = rightOffset;
                else if (dirIndex == 2)
                    offset = topOffset;
                else if (dirIndex == 4)
                    offset = leftOffset;
                // else if (dirIndex == 6)
                else 
                    offset = botOffset;
                // ? ชดเชยจุดที่ทQueens ยืนอยู่
                offset++;
                for (int i = 0; i < offset; i++)
                {
                    addPointWithNoDuplicate(legalMoves,
                        new PointData(
                            queenX + i * scaleX, queenY + i * scaleY));
                }
            }
            // diagonal is so fine
            else
            {
                int n = (nx < ny) ? nx : ny;
                // System.out.println("n = " + n);
                for (int i = 0; i < n; i++)
                {
                    if (queenX + i * scaleX != queenX || queenY + i * scaleY != queenY)
                        addPointWithNoDuplicate(legalMoves,
                            new PointData(
                                queenX + i * scaleX, queenY + i * scaleY));
                }
            }
        }
        // PointData[] ret = legalMoves.toArray(new PointData[0]);
        // return (ret);
        return (legalMoves);
    }

    public void showListOfLegalMoves()
    {
        // System.out.println("Lenght of list = " + queenLegalMoves.length);
        System.out.println("Size of list = " + queenLegalMoves.size());
        for ( var pointData : queenLegalMoves) {
            System.out.print(pointData.posStr() + "\t"); 
        }
        System.out.println();
    }
    
    private boolean isQueenCanMoveOnThisPoint(PointData p)
    {
        for (PointData pointData : queenLegalMoves) {
            if (pointData.equals(p))
                return true;
        }
        return false;
    }

    public void printLegalMoves(Board boardQueenOn)
    {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < boardQueenOn.pointDatas.length; i++)
        {
            int j;
            sb.append("|");
            for ( j = 0; j < boardQueenOn.pointDatas[i].length; j++)
            {
                if (isQueenCanMoveOnThisPoint(new PointData(j, i)))
                {
                    if (this.pointData.equals(new PointData(j, i)))
                    {
                        sb.append("Q|");
                        // sb.append(Color.RED + "Q" + Color.RESET + "|");
                    }
                    else
                        sb.append("x" + "|");
                }
                else   
                {
                    sb.append(" " + "|");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}


class Board
{
    public PointData[][] pointDatas;
    public int N;

    public PointData[][] createEmptyMap(int n)
    {
        PointData[][] pd = new PointData[n][n];
        for (int i = 0; i < n; i++)
        {
            pd[i] = new PointData[n];
            for (int j = 0; j < n; j++)
            {
                pd[i][j] = new PointData(i, j);
                pd[i][j].marked = " ";
            }
        }
        return (pd);
    }

    public Board(int n) 
    {
        this.N = n;
        this.pointDatas = createEmptyMap(n);
    }

    public void OccupyPoint(Piece piece, PointData pointData)
    {
        pointData.whoIsOccupied = piece;
        this.pointDatas[pointData.x][pointData.y] = pointData;
    }

    public void printBoard()
    {

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < pointDatas.length; i++)
        {
            int j;
            sb.append("|");
            for ( j = 0; j < pointDatas[i].length - 1; j++)
            {
                sb.append(pointDatas[i][j] + "|");
            }
            sb.append(pointDatas[i][j] +"|\n");
            // sb.append("∟".repeat((pointDatas[i].length * 2) + 1) + "\n");
        }
        System.out.println(sb.toString());
    }
}

class PathFinder
{
    // static class MinFComparator implements Comparator<PointDataForAStart>
    // {
    //     @Override
    //     public int compare(PointDataForAStart o1, PointDataForAStart o2) {
    //         return (o1.f < o2.f) ? 1 : -1;
    //     }

    // }

    // private static float heuristic(PointData from, PointData target)
    // {
    //     return Math.abs(from.x - target.x) + Math.abs(from.y - target.y);
    // }

    // private static void linkObstacleToMap(PointData[][] map, List<PointData> obstacles)
    // {
    //     for (int i = 0; i < obstacles.size(); i++)
    //     {
    //         PointData cur = obstacles.get(i);
    //         map[cur.x][cur.y].marked = "x";
    //     }
    // }

    // // 8 N for king move
    // public static List<PointDataForAStart> getNeighbors(PointData[][] map, PointData point)
    // {
    //     List<PointDataForAStart> neighbors = new ArrayList<PointDataForAStart>();
    //     List<List<Integer>> nbIndices = UtilsClass.genCombinations(new int[]{-1, 0, 1}, 2);
    //     for (int i = 0; i < nbIndices.size(); i++)
    //     {
    //         int x = nbIndices.get(i).get(0);
    //         int y = nbIndices.get(i).get(1);
    //         try {
    //             if (x != point.x || y != point.y)
    //                 neighbors.add(
    //                     map[point.x + x][point.y + y]
    //                 );
    //         } catch (Exception e) { }
    //     }
    //     // if (x > 1) // add left
    //     //     neighbors.add(map[x - 1][y]);
    //     // if (x < map.length - 1)
    //     //     neighbors.add(map[map.length - x - 1][y]);
    //     // if ()
    //     // int combination[] = {1}


    //     return (neighbors);
    //     // if (x < 0)
    //     // if ()
    // }

    // public static List<PointData> pathToPoint(Board board, List<PointData> obstacles,
    //     PointData _start, PointData _terminal)
    // {
    //     PointData[][] map = board.createEmptyMap(board.N);
    //     linkObstacleToMap(map, obstacles);
        
    //     // PriorityQueue<PointData> closedPoints = new PriorityQueue<PointData>();
    //     // PriorityQueue<PointData> openPoints = new PriorityQueue<PointData>();
    //     PointDataForAStart start = new PointDataForAStart(_start);
    //     PointDataForAStart terminal = new PointDataForAStart(_terminal);

    //     // List<PointDataForAStart> openList = new ArrayList<PointDataForAStart>();
    //     // List<PointDataForAStart> closedList = new ArrayList<PointDataForAStart>();
    //     PriorityQueue<PointDataForAStart> closedList = new PriorityQueue<PointDataForAStart>(new MinFComparator());
    //     PriorityQueue<PointDataForAStart> openList = new PriorityQueue<PointDataForAStart>(new  MinFComparator());
    //     openList.add(start);
    //     start.g = 0;
    //     start.h = heuristic(start, terminal);
    //     start.f = start.g + start.h;


    //     // * test 
    //     // for (PointData p : getNeighbors(map, terminal))
    //     // {
    //     //     System.out.println("Neighbors " + p.posStr());
    //     // }
    //     while (!openList.isEmpty())
    //     {
    //         PointDataForAStart currentCell = openList.peek();
    //         // if (currentCell.equals(terminal))
    //         // {
    //         //     // openList.remove(currentCell);
    //         //     List<PointData> path = new ArrayList<>();
    //         //     PointDataForAStart cur = terminal;
    //         //     while (cur != null)
    //         //     {
    //         //         path.add(cur);
    //         //         cur = cur.
    //         //     }
    //         // }

    //         List<PointDataForAStart> neighbors = getNeighbors(map, currentCell);
    //         for (PointDataForAStart nb : neighbors)
    //         {
    //             float tentativeG = currentCell.g + 1;

    //             if (tentativeG < nb.g)
    //             {
    //                 nb.
    //             }
    //         // closedList.add(currentCel );
    //         // for (PointDataForAStart )
            
    //     }


    //     return (null);
    // }
}

class BFS
{
    // public static int[][] dir = UtilsClass.genCombinations(new int[]{-1, 0, 1}, 2);
    // public static int dirctions[][] = new int[4][2];
    // public static int dirctions[][] = new int[4][2];
    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // public static int dir[][] = new int[8][2];

    // public BFS()
    // {
    //     // List<List<Integer>> d = UtilsClass.genCombinations(new int[]{-1, 0, 1}, 2);
    //     // for (int i = 0; i < d.size(); i++)
    //     // {
    //     //     dirctions[i][0] = d.get(i).get(0);
    //     //     dirctions[i][1] = d.get(i).get(1);
    //     // }
    // }

    private static boolean isValid(int x, int y, PointData[][] map)
    {
        int rows = map.length;
        int cols = map[0].length;
        return x >= 0 && x < rows && y >= 0 && y < cols && map[x][y].marked == " ";

    }

    private static void printResult(Board board, PointData start, PointData terminal,
        PointData queenPos, List<PointData> pathIfExist)
    {
        if (pathIfExist != null)
            // NOTE draw path
            for (PointData cango : pathIfExist) {
                board.pointDatas[cango.y][cango.x].marked = 
                    UtilsClass.ANSI_BLUE + "*" + UtilsClass.ANSI_RESET;
            }
        board.pointDatas[terminal.y][terminal.x].marked = "T";
        board.pointDatas[start.y][start.x].marked = "K";
        board.pointDatas[queenPos.y][queenPos.x].marked = "Q";
        UtilsClass.print2DPointData(board.pointDatas);
    }

    // public List<PointData> findShortestPath(Board board, PointData start, PointData terminal)
    // public static int findShortestPath(Board board, List<PointData> obstacles,
    public static List<PointData> findShortestPath(Board board, List<PointData> obstacles,
        PointData start, PointData terminal,
        PointData queenPos // for visualization
        )
    {

        // ? King pos = start position
        for (PointData obstacle : obstacles)        
        {
            board.pointDatas[obstacle.y][obstacle.x].marked = "x";
            // board.pointDatas[obstacle.y][obstacle.x].marked = "y";
        }
        // if king is on X path -> return -1
        for (PointData point : obstacles)
            if (start.equals(point))
            {
                printResult(board, start, terminal, queenPos, null);
                return null;
            }

        int rows = board.pointDatas.length;
        int cols = board.pointDatas[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<List<PointData>> q = new ArrayDeque<>();
        List<PointData> initialPath = new ArrayList<>();
        initialPath.add(start);

        q.offer(initialPath);
        // visited[start.x][start.y] = true;
        visited[start.y][start.x] = true;
            

        while (!q.isEmpty())
        {
            List<PointData> currentPath = q.poll();
            PointData current = currentPath.get(currentPath.size() - 1);

            if (current.equals(terminal))
            {
                printResult(board, start, terminal, queenPos, currentPath);
                return currentPath;
            }

            for (int[] dir : directions)
            {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];

                // if (isValid(newX, newY, board.pointDatas)
                if (isValid(newX, newY, board.pointDatas)
                    &&
                    !visited[newY][newX]
                )
                {
                    visited[newY][newX] = true;
                    // visited[newX][newY] = true;
                    // visited[newY][newX] = true;
                    List<PointData> newPath = new ArrayList<>(currentPath);
                    newPath.add(board.pointDatas[newX][newY]);
                    // newPath.add(board.pointDatas[newY][newX]);
                    q.offer(newPath);
                }

            }
        }

    printResult(board, start, terminal, queenPos, null);
    return null;
}


public class Main {


    public static void main(String[] args) 
    {
        int boardSize = UtilsClass.getNumInput(1, 1000);
        Board singleBoard = new Board(boardSize);
        Piece king = new Piece(new PointData(a, b), "kingNomsy");
        QueenPiece queen = new QueenPiece(new PointData(a, b),"norminate");
        singleBoard.OccupyPoint(king, king.pointData);
        singleBoard.OccupyPoint(queen, queen.pointData);
        queen.calcualteQueen(singleBoard);
        // queen.printLegalMoves(singleBoard);
        queen.showListOfLegalMoves();
        List<PointData> pathIfFound = BFS.findShortestPath(singleBoard,
            queen.queenLegalMoves, 
            king.pointData,
            new PointData(a, b),
            queen.pointData
        );

        UtilsClass.closeScanner();

    }

    }
}