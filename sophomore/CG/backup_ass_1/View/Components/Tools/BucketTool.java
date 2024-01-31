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

public class BucketTool extends CustomImagePanel {

    private static BucketTool ins;
    public static  BucketTool getInstance() { 
        if (ins == null) {
            ins = new BucketTool(
                "Assignment_1_Newyear/Assets/Icons/paint-bucket.png"
            );
        }
        return ins;
    }

    public BucketTool(String path) {
        super(path);

    }


    public void clickLogic(Point mousePos, BufferedImage buffer, Color panelBackgroundColor)
    {
        Color replacementColor = ColorSelectorTool.getInstance().globalColor;
        String s = String.format("Flooding fill at [%d, %d] with Color %s", 
            mousePos.x, mousePos.y, replacementColor
        );
        System.out.println(s);

        // var fd = new FloodModel(mousePos, buffer, panelBackgroundColor, replacementColor);
        var fd = new FloodModel(mousePos, panelBackgroundColor, replacementColor);

        Center.getInstance().addShape(fd);
        // Console.getInstance().addRowString(s);
    }

    @Override
    protected void onclick() {
        System.out.println("click to use Flood-fill tool");
        Center.getInstance().currentState = CenterState.bucket;

        StatusPanel.getInstance().setString("Bucket");
    }
}
