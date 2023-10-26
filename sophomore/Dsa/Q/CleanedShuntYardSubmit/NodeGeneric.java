
public class NodeGeneric<T>
{
    public T data;
    public NodeGeneric<T> next;

    public NodeGeneric(T data)
    {
        this.data = data;
    }

    @Override
    public String toString() {
        // return "Node [data=" + data + ", next=" + next + "]";
        // return String.format("[%d,%s]\t", data, next);
        return String.format("[%d]", data);
    }
    
}