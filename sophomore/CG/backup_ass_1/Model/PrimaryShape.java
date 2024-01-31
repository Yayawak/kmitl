package backup_ass_1.Model;

import java.awt.Color;

public abstract class PrimaryShape {
    public int id;
    public Color color = Color.black;
    public LineWidthState widthState = LineWidthState.small;

    public abstract void draw();

    @Override
    public String toString() {
        return String.format("color : %s", color);
    }
}
