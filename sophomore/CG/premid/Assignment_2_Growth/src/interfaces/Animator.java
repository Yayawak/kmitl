package src.interfaces;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Animator {
    protected Color color = Color.black;
    protected Point pos = new Point(0, 0);
    protected Point vel = new Point(0, 0);
    protected long startTime = System.currentTimeMillis();
    protected long prevTime = startTime;

    public void update(double dt)
    {
        pos = new Point(
            // pos.x + (int)(vel.x * dt),
            // pos.y + (int)(vel.y * dt)
            pos.x + (int)Math.round(vel.x * dt),
            pos.y + (int)Math.round(vel.y * dt)
        );
        // System.out.println("abc");
    }
    public abstract void draw(Graphics2D gg);








    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Point getPos() {
        return pos;
    }
    public void setPos(Point pos) {
        this.pos = pos;
    }
    public Point getVel() {
        return vel;
    }
    public void setVel(Point vel) {
        this.vel = vel;
    }

    // public void shake()
    // {
    // }

    
}