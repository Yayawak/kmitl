package Lab3CurveTrigFloodFill;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.LinkedList;
import java.util.Queue;

import Lab2LineAlgorithms.Drawing;


public class FloodFill extends Drawing {

    private static void drawNextDotIfValid(Point nextP, BufferedImage bf, Color targetColor, Queue<Point> q)
    // private static void drawNextDotIfValid(Point nextP, BufferedImage bf, Color targetColor, Queue<Point> q, Graphics _g)
    {
        // return;
        // if (bf.getRGB(cur.x, cur.y - 1) == targetColor.getRGB())
        // {
        //     plotDot(cur.x, cur.y - 1);
        //     q.add(new Point(cur.x, cur.y - 1));
        // }

        try {
            int a = bf.getRGB(nextP.x, nextP.y);
            int b = targetColor.getRGB();
            System.out.printf("a = %d\tb = %d\n\n", a, b);
            if (a == b)
            {
                plotDot(nextP.x, nextP.y);
                q.add(nextP);
            }
        } catch (Exception e) {
            System.out.printf("Error Out Of Bound Occured ! at pos %s \t%s\n ",
                nextP, e);
        }
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
        Graphics2D gg = (Graphics2D)bf.getGraphics();
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

        System.out.println(q.peek());

        // System.out.printf("White rgb %d\n", Color.white.getRGB());
        // System.out.printf("tar rgb %s %s\n", targetColor.getRGB(),
        // targetColor.toString());
        // System.out.printf("rep rgb %s %s\n", replacementColor.getRGB(),
        // replacementColor.toString());

        while (!q.isEmpty()) {
            System.out.print("k");
            Point cur = q.poll();
            // north
            // gg.setColor(replacementColor);
            // System.out.println(bf.getRGB(cur.x, cur.y - 1));
            // System.out.println(targetColor.getRGB());
            // var b = bf.getRGB(cur.x, cur.y - 1) == targetColor.getRGB();
            // System.out.println(b);
            // if (cur.y > 0 && bf.getRGB(cur.x, cur.y - 1) == targetColor.getRGB())

            // //* north
            // if (cur.y > 0 && bf.getRGB(cur.x, cur.y - 1) == targetColor.getRGB())
            // {
            // // drawGeneralDot(cur.x, cur.y - 1, 1);
            // plotDot(cur.x, cur.y - 1);
            // q.add(new Point(cur.x, cur.y - 1));
            // }
            // //* north
            if (cur.y > 0) {
                System.out.println("cur.y > 0");
                drawNextDotIfValid(new Point(cur.x, cur.y - 1), bf, targetColor, q);
            }
            // // * west
            // if (cur.x > 0) {
            //     drawNextDotIfValid(new Point(cur.x - 1, cur.y), bf, targetColor, q);
            // }
            // // //* south
            // if (cur.y < height) {
            //     drawNextDotIfValid(new Point(cur.x, cur.y + 1), bf, targetColor, q);
            // }
            // // * east
            // if (cur.x < width) {
            //     drawNextDotIfValid(new Point(cur.x + 1, cur.y), bf, targetColor, q);
            // }

            // //* north
            // if (cur.y > 0)
            // {
            // drawNextDotIfValid(new Point(cur.x, cur.y - 1), bf, targetColor, q, gg);
            // }
            // //* west
            // if (cur.x > 0)
            // {
            // drawNextDotIfValid(new Point(cur.x - 1, cur.y), bf, targetColor, q, gg);
            // }
            // // //* south
            // if (cur.y < height)
            // {
            // drawNextDotIfValid(new Point(cur.x, cur.y + 1), bf, targetColor, q, gg);
            // }
            // // * east
            // if (cur.x < width)
            // {
            // drawNextDotIfValid(new Point(cur.x + 1, cur.y), bf, targetColor, q, gg);
            // }

        }

        // g.drawImage(bf, 0, 0, null);
        // gg.drawImage(bf, 0, 0, null);
    }
}
