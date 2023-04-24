import java.util.*;


class Node {
    char data;
    Node left, right;
};

class ExpTree {
    Node root;
    private static final int count = 5;
    public ExpTree(Node root) {
        this.root = root;
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    private void printTree(Node root, int space) {
        if (root == null)
            return;
        space += count;
        // System.out.println("/");
        printTree(root.right, space);
        // System.out.println("\n");
        for (int i = count; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(root.data + "\n");
        printTree(root.left, space);
    }
    public void printTree() {
        printTree(root, 0);
    }


}

public class ExpCvtV2 {
    static Node newNode(char c) {
        Node n = new Node();
        n.data = c;
        n.left = n.right = null;
        return n;
    }
    static Node build(String s) {
        Stack<Node> stN = new Stack<>();
        Stack<Character> stC = new Stack<>();
        Node t, t1, t2;
        int[] p = new int[123];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stC.add(s.charAt(i));
            }
            else if (Character.isAlphabetic(s.charAt(i))) {
                t = newNode(s.charAt(i));
                stN.add(t);
            } else if (p[s.charAt(i)] > 0) {
                while (!stC.isEmpty() && stC.peek() != '('
                        && ((s.charAt(i) != '^' && p[stC.peek()] >= p[s.charAt(i)])
                                || (s.charAt(i) == '^'
                                        && p[stC.peek()] > p[s.charAt(i)]))) {

                    t = newNode(stC.peek());
                    stC.pop();
                    t1 = stN.peek();
                    stN.pop();
                    t2 = stN.peek();
                    stN.pop();
                    t.left = t2;
                    t.right = t1;
                    stN.add(t);
                }
                stC.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!stC.isEmpty() && stC.peek() != '(') {
                    t = newNode(stC.peek());
                    stC.pop();
                    t1 = stN.peek();
                    stN.pop();
                    t2 = stN.peek();
                    stN.pop();
                    t.left = t2;
                    t.right = t1;
                    stN.add(t);
                }
                stC.pop();
            }
        }
        t = stN.peek();
        return t;
    }

    static void postfixPrinting(Node root) {
        if (root != null) {
            postfixPrinting(root.left);
            postfixPrinting(root.right);
            System.out.print(root.data);
        }
    }


    // Driver code
    public static void main(String[] args) {
        // String s = "(a^b^(c/d/e-f)^(x*y-m*n))";
        // String s = "a*b+c";
        // String s = "a*b+c";
        // String s = "a*b*c*d*e";
        String s = "a*b*c*d*e";
        // String s = "a*b+c/d";
        s = "(" + s;
        s += ")";
        Node root = build(s);
        ExpTree expTree = new ExpTree(root);
        // System.out.println("exp size : " + expTree.treeSize());
        System.out.println("exp t height : " + expTree.height());

        // Function call
        postfixPrinting(root);
        // buildTreeFromPostOrder(root);

        System.out.println("-----------------------------");
        System.out.println("print tree ");
        expTree.printTree();
        System.out.println("-----------------------------");
    }
}

// This code is contributed by aashish1995

