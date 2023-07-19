public class State<T> extends Vertex<T> {
    boolean isInitialState;
    boolean isFinalState;
    public State(T value, boolean isInitialState, boolean isFinalState) {
        super(value);
        // this.value = value;
        this.isInitialState = isInitialState;
        this.isFinalState = isFinalState;
    }
}
