public class Circle {
    int x;
    private int y;
    Circle() {

    }
    Circle(int p, int q) {
        x = p;
        y = q;
    }

    @Override
    public String toString() {
        // StringBuilder.
        // String
        // return "Circle [" + x + "," + y + "]";
        return String.format("Circle [x=%d, y=%d]",
            x, y
        );
    }
}
