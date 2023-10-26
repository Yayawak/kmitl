
public interface QBehavior<T> {
    public void enq(T value);
    public T deq();
    public T front();
    public boolean isFull();
    public boolean isEmpty();
}
