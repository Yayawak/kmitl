package src.Components.Food;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import src.Libs.BZ;
import src.Libs.BazierAlgorithm;
import src.Libs.CircleAlgorithms;
import src.Libs.Drawing;
import src.interfaces.Animator;

public class Food extends Animator {

    public Food(Color color)
    {
        this.color = color;
    }

    public Food(Color color, Point pos)
    {
        this.color = color;
        this.pos = pos;
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }

    @Override
    public void draw(Graphics2D gg) {

    }
    
}
