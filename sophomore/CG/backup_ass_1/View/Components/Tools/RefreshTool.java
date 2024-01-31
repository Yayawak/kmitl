package backup_ass_1.View.Components.Tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

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

public class RefreshTool extends CustomImagePanel {

    private static RefreshTool ins;
    public static  RefreshTool getInstance() { 
        if (ins == null) {
            ins = new RefreshTool(
                "Assignment_1_Newyear/Assets/Icons/refresh.png"
            );
        }
        return ins;
    }

    public RefreshTool(String path) {
        super(path);

    }


    public void clickLogic()
    {
        Center.getInstance().reinitShapesUI();
    }

    @Override
    protected void onclick() {
        System.out.println("refreshing all.");

        StatusPanel.getInstance().setString("Refreshing");
    }
}
