package src.helpers;

import java.awt.Point;

public class Coordinator {
    public static Point getRandomPoint(int width, int height)
    {
        int x = (int)(Math.random() * width);
        int y = (int)(Math.random() * height);
        if (x > width || y > height || x < 0 || y < 0)
            return getRandomPoint(width, height);
        return new Point(x, y);
    }

    public static double getAngle(Point source, Point target) {
        double angle = (float) Math.toDegrees(Math.atan2(target.y - source.y, target.x - source.x));
    
        if(angle < 0){
            angle += 360;
        }
    
        return angle;
    }
}
