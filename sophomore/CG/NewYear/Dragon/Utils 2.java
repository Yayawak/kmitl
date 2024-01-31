package NewYear.Dragon;

import java.awt.Point;
import java.util.List;

public class Utils {
    public static void ShiftPoints(List<Point> ps, Point offsetVector)
    {
        for (var p : ps)
        {
            p.translate(offsetVector.x, offsetVector.y);
        }
    }
}
