package cg.lab4;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class Lab4_64050124 extends JPanel {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        Lab4_64050124 m = new Lab4_64050124();

        f.add(m);
        f.setTitle("Lab 4");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);

        midpointCircle(g, 300, 300, 100);

        midpointEllipse(g, 300, 50, 300, 50);
        midpointCircle(g, 300, 50, 50);

        midpointEllipse(g, 50, 300, 50, 300);
        midpointCircle(g, 50, 300, 50);

        midpointEllipse(g, 505, 300, 50, 300);
        midpointCircle(g, 505, 300, 50);

        midpointEllipse(g, 300, 505, 300, 50);
        midpointCircle(g, 300, 505, 50);
    }

    public void midpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y) {

            plot(g, xc + x, yc + y, 2);
            plot(g, xc + x, yc - y, 2);
            plot(g, xc - x, yc + y, 2);
            plot(g, xc - x, yc - y, 2);
            plot(g, yc + y, xc + x, 2);
            plot(g, yc + y, xc - x, 2);
            plot(g, yc - y, xc + x, 2);
            plot(g, yc - y, xc - x, 2);

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

    public void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

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

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}
