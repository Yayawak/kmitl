package Lab2LineAlgorithms;

import java.awt.Point;

import Assignment_1_Newyear.Model.PrimaryShape;

public class Line extends PrimaryShape {
    public Point start;
    public Point end;



    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }



    @Override
    public void draw() {
        LineAlgorithms.bshLine(start, end);
    }

    @Override
    public String toString() {
        var s = String.format("start:end=[(%d,%d), (%d,%d)]", 
            start.x, start.y, end.x, end.y
        );
        return s + super.toString();
    }
}
