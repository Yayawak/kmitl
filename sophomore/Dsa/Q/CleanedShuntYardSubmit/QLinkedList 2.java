
public class QLinkedList<T> implements QBehavior<T> {

    private NodeGeneric<T> head;
    private NodeGeneric<T> tail;

    @Override
    public void enq(T value) {
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        if (isEmpty())
        {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    @Override
    public T deq() {
        T ret = head.data;
        head = head.next;
        return ret;
    }

    @Override
    public T front() {
        return head.data;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        NodeGeneric<T> cur = head;
        sb.append("HEAD : ");
        while (cur != null)
        {
            sb.append(cur.data + " ");
            cur = cur.next;
        }
        sb.append(" : TAIL");
        return sb.toString();
    }
}
