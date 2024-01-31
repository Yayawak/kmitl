package cg.assignment2;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

import java.awt.*;

public class Assignment2_64050124_64050012 extends JPanel implements Runnable {
    int i = 0,cnt = 0;
    double velocityArc = 5;

    double x = 0,y=500;
    double velocityX = 100.0;
    double velocityY = 150.0;
    double velocity = 150.0;
    double angle = -60.0;
    
    // double squareRotate = 5;
    public static void main(String[] args) {
        JFrame f = new JFrame();
        Assignment2_64050124_64050012 m = new Assignment2_64050124_64050012();

        f.add(m);
        f.setTitle("Assignment2");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();;
    }
    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime,elapsedTime;
        // velocityX = velocity * Math.cos(Math.toRadians(angle));
        // velocityY = velocity * Math.sin(Math.toRadians(angle));
        while(true){
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime =currentTime;
            if(velocityArc<360) {
                velocityArc += 20 * elapsedTime / 1000.0;
                System.out.println(velocityArc);
            }
            x += velocityX * elapsedTime / 1000.0;
            y += velocityY * elapsedTime / 1000.0;

            if(x>=600 - 75){
                x = 600 - 75;
                velocityX = -velocityX;
            }
            if(x<=75){
                x = 75;
                velocityX = -velocityX;
            }
            if(y >= 600 - 75){
                y = 600 - 75;
                velocityY = -velocityY;
            }
            if(y <= 75){
                y = 75;
                velocityY = -velocityY;
            }
            
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage buff = new BufferedImage(601,601,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buff.createGraphics();
        
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 600, 600);        //reset JPanel

        
        g2.setColor(Color.black);
        midpointEllipse(g2, (int)x, (int)y, 150, 150);  // task circle

        

        g2.setColor(Color.gray);
        g2.fillOval(15, 15, 570, 570);
        g2.setColor(Color.black);

        drawsuit(g2,buff); // draw card suit circle

        g2.setColor(Color.pink); // arc
        g2.fillArc(-50, -50, 700, 700, 90, (int)(360-velocityArc));
        

        g2.setColor(Color.black); 
        rabbit(g2, buff);   // draw rabbit
        
        g2.setColor(Color.black); // draw circle
        midpointCircle(g2, 300, 300, 285);
        midpointCircle(g2, 300, 300, 255);

        buff = floodFill(buff, 300, 450, Color.white, Color.red);//new Color(242, 198, 39)
        buff = floodFill(buff, 290, 50, Color.white, Color.red);//new Color(242, 198, 39)
        buff = floodFill(buff, 290, 10, Color.pink, new Color(242, 198, 39));
        midpointEllipse(g2, (int)x, (int)y, 150, 150);
        g.drawImage(buff,0,0,null);
    }
    public void drawsuit(Graphics g,BufferedImage buff){
        Graphics2D g2 = (Graphics2D) g;
        int xx = 315;
        int yy = 30;
        for (int i = 0; i < 36; i++) { // loop for dregrees and draw suit
            g2.rotate(Math.toRadians(i*10),300,300); // rotate pic to circle
            g2.rotate(Math.toRadians(-88),xx,yy);
            switch(i%4){
                case 0 :
                    drawHeart(g2, xx , yy,buff);
                    break;
                case 1 :
                    drawSpade(g2, xx , yy,buff);
                    break;
                case 2 :
                    drawDiamond(g2, xx , yy,buff);
                    break;
                case 3 :
                    drawClub(g2, xx , yy);
                    break;
            }
            
            
            g2.rotate(Math.toRadians(88),xx,yy);
            g2.rotate(Math.toRadians(-i*10),300,300);
        }
        
        // drawHeart(g2, 315 , 115);
    }
    public void drawClub(Graphics g,int x,int y){
        int r = 12;
        //fillOval
        //drawOval
        g.fillOval(x-(r/2), y-11, r, r);    //top
        g.fillOval(x-(r/2)+6, y-3, r, r);   //right
        g.fillOval(x-(r/2)-6, y-3, r, r);   //left

        g.drawLine(x+1, y+10, x+1, y+15);    // R line
        g.drawLine(x, y, x, y+15);        // M line
        g.drawLine(x-1, y+10, x-1, y+15);    // L line
        g.drawLine(x-4, y+14, x+4, y+14);   // Under line
        g.drawLine(x-5, y+15, x+5, y+15);   // Under line
    }
    public void drawSpade(Graphics g,int x,int y,BufferedImage buff){
    
        bezier(g, x, y+8, x+18, y+23, x+8, y-5, x, y-12); // r
        bezier(g, x, y+8, x-18, y+23, x-8, y-5, x, y-12); // l
        g.drawLine(x+1, y+8, x+1, y+15);
        g.drawLine(x, y+8, x, y+15);
        g.drawLine(x-1, y+8, x-1, y+15);
        g.drawLine(x-4, y+14, x+4, y+14);   // Under line
        g.drawLine(x-5, y+15, x+5, y+15);   // Under line
        // buff = floodFill(buff, x, y, Color.white, Color.black);
    }
    public void drawDiamond(Graphics g,int x,int y,BufferedImage buff){
        g.setColor(Color.black);
        int xPoly[] = {x, x+10, x, x-10};
        int yPoly[] = {y-15, y, y+15, y};
        Polygon poly = new Polygon(xPoly, yPoly, xPoly.length);
        g.fillPolygon(poly);
        
        g.setColor(Color.black);

    }
    public void drawHeart(Graphics g,int x,int y,BufferedImage buff){
        g.setColor(Color.black);
        bezier(g, x, y-10, x+20, y-25, x+10, y+7, x, y+15); // r
        bezier(g, x, y-10, x-20, y-25, x-10, y+7, x, y+15); // l
        // buff = floodFill(buff, x, y, Color.white, Color.red);
        g.setColor(Color.black);
    }
    
    

    public void midpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int Dx = 2 * x;
        int Dy = 2 * y;
        int D = 1 - r;

        while (x <= y) {

            plot(g, xc + x, yc + y, 1);
            plot(g, xc + x, yc - y, 1);
            plot(g, xc - x, yc + y, 1);
            plot(g, xc - x, yc - y, 1);
            plot(g, yc + y, xc + x, 1);
            plot(g, yc + y, xc - x, 1);
            plot(g, yc - y, xc + x, 1);
            plot(g, yc - y, xc - x, 1);

            x += 1;
            Dx += 2;
            D += Dx + 1;
            if (D >= 0) {
                y -= 1;
                Dy -= 2;
                D -= Dy;
            }
        }
    }

    // 2.1
    public void midpointEllipse(Graphics g, int xc, int yc, int a, int b) {
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

        // Region 1
        int x = 0;
        int y = b;
        int D = Math.round(b2 - a2 * b + a2 / 4);
        int Dx = 0;
        int Dy = twoA2 * y;

        while (Dx <= Dy) {

            plot(g, xc + x, yc + y, 1);
            plot(g, xc + x, yc - y, 1);
            plot(g, xc - x, yc + y, 1);
            plot(g, xc - x, yc - y, 1);

            x += 1;
            Dx += twoB2;
            D += Dx + b2;

            if (D >= 0) {
                y -= 1;
                Dy -= twoA2;
                D -= Dy;
            }
        }

        x = a;
        y = 0;
        D = Math.round(a2 - b2 * a + b2 / 4);
        Dx = twoB2 * x;
        Dy = 0;

        while (Dx >= Dy) {

            plot(g, xc + x, yc + y, 1);
            plot(g, xc + x, yc - y, 1);
            plot(g, xc - x, yc + y, 1);
            plot(g, xc - x, yc - y, 1);

            y += 1;
            Dy += twoA2;
            D += Dy + a2;

            if (D >= 0) {
                x -= 1;
                Dx -= twoB2;
                D -= Dx;
            }
        }
    }

    public void bez(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { //E1 q1
        plotPoint(g, x1, y1, x2, y2, x3, y3, x4, y4);
        bezier(g, x1, y1, x2, y2, x3, y3, x4, y4);
    }
    private void plot(Graphics g, int x, int y,int d){
    
        // g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        g.fillRect(x, y, d, d);
    }
    public void plotPoint(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        g.setColor(Color.red);
        plot(g, x1, y1, 4);
        g.setColor(Color.green);
        plot(g, x2, y2, 4);
        g.setColor(Color.blue);
        plot(g, x3, y3, 4);
        g.setColor(Color.pink);
        plot(g, x4, y4, 4);
        g.setColor(Color.BLACK);
    }
    public void bezier(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) { //E1 q1
        
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;
            int x = (int) (Math.pow((1 - t), 3) * x1 + 3 * t * Math.pow((1 - t), 2) * x2
                    + 3 * Math.pow((t), 2) * (1 - t) * x3 + Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 + 3 * t * Math.pow((1 - t), 2) * y2
                    + 3 * Math.pow((t), 2) * (1 - t) * y3 + Math.pow(t, 3) * y4);

            plot(g, x, y, 1);
        }

    }
    public BufferedImage floodFill(BufferedImage m, int x, int y, Color target_colour, Color replacement_colour) {//E3 q1
        Queue<Point> queue = new LinkedList<Point>();
        Graphics2D g3 = m.createGraphics();

        if (m.getRGB(x, y) == target_colour.getRGB()) {
            g3.setColor(replacement_colour);
            plot(g3, x, y, 1);
            queue.add(new Point(x, y));
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // south
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x, p.y + 1, 1);
                queue.add(new Point(p.x, p.y + 1));
            }
            // north
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x, p.y - 1, 1);
                queue.add(new Point(p.x, p.y - 1));
            }
            // east
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x + 1, p.y, 1);
                queue.add(new Point(p.x + 1, p.y));
            }
            // west
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == target_colour.getRGB()) {
                g3.setColor(replacement_colour);
                plot(g3, p.x - 1, p.y, 1);
                queue.add(new Point(p.x - 1, p.y));
            }
        }
        return m;
    }
    public void DDALine(int x1, int y1, int x2, int y2,Graphics g,int d){
        d=2;
        double dx = x2-x1;
        double dy = y2-y1;
        double x = Math.min(x1, x2), y = Math.min(y1, y2);
        // double x=0,y=0;
        double m = dy/dx;
       if(m <= 1 && m >= 0){
            for (x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                y =  y+m;
                plot(g, (int)Math.round(x), (int)Math.round(y),d);
            }
       }else if(m<0&&m>=-1){
            for (x = Math.max(x1, x2); x >= Math.min(x1, x2); x--) {
                y =  y-m;
                plot(g, (int)Math.round(x), (int)Math.round(y),d);
            }
        }else if(m>1){
            for (y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                x =  x+(1/m);
                plot(g, (int)Math.round(x), (int)Math.round(y),d);
            }
        }else{
            for (y = Math.max(y1, y2); y >= Math.min(y1, y2); y--) {
                x =  x-(1/m);
                plot(g, (int)Math.round(x), (int)Math.round(y),d);
            }
        } 
    }
    public void rabbit(Graphics g2,BufferedImage buff){
        g2.setColor(Color.black);
        bezier(g2, 210+20, 200-10+25, 110+20, -10-5+25, 260+20, -10-5+25, 255+20, 185-5+25);
        g2.setColor(Color.pink);
        bezier(g2, 220+20, 190-5+25, 140+20, 30-5+25, 240+20, 30-5+25, 240+20, 185-5+25);
        bezier(g2, 220+20, 190-5+25, 230+20, 193-5+25, 230+20, 193-5+25, 240+20, 185-5+25);
        
        buff = floodFill(buff, 242, 180+25, Color.gray, Color.pink);
        //ear right
        g2.setColor(Color.black);
        bezier(g2, 390-20, 200-10+25, 490-20, -10-5+25, 340-20, -10-5+25, 345-20, 185-5+25);
        g2.setColor(Color.pink);
        bezier(g2, 380-20, 190-5+25, 460-20, 30-5+25, 360-20, 30-5+25, 360-20, 185-5+25);
        bezier(g2, 380-20, 190-5+25, 370-20, 193-5+25, 370-20, 193-5+25, 360-20, 185-5+25);
        buff = floodFill(buff, 359, 180+25, Color.gray, Color.pink);
        //between ear
        g2.setColor(Color.black);
        bezier(g2, 255+20, 185-5+25, 285, 175+25, 315, 175+25, 345-20, 185-5+25);
        //head left
        bezier(g2, 230, 190+25, 185, 210+25, 160, 245+25, 160, 300+25);
        //head right
        bezier(g2, 370, 190+25, 415, 210+25, 440, 245+25, 440, 300+25);
        //under face
        bezier(g2, 160, 300+25, 25, 440+25, 575, 440+25, 440, 300+25);
        // eyes left
        
        DDALine(235, 290-10+25, 260, 300-10+25, g2, 5);
        DDALine(235, 300-10+25, 260, 300-10+25, g2, 5);
        // eyes right
        DDALine(365, 290-10+25, 340, 300-10+25, g2, 5);
        DDALine(365, 300-10+25, 340, 300-10+25, g2, 5);

        // nose
        bezier(g2, 290, 300-10+25, 295, 295-10+25, 305, 295-10+25, 310, 300-10+25);
        bezier(g2, 290, 300-10+25, 295, 305-10+25, 305, 305-10+25, 310, 300-10+25);
        buff = floodFill(buff, 300, 300-10+25, Color.gray, Color.black);
        //cheek left
        g2.setColor(Color.pink);
        bezier(g2, 180, 330+25, 180, 300+25, 230, 300+25, 230, 330+25);
        bezier(g2, 180, 330+25, 180, 360+25, 230, 360+25, 230, 330+25);
        buff = floodFill(buff, 185, 330+25, Color.gray, Color.pink);
        //cheek right
        g2.setColor(Color.pink);
        bezier(g2, 420, 330+25, 420, 300+25, 370, 300+25, 370, 330+25);
        bezier(g2, 420, 330+25, 420, 360+25, 370, 360+25, 370, 330+25);
        buff = floodFill(buff, 410, 330+25, Color.gray, Color.pink);
        
        //between cheek
        // g2.setColor(Color.black);
        g2.setColor(new Color(255,94,74));
        DDALine(240, 320-10+25, 239, 325-10+25, g2, 3); // 1
        DDALine(245, 320-10+25, 245, 325-10+25, g2, 3); // 2
        

        DDALine(355, 320-10+25, 355, 325-10+25, g2, 3); // 3
        DDALine(360, 320-10+25, 361, 325-10+25, g2, 3); // 4
        // g2.setColor(new Color(250,78,78));
        // g2.setColor(new Color(250,250,250));
        // on cheek left
        bezier(g2, 190, 340-3+25, 191-2, 341-3+25, 201, 316+3+25, 200, 315+3+25);
        bezier(g2, 190+10, 340+25, 191+10, 341+25, 201+10+2, 316+3+25, 200+10, 315+3+25);
        bezier(g2, 190+20, 340+3+25, 191+20+2, 341+3+25, 201+20, 316+9+25, 200+20, 315+9+25);
        
        // on cheek left
        bezier(g2, 410, 340-3+25, 409+2, 341-3+25, 399, 316+3+25, 400, 315+3+25);
        
        bezier(g2, 410-10, 340+25, 409-10-2, 341+25, 399-10-2, 316+3+25, 400-10, 315+3+25);
        bezier(g2, 410-20, 340+3+25, 409-20-2, 341+3+25, 399-20, 316+9+25, 400-20, 315+9+25);
        
        // g2.setColor(Color.white);
        // plot(g2, 400, 185, 2);
        buff = floodFill(buff, 300, 185, Color.gray, Color.white);
        buff = floodFill(buff, 305, 285, Color.gray, Color.white);
    }

    
}
