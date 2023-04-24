import java.util.Scanner;
import java.util.Stack;

class Node {
    private char data;
    public Node leftChild;
    public Node rightChild;

    public Node(char x) {
        data = x;
    }
    public void displayNode() {
        System.out.print(data);
    }
}
public class ExC {
    private Stack<Character> charStk;
    private String infix;
    private String output = "";

    public ExC(String infix) {
        this.infix = infix;
        this.charStk = new Stack<Character>();
    }

    public String inToPost() {
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            switch (c) {
                case '+':
                case '-':
                    gotOperator(c, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(c, 2);
                case '(':
                    charStk.push(c);
                    break;
                case ')':
                    gotParenthesis();
                    break;
                default:
                    output = output + c;
            }
        }
        while (!charStk.isEmpty())
            output = output + charStk.pop();
        return output;
    }

    private void gotOperator(char opThis, int prec1) {
        while (!charStk.isEmpty()) {
            char opTop = charStk.pop();
            if (opTop == '(') {
                charStk.push(opTop);
                break;
            } else {
                int prec2;
                prec2 = (opTop == '+' || opTop == '-') ? 1 : 2;
                if (prec2 < prec1) {
                    charStk.push(opTop);
                    break;
                } else {
                    output = output + opTop;
                }
            }
        }
        charStk.push(opThis);
    }

    private void gotParenthesis() {
        while (!charStk.isEmpty()) {
            char c = charStk.pop();
            if (c == '(')
                break;
            else
                output = output + c;
        }
    }
    public static void main(String[] args) {
        String c = "y";
        // DataInputStream inp = new DataInputStream(System.in);
        Scanner sc = new Scanner(System.in);
        while (c.equals("y")) {
            Tree tree = new Tree();
            System.out.println("Enter the Expression");
            String infix = sc.nextLine();
            tree.insert(infix);
            tree.traverses(1);
            System.out.println();

            System.out.println("Enter y to continue");
            c = sc.nextLine();
        }
        sc.close();
    }
}

class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void insert(String infix) {
        ExC converter = new ExC(infix);
        String postfix = converter.inToPost();
        Stack<Node> nodeStk = new Stack<>();
        postfix = postfix + "#";
        int i = 0;
        char symbol = postfix.charAt(i);
        Node newNode;
        while (symbol != '#') {
            if (Character.isLetterOrDigit(symbol)) {
                newNode = new Node(symbol);
                nodeStk.push(newNode);
            } else if (
                symbol == '+' || symbol == '-' || symbol == '/'
                || symbol == '*'
            ) {
                Node ptr1 = nodeStk.pop();
                Node ptr2 = nodeStk.pop();
                newNode = new Node(symbol);
                newNode.leftChild = ptr2;
                newNode.rightChild = ptr1;
                nodeStk.push(newNode);
            }
            symbol = postfix.charAt(++i);
        }
        root = nodeStk.pop();
    }

    private void preOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot)
    {
        if (localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }

    public void traverses(int type) {
        switch (type) {
            case 1:
                System.out.println("Preorder Traversal");
                preOrder(root);
                break;
            case 2:
                System.out.println("Inorder Traversal");
                inOrder(root);
                break;
            case 3:
                System.out.println("Postorder Traversal");
                postOrder(root);
                break;
            default:
                System.out.println("Invaild choice");
        }
    }

}

