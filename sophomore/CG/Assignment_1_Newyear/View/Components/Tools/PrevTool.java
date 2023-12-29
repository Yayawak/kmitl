package Assignment_1_Newyear.View.Components.Tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

import Assignment_1_Newyear.Controller.ShapeReaderWriter;
import Assignment_1_Newyear.Model.Curve;
import Assignment_1_Newyear.Model.FloodModel;
import Assignment_1_Newyear.Model.Line;
import Assignment_1_Newyear.Model.LineWidthState;
import Assignment_1_Newyear.View.Center.Center;
import Assignment_1_Newyear.View.Center.StatusPanel;
import Assignment_1_Newyear.View.Center.Center.CenterState;
import Assignment_1_Newyear.View.Console.Console;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import Lab3CurveTrigFloodFill.FloodFill;

public class PrevTool extends CustomImagePanel {

    private static PrevTool ins;
    public static  PrevTool getInstance() { 
        if (ins == null) {
            ins = new PrevTool(
                "Assignment_1_Newyear/Assets/Icons/back.png"
            );
        }
        return ins;
    }

    public PrevTool(String path) {
        super(path);

    }

    @Override
    protected void onclick() {
        System.out.println("clicked to use PREVIOUS tool");
        // Center.getInstance().currentState = CenterState.bucket;
        ShapeReaderWriter.deleteLastLine();

        StatusPanel.getInstance().setString("Previous");
        Console.getInstance().addRowString("Removing The last action !");
        Center.getInstance().reinitShapesUI();
    }
}
