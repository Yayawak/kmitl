package Lab6_affine_transformation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AffineDriver extends JFrame {

    public AffineDriver()
    {
        setDefaultCloseOperation(3);     
        // setSize(600, 600);
        setSize(1200, 900);
        setTitle("Affine Transformation");

        add(new AffinePanel());
    }

    public static void main(String[] args) {
        JFrame f = new AffineDriver();
        f.setVisible(true);
    }
}


class AffinePanel extends JPanel
{
    public AffinePanel()
    {

    }

    static void ex00(Graphics2D gg)
    {
        Point center = new Point(300, 300);
        double rad = Math.toRadians(-30);
        // double rad = Math.toRadians(-30);
        var a = new double[]{
            // Math.cos(rad), Math.sin(rad), center.x*(1 - Math.cos(rad)) - center.y*Math.sin(rad),
            // Math.sin(-rad), Math.cos(rad), center.y*(1 - Math.cos(rad)) - center.x*Math.sin(rad)
                Math.cos(rad),
                -Math.sin(rad),
                Math.sin(rad),
                Math.cos(rad),
                center.x * (1 - Math.cos(rad)) - center.y * Math.sin(rad),
                center.y * (1 - Math.cos(rad)) - center.x * Math.sin(rad)
        };
        // var b = new double[]{Math.sin(-rad), Math.cos(rad), center.y*(1 -
        // Math.cos(rad)) - center.x*Math.sin(rad)};

        // AffineTransform rot30counterAT = new AffineTransform(
        //         Math.cos(rad), Math.sin(rad), -Math.sin(rad),
        //         Math.cos(rad), 0, 0
        //         // a
        // );
        // gg.setTransform(rot30counterAT);

        gg.setTransform(new AffineTransform(a));


        // gg.drawRect(center.x - 100, center.y - 100, 200, 200);
        // var at = new AffineTransform(
        //     2, 0, 0, 2, 0, 0
        // );
        // // gg.setTransform(at);
        // gg.transform(at);
        // gg.transform(rot30counterAT);

        // new Affine
        // gg.drawRect(200, 200, 200, 200);
        gg.drawRect(center.x - 100, center.y - 100, 200, 200);

        gg.drawRect(center.x, center.y, 1,1);

    }

    static void ex01(Graphics2D gg)
    {
        Point center = new Point(300, 300);
        var a = new AffineTransform(
            2, 0,
            0, 2,
            0, 0
        );
        // var x = new AffineTransform();
        // x.scale(2, 2);
        
        var b = new AffineTransform(
            1, 0, 0, 1,
            -50, 50
        );
        a.concatenate(b);

        gg.transform(a);
        gg.drawRect(center.x - 100, center.y - 100, 200, 200);
        gg.drawRect(center.x, center.y, 1,1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D)g;
        ex00(gg);
        // gg.transform(new AffineTransform(1, 0, 0, 1, 0, 0));
        // ex01(gg);
    }
}