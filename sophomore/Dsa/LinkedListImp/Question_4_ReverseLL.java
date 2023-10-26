package LinkedListImp;
public class Question_4_ReverseLL {
    public static void Reverse(MyLinkedList ll)
    {
        Node cur = ll.head;
        Node prev = null;
        Node next = null;
        while (cur != null)
        {
            // 1 -> 2 -> 3 -> 4
            // rev
            // 1 <- 2 <- 3 <- 4

            //NOTE cur = prev;
            //NOTE next = cur.next;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ll.head = prev;
    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        for (int i = 0; i < 5; i++)
        {
            ll.add(i);
        }
        System.out.println(ll);
        Reverse(ll);
        System.out.println(ll);
    }


}
