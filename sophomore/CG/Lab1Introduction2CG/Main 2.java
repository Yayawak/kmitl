package Lab1Introduction2CG;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Main
 */
public class Main {
    public final static int frameWidth = 600;
    public final static int frameHeight = 600;
    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing Application");
        f.setSize(frameWidth, frameHeight);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class GraphicsSwing extends JPanel
{
    // int panelWidth = size.width;
    // int panelHeight = size.height;
    public GraphicsSwing()
    {
        // while (true)
        // {
        //     // try { Thread.sleep(1); } catch (Exception e) { }
        //     repaint();
        // }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("repainting JPanel (GraphicsSwing).");
                repaint();
            }
        });
    }

    private void drawPixel(Graphics g, int x, int y)
    {
        drawDot(g, x, y, 1);
    }

    private void drawDot(Graphics g, int x, int y, int radius)
    {
        g.fillRect(x, y, radius, radius);
    }

    private void myTest(Graphics g)
    {
        g.drawString("Hello", 40, 40);
        g.setColor(Color.BLUE);
        int w = 100;
        int h = 80;
        g.fillRect(130, 30, 100, 80);

        g.setColor(Color.red);
        int x2 = 200;
        int y2 = 30;
        g.drawLine(0, 0, x2, y2);

        g.fillOval(130, 130, 50, 60);

        int x = 30;
        int y = 200;
        w = 200;
        h = 200;
        int startAngle, arcAngle;
        startAngle = 90;
        arcAngle = 60;
        g.drawArc(x, y, w, h, startAngle, arcAngle);

        g.fillArc(300, 230, 200, 300, 180, 90 + 45);

        
        g.setColor(Color.green);
        // *----------------------- UDF 
        for (x = 0; x < 400; x++)
        {
            drawPixel(g, x, 6);

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Hello", 40, 40);
        g.drawString("Click To Re-Render", 
            (int)(Main.frameWidth / 2), 
            (int)(Main.frameHeight * 0.8));
        g.setColor(Color.BLUE);
        int w = 100;
        int h = 80;
        g.fillRect(130, 30, 100, 80);
        g.drawOval(30, 130, 50, 60);

        g.setColor(Color.red);
        int x2 = 200;
        int y2 = 30;
        g.drawLine(0, 0, x2, y2);


        int x = 130;
        int y = 130;

        w = 50; h = 60;
        g.fillOval(x, y, w, h);

        x = 30;
        y = 200;
        w = 40;
        h = 50;
        int startAngle, arcAngle;
        startAngle = 90;
        arcAngle = 60;
        g.drawArc(x, y, w, h, startAngle, arcAngle);

        

        y = 130;
        w = 40; h = 50; startAngle = 180; arcAngle = 40;
        g.fillArc(x, y, w, h, startAngle, arcAngle);

        
        System.out.println(getParent().getSize().toString());


        int N = 10;
        int maxI = N - 1;
        for (int i = 0; i < N; i++)
        {
            float rescaledI = (float)i / (float)maxI;
            // rescaledI *= 255;
            // rescaledI *= 0.9;
            // System.out.println(rescaledI);
            var c = new Color(rescaledI, 0.5f, 0.5f);
            g.setColor(c);
            randomDrawDotOnScreen(g);
        }


        g.drawLine(0, 0, Main.frameWidth, Main.frameHeight);
    }

    boolean inRange1D(int x, int min, int max, int offset)
    {
        // if (0 + offset < randomX && randomX < panelWidth - offset)
        return (min + offset < x && x < max - offset) ? true : false;
    }

    static int randomInRange(int max)
    {
        return (int)(Math.random() * max);
    }
    
    void randomDrawDotOnScreen(Graphics g)
    {
        int offset = 200; // ระยะถอยร่น
        int randomX = randomInRange(Main.frameWidth);
        int randomY = randomInRange(Main.frameHeight);

        // offset = 50
        // example |------------------------------------|
        //         0                                    400
        //         |    *                  X       *    | ------> OK
        //         |    *                          * X  | ------> Not OK
        //                                           
        // if (randomX > 0 + offset && randomX < panelWidth - offset)
        if (inRange1D(randomX, 0, Main.frameWidth, offset)
        && inRange1D(randomY, 0, Main.frameHeight, offset))
        {
            drawDot(g, randomX, randomY, 20);
        }
        else
        {
            System.out.println("Unfortunately You Enter This recursive by small chance becuase you are not in proper offset range in screen.");
            randomDrawDotOnScreen(g);
        }
    }
}