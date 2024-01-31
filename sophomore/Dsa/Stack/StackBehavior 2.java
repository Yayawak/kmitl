package Stack;

public interface StackBehavior {
    public void push(int d);
    public int pop();
    public int top();
    public boolean isFull();
    public boolean isEmpty();
    public String toString();
}
