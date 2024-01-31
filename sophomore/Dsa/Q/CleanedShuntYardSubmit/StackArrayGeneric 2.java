
public class StackArrayGeneric<T> implements StackBehaviorGeneric<T> {

    private int maxsize = 20;
    private int topIndex = 0;
    // public int[] array;
    private T[] array = (T[]) new Object[maxsize];

    public StackArrayGeneric(int maxsize)
    {
        this.maxsize = maxsize;
    }

    public StackArrayGeneric()
    {
    }

    @Override
    public void push(T d) {
        assert !isFull();
        array[topIndex++] = d;
    }

    @Override
    public T pop() {
        assert !isEmpty();
        T ret = array[topIndex - 1];
        array[topIndex - 1] = null;
        topIndex--;
        return ret;
    }

    @Override
    public T top() {
        assert !isEmpty();
        return array[topIndex - 1];
    }

    @Override
    public boolean isFull() {
        return (topIndex ==  maxsize - 1);
    }

    @Override
    public boolean isEmpty() {
        return (topIndex == 0);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < topIndex; i++) {
            T tmp = array[i];
            sb.append(tmp + " ");
        }
        return sb.toString();
    }
}
