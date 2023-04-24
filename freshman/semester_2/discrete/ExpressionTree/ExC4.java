import java.io.*;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.Stack;


class Node
{
    public char data;
    public Node leftChild;
    public Node rightChild;

    public Node(char x)
    {
        data = x;
    }

    public void displayNode()
    {
        System.out.print(data);
    }
}

class Conversion
{
    private Stack<Character> charStk;
    private String input;
    private String output = "";

    public Conversion(String str)
    {
        input = str;
        charStk = new Stack<>();
    }

    public String inToPost()
    {
        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            switch (ch)
            {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    charStk.push(ch);
                    break;
                case ')':
                    gotParenthesis();
                    break;
                default:
                    output = output + ch;
            }
        }
        while (!charStk.isEmpty())
            output = output + charStk.pop();
        return output;
    }
    private void gotOperator(char opThis, int prec1)
    {
        while (!charStk.isEmpty())
        {
            char opTop = charStk.pop();
            if (opTop == '(')
            {
                charStk.push(opTop);
                break;
            } else
            {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1)
                {
                    charStk.push(opTop);
                    break;
                } else
                    output = output + opTop;
            }
        }
        charStk.push(opThis);
    }

    private void gotParenthesis()
    {
        while (!charStk.isEmpty())
        {
            char ch = charStk.pop();
            if (ch == '(')
                break;
            else
                output = output + ch;
        }
    }
}



class Tree
{
    private static int count = 3;
    private Node root;

    public Tree()
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
        // System.out.println("/");
        printTree(root.rightChild, space);
        // System.out.println("\n");
        for (int i = count; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(root.data + "\n");
        printTree(root.leftChild, space);
    }
}

public class ExC4
{
    public static void main(String args[]) throws IOException
    {
        String ch = "y";
        Scanner sc = new Scanner(System.in);
        while (ch.equals("y"))
        {
            Tree t = new Tree();
            System.out.println("Enter the Expression");
            String infix = sc.nextLine();
            t.insert(infix);

            System.out.println("type 1 : prefix form");
            System.out.println("type 2 : infix form");
            System.out.println("type 3 : prefix form");
            System.out.println("choose type [123] ...");
            int type = sc.nextInt();
            t.traverse(type);
            System.out.println();

            // t1.traverse(1);
            // System.out.println("");
            // t1.traverse(2);
            // System.out.println("");
            // t1.traverse(3);
            // System.out.println("");

            System.out.println("print prefix tree");
            t.printTree();

            System.out.print("Enter y to continue ");
            ch = sc.nextLine();
        }
    }
}
