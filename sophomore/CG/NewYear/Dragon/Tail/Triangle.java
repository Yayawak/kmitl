package NewYear.Dragon.Tail;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

import Assignment_1_Newyear.Model.PrimaryShape;
import Lab2LineAlgorithms.Drawing;

// public class Triangle
public class Triangle extends PrimaryShape
{
    public Point[] points = new Point[3];
    public boolean[] isOppositeSideConnected = new boolean[3];

    // public Triangle(Point p1, Point p2, Point p3, Color color)
    public Triangle(Point p1, Point p2, Point p3)
    {
        // this.color = color;
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        // drawTrig();
    }

    // from center point
    // public Triangle(Point p, int radius, Color color)
    public Triangle(Point p, int radius)
    {
        // this.color = color;
        double rad60 = Math.toRadians(60);
        // Point startVertex = new Point(
        for (int i = 0; i < 3; i++)
        {
            Point pp = new Point(
                p.x + (int)(radius * Math.cos(i * rad60)),
                p.y + (int)(radius * Math.sin(i * rad60))
            );
            points[i] = pp;
        }
        // drawTrig();
    }

    public void drawTrig()
    {
        Drawing.drawTriangle(points, color);
    }

    public Point getCenter()
    {
        return new Point(
            (points[0].x + points[1].x + points[2].x) / 3,
            (points[0].y + points[1].y + points[2].y) / 3
        );
    }

    @Override
    public String toString() {
        var s  = String.format(
            "3P : %s, %s, %s\tColor : %s",
                points[0], points[1], points[2], color
            );
        return s;
    }

    public int getArea()
    {
        return getArea(points);
    }

    public static int getArea(Point points[])
    {
        assert points.length == 3;

        double a = points[0].distance(points[1]);
        double b = points[1].distance(points[2]);
        double c = points[0].distance(points[2]);

        double s = (a + b + c) / 2;
        double A = Math.sqrt((s) * (s - a) * (s - b) * (s - c));
        return (int)A;
    }

    public static double getSlopeFrom2Point(Point a, Point b)
    {
        System.out.printf("calculating slope by \n\tp1 = %s\n\tp2 = %s\n",
        a, b
        );
        double bot = a.x - b.x;
        assert (bot!= 0);

        // return (a.y - b.y) / (bot);
        return (-a.y + b.y) / (bot);
    }
}