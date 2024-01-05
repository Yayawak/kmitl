package Assignment_1_Newyear.libs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import NewYear.Dragon.Tail.Triangle;

public class Drawing {
    
    protected static Graphics g = null;
    public static Graphics getG()
    {
        return g;
    }

    public static void attachGraphics(Graphics _g)
    {
        g = _g;
        g.setColor(Color.black);
        // System.out.println("Attached New Graphics To Drawing (static)");
    }
    // public MyDrawer(Graphics g) {
    //     assert  g != null;
    //     this.g = g;
    // }
    public static void printXY(int x, int y)
    {
        System.out.printf("(%d,%d)\t", x, y);
    }

    public static void plotDot(int x, int y)
    {
        // g.fillRect(x, y, 1, 1);
        // int rad = 4;
        drawGeneralDot(x, y, 1);
    }

    public static void drawGeneralDot(Point p, int rad)
    {
        g.fillRect(p.x, p.y, rad, rad);
    }

    public static void drawGeneralDot(int x, int y, int rad)
    {
        g.fillRect(x, y, rad, rad);
    }
    
    public static void drawGrid(int width, int height, int nrows, int ncols)
    {
        int dw = width / ncols;
        int dh = height / nrows;

        g.setColor(Color.black);
        for (int y = 0; y <= nrows; y++)
        {
            for (int x = 0; x <= ncols; x++)
            {
                int xx = x * dw;
                int yy = y * dh;
                String s = String.format("%d,%d", xx, yy);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 8)); 
                g.drawString(s, xx, yy);
                drawGeneralDot(xx, yy, 3);
            }
        }
    }

    public  static List<Integer> getRangeInclusive(int a, int b)
    {
        // ***** version 1 -> both back and forth -> this that necessary ?  -> why don't we just need all a to b
        // ? like 3 to 8 --> [3, 4, 5, 6, 7, 8] --> is also fine as reverse because it will also contains 8 to 3 like 3 to 8
        // List<Integer> ret = new ArrayList<>();
        // if (a < b)
        //     for (int i = a; i <= b; i++)
        //         ret.add(i);
        // else
        //     for (int i = a; i >= b; i--)
        //         ret.add(i);
        // System.out.println(ret.size());

        // ***** version 2
        List<Integer> ret = new ArrayList<>();
        if (a > b)
        {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = a; i <= b; i++)
            ret.add(i);
        return ret;
    }


    public static Polygon drawTriangle(Point points[])
    {
        return drawTriangle(points, Color.black);
    }

    public static Polygon drawTriangle(Point points[], Color col)
    {
        assert points.length == 3;
        Polygon pl = new Polygon();
        for (int i = 0; i < 3 ; i++)
        {
            assert points[i] != null;
            // System.out.println(points[i]);

            pl.addPoint(points[i].x, points[i].y);

        }
        // Drawing.getG().setColor(Color.orange);
        g.setColor(col);
        // g.fillPolygon(pl);
        Drawing.getG().drawPolygon(pl);
        // Drawing.getG().fillPolygon(pl);
        // Drawing.drawGeneralDot(500, 300, 20);

        // LineAlgorithms.bshLine(0, 0, 300, 300);

        return pl;
    }

    public static void drawVerticesTriangle(Triangle t, Color color)
    {
        drawVerticesTriangle(t.points, color);
    }

    public static void drawVerticesTriangle(Point points[], Color color)
    {
        assert points.length == 3;
        for (int i = 0; i < 3; i++)
        {
            // var p =  t.points[i];
            var p =  points[i];
            Drawing.getG().setColor(color);
            Drawing.drawGeneralDot(p, 5);
        }
    }

}
