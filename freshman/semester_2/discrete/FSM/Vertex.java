public class Vertex<T> {
    T value;

    public Vertex(T value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null || getClass() != obj.getClass()) {
            return false;
        }
        Vertex<?> v2 = (Vertex<?>) obj;
        return value.equals(v2.value);
    }

    @Override
    public String toString() {
        // return "Vertex [value=" + value + ", isInitialState=" + isInitialState + ", isFinalState=" + isFinalState
        //         + "]";
        return String.format("Vertex %s", value);

    }

}
