package Assignment_1_Newyear.Model;

import java.awt.Color;

public abstract class PrimaryShape {
    public int id;
    public Color color;
    public abstract void draw();

    @Override
    public String toString() {
        return String.format("color : %s", color);
    }
}
