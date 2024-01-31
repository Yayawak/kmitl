package backup_ass_1.Controller;

import java.awt.Color;

public class ColorUtils {
    public static String rgbToHex(Color color)
    {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        var rr = String.valueOf(Integer.toHexString(r));
        var gg = String.valueOf(Integer.toHexString(g));
        var bb = String.valueOf(Integer.toHexString(b));
        if (rr.equals("0"))
            rr = "00";
        if (gg.equals("0"))
            gg = "00";
        if (bb.equals("0"))
            bb = "00";
// * this is ok (good interpreted) don't cut 00 to 0
// curve, 99, #ff9900, medium, 130, 31, 130, 408, 75, 196, 286, 230
// * this is not ok (bad interpreted)
// curve, 99, #ff990, medium, 130, 31, 130, 408, 75, 196, 286, 230 
        String hexColor = "#" + rr + gg + bb;
        return hexColor;
    }
}
