package NewYear.Dragon.Old;

import java.awt.Color;
import java.awt.Point;

import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import Lab3CurveTrigFloodFill.BazierAlgorithm;

public class DRing {
    // * middle of node
    private Point point = new Point();
    // int radius = 100; // pixel unit
    int radius = 60; // pixel unit
    private final int n_subrings = 12;
    public Point[] circums = new Point[n_subrings];

    public DRing(Point p)
    {
        this.point = p;

        // circums[0] = new Point(   point.x + 0     , point.y + radius);
        // circums[1] = new Point(point.x + radius, point.y + radius);
        // circums[2] = new Point( point.x - radius ,point.y - radius);
        // circums[3] = new Point( point.x + 0     , point.y + radius); // like cricum[0]
        for (int i = 0; i < n_subrings; i++)
        {
            int deg = (int)(((float)i / n_subrings) * 360);
            // System.out.println("deg = " + deg);
            circums[i] = new Point();
            double radian = Math.toRadians(deg);
            circums[i].x = point.x + (int)(Math.cos(radian) * radius);
            circums[i].y = point.y + (int)(Math.sin(radian) * radius);

            // System.out.println(circums[i]);
        }
    }

    public void drawBody()
    {

        Drawing.getG().setColor(Color.decode("#e87109"));
        // BazierAlgorithm.bezier(
        //     point.x + 0     , point.y + radius, 
        //     point.x + radius, point.y + 0,
        //     point.x + 0     , point.y - radius,
        //     point.x + 0     , point.y + radius // start point
        //     // point.x + radius, point.y,
        //     , 3
        // );
        
        // Point prevPoint = new Point();
        // int N = 3;
        // for (int i = 0; i < 4; i++)
        // {
        //     Point outCur = circums[i];
        //     for (int j = 0; i < N; i++)
        //     {
        //         if (i == 0 && j == 0) return;
        //         Point cur = new Point(outCur.);

        //         LineAlgorithms.bshLine(
        //             prevPoint.x, prevPoint.y,
                    
        //         );

        //     }
        // }

        // BazierAlgorithm.bezier(
        //     // point.x + radius, point.y,
        //     circums[0].x, circums[0].y,
        //     circums[1].x, circums[1].y,
        //     circums[2].x, circums[2].y,
        //     circums[3].x, circums[3].y,
        //     3
        // );

        // Drawing.drawGeneralDot(point.x, point.y, 30);
        // BazierAlgorithm.bezier(

        // );
        for (int i = 0; i < n_subrings; i++)
        {
            if (i == 0) continue;

            Point prev = circums[i - 1];
            Point cur = circums[i];
            if (i == n_subrings - 1)
            {
                LineAlgorithms.bshLine(
                    circums[0].x, circums[0].y,
                    cur.x, cur.y, 
                    3
                );
            }

            // System.out.println("kk");
            // System.out.println(prev);
            // System.out.println(cur);
            // System.out.println();

            LineAlgorithms.bshLine(prev.x, prev.y,
                cur.x, cur.y, 
                3
            );
        }
        
    }
}
