package NewYear.Dragon.UtilsTrigs;

import NewYear.Dragon.Tail.Triangle;

public class Node {

    public Triangle triangle;
    public int index;
    public Node(Triangle triangle, int index) {
        this.triangle = triangle;
        this.index = index;
        // System.out.println(index);
    }


    @Override
    public String toString() {
        var trigS = triangle.toString();
        var s = String.format("Tail Index[%d] : Trig[%s]", index, trigS);
        return s;
    }

}
