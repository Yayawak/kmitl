package backup_ass_1.View.Components.Tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.sql.ShardingKey;
import java.util.Objects;

import javax.print.DocFlavor.STRING;

import Assignment_1_Newyear.Controller.Finders.ShapeFinders;
import Assignment_1_Newyear.Model.Curve;
import Assignment_1_Newyear.Model.Dot;
import Assignment_1_Newyear.Model.FloodModel;
import Assignment_1_Newyear.Model.Line;
import Assignment_1_Newyear.Model.LineWidthState;
import Assignment_1_Newyear.Model.PrimaryShape;
import Assignment_1_Newyear.View.Center.Center;
import Assignment_1_Newyear.View.Center.StatusPanel;
import Assignment_1_Newyear.View.Center.Center.CenterState;
import Assignment_1_Newyear.View.Console.Console;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import Lab3CurveTrigFloodFill.FloodFill;

public class SnapTool extends CustomImagePanel {
    // private Point mousePosByMouseMoveMethod = null;
    private static SnapTool ins;
    public static  SnapTool getInstance() { 
        if (ins == null) {
            ins = new SnapTool(
                "Assignment_1_Newyear/Assets/Icons/magnet.png"
            );
        }
        return ins;
    }

    public record ShapeDistPair(PrimaryShape shp, double dist, Point nearestPoint) {
        // public ShapeDistPair {
            // Objects.requireNonNull(shp);
            // Objects.requireNonNull(dist);
        // }
    }

    // public PrimaryShape snapingShape = null;
    public ShapeDistPair snapingShapeData = null;

    public SnapTool(String path) {
        super(path);
    }


    @Override
    protected void onclick() {
        Center.getInstance().currentState = CenterState.snap;
        StatusPanel.getInstance().setString("Snap");
    }


    public void deleteSnapingShapeOnClick()
    {
        if (snapingShapeData != null && snapingShapeData.shp != null)
        {
            // ShapeFinders.findRowIndexByShape(snapingShapeData.shp);
            ShapeFinders.findRowByShapeAndDelete(snapingShapeData.shp);
            Center.getInstance().reinitShapesUI();
        }

        // if (snapingShapeData != null)
        // {
        //     int size = Center.getInstance().shapes.size();
        //     System.out.println("old size = " + size);
        //     Center.getInstance().shapes.remove(snapingShapeData.shp);
        //     size = Center.getInstance().shapes.size();
        //     System.out.println("new size = " + size);

        //     Center.getInstance().repaint();
        //     Console.getInstance().addRowString("Deleting Snapping Shape : " + snapingShapeData.shp);
        // }
    }

    private ShapeDistPair updateDistIfCloser(
        Point mousePoint, Point testPoint, 
        ShapeDistPair old,
        PrimaryShape testShape
        )
    {
        double d = mousePoint.distance(testPoint);
        if (d < old.dist)
        {
            return new ShapeDistPair(testShape, d, testPoint);
        }
        return old;
    }

    public void dragLogic()
    {
        if (snapingShapeData == null)
        {
            System.out.println("snapping Shape data is NULL.");
            return;
        }
        else if( snapingShapeData.shp != null)
        {
            System.out.println("snappingShapeData.shp is NULL.");
            return;
        }

        {
            // System.out.println("Nearest Point to Mouse is " +
            //     snapingShapeData.nearestPoint
            // );
            // System.out.println("mouse pos =" + newMousePointToAssign);
            // System.out.println("mouse pos =" + newMousePointToAssign);
            // snapingShapeData.shp.
            if (snapingShapeData.shp instanceof Line)
            {
                Line l = (Line)snapingShapeData.shp;
                // l.
                if (l.start.equals(snapingShapeData.nearestPoint))
                {
                    // l.start = newMousePointToAssign;
                    // l.start = mousePosByMouseMoveMethod;
                    // l.start = getMousePosition();
                    // l.start = Center.getInstance().getMousePosition();
                    // l.start = Center.getInstance().getMousePosition();
                    // ! bug real time -> wanted mouse point in real time but ti's so hard to get mouse pos 'in real time ?'
                    // l.start = Center.getInstance()
                    // l.start = temp;
                    // System.out.println("SET START SET = " + l.start);
                }
                else if (l.end.equals(snapingShapeData.nearestPoint))
                {
                    // l.end = newMousePointToAssign;
                    // l.start = mousePosByMouseMoveMethod;
                }
            }
            // snapingShapeData.nearestPoint
        }
    }

    // Point temp;

    public void onMove(Point mousePoint)
    {
        // temp = mousePoint;
        // PrimaryShape closestShape = null;
        // double minDist = Float.MAX_VALUE;
        // System.out.println("moving");
        ShapeDistPair pair = new ShapeDistPair(null, Double.MAX_VALUE, null);
        for (var shape : Center.getInstance().shapes)
        {
            if (shape instanceof Line)
            {
                Line l = (Line)shape;
                pair = updateDistIfCloser(mousePoint, l.start, pair, l);
                pair = updateDistIfCloser(mousePoint, l.end, pair, l);
            }
            else if (shape instanceof Curve)
            {
                Curve l = (Curve)shape;
                pair = updateDistIfCloser(mousePoint, l.start, pair, l);
                pair = updateDistIfCloser(mousePoint, l.end, pair, l);
                pair = updateDistIfCloser(mousePoint, l.control1, pair, l);
                pair = updateDistIfCloser(mousePoint, l.control2, pair, l);
            }
        }

        snapingShapeData = pair;
        int size = 16;
        if (pair.shp instanceof Line)
        {
            Line l = (Line)pair.shp;
            // ! bug because l is points to old object in normal-shapes
            // * we should create copy of line if we want to make belowing line
            Dot d1 = new Dot(l.start, size);
            Dot d2 = new Dot(l.end, size);
            d1.color = Color.green;
            d2.color = Color.green;

            Center.getInstance().addMetaShape(d1);
            Center.getInstance().addMetaShape(d2);

        }
        else if (pair.shp instanceof Curve)
        {
            Curve c = (Curve)pair.shp;
            Dot d1 = new Dot(c.start, size);
            Dot d2 = new Dot(c.end, size);
            Dot d3 = new Dot(c.control1, size);
            Dot d4 = new Dot(c.control2, size);
            d1.color = Color.green;
            d2.color = Color.green;
            d3.color = Color.green;
            d4.color = Color.green;

            Center.getInstance().addMetaShape(d1);
            Center.getInstance().addMetaShape(d2);
            Center.getInstance().addMetaShape(d3);
            Center.getInstance().addMetaShape(d4);
        }
    }
    
}
