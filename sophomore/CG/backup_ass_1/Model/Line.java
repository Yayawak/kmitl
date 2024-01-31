package backup_ass_1.Model;

import java.awt.Point;

import Assignment_1_Newyear.View.Components.Tools.LineWidthTool;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;

public class Line extends PrimaryShape {
    public Point start;
    public Point end;



    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }



    @Override
    public void draw() {
        Drawing.getG().setColor(color);
        // LineAlgorithms.bshLine(start, end);
        // LineAlgorithms.bshLine(start, end, LineWidthTool.getInstance().getSizePixel());
        LineAlgorithms.bshLine(start, end, LineWidthTool.getSizePixel(widthState));
    }

    @Override
    public String toString() {
        var s = String.format("start:end=[(%d,%d), (%d,%d)]", 
            start.x, start.y, end.x, end.y
        );
        return s + super.toString();
    }
}
