package Stack;

public class Tester {
    private static void testStackArray()
    {
        StackArray sa = new StackArray();
        sa.push(1);
        sa.push(2);
        sa.push(3);
        sa.push(4);
        sa.push(5);

        System.out.println("After pushed.");
        System.out.println(sa.toString());

        // int p = sa.pop();
        // System.out.println("poped is " + p );
        while (!sa.isEmpty())
        {
            int tmp = sa.pop();
            System.out.println("poped is " + tmp);
        }

        System.out.println("Stack Overflow ....");
        for (int i = 0; i < 25; i++)
        {
            sa.push(i);
        }
        System.out.println(sa);
    }

    public static void testStackLL()
    {
        StackLinkedList sll = new StackLinkedList();
        for (int i = 0; i < 10; i++)
        {
            sll.push(i * 5);
        }
        System.out.println(sll);
        System.out.println("Testing POP...");
        while (!sll.isEmpty())
        {
            int tmp = sll.pop();
            System.out.print(tmp + " ");
        }
    }

    public static void main(String[] args) {
        // testStackArray(); // worked
        // testStackLL(); //worked
    }
}
