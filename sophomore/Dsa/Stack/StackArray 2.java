package Stack;

public class StackArray implements StackBehavior {

    private final int maxsize = 20;
    private int topIndex = 0;
    // public int[] array;
    public int[] array = new int[maxsize];

    public StackArray()
    {
    }

    @Override
    public void push(int d) {
        assert !isFull();
        array[topIndex++] = d;
    }

    @Override
    public int pop() {
        assert !isEmpty();
        int ret = array[topIndex - 1];
        array[topIndex - 1] = -99;
        topIndex--;
        return ret;
    }

    @Override
    public int top() {
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
            int tmp = array[i];
            sb.append(tmp + " ");
        }
        return sb.toString();
    }
}
