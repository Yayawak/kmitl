package Lab2LineAlgorithms;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class LineAlgorithms extends Drawing {
    // public Graphics g;
    private LineAlgorithms() {}

    public static void naiveLine(int ...argints)
    {
        naiveLine(argints[0], argints[1], argints[2], argints[3]);
    }


    public static void naiveLine(int x1, int y1, int x2, int y2)
    {
        assert g != null;

        // if (x1 > x2)
        // {
        //     int temp = x1;
        //     x1 = x2;
        //     x2 = temp;
        // }
        

        System.out.printf("Start Drawing Naive Line (%d,%d) to (%d, %d)\n", 
            x1, y1, x2, y2);
        float dx = x2 - x1;
        float dy = y2 - y1;
        float m = (dy / dx);
        float b = y1 - m * x1;
        System.out.printf("params dx=%.4f, dy=%.4f, m=%.4f, b=%.4f\n",
            dx, dy, m, b
        );

        // for (int x = x1; x <= x2; x++)
        // ? can write backward and forward ***** 
        // for (Integer x : getRangeInclusive(x2, x1)) // * this is fine
        for (Integer x : getRangeInclusive(x1, x2)) // * this is also fine -> because we have both 
        {
            int y = Math.round(m * x) + Math.round(b);
            // ! can't make it too late so java swing will delete it before ?????? -> don't debug lol
            // printXY(x, y);
            plotDot(x, y);
            // try {
            //     Thread.sleep(1);
            // } catch (Exception e) { System.out.println(e);}
        }
    }

    public static void ddaLine(int ...argints)
    {
        for (int a : argints)
            System.out.print(String.valueOf(a) + ",");
        System.out.println();
        ddaLine(argints[0], argints[1], argints[2], argints[3]);
        System.out.println();
    }

    public static void ddaLine(int x1, int y1, int x2, int y2)
    {
        if (x1 > x2)
        {
            int temp = x1;
            x1 = x2;
            x2 = temp;

            int tempy = y1;
            y1 = y2;
            y2 = tempy;
        }
        // System.out.println();
        float dx = x2 - x1;
        float dy = y2 - y1;
        float y = y1;
        float x = x1;
        float m = dy / dx;
        System.out.printf("params dx=%.4f, dy=%.4f, m=%.4f\n",
            dx, dy, m
        );

        if (m >= 0 && m <= 1)
        {
            System.out.printf("m=%f\n", m);
            // for (int x = x1; x <= x2; x++)
            
            // Int
            for (x = x1; x <= x2; x++)
            // for (x = x1; x >= x2; x--)
            // for (var _x : getRangeInclusive(x1, x2))
            {
                // System.out.println(_x);
                y += m;
                // int _y = Math.round(y);
                // printXY(_x, _y);
                plotDot((int)(x), Math.round(y));
                // plotDot(_x, _y);
            }
        }
        else if (m <= -1)
        {
            System.out.printf("m=%f\n", m);
            for (x = x2; x <= x1; x++)
            {
                y += m;
                plotDot((int)(x), Math.round(y));
            }
        }
        else if (m > 1)
        {
            System.out.printf("m=%f\n", m);
            for (y = y1; y <= y2; y++)
            // for (var _y : getRangeInclusive(y1, y2))
            {
                x = x + 1 / m;
                plotDot((int)(x), Math.round(y));
                // plotDot((int)(x), _y);
            }
        }
        else
        {
            System.out.printf("m=%f\n", m);
            for (y = y2; y <= y1; y++)
            {
                x = x + 1 / m;
                plotDot((int)(x), Math.round(y));
            }
        }
    }


    public static void bshLine(int ...argints)
    {
        for (int a : argints)
            System.out.print(String.valueOf(a) + ",");
        System.out.println();
        bshLine(argints[0], argints[1], argints[2], argints[3]);
        System.out.println();
    }

    public static void bshLine(Point p1, Point p2)
    {
        bshLine(p1.x, p1.y, p2.x, p2.y);
    }

    public static void bshLine(Point p1, Point p2, int size)
    {
        bshLine(p1.x, p1.y, p2.x, p2.y, size);
    }

    public static void bshLine(int x1, int y1, int x2, int y2)
    {
        bshLine(x1, y1, x2, y2, 1);
    }

    public static void bshLine(int x1, int y1, int x2, int y2, int size)
    {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;

        if (dy > dx)
        {
            int temp = dx;
            dx = dy;
            dy = temp;
            isSwap = true;
        }
        // System.out.printf("dxdy=(%d,%d)\n", dx, dy);
        int D = 2 * dy - dx;

        int x = x1;
        int y = y1;

        for (int i = 1; i <= dx; i++)
        {
            // printXY(x, y);
            drawGeneralDot(x, y, size);

            if (D >= 0)
            {
                if (isSwap) x += sx;
                else y += sy;

                D -= 2 * dx;
            }

            if (isSwap) y += sy;
            else x += sx;

            D += 2 * dy;
        }
    }
}
