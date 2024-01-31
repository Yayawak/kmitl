package Lab3CurveTrigFloodFill;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// import Lab2LineAlgorithms.Drawer;
import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import Lab3CurveTrigFloodFill.BazierAlgorithm;
import NewYear.Dragon.Old.DragonGraphic;

public class SwingPanel extends JPanel {

    public int x0 = 0;
    public int x3 = 100;
    public SwingPanel()
    {
        System.out.println("init swing panel");
        add(new Button("Btn"));

        // Slider x0sld = new Slider(getWidth());
        // Slider x3sld = new Slider(getWidth());
        Slider x0sld = new Slider(500);
        Slider x3sld = new Slider(500);

        x0sld.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // x0 = e.
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int val = (int) source.getValue();
                    x0 = val;
                    // System.out.println(x0);
                    repaint();
                }
            }
        });
        x3sld.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int val = (int) source.getValue();
                    x3 = val;
                    repaint();
                }
            }
        });
        add(x0sld);
        add(x3sld);
    }

    class Slider extends JSlider {
        // public Slider(int width, SwingPanel parent) {
        public Slider(int width) {
            super(JSlider.HORIZONTAL, 0, width, 0);

            // this.addChangeListener(new ChangeListener() {
            //     @Override
            //     public void stateChanged(ChangeEvent e) {
            //         JSlider source = (JSlider) e.getSource();
            //         if (!source.getValueIsAdjusting()) {
            //             int val = (int) source.getValue();
            //             // parent.x0
            //             repaint();
            //         }
            //     }
            // });
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // ! most important line
        Drawing.attachGraphics(g);
        // System.out.println("Paint Component");
        // Drawing.drawGrid(500, 500, 10, 10);
        // LineAlgorithms.bshLine(0, 0, 400, 400);
        BZ.bz(
                x0, 0,
                300, 300,
                500, 500,
                x3, 0);

    }

}
