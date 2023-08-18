import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

class Point
{
    public int label;
    public Point leftParent;
    public Point rightParent;
    public int x;
    public int y;
    public boolean called = false;
    public Point(int label, Point leftParent, Point rightParent, int x, int y) {
        this.label = label;
        this.leftParent = leftParent;
        this.rightParent = rightParent;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return String.format("%s", label);
    }
}

class TriangleBoxes
{
    Point[][] pyramid;
    public TriangleBoxes(int nrow)    
    {
        pyramid = constructMatrix(nrow);
    }

    public int calculateNBoxesFromHeight(int height)
    {
        int sum = 0;
        for (int i = 0; i < height; i++)
        {
            int ncol = i + 1;
            sum += ncol;
        }
        return sum;
    }

    //NOTE this method also apply back tracking (by using parent tracking)
    public Point[][] constructMatrix(int height)
    {
        Point[][] ret = new Point[height][height];
        int curLabel = 1;
        for (int h = 0; h < height; h++)
        {
            int ncol = h + 1;
            ret[h] = new Point[ncol];
            for (int x = 0; x < ncol; x++)
            {
                Point currentPoint = null;
                if (x == 0 && h == 0)
                {
                    currentPoint = new Point(curLabel, null, null, 0, 0);
                }
                else if (x == 0)
                {
                    currentPoint = new Point(
                        curLabel,
                        null,
                        ret[h - 1][0], x, h);
                }
                else if (x == ncol - 1)
                {
                    currentPoint = new Point(
                        curLabel,
                        ret[h - 1][x - 1],
                        null, x, h);
                }
                // middle points
                else 
                // else if (x > 0 && x < ncol - 1)
                {
                    currentPoint = new Point(
                        curLabel,
                        ret[h - 1][x - 1],
                        ret[h - 1][x], x, h);
                }

                ret[h][x] = currentPoint;
                curLabel++;
            }
        }
        return ret;
    }

    public static void printMat(Point[][] mat)
    {
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
            {
                int curLabel = mat[i][j].label;
                if (curLabel < 10)
                {
                    System.out.print(mat[i][j] + "  ");
                }
                else 
                    System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Point[] getParentOfPoint(Point child)
    {
        Point[] ret = {child.leftParent, child.rightParent};
        System.out.println("child:" + child);
        System.out.println("Left parent: " + child.leftParent);
        System.out.println("Right parent: " + child.rightParent);
        System.out.println();
        return ret;
    }

    public long calculateScoreOnHitPoint(Point p)
    {
        // System.out.println("p label = " + p.label);
        // BigInteger score = p.label * p.label;
        long score = (long)(p.label * p.label);

        if (p.leftParent == null && p.rightParent == null)
            return score;
        if (p.rightParent != null && !p.rightParent.called)
        {
            p.rightParent.called = true;
            // calculateScoreOnHitPoint(p.rightParent, sumScore + score);
            score += calculateScoreOnHitPoint(p.rightParent);
        }
        if (p.leftParent != null && !p.leftParent.called)
        {
            p.leftParent.called = true;
            score += calculateScoreOnHitPoint(p.leftParent);
        }
        return score;
    }
    private float labelToWhichRow(int label)
    {
        return (float)(Math.sqrt((2 * label) - 1.75f) - 0.5f);
    }

    public int[] labelToPyramidPosition(int label)
    {
        int rowOfThatLabel = (int)Math.floor((double)labelToWhichRow(label));
        // System.out.println("ROW = " + rowOfThatLabel);
        Point[] exactRow = pyramid[rowOfThatLabel];
        int[] pos = new int[2];
        for (Point point : exactRow) {
            if (point.label == label)
            {
                pos[0] = point.x;
                pos[1] = point.y;
            }
        }
        return (pos);
    }

    
}

public class Main
{
    public static void main(String[] args) {
        final int nrow = 2023;
        TriangleBoxes tb = new TriangleBoxes(nrow);
        Scanner sc = new Scanner(System.in);
        int[] xy = tb.labelToPyramidPosition(sc.nextInt());
        System.out.println(tb.calculateScoreOnHitPoint(tb.pyramid[xy[1]][xy[0]]));
        sc.close();
    }

}