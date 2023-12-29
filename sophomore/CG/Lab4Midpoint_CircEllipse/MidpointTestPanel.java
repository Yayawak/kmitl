package Lab4Midpoint_CircEllipse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;

import javax.swing.JPanel;

import Lab2LineAlgorithms.Drawing;

public class MidpointTestPanel extends JPanel {
    public MidpointTestPanel()
    {
        // setBackground(Color.gray);
    }

    private static void testCircles(Graphics g)
    {
        // Drawing.drawGeneralDot(300, 200, 10);

        // CircleAlgorithms.midpointDrawCirlcle(300, 200, 70);
        // CircleAlgorithms.midpointDrawCirlcle(100, 100, 50);
        int x = (int)(Math.random() * 500);
        int y = (int)(Math.random() * 400);
        int r = (int)(Math.random() * 200);
        CircleAlgorithms.midpointDrawCirlcle(
            x, y, r 
        );
        // var ps = CircleAlgorithms.getOctancesFromPoint(new Point(0, 10));
        // var ps = CircleAlgorithms.getOctancesFromPoint(new Point(1, 2));
        // System.out.println(Arrays.toString(ps));
        // g.repaint();
    }

    private static void testEllipses(Graphics g)
    {
        int x = (int)(Math.random() * 500);
        int y = (int)(Math.random() * 400);
        int a = (int)(Math.random() * 200);
        int b = (int)(Math.random() * 200);
        EllipseAlgorithms.midpointDrawEllipse(
            x, y, a, b 
            // 300, 200, 200, 100
        );

    }

    @Override
    protected void paintComponent(Graphics g) {
        Drawing.attachGraphics(g);

        // testCircles(g);
        testEllipses(g);
        repaint();
    }
}
