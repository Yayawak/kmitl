package cg.lab5;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class Lab5_64050124 extends JPanel implements Runnable {
    double x = 0,y=500;
    double velocityX = 100.0;
    double velocityY = 100.0;
    double velocity = 100.0;
    double angle = -60.0;
    double starRotate = 0;
    public static void main(String[] args) {
        JFrame f = new JFrame();
        Lab5_64050124 m = new Lab5_64050124();

        f.add(m);
        f.setTitle("Lab 4");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();;
    }
    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime,elapsedTime;
        velocityX = velocity * Math.cos(Math.toRadians(angle));
        velocityY = velocity * Math.sin(Math.toRadians(angle));
        while(true){
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime =currentTime;

            velocityY += 9.81 * elapsedTime / 1000.0;
            starRotate += 5 * elapsedTime / 1000.0;
            x += velocityX * elapsedTime / 1000.0;
            y += velocityY * elapsedTime / 1000.0;

            if(x>=600-50){
                x = 550;
                velocityX = -velocityX;
            }
            if(x<=0){
                x = 0;
                velocityX = -velocityX;
            }
            if(y >= 600 - 50){
                y = 550;
                velocityY = -velocityY;
            }
            if(y <= 0){
                y = 0;
                velocityY = -velocityY;
            }
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(getBackground());
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.BLACK);
        
        g2.setColor(Color.red);
        
        g2.rotate(starRotate, (int)x, (int)y);
        midpointEllipse(g, (int)x, (int)y, 100, 25);
        midpointEllipse(g, (int)x, (int)y, 25, 100);
        g2.rotate(starRotate, (int)x, (int)y);
    }

    public void midpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y) {

            plot(g, xc + x, yc + y, 10);
            plot(g, xc + x, yc - y, 10);
            plot(g, xc - x, yc + y, 10);
            plot(g, xc - x, yc - y, 10);
            plot(g, yc + y, xc + x, 10);
            plot(g, yc + y, xc - x, 10);
            plot(g, yc - y, xc + x, 10);
            plot(g, yc - y, xc - x, 10);

            x += 1;
            Dx += 2;
            D += Dx + 1;
            if (D >= 0) {
                y -= 1;
                Dy -= 2;
                D -= Dy;
            }
        }
    }

    // 2.1
    public void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

        // Region 1
        int x = 0;
        int y = b;
        int D = Math.round(b2 - a2 * b + a2 / 4);
        int Dx = 0;
        int Dy = twoA2 * y;

        while (Dx <= Dy) {

            plot(g, xc + x, yc + y, 1);
            plot(g, xc + x, yc - y, 1);
            plot(g, xc - x, yc + y, 1);
            plot(g, xc - x, yc - y, 1);

            x += 1;
            Dx += twoB2;
            D += Dx + b2;

            if (D >= 0) {
                y -= 1;
                Dy -= twoA2;
                D -= Dy;
            }
        }

        x = a;
        y = 0;
        D = Math.round(a2 - b2 * a + b2 / 4);
        Dx = twoB2 * x;
        Dy = 0;

        while (Dx >= Dy) {

            plot(g, xc + x, yc + y, 1);
            plot(g, xc + x, yc - y, 1);
            plot(g, xc - x, yc + y, 1);
            plot(g, xc - x, yc - y, 1);

            y += 1;
            Dy += twoA2;
            D += Dy + a2;

            if (D >= 0) {
                x -= 1;
                Dx -= twoB2;
                D -= Dx;
            }
        }
    }

    public void plot(Graphics g, int x, int y,int d){
        g.fillRect(x, y, d, d);
    }

    
}
