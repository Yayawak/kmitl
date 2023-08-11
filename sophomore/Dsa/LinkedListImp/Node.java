public class Node
{
    public int data;
    public Node next;

    public Node(int data)
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