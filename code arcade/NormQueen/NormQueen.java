package NormQueen;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;
// import java.util.Vector;
// import java.lang.Math;

// class Color
// {
//     public static final String RESET = "\033[0m";  // Text Reset
//     // Regular Colors
//     public static final String BLACK = "\033[0;30m";   // BLACK
//     public static final String RED = "\033[0;31m";     // RED
//     public static final String GREEN = "\033[0;32m";   // GREEN
//     public static final String YELLOW = "\033[0;33m";  // YELLOW
//     public static final String BLUE = "\033[0;34m";    // BLUE
//     public static final String PURPLE = "\033[0;35m";  // PURPLE
//     public static final String CYAN = "\033[0;36m";    // CYAN
//     public static final String WHITE = "\033[0;37m";   // WHITE

// }

// class PointData
// {
//     int x;
//     int y;
//     public Piece whoIsOccupied;
//     // boolean 


//     public PointData(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }

//     // @Override
//     public boolean equals(PointData other)
//     {
//         return this.x == other.x && this.y == other.y;
//     }

//     @Override
//     public String toString()
//     {
//         // return (whoIsOccupied == null) ? " " : "x";
//         return (whoIsOccupied != null) ? (whoIsOccupied.pieceName == "norminate")
//             ? "Q" : "K"
//             : "v";
//         // return "x";
//     }

//     public String posStr()
//     {
//         return String.format("[%d,%d]", x, y);
//     }

// }

// class Piece
// {
//     PointData pointData;
//     String pieceName;

//     public Piece(PointData pointData, String pieceName) {
//         this.pointData = pointData;
//         this.pieceName = pieceName;
//     }
// }

// class QueenPiece extends Piece 
// {
//     PointData[] queenLegalMoves;

//     public QueenPiece(PointData pointData, String pieceName) {
//         super(pointData, pieceName);
//     }

//     public void calcualteQueen(Board board)
//     {
//         this.queenLegalMoves = allLegalMovesPositionData(board);
//     }

//     public PointData[] allLegalMovesPositionData(Board boardQueenOn)
//     {
//         final int queenX = pointData.x;
//         final int queenY = pointData.y;
//         System.out.format("Queen position [%d,%d]\n", queenX, queenY);
//         final int rightVec[] = {1, 0};
//         final int leftOffset = queenX - 0;
//         // final int rightOffset = 8 - 1 - queenX;
//         final int rightOffset = boardQueenOn.N - 1 - queenX;
//         final int topOffset = queenY - 0;
//         final int botOffset = boardQueenOn.N - 1 - queenY;
//         List<PointData> legalMoves = new ArrayList<PointData>();

//         for (int dirIndex = 0; dirIndex < 8; dirIndex++)
//         {
//             // legalMoves = new ArrayList<>();
//             int degree = 45 * dirIndex;
//             // 180 deg = 1 pi rad -> 1 rad = 180 / pi deg -> 1 rad =  180 / 3.14 degrees 
//             // float rad = (float)(Math.PI / (float)degree);
//             // rad = Math.round(rad);
//             // float 
//             float rad = (float)Math.toRadians((float)degree);
//             // rotation matrix simple computation
//             // System.out.println("deg = " + degree);
//             System.out.println("deg = " + degree);
//             float Rv_x = (float)Math.cos(rad) * rightVec[0] - (float)Math.sin(rad) * rightVec[1];
//             float Rv_y = (float)Math.sin(rad) * rightVec[0] + (float)Math.cos(rad) * rightVec[1];
//             System.out.format("rvx = %f, rvy = %f\n", Rv_x, Rv_y);

//             // int scaleX = (Math.abs(Rv_x) == 0.f) ? 0 : (Rv_x > 0) ? 1 : -1;
//             // int scaleY = (Math.abs(Rv_y) == 0.f) ? 0 : (Rv_y > 0) ? 1 : -1;
//             int scaleX = (Math.abs(Rv_x - 0.000f) < 0.001f) ? 0 : (Rv_x > 0) ? 1 : -1;
//             int scaleY = (Math.abs(Rv_y - 0.000f) < 0.001f) ? 0 : (Rv_y > 0) ? -1 : +1;
//             // int scaleY = (Math.signum(Rv_y) == 0.f) ? 0 : (Rv_y > 0) ? 1 : -1;
//             System.out.format("scaleX = %d, scaleY = %d\n", scaleX, scaleY);

//             // int nx = Rv_x > 0 ? rightOffset : leftOffset;
//             // int ny = Rv_y > 0 ? botOffset : topOffset;
//             int nx = (scaleX >= 0) ? rightOffset : leftOffset;
//             int ny = (scaleY >= 0) ? botOffset : topOffset;
//             // int ny = Rv_y > 0 ? botOffset : topOffset;
//             System.out.println("nx = " + nx + ", ny = " + ny + "\n");
//             // if (nx == 0) nx += 1 ;
//             // if (ny == 0) ny += 1;
//             // // ? for ชดเชยที่ใช้ center
//             nx++;
//             ny++;
//             // System.out.println("shoud multiple " + nx * ny + " times.");
//             // System.out.println("nx = " + nx + ", ny = " + ny + "\n");
            
//             // int n = (nx != 0) ? 
//             //     (nx < ny) ? nx : ny
//             //     : 
//             // direct dir
//             if (dirIndex % 2 == 0)
//             {
//                 int offset;
//                 if (dirIndex == 0)
//                     offset = rightOffset;
//                 else if (dirIndex == 2)
//                     offset = topOffset;
//                 else if (dirIndex == 4)
//                     offset = leftOffset;
//                 // else if (dirIndex == 6)
//                 else 
//                     offset = botOffset;
//                 // ? ชดเชยจุดที่ทQueens ยืนอยู่
//                 offset++;
//                 for (int i = 0; i < offset; i++)
//                 {
//                     legalMoves.add(
//                         new PointData(
//                             queenX + i * scaleX, queenY + i * scaleY)
//                     );
//                 }
//             }
//             // diagonal is so fine
//             else
//             {
//                 int n = (nx < ny) ? nx : ny;
//                 System.out.println("n = " + n);
//                 for (int i = 0; i < n; i++)
//                 {
//                     if (queenX + i * scaleX != queenX || queenY + i * scaleY != queenY)
//                         legalMoves.add(
//                             new PointData(
//                                 queenX + i * scaleX, queenY + i * scaleY)
//                             );
//                 }
//             }
//             System.out.println();
//             for ( var pointData : legalMoves) {
//                 System.out.print(pointData.posStr() + "\t"); 
//             }
//             System.out.println("\n" + "---".repeat(20) + "\n");
//             // printLegalMoves(boardQueenOn);
//         }
//         // x == y is goable of queen PointData traversalPoint = pointData;
//         // croos X Move algorihm
//         // PointData[] ret = legalMoves.toArray(new PointData[legalMoves.size()]);
//         // PointData[] ret = legalMoves.toArray(new PointData[0]);
//         // System.out.println("Lenght of list = " + legalMoves.size());
//         // for ( var pointData : legalMoves) {
//         //     System.out.print(pointData.posStr() + "\t"); 
//         // }
//         PointData[] ret = legalMoves.toArray(new PointData[0]);
//         System.out.println("Lenght of array ret = " + ret.length);
//         return (ret);
//     }
    
//     // private boolean isQueenCanMoveOnThisPoint(PointData p, Board board)
//     private boolean isQueenCanMoveOnThisPoint(PointData p)
//     {
//         for (PointData pointData : queenLegalMoves) {
//             if (pointData.equals(p))
//                 return true;
//         }
//         return false;
//     }

//     private PointData[][] createEmptyMatrixOfN(int N)
//     {
//         PointData[][] ret = new PointData[N][N];
//         for (int i = 0; i < N; i++)
//         {
//             ret[i] = new PointData[N];
//             for (int j = 0; j < N; j++)
//             {
//                 ret[i][j] = new PointData(i, j);
//             }
//         }
//         return ret;
//     }

//     public void printLegalMoves(Board boardQueenOn)
//     {
        
//         int order = 0;
//         StringBuilder sb = new StringBuilder("");
//         // this.pointData = new PointData(3, 5);
//         for (int i = 0; i < boardQueenOn.pointDatas.length; i++)
//         {
//             int j;
//             sb.append("|");
//             for ( j = 0; j < boardQueenOn.pointDatas[i].length; j++)
//             {
//                 if (isQueenCanMoveOnThisPoint(new PointData(j, i)))
//                 {
//                     // if (this.pointData.x == i && this.pointData.y == j)
//                     // if (this.pointData.equals(new PointData(i, j)))
//                     if (this.pointData.equals(new PointData(j, i)))
//                     {
//                         // System.out.format("Q at [%d,%d]", i, j);
//                         // sb.append("Q" + "|");
//                         sb.append(Color.RED + "Q" + Color.RESET + "|");
//                     }
//                     else
//                         sb.append("x" + "|");
//                     // sb.append("x" + "|");
//                     // sb.append("x" + "|");
//                 }
//                 else   
//                 {
//                     sb.append(" " + "|");
//                 }
//                 // sb.append(order + "|");
//                 // {
//                 //     sb.append(boardQueenOn.pointDatas[i][j] + "|");
//                 // }
//                 // order++;
//             }
//             // sb.append(boardQueenOn.pointDatas[i][j] +"|\n");
//             // System.out.println();
//             sb.append("\n");
//             // sb.append("∟".repeat((pointDatas[i].length * 2) + 1) + "\n");
//         }
//         System.out.println(sb.toString());

//         // PointData[][] displayer = createEmptyMatrixOfN(boardQueenOn.pointDatas.length);
//         // for (int i = 0; i < displayer.length; i++) 
//         // {
//         //     for (int j = 0; j < displayer[0].length; j++) 
//         //     {
//         //         // if (isQueenCanMoveOnThisPoint(new PointData(i, j)))
//         //         // {

//         //         // }
//         //         if (displayer[i][j].whoIsOccupied != null)
//         //         {

//         //         }
//         //     }
//         // }
//     }
// }


// class Board
// {
//     public PointData[][] pointDatas;
//     public Piece nomsyPiece;
//     public QueenPiece norminatePiece;
//     private static Board instance;
//     public int N;

//     public static Board getInstance()
//     {
//         if (instance == null)
//         {
//             // instance = new Board(8);
//             instance = new Board(20);
//         }
//         return instance;
//     }

//     private Board(int n) 
//     {
//         this.pointDatas = new PointData[n][n];
//         this.N = n;
//         for (int i = 0; i < n; i++)
//         {
//             pointDatas[i] = new PointData[n];
//             for (int j = 0; j < n; j++)
//             {
//                 pointDatas[i][j] = new PointData(i, j);
//             }
//         }

//         Piece king = new Piece(new PointData(3, 2), "kingNomsy");
//         // QueenPiece norminateQueen = new QueenPiece(new PointData(3, 5),"norminate");
//         QueenPiece norminateQueen = new QueenPiece(new PointData(15, 5),"norminate");

//         this.nomsyPiece = king;
//         this.norminatePiece = norminateQueen;
//     }

//     public void OccupyPoint(Piece piece, PointData pointData)
//     {
//         pointData.whoIsOccupied = piece;
//         this.pointDatas[pointData.x][pointData.y] = pointData;
//     }

//     public void printBoard()
//     {

//         StringBuilder sb = new StringBuilder("");
//         for (int i = 0; i < pointDatas.length; i++)
//         {
//             int j;
//             sb.append("|");
//             for ( j = 0; j < pointDatas[i].length - 1; j++)
//             {
//                 sb.append(pointDatas[i][j] + "|");
//             }
//             sb.append(pointDatas[i][j] +"|\n");
//             // sb.append("∟".repeat((pointDatas[i].length * 2) + 1) + "\n");
//         }
//         System.out.println(sb.toString());
//     }
// }

// public class NormQueen {

//     // public Main(int n)
//     // {
//         // board = new int[n][n];
//     void testQueenPos()
//     {
//     }

//     static int randint()
//     {
//         // return (int)((int)Math.random() * 15 + 5);
//         return (int)(Math.random() * 18 + 2);
//         // return (int)(Math.random() * 10 + 10);
//     }
//     // }
//     public static void main(String[] args) {
//         // Board.getInstance();

//         Board singleBoard = Board.getInstance();
//         singleBoard.OccupyPoint(singleBoard.norminatePiece, singleBoard.norminatePiece.pointData);
//         singleBoard.OccupyPoint(singleBoard.nomsyPiece, singleBoard.nomsyPiece.pointData);
        
//         singleBoard.norminatePiece.calcualteQueen(singleBoard);
//         singleBoard.norminatePiece.printLegalMoves(singleBoard);

//         // for (int i = 0; i < 200; i++)
//         // {
//         //     // System.out.println("Enter coordinate of queen");

//         //     System.out.println("Go ?");
//         //     // int k = sc.nextInt();
//         //     // int x = sc.nextInt();
//         //     // int y = sc.nextInt();
//         //     int x = randint();
//         //     int y = randint();
//         //     System.out.format("x,y = [%d,%d]", x, y);

//         //     singleBoard.norminatePiece.pointData = new PointData(x, y);
//         //     singleBoard.norminatePiece.calcualteQueen(singleBoard);
//         //     singleBoard.norminatePiece.printLegalMoves(singleBoard);
//         //     try {
//         //         Thread.sleep(100);
//         //     } catch (Exception e) { }
//         //     System.out.print("\033[H\033[2J");  
//         // }



//         // Scanner sc = new Scanner(System.in);
//         // for (int i = 0; i < 100; i++)
//         // for (int i = 0; i < 100; i++)
//         // {
//         //     // System.out.println("Enter coordinate of queen");

//         //     System.out.println("Go ?");
//         //     int k = sc.nextInt();
//         //     // int x = sc.nextInt();
//         //     // int y = sc.nextInt();
//         //     int x = randint();
//         //     int y = randint();
//         //     System.out.format("x,y = [%d,%d]", x, y);

//         //     singleBoard.norminatePiece.pointData = new PointData(x, y);
//         //     singleBoard.norminatePiece.calcualteQueen(singleBoard);
//         //     singleBoard.norminatePiece.printLegalMoves(singleBoard);
//         // }
//         // sc.close();
//         // norminateQueen.calcualteQueen();
//         // norminateQueen.printLegalMoves(getInstance());
//     }
// }
