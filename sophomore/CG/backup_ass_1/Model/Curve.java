package backup_ass_1.Model;

import java.awt.Point;

import Assignment_1_Newyear.View.Components.Tools.LineWidthTool;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import Lab3CurveTrigFloodFill.BazierAlgorithm;

public class Curve extends PrimaryShape {

    public Point start;
    public Point end;
    public Point control1;
    public Point control2;




    public Curve(Point start, Point end, Point control1, Point control2) {
        this.start = start;
        this.end = end;
        this.control1 = control1;
        this.control2 = control2;
    }

    @Override
    public void draw() {
        Drawing.getG().setColor(color);
        // LineAlgorithms.bshLine(start, end);
        // LineAlgorithms.bshLine(start, end, LineWidthTool.getInstance().getSizePixel());
        // LineAlgorithms.bshLine(start, end, LineWidthTool.getSizePixel(widthState));
        BazierAlgorithm.bezier(
            start.x, start.y,
            control1.x, control1.y,
            control2.x, control2.y,
            end.x, end.y,
            LineWidthTool.getSizePixel(widthState),
            color
        );
    }

    @Override
    public String toString() {

        // var s = String.format("start:end=[(%d,%d), (%d,%d)]", 
        //     start.x, start.y, end.x, end.y
        // );

        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("start : %s, ", start));
        sb.append(String.format("end : %s, ", end));
        sb.append(String.format("control 1 : %s, ", control1));
        sb.append(String.format("control 2 : %s, ", control2));


        return sb.toString() + super.toString();
    }
}
