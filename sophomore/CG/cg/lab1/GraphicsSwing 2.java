package cg.lab1;

import java.awt.*;
import java.util.Random;

import javax.swing.*;
public class GraphicsSwing extends JPanel {
    public static void main(String[] args) {

        GraphicsSwing m = new GraphicsSwing();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    }
    public void paintComponent(Graphics g){
        //1
    g.setColor(new Color(190, 150, 200,175));//r g b opacity
    g.fillRect(35, 10, 150, 40);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
    g.setColor(Color.black);
    g.drawString("64050124", 40, 40);
    

    g.setColor(new Color(200, 106, 104));
    g.fillOval(50, 50, 45, 45);

    g.drawOval(30, 130, 50, 60); // x y w h 
    
    g.setColor(Color.black);
    g.drawArc(200, 200, 50, 50, 45, 350); // x y w h start(0 is right) length of arc
    g.fillArc(200, 200, 50, 50, 45, 350); // same as draw

    g.setColor(Color.RED);
    g.drawLine(0, 0, getWidth(), getHeight());
    g.fillOval(130, 130, 50, 60);
    g.drawArc(30, 200, 40, 50, 90, 60);
        // 2
    for (int i = 0; i < 10; i++) {
        Random random = new Random();
        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        plot(g, 20+(i*15), 300);
    }
    
    // 3
    /* 
     let start at 0,0 and end is getWidth() and getHeight()
    */
    }
    private void plot(Graphics g, int x, int y){
    g.fillRect(x, y, 10, 10);
    }
}