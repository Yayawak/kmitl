import java.util.*;

class Cop
{

// Tree Structure
static class nptr
{
    char data;
    nptr left, right;
} ;

// Function to create new node
static nptr newNode(char c)
{
    nptr n = new nptr();
    n.data = c;
    n.left = n.right = null;
    return n;
}

// Function to build Expression Tree
static nptr build(String s)
{

    // Stack to hold nodes
    Stack<nptr> stN = new Stack<>();


    // Stack to hold chars
    Stack<Character> stC = new Stack<>();
    nptr t, t1, t2;

    // Prioritising the operators
    int []p = new int[123];
    p['+'] = p['-'] = 1;
    p['/'] = p['*'] = 2;
    p['^'] = 3;
    p[')'] = 0;

    for (int i = 0; i < s.length(); i++)
    {
        if (s.charAt(i) == '(') {

            // Push '(' in char stack
            stC.add(s.charAt(i));
        }

        // Push the operands in node stack
        else if (Character.isAlphabetic(s.charAt(i)))
        {
            t = newNode(s.charAt(i));
            stN.add(t);
        }
        else if (p[s.charAt(i)] > 0)
        {

            // If an operator with lower or
            // same associativity appears
            while (
                !stC.isEmpty() && stC.peek() != '('
                && ((s.charAt(i) != '^' && p[stC.peek()] >= p[s.charAt(i)])
                    || (s.charAt(i) == '^'
                        && p[stC.peek()] > p[s.charAt(i)])))
            {

                // Get and remove the top element
                // from the character stack
                t = newNode(stC.peek());
                stC.pop();

                // Get and remove the top element
                // from the node stack
                t1 = stN.peek();
                stN.pop();

                // Get and remove the currently top
                // element from the node stack
                t2 = stN.peek();
                stN.pop();

                // Update the tree
                t.left = t2;
                t.right = t1;

                // Push the node to the node stack
                stN.add(t);
            }

            // Push s[i] to char stack
            stC.push(s.charAt(i));
        }
        else if (s.charAt(i) == ')') {
            while (!stC.isEmpty() && stC.peek() != '(')
            {
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

// Function to print the post order
// traversal of the tree
static void postorder(nptr root)
{
    if (root != null)
    {
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
}

public static void displayTree(nptr root, String indent, String prefix) {
    if (root != null) {
        System.out.println(indent + prefix + root.data);
        displayTree(root.left, indent + "  ", "/ ");
        displayTree(root.right, indent + "  ", "\\ ");
    }
}
// Driver code
public static void main(String[] args)
{
    String s = "(a^b^(c/d/e-f)^(x*y-m*n))";
    s = "(" + s;
    s += ")";
    nptr root = build(s);

    // Function call
    postorder(root);
    displayTree(root, "", "");
}
}
