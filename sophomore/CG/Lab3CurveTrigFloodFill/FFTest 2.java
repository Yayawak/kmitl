package Lab3CurveTrigFloodFill;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.DriverAction;

import javax.swing.*;

import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;

class FFtest extends JPanel {
 
    // BufferedImage buffer; 
    // Graphics2D g2;
    public FFtest(int w, int h)
    {
        // buffer = new BufferedImage(getWidth(), getHeight(), 
        // buffer = new BufferedImage(600, 600,
        // buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // g2 = buffer.createGraphics();
        // addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         // FloodFill.getG().fillRect(0, 0, getWidth(), getHeight());
        //         // System.out.println(e.getPoint());
        //         // FloodFill.attachGraphics(g2);
        //         FloodFill.floodFill(buffer, 
        //             e.getX(), e.getY(),
        //             Color.white, Color.blue,
        //             // Color.black, Color.green
        //             getWidth(), getHeight()
        //         );
        //         repaint();
        //         // Drawing.getG().drawImage(buffer, 0, 0, null);
        //     }
        // });
    }

    public void paintComponent(Graphics g) {
 
        // int width = 600;
        // int height = 600;

        // Drawing.attachGraphics(g);
        // Graphics2D g2;
        int width = getWidth();
        int height = getHeight();
        BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        // buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
        Drawing.attachGraphics(g2);
        // * must do -> fill white before flood fill
        g2.setColor(Color.white);
        g2.fillRect(0, 0, width, height); // write black ????????? bug ??????????/


        // g2.setColor(Color.BLUE);
        // Drawing.drawGeneralDot(70, 70, 20);


        // Drawing.drawGrid(width, height, 10, 10);
        BZ.bz(
            width / 4, height / 2,
            // width / 2, height / 4,
            width, -300,
            width / 2, height / 2,
            width / 4, height / 2
        );


        var pl = new Polygon();
        pl.addPoint(width / 3, height / 3);
        pl.addPoint(width / 2, height);
        pl.addPoint(width, height / 4);
        // g.drawPolygon(pl);
        g2.drawPolygon(pl);

        // LineAlgorithms.bshLine(300, 300, 400, 400);
        // FloodFill.floodFill(
        //     buffer, 
        //     // width / 2, height / 2,
        //     // 300, 400,
        //     50, 50,
        // //  getForeground(), getBackground()
        // //  getForeground(), Color.green
        //     Color.white, Color.green,
        //     // Color.black, Color.green
        //     width, height
        // );

        // FloodFill.floodFill(
        //     buffer, 
        //     300, 400,
        //     Color.white, Color.orange,
        //     width, height
        // );

        // FloodFill.floodFill(
        //     buffer, 
        //     // 500, 0,
        //     width / 2, height / 2,
        //     Color.white, Color.red,
        //     width, height
        // );
        // // g.drawImage(buffer, 0, 0, null);
        // g.drawImage(buffer, 0, 0, null);
        g.drawImage(buffer, 0, 0, null);
        // // g.drawImage(buffer, 0, 0, this);
    }
}
