package NewYear;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

// import Lab2LineAlgorithms.Drawer;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import Lab3CurveTrigFloodFill.BazierAlgorithm;
import NewYear.Dragon.Old.DragonGraphic;
import NewYear.Dragon.Tail.Tails;
import NewYear.Dragon.Tail.Triangle;
import NewYear.Dragon.Tail.TriangleMesh;
import NewYear.Dragon.UtilsTrigs.Node;
import NewYear.Dragon.Wing.PairWing;
import NewYear.Dragon.Wing.Wing;

public class SwingPanel extends JPanel {

    public SwingPanel()
    {
        var t = new Thread(new Runnable() {
            @Override
            public void run() {
                // while (true)
                // {
                //     try {
                //         Thread.sleep(1000);
                //         repaint();
                //     } catch (Exception e) {
                //     }
                // }
            }
        });
        t.start();
    }

    private  static void testMeshingTriangles()
    {
        Triangle t1 = new Triangle(
            new Point(200, 200),
            new Point(300, 200),
            new Point(300, 300)
        );
        t1.color = Color.magenta;
        // Drawing.drawVerticesTriangle(t1, Color.blue);
        t1.drawTrig();
        // System.out.println("Area t1 = " + t1.getArea());


        Triangle t2 = TriangleMesh.extrudeAnotherTrigByClosetAngle(
            t1, 0, 1, 0
        );
        t2.color = Color.red;
        t2.drawTrig();
    }


    @Override
    protected void paintComponent(Graphics g) {
        Drawing.attachGraphics(g);
        // super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        // Tails tails = new Tails(3);
        // Tails tails = new Tails(8);
        // Tails tails = new Tails(8, new Point(300, 20));
        // int x = (int)(Math.random() * getWidth());
        int x = getWidth() / 2;

        // Tails tails = new Tails(15, new Point(x, getHeight() / 3));
        // Tails tails = new Tails(4, new Point(x, getHeight() / 3));

        
        // Node coreNode = tails.tails.getFirst();
        // PairWing pairWing = new PairWing(coreNode);
        // Tails tails = new Tails(9, new Point(x, 20));
        // Tails tails = new Tails(5, new Point(x, 20));
        // Tails tails = new Tails(2, new Point(x, 20));
        Tails tails = new Tails(3, new Point(x, 100));
        // Tails tails = new Tails(4, new Point(x, 20));

        // testMeshingTriangles();

        // Drawing.drawGrid(getWidth(), getHeight(), 15, 10);
        Drawing.drawGrid(getWidth(), getHeight(), 20, 20);

    }
}
