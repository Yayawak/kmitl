package Q;

public class QTester {
    public static void testQArray()
    {
        QArray<String> q = new QArray<String>();
        q.enq("a");
        q.enq("b");
        q.enq("c");
        q.enq("d");
        q.enq("e");

        System.out.println("Enqueue abcde");
        System.out.println(q);

        System.out.println("Dequeuing ...");
        while (!q.isEmpty())
        {
            System.out.print(q.deq() + " <- ");
        }
    }

    public static void testQLL()
    {
        QLinkedList<String> q = new QLinkedList<>();
        q.enq("a");
        q.enq("b");
        q.enq("c");
        q.enq("d");
        q.enq("e");

        System.out.println("Enqueue abcde");
        System.out.println(q);

        System.out.println("Dequeuing ...");
        while (!q.isEmpty())
        {
            System.out.print(q.deq() + " <- ");
        }

    }

    public static void testShuntYardAlgorithm()
    {
        ShuntingYardInfixNotation infixToPostfixConverter = new ShuntingYardInfixNotation();
        // String infix = "5 + 3";
        // String infix = "5 + 3 4 4 * +";
        // String infix = "3 + 4 * ( 7 - 5 )";
        String infix = "5 + 3 * 6 / ( 7 + 1 - 2 * 3 )";
        System.out.println(infixToPostfixConverter.getReversePolishNotation(infix));
    }


    public static void main(String[] args) {

        // testQLL();
        // testQArray();
        testShuntYardAlgorithm();
    }
}
