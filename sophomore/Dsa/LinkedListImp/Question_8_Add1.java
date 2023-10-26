package LinkedListImp;
public class Question_8_Add1 {
    public static void AddOne(MyLinkedList ll)
    {
        System.out.println(ll);
        Question_4_ReverseLL.Reverse(ll);
        System.out.println(ll);

        Node cur = ll.head;
        Node tmp = null;
        int sum = 0;
        int carry = 1;

        while (cur != null)
        {
            // int value = cur.data;

            // sum = cur.data + 1;
            sum = cur.data + carry;
            carry = (sum >= 10) ? 1 : 0;
            sum %= 10;
            cur.data = sum;

            tmp = cur;
            cur = cur.next;
        }
        if (carry > 0)
            tmp.next = new Node(carry);
        System.out.println(ll);
        Question_4_ReverseLL.Reverse(ll);
        System.out.println(ll);

    }

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        // ll.add(1);
        // ll.add(9);
        // ll.add(9);
        // ll.add(9);
        int A[] = {1, 9, 9, 8};
        for (int i = 0; i < A.length; i++)
        {
            ll.add(A[i]);
        }
        // for (int i)
        // for (int i = 0; i < 5; i++)
        // {
        //     ll.add(i);
        // }
        AddOne(ll);
    }
}
