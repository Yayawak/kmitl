public class TransitionEdge<T> extends Edge<T> {
    State<T> src;
    State<T> dst;

    public TransitionEdge(State<T> src, State<T> dst, int weight) {
        super(src, dst, weight);
        this.src = src;
        this.dst = dst;
    }

}
