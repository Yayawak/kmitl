package Mst;

public class PrimEdge {
    int u;
    int v;
    int weight;


    public PrimEdge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }


    public int getU() {
        return u;
    }


    public int getV() {
        return v;
    }


    public int getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return "PrimEdge [u=" + u + ", v=" + v + ", weight=" + weight + "]";
    }

}
