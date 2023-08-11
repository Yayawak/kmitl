public class Question_1_RotLL {
    public static void Rotate(MyLinkedList list, int k)
    {
        // if (k <= 0)
        //     return;
        // Node tail = list.getLast();
        // Node cur = list.head;
        // for (int i = 0; i < k - 1 && cur != null; i++)
        //     cur = cur.next;
        // if (cur == null || cur.next == null)
        //     // k is > len(list) -> dont rot
        //     return;
        // Node newHead = cur.next;
        // cur.next = null;
        // list.head = newHead;
        // tail.next = list.head;

        // -----------------------
        // if (list.head == null || list.head.next == null)
        //     return;
        // Node tail = list.getLast();
        // tail.next = list.head;
        // list.head = tail.next;
        // tail.next = null;
        // -----------------------
        for (int i = 0; i < k; i++)
        {
            if (list.head == null || list.head.next == null)
                return;
            Node cur = list.head;
            Node newTail = null;
            Node oldTail = list.getLast();

            while (cur.next != null)
            {
                newTail = cur;
                cur = cur.next;
            }
            // System.out.println("New tail : " + newTail);
            newTail.next = null;
            oldTail.next = list.head;
            list.head = oldTail;
        }
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        for (int i = 0; i < 5; i++)
        {
            ll.add(i);
        }
        System.out.println(ll);
        Rotate(ll, 3);
        System.out.println(ll);
    }
}
