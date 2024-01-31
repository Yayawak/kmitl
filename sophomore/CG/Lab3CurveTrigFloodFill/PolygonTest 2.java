package Lab3CurveTrigFloodFill;
import java.awt.*;
import javax.swing.*;

class PolygonTest extends JPanel {
    int xPoly[] = { 150, 250, 325, 375, 400, 275, 100 };
    int yPoly[] = { 150, 100, 125, 225, 325, 375, 300 };

    public void paintComponent(Graphics g) {
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        // g.setColor(Color.black);
        for (int i = 0; i < xPoly.length; i++)
        {
            g.drawString(String.valueOf(i), 
                xPoly[i],
                yPoly[i]
            );
        }
        g.drawPolygon(poly);

        int[][] mapping = {
            {0, 6, 5},
            {0, 1, 5},
            {1, 2, 5},
            {2, 3, 5},
            {3, 4, 5}
        };
        g.setColor(Color.blue);
        triangulate(g, mapping);

        // int[][] mapping2 = {
        //     {1, 0, 6},
        //     {1, 2, 6},
        //     {6, 2, 3},
        //     {3, 6, 5},
        //     {3, 4, 5}
        // };
        // g.setColor(Color.green);
        // triangulate(g, mapping2);

        // int[][] mapping3 = {
        //     {6, 4, 5},
        //     {3, 4, 6},
        //     {2, 3, 6},
        //     {1, 2, 6},
        //     {0, 1, 6}
        // };
        // g.setColor(Color.orange);
        // triangulate(g, mapping3);
    }

    public void waitms()
    {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    public void triangulate(Graphics g, int[][] mapping)
    {
        for (int i = 0; i < mapping.length; i++)
        {
            // Point
            int[] xs = new int[3];
            int[] ys = new int[3];
            for (int j = 0; j < 3; j++)
            {
                int idx = mapping[i][j];
                xs[j] = xPoly[idx];
                ys[j] = yPoly[idx];
            }
            var pl = new Polygon(xs, ys, 3);
            g.drawPolygon(pl);
        }
        // g.drawPolygon(null);
    }
}