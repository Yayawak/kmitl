package Stack;

import java.util.LinkedList;

import LinkedListImp.MyLinkedList;
import LinkedListImp.Node;

public class StackLinkedList implements StackBehavior {

    // private LinkedList<Integer> ll = new LinkedList<>();
    private MyLinkedList ll = new MyLinkedList();
    // private Node topNode;

    public StackLinkedList()
    {
        // topNode = ll.head;
    }

    @Override
    public void push(int d) {
        Node newHead = new Node(d);
        // System.out.println("Pusing " + d);
        if (ll.head == null)
        {
            // System.out.println("E");
            ll.insert(d);
            // System.out.println(ll);
            return;
        }
        Node oldHead = ll.head;
        ll.head = newHead;
        ll.head.next = oldHead;
        // System.out.println("ll.head.next  = " + ll.head.next);
    }

    @Override
    public int pop() {
        int ret = ll.head.data;
        ll.head = ll.head.next;
        return ret;
    }

    @Override
    public int top() {
        return ll.head.data;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return ll.size() == 0 || ll.head == null;
    }

    @Override
    public String toString() {
        // while (ll.)
        // Node cur = ll.head;
        // StringBuilder sb = new StringBuilder("");
        // while (cur != null)
        // {
        //     // System.out.print(cur.data + " ");
        //     sb.append(cur.data + " ");
        //     cur = cur.next;
        // }
        // return sb.toString();
        return "TOP : " + ll.toString();
    }
}
