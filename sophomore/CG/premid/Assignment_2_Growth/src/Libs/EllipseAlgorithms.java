package src.Libs;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class EllipseAlgorithms extends Drawing {

    public static Point[] getQuadrantsFromPoint(Point p)
    {
        int x = p.x;
        int y = p.y;
        Point[] ps = new Point[4];
        int[] xs = {x, -x, x, -x};
        int[] ys = {y, y, -y, -y};
        for (int i = 0; i < 4; i++)
            ps[i] = new Point(xs[i], ys[i]);
        return ps;
    }

    public static List<Point> midpointDrawEllipse(int X, int Y, int a, int b)
    {
        List<Point> ret = new ArrayList<>();


        // int x = 0 + X;
        // int y = r + Y;

        int a2 = a * a;
        int b2 = b * b;
        int a22 = 2 * a2;
        int b22 = 2 * b2;

        // ! region 1
        int x = 0;
        int y = b;
        int Dx = 0;
        int Dy = a22 * y;
        int D = Math.round(b2 - a2*b + (float)a2/4.f);

        while (Dx <= Dy)
        {
            Point[] oct = getQuadrantsFromPoint(new Point(x, y));
            for (var p : oct)
            {
                p = new Point(p.x + X, p.y + Y);
                plotDot(p.x, p.y);
                ret.add(p);
            }

            x += 1;
            Dx = Dx + b22;
            D = D + Dx + b2;

            if (D >= 0)
            {
                y = y - 1;
                Dy = Dy - a22;
                D = D - Dy;
            }
        }

        // ! region 2
        x = a;
        y = 0;
        // D = Math.round(a*a - b*b*a + b*(float)(b)/4.f);
        D = Math.round(a*a - b*b*a + b*b/4);

        while (b2*x >= a2*y)
        // while (b*b*x >= a*a*y)
        {
            Point[] qs = getQuadrantsFromPoint(new Point(x, y));
            for (var p : qs)
            {
                p = new Point(p.x + X, p.y + Y);
                plotDot(p.x, p.y);
                ret.add(p);
            }

            y += 1;
            // D = D + 2*a*a*y + a*a;
            D = D + a22*y + a2;

            if (D >= 0)
            {
                x--;
                // D = D - 2*b*b*x;
                D = D - b22*x;
            }
        }

        // System.out.println(ret.size());
        return ret;
    }
}
