package Circle;

public class Circle_65988 {
    double radius = 1.0;
    Circle_65988() { }
    Circle_65988(double radius)
    {
        this.radius = radius;
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
