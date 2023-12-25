package Assignment_1_Newyear.View.Center;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Assignment_1_Newyear.Controller.ShapeReaderWriter;
import Assignment_1_Newyear.Model.PrimaryShape;
import Assignment_1_Newyear.View.MainFrame;
import Assignment_1_Newyear.View.Components.CustomImage.PencilTool;
import Assignment_1_Newyear.View.Console.Console;
import Assignment_1_Newyear.View.Side.Sidebar;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;


public class Center extends JPanel {
    private static Center ins;
    public static Center getInstance() { if (ins == null) {ins = new Center();} return ins;}
    // private ArrayList<PrimaryShape> shapes = new ArrayList<>();
    private ArrayList<PrimaryShape> shapes = ShapeReaderWriter.readShapesFromMemory();

    private void initShapesUI()
    {
        for (var s : shapes)
        {
            Sidebar.getInstance().addRow(s);
        }
    }

    private Center()
    {
        initShapesUI();
        setBackground(Color.lightGray);
        // add(new JLabel("Center"));

        setLayout(null);
        var statusPanel = StatusPanel.getInstance();
        // statusPanel.setLocation((int)(MainFrame.screenWidth * 0.8), 100);
        statusPanel.setBounds(
            // (int)(MainFrame.screenWidth * 0.85), 
            (int)(MainFrame.screenWidth * 0.8 * 0.85), 
            (int)(MainFrame.screenHeight * 0.01), 
            100, 25
            // statusPanel.getWidth(), statusPanel.getHeight() // notworked
            );
        // statusPanel.setLocation(400, 100);
        add(statusPanel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                PencilTool.getInstance().swapClickLogic(e.getPoint());
                repaint();
            }
        });

        // setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void drawAllShapes()
    {
        for (PrimaryShape shp : shapes)
        {
            shp.draw();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();

        Drawing.attachGraphics(g);

        drawAllShapes();

        Drawing.drawGrid(w, h, 15, 15);
    }


    public void addShape(PrimaryShape shape)
    {
        shapes.add(shape);
        ShapeReaderWriter.writeNewShapeDataToMemory(shape);
        updateShapeUI(shape);
    }

    private void updateShapeUI(PrimaryShape shape)
    {
        Console.getInstance().addRowString(shape.toString() + "\n");
        Sidebar.getInstance().addRow(shape);
    }
}
