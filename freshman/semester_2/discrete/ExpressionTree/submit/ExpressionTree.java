
import java.util.Stack;

class ExpressionTree
{
    private static int count = 3;
    private Node root;

    public ExpressionTree()
    {
        root = null;
    }

    public void insert(String s)
    {
        Conversion c = new Conversion(s);
        s = c.inToPost();
        Stack<Node> nodeStk = new Stack<>();
        s = s + "#";
        int i = 0;
        char symbol = s.charAt(i);
        Node newNode;
        while (symbol != '#')
        {
            if (Character.isLetterOrDigit(symbol))
            {
                newNode = new Node(symbol);
                nodeStk.push(newNode);
            } else if (symbol == '+' || symbol == '-' || symbol == '/'
                    || symbol == '*')
            {
                Node ptr1 = nodeStk.pop();
                Node ptr2 = nodeStk.pop();
                newNode = new Node(symbol);
                newNode.leftChild = ptr2;
                newNode.rightChild = ptr1;
                nodeStk.push(newNode);
            }
            symbol = s.charAt(++i);
        }
        root = nodeStk.pop();
    }
    public void traverse(int type)
    {
        switch (type)
        {
            case 1:
                // System.out.print("Preorder Traversal:-    ");
                System.out.print("Prefix Traversal:-    ");
                preOrder(root);
                break;
            case 2:
                System.out.print("Inorder Traversal:-     ");
                inOrder(root);
                break;
            case 3:
                // System.out.print("Postorder Traversal:-   ");
                System.out.print("Postfix Traversal:-   ");
                postOrder(root);
                break;
            default:
                System.out.println("Invalid Choice");
        }
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

    public void printTree() {
        System.out.println();
        printTree(root, 0);
        System.out.println();
    }

    private void printTree(Node root, int space) {
        if (root == null)
            return;
        space += count;
        printTree(root.rightChild, space);
        for (int i = count; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(root.data + "\n");
        printTree(root.leftChild, space);
    }
}
