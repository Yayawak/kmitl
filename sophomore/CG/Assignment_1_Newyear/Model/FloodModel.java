package Assignment_1_Newyear.Model;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;

import Assignment_1_Newyear.View.Center.Center;
import Lab3CurveTrigFloodFill.FloodFill;

public class FloodModel extends PrimaryShape {
    public Point targetPos;
    // BufferedImage buffer;
    public Color oldColor;
    public Color replacementColor;


    // public FloodModel(Point targetPos, BufferedImage buffer, Color oldColor, Color replacementColor) {
    public FloodModel(Point targetPos, Color oldColor, Color replacementColor) {
        this.targetPos = targetPos;
        // this.buffer = buffer;
        this.oldColor = oldColor;
        this.replacementColor = replacementColor;
    }


    @Override
    public void draw() {
        System.out.println("Drawing Flooding From Flood class");
        var buffer = Center.getInstance().buffer;
        FloodFill.floodFill(
            buffer, 
            targetPos.x,
            targetPos.y,
            oldColor,
            replacementColor,
            // w, h
            // 500, 500
            buffer.getWidth(),
            buffer.getHeight()
        );
    }
    
}
