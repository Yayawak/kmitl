package backup_ass_1.libs;
import java.awt.Graphics;
import java.awt.Point;

import Lab2LineAlgorithms.Drawing;
import cg.lab1.GraphicsSwing;

public class BZ extends Drawing{
    // public static void BZ(Graphics g, 
    // public static Point BZ(Graphics g, 
    private BZ() {}

    public static void bz(
        int x0, int y0,
        int x1, int y1,
        int x2, int y2,
        int x3, int y3
    )
    {
        bz(x0, y0, x1, y1, x2, y2, x3, y3, 1);
    }
    public static void bz(
        int x0, int y0,
        int x1, int y1,
        int x2, int y2,
        int x3, int y3,
        int size
    )
    {
        int ndots = 1000;
        // int ndots = 10;
        assert ndots != 0;
        float inc = 1 / (float)ndots;
        if (inc == 0)
            inc = 0.01f;
        for (float t = 0.f; t < 1; t += inc)
        {
            // System.out.println(t);
            double b = 1 - t;
            double x = 
                Math.pow(b, 3) * x0 
                + (3 * t * Math.pow(b, 2)) * x1
                + (3 * Math.pow(t, 2) * b) * x2
                + Math.pow(t, 3) *  x3;
            double y = 
                Math.pow(b, 3) * y0
                + (3 * t * Math.pow(b, 2)) * y1
                + (3 * Math.pow(t, 2) * b) * y2
                + Math.pow(t, 3) *  y3;
            // Drawing.drawGeneralDot((int)(x), (int)(y), size);
            drawGeneralDot((int)(x), (int)(y), size);
        }
    }
}
