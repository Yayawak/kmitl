package Assignment_1_Newyear.View.Components.Tools;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Assignment_1_Newyear.Model.Line;
import Assignment_1_Newyear.View.Center.Center;
import Assignment_1_Newyear.View.Center.StatusPanel;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;

public class ColorSelectorTool extends CustomImagePanel {

    private static ColorSelectorTool ins;
    public static ColorSelectorTool getInstance() {
        if (ins == null) {
            ins = new ColorSelectorTool(
                    "Assignment_1_Newyear/Assets/Icons/color-wheel.png");
        }
        return ins;
    }
    public Color globalColor = Color.black;
    enum ColorSelectorState {
    }
    public ColorSelectorState currentState;

    public ColorSelectorTool(String path) {
        super(path);

    }

    @Override
    protected void onclick() {
        showColorChooser();
    }

    // @Override
    // protected void onEnter() {
    //     System.out.println("Enter color selector");
    //     toggleColorChooser();
    // }

    // @Override
    // protected void onExit() {
    //     toggleColorChooser();
    // }

    protected void showColorChooser() {
        // Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
        Color newColor = JColorChooser.showDialog(this, "Choose a color", Color.RED);
        if (newColor != null)
        {
            globalColor = newColor;
            setBackground(globalColor);
            repaint();
            System.out.println("Select new color : " + globalColor);
        }
        else
        {
            System.out.println("Choosed Color is null -> don't set new color.");
        }
    }
}
