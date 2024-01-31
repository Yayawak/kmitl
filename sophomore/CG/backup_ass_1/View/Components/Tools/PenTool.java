package backup_ass_1.View.Components.Tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;

import Assignment_1_Newyear.Model.Curve;
import Assignment_1_Newyear.Model.Line;
import Assignment_1_Newyear.Model.LineWidthState;
import Assignment_1_Newyear.View.Center.Center;
import Assignment_1_Newyear.View.Center.StatusPanel;
import Assignment_1_Newyear.View.Center.Center.CenterState;
import Assignment_1_Newyear.View.Console.Console;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;

public class PenTool extends CustomImagePanel {

    private static PenTool ins;
    public static  PenTool getInstance() { 
        if (ins == null) {
            ins = new PenTool(
                "Assignment_1_Newyear/Assets/Icons/pen.png"
            );
        }
        return ins;
    }

    public enum PenState
    {
        start,
        control1,
        control2,
        end,
        deactivate
    }

    public PenState currentState = PenState.start;
    // class BezierPoints
    // {
    //     public Point start;
    // }
    public Point controlPoints[] = new Point[4];

    public PenTool(String path) {
        super(path);

    }


    public void draw()
    {
        for (int i = 0; i < 4; i++)
        {
            // assert controlPoints[i] != null;
            if (controlPoints[i] == null)
            {
                System.err.printf("Error Using Pen Tool Without 4 controls point [%d]\n", i);
                return;
            }
        }
        System.out.printf("Drawing Curve from %s -> %s\n\twith control point = %s, %s\n",
            controlPoints[0],
            controlPoints[3],
            controlPoints[1],
            controlPoints[2]
        );
        var c = new Curve(
            controlPoints[0],
            controlPoints[3],
            controlPoints[1],
            controlPoints[2]
        );
        // var l = new Line(
        //     doublePoints[0], doublePoints[1]
        // );
        Console.getInstance().addRowString(c.toString());
        Center.getInstance().addShape(c);
    }

    public void penClickingLogic(Point mousePos)
    {
        System.out.println("PEN State : " + currentState.toString());
        StatusPanel.getInstance().setString(currentState.toString());
        switch (currentState) {
            case start:
                currentState = PenState.control1;
                controlPoints[0] = mousePos;
                Center.getInstance().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                break;
            case control1:
                currentState = PenState.control2;
                controlPoints[1] = mousePos;
                // Center.getInstance().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                break;
            case control2:
                currentState = PenState.end;
                controlPoints[2] = mousePos;
                // Center.getInstance().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                break;
            case end:
                currentState = PenState.start;
                controlPoints[3] = mousePos;
                Center.getInstance().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                draw();
                break;
        
            default:
                break;
        }
    }

    @Override
    protected void onclick() {
        System.out.println("click to use PEN tool");
        Center.getInstance().currentState = CenterState.pen;
        currentState = PenState.start;

        StatusPanel.getInstance().setString(currentState.toString());
    }

    
}
