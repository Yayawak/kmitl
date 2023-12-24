package Lab3CurveTrigFloodFill;
import java.awt.Graphics;

import Lab2LineAlgorithms.Drawing;


public class BazierAlgorithm extends Drawing {
    
    private BazierAlgorithm() {}
    
    public static void bezier(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) 
    {
        bezier(x1, y1, x2, y2, x3, y3, x4, y4, 1);
    }

    public static void bezier(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int size) { //E1 q1
        
        for (int i = 0; i <= 1000; i++) {
            double t = i / 1000.0;
            int x = (int) (Math.pow((1 - t), 3) * x1 + 3 * t * Math.pow((1 - t), 2) * x2
                    + 3 * Math.pow((t), 2) * (1 - t) * x3 + Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 + 3 * t * Math.pow((1 - t), 2) * y2
                    + 3 * Math.pow((t), 2) * (1 - t) * y3 + Math.pow(t, 3) * y4);
            drawGeneralDot(x, y, size);
            
        }

    }
}
