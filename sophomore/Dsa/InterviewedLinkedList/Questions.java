package InterviewedLinkedList;

class Node
{
    public int data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
    }
}

class LinkedList
{
    Node head;

    public LinkedList()
    {

    }

    public Node getLast()
    {
        assert head != null;

        Node current = head;
        while (current.next != null)
            current = current.next;
        return current;
    }

    public void insertLast(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            return;
        }
        getLast().next = newNode;
    }

    public void printLL()
    {
        Node n = head;

        if (n == null)
        {
            System.out.println("list has no head");
            return;
        }
        while (n != null)
        {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }
}


class RotateLinkedList
{
    public void reverseLinkedListOneTime(LinkedList L)
    {
        Node last = L.getLast();
        Node head = L.head;
        last.next = head;

        L.head = head.next;
        head.next = null;

        L.printLL();
    }

    public void reverseKTime(LinkedList L, int k)
    {
        for (int i = 0; i < k; i++)
            reverseLinkedListOneTime(L);
    }

    public void rotateV2(LinkedList L, int k)
    {
        assert k > 0;

        int i = 0;
        Node cur = L.head;
        Node oldHead = L.head;
        Node prevNewHead = L.head;
        Node last = L.head;
        while (cur.next != null)
        {
            if (i == k - 1)
            {
                prevNewHead = cur;
            }
            cur = cur.next;
            i++;
        }
        last = cur;

        L.head = prevNewHead.next;        
        prevNewHead.next = null;
        last.next = oldHead;


        L.printLL();
    }

    public void rotateV3(LinkedList L, int k)
    {
        int i = 0;
        // seperate to binary list
        Node h1 = L.head;
        // Node h2 = L.head;
        Node c = L.head;
        while (i < k)
        {
            c = c.next;
            i++;
        }
        Node h2 = c.next;
        c.next = null;

        // h1.next = h2;
        // L.head = h2;

        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.head = h1;
        l2.head = h2;

        l1.printLL();
        l2.printLL();
        // L.printLL();
    }
}

class ReverseLinkedList
{
    public void Rev(LinkedList L)
    {
        Node q, r, p;
        
        r = q = L.head;
        p = L.head.next;

        while (p.next != null)
        {
            q = p;
            p = p.next;
            q.next = r;
            r = q;
        }
        
        L.printLL();
    }
}
class RemoveDuplicationLinkedList
{
    public void removeDup(LinkedList L)
    {
        Node a = L.head;
        while (a.next != null)
        {
            Node b = a.next;
            while (b.next != null)
            {
                if (a.data == b.next.data)
                {
                    System.out.println("found duplication " + a.data);
                    b.next = b.next.next;
                }

                b = b.next;
            }
            a = a.next;
        }

        System.out.println("ok");
        L.printLL();
    }
}

public class Questions {


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        int[] A = {0, 1, 2, 3, 4, 3, 5, 6, 7, 8, 9};
        // for (int i = 1; i < 7; i++)
        for (int i = 0; i < A.length; i++)
        {
            // ll.insertLast(i * 10);
            ll.insertLast(A[i]);
        }


        ll.printLL();

        RotateLinkedList rotL = new RotateLinkedList();
        // rotL.reverseKTime(ll, 3);
        // reverseLinkedList(ll);

        // rotL.rotateV2(ll, 3);

        // rotL.rotateV3(ll, 1);
        // ll.printLL();

        ReverseLinkedList rev = new ReverseLinkedList();
        // rev.Rev(ll);

        RemoveDuplicationLinkedList rem = new RemoveDuplicationLinkedList();
        // rem.removeDup(ll);
    }
}
