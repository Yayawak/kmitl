package NewYear.Dragon.Tail;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import NewYear.Dragon.UtilsTrigs.Node;



public class Tails {
    // public LinkedList<Triangle> tails = new LinkedList<>();
    public LinkedList<Node> tails = new LinkedList<>();
    Point tailPivotPosition;
    public int tailsFinalLength;

    public Tails(int n, Point tailPivotPosition)
    {
        this.tailsFinalLength = n;
        this.tailPivotPosition = tailPivotPosition;
        for (int i = 0; i < n; i++)
        {
            addTail();
        }
    }

    public void addTail()
    {
        // System.out.println("Adding tail to dragon");
        // Tail tl = new Tail();
        if (tails.isEmpty())
        {
            // Point p = new Point(300, 300);
            System.out.println("adding head of tail.");

            Node t = new Node(
                    new Triangle(
                        // new Point(300, 50), 100, Color.red)
                        // new Point(300, 0),
                        tailPivotPosition,
                        // 30
                        70
                    ),
                    0
            );
            t.triangle.color = Color.MAGENTA;

            tails.add(t);
            // System.out.println(t);
            t.triangle.drawTrig();

            Drawing.drawVerticesTriangle(t.triangle, Color.blue);
                    // new Point(200, 100), 30));
        }
        else
        {
            // Triangle tail = tails.getLast();
            Node tail = tails.getLast();

            int oscilationDegreeNoise = 45;
            // int oscilationDegreeNoise = 35;
            // double f = Math.random() - 0.5f;
            double f = Math.random();
            f += 0.2f;
            f *= oscilationDegreeNoise;
            int base = 270;
            // int deg = (int)(base + f);
            int tailIndex = tails.size();
            int deg = base;
            // ! use this line for goodness
            // int deg = tailIndex % 2 == 0 ? base + 45 : base - 45;

            // int deg = tailIndex % 2 == 0 ? (int)(base + f) : (int)(base - f);


            float scaleTailIndex = 1 - ((float)tailIndex / (float)tailsFinalLength);

            // deg += (Math.sin(Math.toRadians(45 * scaleTailIndex)) * 45);
            // deg += 45 * Math.sin()
            // deg += Math.sin(Math.toRadians(scaleTailIndex * 180)) * 45;
            // double d = Math.cos(Math.toRadians((scaleTailIndex * 90))) * 45;
            // double d = Math.tanh(Math.toRadians((scaleTailIndex * 180))) * 45;

            double d = Math.tanh(Math.toRadians((scaleTailIndex * 180))) * 75;
            d = tailIndex % 2 == 0 ? -d : d;
            // deg += d;

            // System.out.println("d = " + d);
            // System.out.println("Deg = " + deg);
            // System.out.println("Scale index = "+ scaleTailIndex);


            Triangle t = TriangleMesh.extrudeAnotherTrigByClosetAngle(tail.triangle, deg, scaleTailIndex, tail.index);
            // Color realOrange = Color.decode("#FF5C01");
            // t.color = tailIndex % 2 == 0 ? realOrange : Color.orange;
            t.drawTrig();
            Drawing.drawVerticesTriangle(t, Color.blue);

            var newTail = new Node(t, tailIndex);
            tails.add(newTail);

        }

    }
}
