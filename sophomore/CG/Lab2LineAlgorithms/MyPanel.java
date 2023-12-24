package Lab2LineAlgorithms;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
    
    // Drawer drawer = new Drawer();
    final int[] args1 = {100, 100, 400, 200};
    final int[] args2 = {400, 300, 100, 200};
    final int[] args3 = {100, 100, 200, 400};

    public MyPanel()
    {
        super();
        setBackground(Color.lightGray);
    }

    public void ex1Naivelines(Graphics g)
    {
        System.out.println("Testing Naive Lines");
        // drawer.g = g;
        g.setColor(Color.BLUE);
        // drawer.lineAlgorithms.naiveLine(args1);
        // g.setColor(Color.green);
        // drawer.lineAlgorithms.naiveLine(args2);
        // g.setColor(Color.red);
        // drawer.lineAlgorithms.naiveLine(args3);

        LineAlgorithms.naiveLine(args1);
        g.setColor(Color.green);
        LineAlgorithms.naiveLine(args2);
        g.setColor(Color.red);
        LineAlgorithms.naiveLine(args3);

        System.out.println();
    }

    public void ex2DDA_Lines(Graphics g)
    // public void ex2DDA_Lines()
    {
        System.out.println("Testing DDA Lines");

        // g.setColor(Color.BLUE);
        // drawer.lineAlgorithms.ddaLine(args1);
        // g.setColor(Color.green);
        // drawer.lineAlgorithms.ddaLine(args2);
        // g.setColor(Color.red);
        // drawer.lineAlgorithms.ddaLine(args3);

        // drawer.g = g;
        g.setColor(Color.BLUE);
        LineAlgorithms.ddaLine(args1);
        g.setColor(Color.green);
        LineAlgorithms.ddaLine(args2);
        g.setColor(Color.red);
        LineAlgorithms.ddaLine(args3);

        System.out.println();
    }

    public void ex3BSH_Lines(Graphics g)
    // public void ex2DDA_Lines()
    {
        System.out.println("Testing Brasenhim's Algorithm");
        // g.setColor(Color.BLUE);
        // drawer.lineAlgorithms.bshLine(args1);
        // g.setColor(Color.green);
        // drawer.lineAlgorithms.bshLine(args2);
        // g.setColor(Color.red);
        // drawer.lineAlgorithms.bshLine(args3);
        // drawer.g = g;
        g.setColor(Color.BLUE);
        LineAlgorithms.bshLine(args1);
        g.setColor(Color.green);
        LineAlgorithms.bshLine(args2);
        g.setColor(Color.red);
        LineAlgorithms.bshLine(args3);

        System.out.println();
    }

    private void annots(Graphics g)
    // private void annots()
    {
        g.drawString("(100,100)", 100, 100);
        g.drawString("(400,200)", 400, 200);
        g.drawString("(400,300)",400, 300);
        g.drawString("(100,200)", 100, 200);
        g.drawString("(200,400)", 200, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // drawer.
        Drawing.g = g;
        System.out.println("paint component");
        annots(g);
        // drawer.lineAlgorithms.drawGrid(getWidth(), getHeight(), 10, 8);
        LineAlgorithms.drawGrid(getWidth(), getHeight(), 10, 8);


        // ex1Naivelines(g);
        // ex2DDA_Lines(g);
        ex3BSH_Lines(g);

        // System.out.println(getSize());

        // g.drawLine(
        //     100, 100,
        //     400, 200
        // );
    }

}
