package src.Libs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;



public class FloodFill extends Drawing {

    // static Set<Point> travesed;
    private static void drawNext(Point nextP, Queue<Point> q)
    {
        plotDot(nextP.x, nextP.y);
        q.add(nextP);
        // if (!q.contains(nextP))
        // if (!travesed.contains(nextP))
        // {
        //     plotDot(nextP.x, nextP.y);
        //     q.add(nextP);
        // }
    }
    private static void drawNextDotIfValid(Point nextP, BufferedImage bf, Color targetColor, Queue<Point> q)
    // private static void drawNextDotIfValid(Point nextP, BufferedImage bf, Color targetColor, Queue<Point> q, Graphics _g)
    {
        // return;
        // if (bf.getRGB(cur.x, cur.y - 1) == targetColor.getRGB())
        // {
        //     plotDot(cur.x, cur.y - 1);
        //     q.add(new Point(cur.x, cur.y - 1));
        // }
        int a = bf.getRGB(nextP.x, nextP.y);
        int b = targetColor.getRGB();
        // System.out.printf("a = %d\tb = %d\n\n", a, b);
        if (a == b)
        {
            if (!q.contains(nextP))
            {
                plotDot(nextP.x, nextP.y);
                q.add(nextP);
            }
            // plotDot(nextP.x, nextP.y);
            // q.add(nextP);
            try {
                // System.out.println(nextP);
                // Thread.sleep(200);
                // Thread.sleep(1000);
                // Thread.sleep(4000);
                // Thread.sleep(100 / 2);

            } catch (Exception e) {
            }
        }
        // else
        //     System.out.println("collision occurred -> found other color boundary (a != b)");

    }

    public static boolean validCoord(int x, int y, int n, int m)
    {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x >= n || y >= m) {
            return false;
        }
        return true;
    }

    // public static void floodFill(int x, int y, 
    public static void floodFill(
        BufferedImage bf,
        int x, int y, 
        Color targetColor,
        Color replacementColor,
        int width, int height
    )
    {
        System.out.println("Start Flood-Fill");
        // Graphics2D gg = bf.createGraphics();
        // Graphics2D gg = (Graphics2D)bf.getGraphics();
        // Queue<Point> q = new LinkedList<>();
        Queue<Point> q = new LinkedList<>();

        // gg.fillRect(0, 0, width, height);

        // Drawing.attachGraphics(gg);

        // LineAlgorithms.bshLine(0, 0, 20, 20);

        g.setColor(replacementColor);
        // gg.setColor(replacementColor);
        // attachGraphics(gg);
        // gg.setColor(Color.yellow);
        // g.setColor(replacementColor);
        // gg.setColor(Color.green);
        // plotDot(x, y);

        drawGeneralDot(x, y, 1);
        // System.out.println("Doted");
        q.add(new Point(x, y));

        // System.out.println(q.peek());

        int vis[][]=new int[height][width];
        // for(int i=0;i<=height;i++){
        //     for(int j=0;j<=width;j++){
        //         vis[i][j]=0;
        //     }
        // }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                vis[i][j]=0;
            }
        }


        // System.out.printf("White rgb %d\n", Color.white.getRGB());
        // System.out.printf("tar rgb %s %s\n", targetColor.getRGB(),
        // targetColor.toString());
        // System.out.printf("rep rgb %s %s\n", replacementColor.getRGB(),
        // replacementColor.toString());
        // Set<Point> traversedPoints = new HashSet<>();
        // traversedPoints = new HashSet<>();
        // travesed = new HashSet<>();

        int b = targetColor.getRGB();
        while (!q.isEmpty()) {
            // System.out.print("k");
            Point cur = q.poll();
            // traversedPoints.add(cur);
            // if (!travesed.contains(cur))
            // travesed.add(cur);
            // System.out.println(height);
            // int a = bf.getRGB(nextP.x, nextP.y);
            // int a = bf.getRGB(nextP.x, nextP.y);
            //* north
            // Point next = new Point(cur.x, cur.y - 1);
            // // if (cur.y > 0 && bf.getRGB(cur.x, cur.y - 1) == b) {
            // if (cur.y > 0 && bf.getRGB(next.x, next.y) == b) {
            //     // System.out.println("cur.y > 0");
            //     // drawNextDotIfValid(new Point(cur.x, cur.y - 1), bf, targetColor, q);
            //     // drawNext(cur, bf, targetColor, q);
            //     // drawNextDotIfValid(new Point(cur.x, cur.y - 1), bf, targetColor, q);
            //     drawNext(next, q);
            // }
            // // * west
            // next = new Point(cur.x - 1, cur.y);
            // if (cur.x > 0 && bf.getRGB(next.x, next.y) == b) {
            //     // drawNextDotIfValid(new Point(cur.x, cur.y + 1), bf, targetColor, q);
            //     drawNext(next, q);
            // }
            // System.out.println(travesed.size());
            // *north
            if ((validCoord(cur.x, cur.y - 1, width, height))
                && vis[cur.y - 1][cur.x] == 0 && bf.getRGB(cur.x, cur.y - 1) == b)
            {
                drawNext(new Point(cur.x, cur.y - 1), q);
                vis[cur.y - 1][cur.x] = 1;
            }
            // *south
            if ((validCoord(cur.x, cur.y + 1, width, height))
                && vis[cur.y + 1][cur.x] == 0 && bf.getRGB(cur.x, cur.y + 1) == b)
            {
                drawNext(new Point(cur.x, cur.y + 1), q);
                vis[cur.y + 1][cur.x] = 1;
            }
            // *west
            if ((validCoord(cur.x - 1, cur.y, width, height))
                && vis[cur.y][cur.x - 1] == 0 && bf.getRGB(cur.x - 1, cur.y) == b)
            {
                drawNext(new Point(cur.x - 1, cur.y), q);
                vis[cur.y][cur.x - 1] = 1;
            }
            // *east
            if ((validCoord(cur.x + 1, cur.y, width, height))
                && vis[cur.y][cur.x + 1] == 0 && bf.getRGB(cur.x + 1, cur.y) == b)
            {
                drawNext(new Point(cur.x + 1, cur.y), q);
                vis[cur.y][cur.x + 1] = 1;
            }
            // //* south
            // next = new Point(cur.x, cur.y + 1);
            // if (cur.y < height && bf.getRGB(next.x, next.y) == b) {
            //     // drawNextDotIfValid(new Point(cur.x, cur.y + 1), bf, targetColor, q);
            //     drawNext(next, q);
            // }
            // // * east
            // next = new Point(cur.x + 1, cur.y);
            // if (cur.x < width && bf.getRGB(next.x, next.y) == b) {
            //     // drawNextDotIfValid(new Point(cur.x, cur.y + 1), bf, targetColor, q);
            //     drawNext(next, q);
            // }
            // if (cur.x < width) {
            //     drawNextDotIfValid(new Point(cur.x + 1, cur.y), bf, targetColor, q);
            // }

            // System.out.println(q.size());
        }

        // q.add(new Point(x, y));
        // while (!q.isEmpty()) {
        //     // System.out.print("k");
        //     Point cur = q.poll();
        //     traversedPoints.add(cur);
        //     // System.out.println(height);
        //     //* north
        //     if (cur.y > 0) {
        //         // System.out.println("cur.y > 0");
        //         drawNextDotIfValid(new Point(cur.x, cur.y - 1), bf, targetColor, q);
        //     }
        //     // * east
        //     if (cur.x < width) {
        //         drawNextDotIfValid(new Point(cur.x + 1, cur.y), bf, targetColor, q);
        //     }

        //     System.out.println(q.size());
        // }

        // g.drawImage(bf, 0, 0, null);
        // gg.drawImage(bf, 0, 0, null);
    }
}
