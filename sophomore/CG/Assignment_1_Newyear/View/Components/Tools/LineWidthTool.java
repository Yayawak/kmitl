package Assignment_1_Newyear.View.Components.Tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Assignment_1_Newyear.Controller.ImageApi;
import Assignment_1_Newyear.Model.Line;
import Assignment_1_Newyear.Model.LineWidthState;
import Assignment_1_Newyear.View.Center.Center;
import Assignment_1_Newyear.View.Center.StatusPanel;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;

public class LineWidthTool extends CustomImagePanel {
    static String base = "Assignment_1_Newyear/Assets/Icons/line_widths/";
    static Path smallPath = Paths.get(base, "small.png");
    static Path bigPath = Paths.get(base, "big.png");
    static Path mediumPath = Paths.get(base, "medium.png");

    private static LineWidthTool ins;
    public static LineWidthTool getInstance() {
        if (ins == null) {
            ins = new LineWidthTool(
                // "Assignment_1_Newyear/Assets/Icons/line_widths/line-widths.png"
                // "Assignment_1_Newyear/Assets/Icons/pen.png"
                mediumPath.toString()
            );
        }
        return ins;
    }
    public LineWidthState currentState = LineWidthState.medium;

    public LineWidthTool(String path) {
        super(path);
        setBackground(Color.white);

    }

    public static int getSizePixel(LineWidthState state)
    {
        switch (state) {
            case small:
                return 1;
            case medium:
                return 5;
            case big:
                return 10;
        }
        return 100;
    }

    private void setNewIcon(Path path)
    {
        imageicon = ImageApi.readImageIconFromFile(
            path.toString()
            , 40, 40);
        iconLabel.setIcon(imageicon);
        iconLabel.revalidate();
        // iconLabel.repaint();
    }

    @Override
    protected void onclick() {
        Path pathToUse = mediumPath;
        switch (currentState) {
            case small:
                currentState = LineWidthState.medium;
                pathToUse = mediumPath;
                break;
            case medium:
                currentState = LineWidthState.big;
                pathToUse = bigPath;
                break;
            case big:
                currentState = LineWidthState.small;
                pathToUse = smallPath;
                break;
        
            default:
                break;
        }
        // System.out.println("changing state of strok-width to " + currentState.toString());
        setNewIcon(pathToUse);

    }

}
