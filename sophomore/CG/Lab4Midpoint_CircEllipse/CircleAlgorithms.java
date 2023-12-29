package Lab4Midpoint_CircEllipse;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Lab2LineAlgorithms.Drawing;

public class CircleAlgorithms extends Drawing {
    public static Point[] getOctancesFromPoint(Point p)
    {
        int x = p.x;
        int y = p.y;
        Point[] ps = new Point[8];
        int[] xs = {x, y, y, x, -x, -y, -y, -x};
        int[] ys = {y, x, -x, -y, -y, -x, x, y};
        for (int i = 0; i < 8; i++)
            ps[i] = new Point(xs[i], ys[i]);
        return ps;
    }

    public static List<Point> midpointDrawCirlcle(int X, int Y, int r)
    // public static Point[] midpointDrawCirlcle(int X, int Y, int r)
    {
        // System.out.println("X - Y + 1" + (X - Y + 1));
        // int retsize = (X - Y + 1) * 8;        
        // Point[] ret = new Point[retsize];
        // int k = 0;
        // alternative -> return array of 'retsize'
        List<Point> ret = new ArrayList<>();


        // int x = 0 + X;
        // int y = r + Y;
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y)
        {
            Point[] oct = getOctancesFromPoint(new Point(x, y));
            for (var p : oct)
            {
                p = new Point(p.x + X, p.y + Y);
                plotDot(p.x, p.y);
                // drawGeneralDot(p.x, p.y, 3);
                // ret[k] = p;
                // k++;
                ret.add(p);
            }

            x += 1;
            Dx = Dx + 2;
            D = D + Dx + 1;

            if (D >= 0)
            {
                y = y - 1;
                Dy = Dy - 2;
                D = D - Dy;
            }
        }

        // System.out.println(ret.size());
        return ret;
    }
}
