package cg.lab3;
//64050037 
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

public class Lab3_037 extends JPanel {

    public static void main(String[] args) {
        Lab3_037 m = new Lab3_037();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("curve");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {

        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);
        bezier(g2, 200, 500, 120, 230, 500, 200, 400, 500);
        int xPoly[] = { 150, 250, 325, 375, 400, 275, 100 };
        int yPoly[] = { 150, 100, 125, 225, 325, 375, 300 };
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        g2.drawPolygon(poly);
        Random r = new Random();
        int k = r.nextInt();
        Color mycolor = new Color(k);
        buffer = floodFill(buffer, 200, 150, Color.WHITE, Color.GREEN);//E# q2
        buffer = floodFill(buffer, 220, 382, Color.WHITE, mycolor);
        mycolor = new Color(k + r.nextInt());
        buffer = floodFill(buffer, 230, 400, Color.WHITE, mycolor);
        g.drawImage(buffer, 0, 0, null);
    }

    private void plot(Graphics g, int x, int y, int w, int h) {
        g.fillRect(x, y, w, h);
    }

    public void plotPoint(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        g.setColor(Color.red);
        plot(g, x1, y1, 5, 5);
        plot(g, x2, y2, 5, 5);
        plot(g, x3, y3, 5, 5);
        plot(g, x4, y4, 5, 5);
        g.setColor(Color.BLACK);
    }

    public void bezier(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { //E1 q1
        plotPoint(g, x1, y1, x2, y2, x3, y3, x4, y4);
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;
            int x = (int) (Math.pow((1 - t), 3) * x1 + 3 * t * Math.pow((1 - t), 2) * x2
                    + 3 * Math.pow((t), 2) * (1 - t) * x3 + Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 + 3 * t * Math.pow((1 - t), 2) * y2
                    + 3 * Math.pow((t), 2) * (1 - t) * y3 + Math.pow(t, 3) * y4);

            plot(g, x, y, 1, 1);
        }

    }

    public BufferedImage floodFill(BufferedImage m, int x, int y, Color target_colour, Color replacement_colour) {//E3 q1
        Queue<Point> queue = new LinkedList<Point>();
        Graphics2D g3 = m.createGraphics();

        if (m.getRGB(x, y) == target_colour.getRGB()) {
            g3.setColor(replacement_colour);
            plot(g3, x, y, 1, 1);
            queue.add(new Point(x, y));
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // south
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x, p.y + 1, 1, 1);
                queue.add(new Point(p.x, p.y + 1));
            }
            // north
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x, p.y - 1, 1, 1);
                queue.add(new Point(p.x, p.y - 1));
            }
            // east
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x + 1, p.y, 1, 1);
                queue.add(new Point(p.x + 1, p.y));
            }
            // west
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x - 1, p.y, 1, 1);
                queue.add(new Point(p.x - 1, p.y));
            }
        }
        return m;
    }
}
