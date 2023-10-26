
public interface StackBehaviorGeneric<T> {
    public void push(T d);
    public T pop();
    public T top();
    public boolean isFull();
    public boolean isEmpty();
    public String toString();
}
