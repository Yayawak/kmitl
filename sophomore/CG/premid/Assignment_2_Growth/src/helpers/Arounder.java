package src.helpers;

import java.awt.Graphics2D;
import java.awt.Point;

public class Arounder {
    
    public static void scaleAround(Point center, float scaleX, float scaleY, Graphics2D gg)
    {
        gg.translate(center.x, center.y);
        gg.scale(scaleX, scaleY);
        gg.translate(-center.x, -center.y);
    }
}
