package LinkedListImp;

public class MyLinkedList {

    public Node head = null;;

    public MyLinkedList()
    {
    }

    public int size()
    {
        int n = 0;
        Node cur = head;
        while (cur != null)
        {
            n++;
            cur = cur.next;
        }
        return (n);
    }

    public Node getLast()
    {
        if (head == null)
        {
            System.out.println("head is null");
            return head;
        }
        Node cur = head;
        while (cur.next != null)
            cur = cur.next;
        return (cur);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("");
        Node cur = head;
        while (cur != null)
        {
            sb.append(cur.toString() + " -> ");
            if (cur.next == null)
                sb.append("null");
            cur = cur.next;
        }
        return sb.toString();
    }

    public void add(int data)
    {
        Node n = new Node(data);
        if (head == null)
        {
            head = n;
            return;
        }
        getLast().next = n;
    }

    // insert in ordered linked list
    // let's say we want to insert 3 which is middle of 12345
    public void insert(int data)
    {
        Node newNode = new Node(data);
        if (head == null || data < head.data)
        {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node cur = head;
        while (cur.next != null && cur.next.data < data)
        {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
    }


    public Node find(int data)
    {
        Node cur = head;
        while (cur != null)
        {
            if (cur.data == data)
            {
                return (cur);
            }
            cur = cur.next;
        }
        System.out.println("data not found in linked list");
        return (null);
    }

    public void delete(int data)
    {
        Node cur = head;
        if (cur.data == data)
        {
            head = cur.next;
            return;
        }
        while (cur.next != null && cur.next.data != data)
        {
            cur = cur.next;
        }
        if (cur.next != null)
            cur.next = cur.next.next;
        else
            System.out.println("item to delete not found in liked list : " + data);
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        System.out.println("Before insertion");
        ll.add(1);
        ll.add(2);
        // ll.add(3);
        ll.add(4);
        ll.add(5);
        // ll.add(6);
        ll.add(7);
        System.out.println(ll);
        System.out.println("After insertion");
        // ll.insert(3);
        ll.insert(6);
        System.out.println(ll);

        System.out.println("After deletion");
        ll.delete(-1);
        ll.delete(4);
        // ll.delete(8);
        // ll.delete(7);
        ll.delete(1);
        System.out.println("Size = " + ll.size());
        System.out.println(ll);


        // System.out.println(ll.find(3));
        // System.out.println(ll.getLast());
    }
    // public
}
