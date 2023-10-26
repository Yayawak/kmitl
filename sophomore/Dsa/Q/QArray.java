package Q;

public class QArray<T> implements QBehavior<T> {

    private final int maxSize = 20;
    private T[] array = (T[]) new Object[maxSize];
    int head = 0;
    int tail = 0;

    @Override
    public void enq(T value) {
        array[tail] = value;
        tail = (tail + 1) % maxSize;
    }

    @Override
    public T deq() {
        T ret = array[head];
        head = (head + 1) % maxSize;
        return ret;
    }

    @Override
    public T front() {
        return array[head];
    }

    @Override
    public boolean isFull() {
        return ((tail + 1) % maxSize) == head;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        int cur = head;

        sb.append("HEAD : ");
        if (head == tail)
        {
            sb.append(array[head]);
            sb.append(" : TAIL");
        }
        else
        {
            while (cur != tail)
            {
                sb.append(array[cur] + " ");
                cur = (cur + 1) % maxSize;
            }
        }
        sb.append(" : TAIL");
        return sb.toString();
    }

}
