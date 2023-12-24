package Assignment_1_Newyear.View.Components.CustomImage;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;

import Assignment_1_Newyear.View.Center.Center;
import Assignment_1_Newyear.View.Center.StatusPanel;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;

public class PencilTool extends CustomImagePanel {

    private static PencilTool ins;
    public static  PencilTool getInstance() { 
        if (ins == null) {
            ins = new PencilTool(
                "Assignment_1_Newyear/Assets/Icons/pencil.png"
            );
        }
        return ins;
    }

    enum PencilState
    {
        initing,
        firstClick,
        secondClick,
        // waiting,
        // idle
    }

    // PencilState currentState = PencilState.idle;
    public PencilState currentState = PencilState.initing;
    public Point doublePoints[] = new Point[2];

    public PencilTool(String path) {
        super(path);

    }

    public void draw()
    {
        if(doublePoints[0] == null)
        {
            System.out.println("Point A is null");
            if ( doublePoints[1] == null)
            {
                System.out.println("Point B is null");
                return;
            }
            return;
        }
        System.out.printf("Drawing Line from %s -> %s\n", doublePoints[0], doublePoints[1]);
        Drawing.getG().setColor(Color.orange);
        LineAlgorithms.bshLine(doublePoints[0], doublePoints[1]);

        Drawing.getG().setColor(Color.red);
        LineAlgorithms.bshLine(0, 0 , 400, 400);

        Drawing.drawGeneralDot(doublePoints[0], 10);

        Center.getInstance().repaint();
        Center.getInstance().revalidate();
    }

    public void swapClickLogic(Point p)
    {
        switch (currentState) {
            case firstClick:
                currentState = PencilState.secondClick;
                // doublePoints[0] = MouseInfo.getPointerInfo().getLocation();
                doublePoints[0] = p;
                break;
            case secondClick:
                currentState = PencilState.firstClick;
                doublePoints[1] = p;
                draw();
                break;
            default:
                break;
        }
        StatusPanel.getInstance().setString(currentState.toString());
        System.out.println(currentState.toString());
    }

    @Override
    protected void onclick() {
        System.out.println("click to use pencil tool");
        System.out.println(currentState.toString());
        // currentState = PencilState.initing;
        currentState = PencilState.firstClick;

        // System.out.println("click status = " + currentState.toString());
        StatusPanel.getInstance().setString(currentState.toString());
    }
    
}
