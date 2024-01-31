package cg.assignment2;

// 64050177 พิสิษฐ์ เปรื่องปราชญ์
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class Lab5_64050177 extends JPanel implements Runnable {

    static int width = 600;
    static int height = 600;

    double circleMove = 0;
    double circleVelocity = 50;
    int circleDiameter = 100;

    double squareRotate = 0;

    double square2VelocityY = 100;
    double square2Move = 0;
    int square2Width = 50;
    int square2Height = 50;

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Lab5_64050177 m = new Lab5_64050177();

        f.add(m);
        f.setTitle("Lab 5");
        f.setSize(width, height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.BLACK);
        g2.translate(circleMove, 0);
        g2.drawOval(0, 0, circleDiameter, circleDiameter);
        g2.translate(-circleMove, 0);

        g2.rotate(squareRotate, 300, 300);
        g2.setColor(Color.red);
        g2.drawRect(200, 200, 200, 200);
        g2.setColor(Color.BLACK);
        g2.rotate(-squareRotate, 300, 300);

        g2.translate(0, -square2Move);
        g2.drawRect(0, height - square2Height, square2Width, square2Height);
    }

    @Override
    public void run() {

        double lastTime = System.currentTimeMillis();
        double starTime = lastTime;
        double currentTime, elapsedTime;

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            circleMove += circleVelocity * elapsedTime / 1000.0;
            squareRotate += 0.5 * elapsedTime / 1000.0;

            if (currentTime - starTime >= 3000) {
                square2Move += square2VelocityY * elapsedTime / 1000.0;
            }

            if (circleMove >= width - circleDiameter) {
                circleMove = width - circleDiameter;
                circleVelocity = -circleVelocity;
            } else if (circleMove <= 0) {
                circleMove = 0;
                circleVelocity = -circleVelocity;
            }

            if (square2Move >= height - square2Height) {
                square2Move = height - square2Height;
                square2VelocityY = -square2VelocityY;
            } else if (square2Move <= 0) {
                square2Move = 0;
                square2VelocityY = -square2VelocityY;
            }

            repaint();
        }
    }
}
