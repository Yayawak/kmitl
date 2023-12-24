package Assignment_1_Newyear.View.Center;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Assignment_1_Newyear.View.MainFrame;
import Assignment_1_Newyear.View.Components.CustomImage.PencilTool;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;


public class Center extends JPanel {
    private static Center ins;
    public static Center getInstance() { if (ins == null) {ins = new Center();} return ins;}

    private Center()
    {
        System.out.println("Setting up Center");
        setBackground(Color.lightGray);
        // add(new JLabel("Center"));

        // setLayout(null);
        var statusPanel = StatusPanel.getInstance();
        // statusPanel.setLocation((int)(MainFrame.screenWidth * 0.8), 100);
        // statusPanel.setLocation(400, 100);
        add(statusPanel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                System.out.println("\n" + e.getPoint() + "\n");
                // PencilTool.getInstance().swapClickLogic(e.getPoint());

                Drawing.drawGeneralDot(e.getPoint(), 5);
                // revalidate();
                System.out.println("Repainting");
                // LineAlgorithms.bshLine(0, 0 , 400, 400);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();

        Drawing.attachGraphics(g);

        Drawing.drawGrid(w, h, 15, 15);
        // Drawing.getG().setColor(Color.red);
        // LineAlgorithms.bshLine(0, 0 , 400, 400);
    }
}
