package src;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.ContainerEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.*;

import src.Components.Pacman;
import src.Components.Food.Cherry;
import src.Components.Food.Food;
import src.Components.Ghost.Ghost;
import src.Libs.Drawing;
import src.helpers.Coordinator;
import src.helpers.TimeTime;
import src.interfaces.Animator;


public class MainAss2 extends JPanel implements Runnable {
    public static final int width = 500;
    public static final int height = 500;

    public static List<Animator> anims = new ArrayList<>();
    private static boolean isAllUpdated = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainAss2 ass2 = new MainAss2();
            JFrame f = new JFrame();

            f.add(ass2);
            f.setTitle("FROM BABIES TO ...");
            f.setSize(width, height);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            (new Thread(ass2)).start();
        });
    }

    @Override
    public void run() {
        initDrawing();

        while (true) {
            TimeTime.setCurrentTime(System.currentTimeMillis());
            TimeTime.setElapsedTime(
                TimeTime.getCurrentTime() - TimeTime.getLastTime()
            );
            


            isAllUpdated = false;
            updateLogics(TimeTime.getElapsedTime());
            repaint();
            isAllUpdated = true;


            TimeTime.setLastTime(TimeTime.getCurrentTime());
            // * frame waiting
            try { Thread.sleep(1000/60); } catch (InterruptedException e) { System.err.println(e); }
        }
    }

    // * init your very first characters like pacman, ghosts
    void initDrawing()
    {
        Pacman pm = Pacman.Ins();
        registerAnimObject(pm);

        List<Color> colors = new ArrayList<>();
        colors.add(Color.red);
        colors.add(Color.yellow);
        colors.add(Color.blue);
        colors.add(Color.black);
        // colors.add(Color.pink);
        colors.add(Color.GREEN);

        // Ghost g1 = new Ghost(Color.blue, new Point(200, 200));
        // Food cherry = new Cherry(Color.red, new Point(200, 200));
        // registerAnimObject(cherry);

        // for (int i = 0; i < 5; i++)
        for (int i = 0; i < 9; i++)
        {
            int j = (int)(Math.random() * colors.size());

            Food cherry = new Cherry(colors.get(j), Coordinator.getRandomPoint(width, height));
            registerAnimObject(cherry);
        }

        // Ghost g1 = new Ghost(Color.blue, new Point(300, 200));
        // registerAnimObject(g1);
        // for 
        for (int i = 0; i < 8; i++)
        {
            int j = (int)(Math.random() * colors.size());
            Ghost ghost = new Ghost(colors.get(j), 
                Coordinator.getRandomPoint(width, height)
            );
            registerAnimObject(ghost);
        }
    }

    void updateLogics(double dt)
    {
        for (Animator animatable : anims) {
            // System.out.println(dt/ 1000);
            animatable.update(dt / 1000);
            // animatable.update(dt);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D gg = (Graphics2D)g;
        Drawing.attachGraphics(gg);
        Drawing.drawGrid(MainAss2.width, MainAss2.height,
            10,
            10 
        );

        // gg.scale(3, 3);
        // gg.scale(1.2, 1.2);

        for (Animator animatable : anims) {
            var oldTf = gg.getTransform();
            Color originColor = gg.getColor();

            // * background section
            // gg.setColor(Color.red);
            // gg.drawRect(0, 0, width, height);
            

            // * segments section
            animatable.draw(gg);

            gg.setColor(originColor);
            gg.setTransform(oldTf);
        }
    }

    public static void waitForRemoveAnimObject(Animator life)
    {
        new Thread(() -> {
            while (!isAllUpdated);
            anims.remove(life);
        }).start();
        // if (isAllUpdated)
        // {
        //     anims.remove(life);
        // }
        // else
        // {
        //     waitForRemoveAnimObject(life);
        // }
    }


    public static void registerAnimObject(Animator life)
    {
        Objects.requireNonNull(life);
        // System.out.println("New Lift Animatable object has been added to main ass 2.");
        anims.add(life);
    }


}
