import java.util.Stack;

class Node {
    char value;
    Node left, right;

    Node(char item) {
        value = item;
        left = right = null;
    }
}

// expression Tree
class Test {
    static boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            return true;
        }
        return false;
    }

    static Node constructTree(char postfix[]) {
        Stack<Node> stack = new Stack<Node>();
        Node t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
                stack.push(t);
            } else {
                t = new Node(postfix[i]);

                t1 = stack.pop();
                t2 = stack.pop();

                t.right = t1;
                t.left = t2;

                stack.push(t);
            }
        }

        t = stack.peek();
        stack.pop();

        return t;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    public static void main(String args[]) {
        char postfix[] = {'A', 'B', '+', 'C', 'D', '-', '*', 'E', '+', 'F', '/'};
        Node root = constructTree(postfix);
        System.out.print("Infix expression is: ");
        inorder(root);
    }
}

