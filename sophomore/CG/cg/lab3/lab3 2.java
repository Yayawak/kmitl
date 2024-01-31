package cg.lab3;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class lab3 extends JPanel {
    Random random = new Random();
    private void plot(Graphics g, int x, int y,int d){
    
        // g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        g.fillRect(x, y, d, d);
    }
        public void plotPoint(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
            g.setColor(Color.red);
            plot(g, x1, y1, 4);
            g.setColor(Color.green);
            plot(g, x2, y2, 4);
            g.setColor(Color.blue);
            plot(g, x3, y3, 4);
            g.setColor(Color.pink);
            plot(g, x4, y4, 4);
            g.setColor(Color.BLACK);
        }
    public static void main(String[] args) {

        lab3 m = new lab3();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        
    }
    public void paintComponent(Graphics g){
        BufferedImage buff = new BufferedImage(601,601,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buff.createGraphics();
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.red);
        g2.fillRect(0, 0, 50, 50);
        floodFill(buff, 1, 1, Color.red, Color.BLACK);
        bezier(g2, 200, 200, 200, 400, 400, 400, 400, 200);
        bezier(g2, 200, 200, 200, 0, 400, 0, 400, 200);
        int xPoly[] = {150, 250, 325, 375, 450, 275, 100};
        int yPoly[] = {150, 100, 125, 225, 250, 375, 300};
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        g2.drawPolygon(poly);

        buff = floodFill(buff, 220, 200, Color.white, Color.red);

        g.drawImage(buff,0,0,null);
    }
    public void bezier(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { //E1 q1
        plotPoint(g, x1, y1, x2, y2, x3, y3, x4, y4);
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;
            int x = (int) (Math.pow((1 - t), 3) * x1 + 3 * t * Math.pow((1 - t), 2) * x2
                    + 3 * Math.pow((t), 2) * (1 - t) * x3 + Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 + 3 * t * Math.pow((1 - t), 2) * y2
                    + 3 * Math.pow((t), 2) * (1 - t) * y3 + Math.pow(t, 3) * y4);

            plot(g, x, y, 2);
        }

    }
    public BufferedImage floodFill(BufferedImage m, int x, int y, Color target_colour, Color replacement_colour) {//E3 q1
        Queue<Point> queue = new LinkedList<Point>();
        Graphics2D g3 = m.createGraphics();

        if (m.getRGB(x, y) == target_colour.getRGB()) {
            g3.setColor(replacement_colour);
            plot(g3, x, y, 1);
            queue.add(new Point(x, y));
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // south
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x, p.y + 1, 1);
                queue.add(new Point(p.x, p.y + 1));
            }
            // north
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x, p.y - 1, 1);
                queue.add(new Point(p.x, p.y - 1));
            }
            // east
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x + 1, p.y, 1);
                queue.add(new Point(p.x + 1, p.y));
            }
            // west
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x - 1, p.y, 1);
                queue.add(new Point(p.x - 1, p.y));
            }
        }
        return m;
    }
    

    
}