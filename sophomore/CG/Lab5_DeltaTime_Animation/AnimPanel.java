package Lab5_DeltaTime_Animation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfigTemplate;
import java.awt.Point;

import javax.swing.JPanel;

public class AnimPanel extends JPanel implements Runnable {
    int screenWidth = 600;
    int screenHeight = 600;

    // Point velecity = new Point(1, 0);
    // double[] velecity = {1, 0};
    double circleMove = 100;
    double squareY = 0;
    double squareRotate = 0;
    int circleRadius = 100;
    // Point vel = new Point(0, 0);
    Point vel = new Point(600, 100);
    double startTime = System.currentTimeMillis();


    public AnimPanel() {

    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;

        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;


            // TODO: update logics
            update(elapsedTime);

            // System.out.printf("elapsed time = %.8f\n" , elapsedTime);
            // circleMove += 50.0 * elapsedTime / 1000.0;

            // Display
            repaint();
        }
    }

    public void update(double dt)
    {
        squareRotate += 0.5 * dt / 1000.0;
        // System.out.println("circle x = " + circleMove);
        // System.out.println("rotate = " + squareRotate);

        circleMove += vel.x * dt / 1000.0;

        if (circleMove > screenWidth - circleRadius)
        {
            // circleMove -= 50.0 * dt / 1000.0;
            // circleMove -= vel.x * dt / 1000.0;
            vel = new Point(-vel.x, vel.y);
        }
        // if (circleMove < circleRadius - 0)
        else if (circleMove < 0)
        {
            // circleMove += vel.x * dt / 1000.0;
            // circleMove += 50.0 * dt / 1000.0;
            vel = new Point(-vel.x, vel.y);
        }


        double msFromStart = System.currentTimeMillis() - startTime;
        
        if (msFromStart >= 3000)
        {
            squareY += vel.y * dt / 1000;
            if (squareY > screenHeight - 50)
            {
                // circleMove -= 50.0 * dt / 1000.0;
                // circleMove -= vel.x * dt / 1000.0;
                vel = new Point(-vel.x, -vel.y);
            }
            else if (squareY < 0)
            {
                vel = new Point(vel.x, -vel.y);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D)g;


        // System.out.println(circleMove);
        // gg.translate(circleMove, 0);
        gg.drawOval((int)circleMove, 0,
            circleRadius, circleRadius);

        // gg.drawOval(
        //     (int)velecity[0],    
        //     (int)velecity[1],    
        //     100,
        //     100
        // );
        gg.drawRect(0,
            (int)squareY,
            100,
            100
        );


        gg.rotate(squareRotate, screenWidth / 2 , screenHeight / 2);
        gg.drawRect(200, 200, 200, 200);


    }

}
