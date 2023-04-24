import java.nio.file.StandardOpenOption;
import java.util.Stack;

// import Cop.nptr;

public class ExpressionTree {
    static class Node {
        char data;
        Node left;
        Node right;
    }

    static Node newNode(char c) {
        Node n = new Node();
        n.data = c;
        n.left = n.right = null;
        return n;
    }

    static Node build(String s) {
        Stack<Node> stackNodes = new Stack<>();
        Stack<Character> stackChars = new Stack<>();
        Node t, t1, t2;

        int[] p = new int[127];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;


        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(') {
                stackChars.add(s.charAt(i));
            }
            // * push operands
            else if (Character.isAlphabetic(s.charAt(i))) {
                t = newNode(s.charAt(i));
                stackNodes.add(t);
            }
            else if (p[s.charAt(i)] > 0){
                // * If an operator with lower of same associativity appears
                while (
                    !stackChars.isEmpty()
                    && stackChars.peek() != '('
                    && (
                        (s.charAt(i) != '^' && p[stackChars.peek()] >= p[s.charAt(i)])
                        ||
                        (s.charAt(i) == '^' && p[stackChars.peek()] > p[s.charAt(i)])
                    )
                ) {
                    // * retrieve top element from char stack
                    // t = newNode(stackChars.peek());
                    t = newNode(stackChars.pop());
                    // stackChars.pop();

                    // * retrieve top element of node stack
                    t1 = stackNodes.pop();


                    // * retirve another top element of node stack
                    t2 = stackNodes.pop();

                    // * update the tree
                    t.left = t2;
                    t.right = t1;

                    // * push the temp node to the node stack
                    stackNodes.add(t);
                }

                // * push s[i] t char stack to do next iteration
                stackChars.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')') {
                while (!stackChars.isEmpty() && stackChars.peek() != '(') {
                    // t = newNode(stackChars.peek());
                    t = newNode(stackChars.pop());
                    t1 = stackNodes.pop();
                    t2 = stackNodes.pop();

                    t.left = t2;
                    t.right = t1;
                }
                stackChars.pop();
            }
        }
        t = stackNodes.peek();
        return t;
    }

    private static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }

    public static void displayTree(Node root, String indent, String prefix) {
        if (root != null) {
            System.out.println(indent + prefix + root.data);
            displayTree(root.left, indent + "  ", "/ ");
            displayTree(root.right, indent + "  ", "\\ ");
        }
    }
    public static void main(String[] args) {
        String s = "a+b";
        // String s = "(a^b^(c/d/e-fA))";
        Node root = build(s);

        postorder(root);
        // displayTree(root, "", "");
        displayTree(root, "", "");
    }
}
