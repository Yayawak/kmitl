package cg.lab2;

import java.awt.*;
import java.util.Random;

import javax.swing.*;
public class lab2 extends JPanel {
    Random random = new Random();
    public static void main(String[] args) {

        lab2 m = new lab2();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        
        
    }
    public void paintComponent(Graphics g){
         // naiveLine(100, 100, 400, 200, g);
        // naiveLine(400, 300, 100, 200, g);
        // naiveLine(100, 100, 200, 400, g);

        // DDALine(100, 100, 400, 200, g);
        // DDALine(400, 300, 100, 200, g);
        // DDALine(100, 100, 200, 400, g);

        // bresenhamLine(100, 100, 400, 200, g);
        // bresenhamLine(400, 300, 100, 200, g);
        // bresenhamLine(100, 100, 200, 400, g);
    }
    public void naiveLine(int x1, int y1, int x2, int y2,Graphics g){
        double dx = (double) Math.abs(x2-x1);
        double dy = (double) Math.abs(y2-y1);
        double b = y1-(dy/dx)*x1;
        int y;
        for (int x = Math.min(x1, x2); x < Math.max(x1, x2); x++) {
            y = (int) Math.round(((dy / dx) * x)+ b);
            plot(g, x, y);
        }
    }
    public void DDALine(int x1, int y1, int x2, int y2,Graphics g){
        double dx = Math.abs(x2-x1);
        double dy = Math.abs(y2-y1);
        double x = Math.min(x1, x2), y = Math.min(y1, y2);
        double m = dy/dx;
       if(m <= 1 && m >= 0){
            for (x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                y =  y+m;
                plot(g, (int)Math.round(x), (int)Math.round(y));
            }
       }else if(m<0&&m>=-1){
            for (x = Math.max(x1, x2); x >= Math.min(x1, x2); x--) {
                y =  y-m;
                plot(g, (int)Math.round(x), (int)Math.round(y));
            }
        }else if(m>=1){
            for (y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                x =  x+(1/m);
                plot(g, (int)Math.round(x), (int)Math.round(y));
            }
        }else{
            for (y = Math.max(y1, y2); y >= Math.min(y1, y2); y--) {
                x =  x-(1/m);
                plot(g, (int)Math.round(x), (int)Math.round(y));
            }
        }

        
    }
    public void bresenhamLine(int x1, int y1, int x2, int y2,Graphics g) {
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);
        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;
        if (dy > dx) {
            double cur = dy;
            dy = dx;
            dx = cur;
            isSwap = true;
        }
        double D = 2 * dy - dx;
        double x = x1, y = y1;
        for (int i = 1; i < dx; i++) {
            plot(g, (int) y,(int) x);
            if (D >= 0) {
                if (isSwap) {
                    x += sx;
                } else {
                    y += sy;
                }
                D -= 2 * dx;
            }
            if (isSwap) {
                y += sy;
            } else {
                x += sx;
            }
            D += 2 * dy;
        }
    }
    

    private void plot(Graphics g, int x, int y){
    
    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
    g.fillRect(x, y, 1, 1);
    }
}