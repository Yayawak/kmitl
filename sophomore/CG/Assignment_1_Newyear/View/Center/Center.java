package Assignment_1_Newyear.View.Center;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Assignment_1_Newyear.Controller.ShapeReaderWriter;
import Assignment_1_Newyear.Model.PrimaryShape;
import Assignment_1_Newyear.View.MainFrame;
import Assignment_1_Newyear.View.Components.Tools.ColorSelectorTool;
import Assignment_1_Newyear.View.Components.Tools.BucketTool;
import Assignment_1_Newyear.View.Components.Tools.LineWidthTool;
import Assignment_1_Newyear.View.Components.Tools.PenTool;
import Assignment_1_Newyear.View.Components.Tools.PencilTool;
import Assignment_1_Newyear.View.Components.Tools.SnapTool;
import Assignment_1_Newyear.View.Components.Tools.PenTool.PenState;
import Assignment_1_Newyear.View.Components.Tools.PencilTool.PencilState;
import Assignment_1_Newyear.View.Console.Console;
import Assignment_1_Newyear.View.Side.Sidebar;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import Lab3CurveTrigFloodFill.FloodFill;


// public class Center extends JPanel {
public class Center extends JPanel implements MouseMotionListener{
    private static Center ins;
    public static Center getInstance() { if (ins == null) {ins = new Center();} return ins;}
    // private ArrayList<PrimaryShape> shapes = new ArrayList<>();
    // private ArrayList<PrimaryShape> shapes = ShapeReaderWriter.readShapesFromMemory();
    public ArrayList<PrimaryShape> shapes;
    public ArrayList<PrimaryShape> metaShapes = new ArrayList<>();
    // public Queue<PrimaryShape> metaShapes = new LinkedList<>();

    // private PrimaryShape singleMetaShape = null;
    public enum CenterState
    {
        pen, pencil, bucket, snap
    }
    public CenterState currentState; 
    // Color panelBackgroundColor = Color.white;
    public BufferedImage buffer;
    // public static BufferedImage buffer;

    public void reinitShapesUI()
    {
        shapes = ShapeReaderWriter.readShapesFromMemory();
        Sidebar.getInstance().clearAll();
        for (var s : shapes)
        {
            Sidebar.getInstance().addRow(s);
        }
        repaint(); // * also update Center graphics
    }

    class MonitoringThread extends Thread
    {
        @Override
        public void run() {
            // while (true)
            // {
            //     reinitShapesUI();
            //     // System.out.println("Rerender all by re-reading data from Memory.");
            //     try { Thread.sleep(10000); } catch (Exception e) { }
            // }
        }
    }

    private Center()
    {
        var t = new Thread(new MonitoringThread());
        t.start();

        reinitShapesUI();
        // setBackground(Color.lightGray);
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
            // @Override
            // public void mouseReleased(MouseEvent e) {
            //     System.out.println("RELEASE MOUSE ON CENTER");
            // }
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                // if (PencilTool.getInstance().currentState != PencilState.deactivate)
                if (currentState == null)
                    return;
                else if (currentState.equals(CenterState.pencil))
                    PencilTool.getInstance().swapClickLogic(e.getPoint());
                else if (currentState.equals(CenterState.pen))
                    PenTool.getInstance().penClickingLogic(e.getPoint());
                else if (currentState.equals(CenterState.bucket))
                {
                    Color colorAtMousePos;
                    //  buffer.getRGB(ALLBITS, ABORT)
                    int rgb = buffer.getRGB(e.getX(), e.getY());
                    colorAtMousePos = new Color(rgb);
                    BucketTool.getInstance().clickLogic(
                        // e.getPoint(), buffer, panelBackgroundColor
                        e.getPoint(), buffer, colorAtMousePos
                    );

                }
                else if (currentState.equals(CenterState.snap))
                {
                    SnapTool.getInstance().deleteSnapingShapeOnClick();
                }
                repaint();
            }

        });

        // ? for mouseMove()
        addMouseMotionListener(this);

        // setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void drawAllShapes()
    {
        // repaint();
        for (PrimaryShape shp : shapes)
        {
            shp.draw();
        }
        // if (singleMetaShape != null)
        // {
        //     singleMetaShape.draw();
        // }
        for (PrimaryShape mshp : metaShapes)
        {
            mshp.draw();
        }
        metaShapes.clear();
        // repaint();
        // singleMetaShape = null; // * clear singleMetaShape to dont draw
        // repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        // BufferedImage buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        Drawing.attachGraphics(g2);
        // g2.setColor(panelBackgroundColor);
        g2.setColor(Color.white);
        g2.fillRect(0, 0, w, h); // write black ????????? bug ??????????/

        drawAllShapes();


        // FloodFill.floodFill(buffer, 
        //     160, 100, 
        // // FloodFill.floodFill(buffer, 60, 100, 
        //     panelBackgroundColor,
        //     Color.green,
        //     w, h
        // );

        Drawing.drawGrid(w, h, 15, 15);

        g.drawImage(buffer, 0, 0, null);
    }


    public void addShape(PrimaryShape shape)
    {
        shape.color = ColorSelectorTool.getInstance().globalColor;
        shape.widthState = LineWidthTool.getInstance().currentState;
        shapes.add(shape);
        ShapeReaderWriter.writeNewShapeDataToMemory(shape);
        updateShapeUI(shape);
        repaint();
    }

    public void addMetaShape(PrimaryShape shape)
    {
        // metaShapes.clear();
        metaShapes.add(shape);
        // // System.out.println("shape meta len = " + metaShapes.size());
        repaint();
    }

    private void updateShapeUI(PrimaryShape shape)
    {
        Console.getInstance().addRowString(shape.toString());
        Sidebar.getInstance().addRow(shape);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // SnapTool.getInstance().dragLogic(e.getPoint());
        SnapTool.getInstance().dragLogic();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (currentState == null)
            return;
        else if (currentState.equals(CenterState.snap))
        {
            SnapTool.getInstance().onMove(e.getPoint());
        }
    }

}
