package Coin;

public class Coin_65988 {
    double radius = 1.0;
    String colorHead = "red";
    String colorTail = "red";

    void flip()
    {
        String tempColor = colorHead;
        colorHead = colorTail;
        colorTail = tempColor;
    }

    void setColor(String color)
    {
        colorHead = color;
    }

    String getColor()
    {
        return colorHead;
    }

    Coin_65988() { }

    Coin_65988(double radius, String colorH, String colorT)
    {
        this.radius = radius;
        colorHead = colorH;
        colorTail = colorT;
    }

    double getRadius()
    {
        return radius;
    }

    void setRadius(double radius)
    {
        this.radius = radius;
    }

    double getArea()
    {
        return 2 * Math.PI * radius;
    }

    double getCircumference()
    {
        return radius * 2 * Math.PI;
    }

    public String toString()
    {
        return "Circle[radius=" + radius + "]";
    }

}
