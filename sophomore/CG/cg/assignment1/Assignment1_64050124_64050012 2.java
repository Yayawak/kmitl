package cg.assignment1;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

import javax.swing.*;
public class Assignment1_64050124_64050012 extends JPanel {
    Random random = new Random();
    
    public static void main(String[] args) {

        Assignment1_64050124_64050012 m = new Assignment1_64050124_64050012();
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
        g2.setColor(Color.black);


        //center line
        // g2.drawLine(300, 0, 300, 600);
        // g2.drawLine(0, 280, 600, 280);
        // ear left
        bezier(g2, 210+20, 200-10, 110+20, -10-5, 260+20, -10-5, 255+20, 185-5);
        g2.setColor(Color.pink);
        bezier(g2, 220+20, 190-5, 140+20, 30-5, 240+20, 30-5, 240+20, 185-5);
        bezier(g2, 220+20, 190-5, 230+20, 193-5, 230+20, 193-5, 240+20, 185-5);
        buff = floodFill(buff, 242, 180, Color.white, Color.pink);
        //ear right
        g2.setColor(Color.black);
        bezier(g2, 390-20, 200-10, 490-20, -10-5, 340-20, -10-5, 345-20, 185-5);
        g2.setColor(Color.pink);
        bezier(g2, 380-20, 190-5, 460-20, 30-5, 360-20, 30-5, 360-20, 185-5);
        bezier(g2, 380-20, 190-5, 370-20, 193-5, 370-20, 193-5, 360-20, 185-5);
        buff = floodFill(buff, 359, 180, Color.white, Color.pink);
        //between ear
        g2.setColor(Color.black);
        bezier(g2, 255+20, 185-5, 285, 175, 315, 175, 345-20, 185-5);
        //head left
        bezier(g2, 230, 190, 185, 210, 160, 245, 160, 300);
        //head right
        bezier(g2, 370, 190, 415, 210, 440, 245, 440, 300);
        //under face
        bezier(g2, 160, 300, 25, 440, 575, 440, 440, 300);
        // eyes left
        
        DDALine(235, 290-10, 260, 300-10, g2, 5);
        DDALine(235, 300-10, 260, 300-10, g2, 5);
        // eyes right
        DDALine(365, 290-10, 340, 300-10, g2, 5);
        DDALine(365, 300-10, 340, 300-10, g2, 5);

        // nose
        bezier(g2, 290, 300-10, 295, 295-10, 305, 295-10, 310, 300-10);
        bezier(g2, 290, 300-10, 295, 305-10, 305, 305-10, 310, 300-10);
        buff = floodFill(buff, 300, 300-10, Color.white, Color.black);
        //cheek left
        g2.setColor(Color.pink);
        bezier(g2, 180, 330, 180, 300, 230, 300, 230, 330);
        bezier(g2, 180, 330, 180, 360, 230, 360, 230, 330);
        buff = floodFill(buff, 185, 330, Color.white, Color.pink);
        //cheek right
        g2.setColor(Color.pink);
        bezier(g2, 420, 330, 420, 300, 370, 300, 370, 330);
        bezier(g2, 420, 330, 420, 360, 370, 360, 370, 330);
        buff = floodFill(buff, 410, 330, Color.white, Color.pink);
        
        //between cheek
        // g2.setColor(Color.black);
        g2.setColor(new Color(255,94,74));
        DDALine(240, 320-10, 239, 325-10, g2, 3); // 1
        DDALine(245, 320-10, 245, 325-10, g2, 3); // 2
        

        DDALine(355, 320-10, 355, 325-10, g2, 3); // 3
        DDALine(360, 320-10, 361, 325-10, g2, 3); // 4
        // g2.setColor(new Color(250,78,78));
        // g2.setColor(new Color(250,250,250));
        // on cheek left
        bezier(g2, 190, 340-3, 191-2, 341-3, 201, 316+3, 200, 315+3);
        bezier(g2, 190+10, 340, 191+10, 341, 201+10+2, 316+3, 200+10, 315+3);
        bezier(g2, 190+20, 340+3, 191+20+2, 341+3, 201+20, 316+9, 200+20, 315+9);
        
        // on cheek left
        bezier(g2, 410, 340-3, 409+2, 341-3, 399, 316+3, 400, 315+3);
        
        bezier(g2, 410-10, 340, 409-10-2, 341, 399-10-2, 316+3, 400-10, 315+3);
        bezier(g2, 410-20, 340+3, 409-20-2, 341+3, 399-20, 316+9, 400-20, 315+9);
        

        g.drawImage(buff,0,0,null);
    }
    public void bez(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { //E1 q1
        plotPoint(g, x1, y1, x2, y2, x3, y3, x4, y4);
        bezier(g, x1, y1, x2, y2, x3, y3, x4, y4);
    }
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
    public void bezier(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { //E1 q1
        
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;
            int x = (int) (Math.pow((1 - t), 3) * x1 + 3 * t * Math.pow((1 - t), 2) * x2
                    + 3 * Math.pow((t), 2) * (1 - t) * x3 + Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 + 3 * t * Math.pow((1 - t), 2) * y2
                    + 3 * Math.pow((t), 2) * (1 - t) * y3 + Math.pow(t, 3) * y4);

            plot(g, x, y, 3);
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
    public void DDALine(int x1, int y1, int x2, int y2,Graphics g,int d){
        double dx = x2-x1;
        double dy = y2-y1;
        double x = Math.min(x1, x2), y = Math.min(y1, y2);
        // double x=0,y=0;
        double m = dy/dx;
       if(m <= 1 && m >= 0){
            for (x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                y =  y+m;
                plot(g, (int)Math.round(x), (int)Math.round(y),d);
            }
       }else if(m<0&&m>=-1){
            for (x = Math.max(x1, x2); x >= Math.min(x1, x2); x--) {
                y =  y-m;
                plot(g, (int)Math.round(x), (int)Math.round(y),d);
            }
        }else if(m>1){
            for (y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                x =  x+(1/m);
                plot(g, (int)Math.round(x), (int)Math.round(y),d);
            }
        }else{
            for (y = Math.max(y1, y2); y >= Math.min(y1, y2); y--) {
                x =  x-(1/m);
                plot(g, (int)Math.round(x), (int)Math.round(y),d);
            }
        } 
    }
    
}