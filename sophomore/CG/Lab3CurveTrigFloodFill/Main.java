package Lab3CurveTrigFloodFill;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("Curve Triangle Flood-fill");
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int w = 500;
        int h = 500;
        // f.setSize(1024, 720);
        f.setSize(w, h);
        f.setLocationRelativeTo(null);
        


        f.add(new SwingPanel());
        // f.add(new PolygonTest());
        // f.add(new FFtest(f.getWidth(), f.getHeight()));
        // f.add(new FFtest(w, h));
        

    }
}
