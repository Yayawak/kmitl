package Assignment_1_Newyear.Model;

import java.awt.Point;

import Assignment_1_Newyear.View.Components.Tools.LineWidthTool;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;

public class Dot extends PrimaryShape {
    public Point center;
    public int size;

    public Dot(Point center, int size) {
        this.center = center;
        this.size = size;
    }

    @Override
    public void draw() {
        Drawing.getG().setColor(color);
        Drawing.drawGeneralDot(center, size);
    }

    @Override
    public String toString() {
        var s = String.format("center[%s], size=[%d]", 
            center, size
        );
        return s + super.toString();
    }
}
