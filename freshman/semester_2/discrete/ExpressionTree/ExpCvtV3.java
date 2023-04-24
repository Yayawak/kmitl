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

    // public void printTree() {
    //     printTree(root, 0);
    // }


    public void printTree() {
        Stack<Node> stack = new Stack<>();
        // for (Node n : )
        Node temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            else {
                temp = stack.pop();
                // String.format(" ".repeat(count))
                System.out.println(temp.data);
                temp = temp.right;
            }
        }
    }

    // public void printTree() {
    //     int h = height(root);
    //     int w = (int)Math.pow(2, h) - 1;
    //     // String[][] arr = new String[h + 1][w + 1];
    //     // String[][] arr = new String[h + 3][w + 1];
    //     char[][] arr = new char[h + 3][w + 1];

    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);
    //     int level = 0;
    //     int levelSize = 1;

    //     while (!q.isEmpty()) {
    //         int i = 0;
    //         while (i < levelSize) {
    //             Node cur = q.poll();
    //             int start = (int)(Math.pow(2, h - level - 1) * (2 * i + 1) - 1);
    //             int end = (int)(Math.pow(2, h - level) * (2 * i + 1) - 1);
    //             // System.out.println();
    //             // arr[level][start + (end - start) / 2] = Integer.toString(cur.data);
    //             int mid = start + (end - start) / 2;
    //             // arr[level][start + (end - start) / 2] = String.valueOf(cur.data);
    //             // arr[level][mid] = String.valueOf(cur.data);
    //             arr[level][mid] = cur.data;

    //             if (cur.left != null)
    //                 q.add(cur.left);
    //             if (cur.right != null)
    //                 q.add(cur.right);
    //             i++;
    //         }
    //         level++;
    //         levelSize = q.size();
    //     }

    //     for (int i = 0; i < h; i++) {
    //         for (int j = 0; j < w; j++) {
    //             // if (arr[i][j] != null) {
    //             if (arr[i][j] != '\0') {
    //                 System.out.print(arr[i][j]);
    //             } else {
    //                 System.out.print(" ");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
    // public void printTree() {
    //     // thisLevel =
    //     List<Node> thisLevelNodes = new ArrayList<>();
    //     thisLevelNodes.add(this.root);
    //     int curentHeight = 0;
    //     int h = height(root);
    //     // int b = (int)((Math.pow(2, h)) * 2);
    //     int b = 9;
    //     System.out.println("h = " + h);
    //     System.out.println("b = " + b);
    //     // int[][] matrix = new int[h + 1][b];
    //     int[][] matrix = new int[h + 3][b];
    //     // char[][] matrix = new char[h + 4][b];
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             matrix[i][j] = 'A';
    //         }
    //     }
    //     int mid = matrix[0].length / 2;
    //     int lMid = mid;
    //     int rMid = mid;
    //     matrix[curentHeight][mid] = root.data;
    //     while (!thisLevelNodes.isEmpty()) {
    //         List<Node> nextLevelNodes = new ArrayList<>();
    //         for (Node n : thisLevelNodes) {
    //             // System.out.println("value " + n.data);
    //             // System.out.printf("%c ", n.data);
    //             // matrix[curentHeight][mid]
    //             if (n.left != null) {
    //                 nextLevelNodes.add(n.left);
    //                 // mid = mid - curentHeight - 1;
    //                 // lMid = lMid - curentHeight - 1;
    //                 lMid -= 1;
    //                 matrix[curentHeight + 1][lMid] = n.left.data;
    //                 // System.out.println("left " + n.left.data);
    //             }
    //             if (n.right != null) {
    //                 nextLevelNodes.add(n.right);
    //                 // mid = mid + curentHeight + 1;
    //                 // rMid = rMid + curentHeight + 1;
    //                 rMid += 1;
    //                 matrix[curentHeight + 1][rMid] = n.right.data;

    //             }
    //         }
    //         // System.out.println();
    //         thisLevelNodes = nextLevelNodes;
    //         curentHeight++;
    //     }

    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             int c = matrix[i][j];
    //             if (c == 'A') {
    //                 System.out.printf("%c ",  '_');
    //             } else {
    //                 System.out.printf("%c ", matrix[i][j]);
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
}

public class ExpCvtV3 {

    // Tree Structure
    // ExpTAee expTree = new ExpTree(root);
    // ExpTAee expTree;


    // Function to create new node
    static Node newNode(char c) {
        Node n = new Node();
        n.data = c;
        n.left = n.right = null;
        return n;
    }

    // Function to build Expression Tree
    static Node build(String s) {

        // Stack to hold nodes
        Stack<Node> stN = new Stack<>();

        // Stack to hold chars
        Stack<Character> stC = new Stack<>();
        Node t, t1, t2;

        // Prioritising the operators
        int[] p = new int[123];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {

                // Push '(' in char stack
                stC.add(s.charAt(i));
            }

            // Push the operands in node stack
            else if (Character.isAlphabetic(s.charAt(i))) {
                t = newNode(s.charAt(i));
                stN.add(t);
            } else if (p[s.charAt(i)] > 0) {

                // If an operator with lower or
                // same associativity appears
                while (!stC.isEmpty() && stC.peek() != '('
                        && ((s.charAt(i) != '^' && p[stC.peek()] >= p[s.charAt(i)])
                                || (s.charAt(i) == '^'
                                        && p[stC.peek()] > p[s.charAt(i)]))) {

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

    // Function to print the post order
    // traversal of the tree
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data);
        }
        // System.out.println();
    }


    // Driver code
    public static void main(String[] args) {
        // String s = "(a^b^(c/d/e-f)^(x*y-m*n))";
        // String s = "a*b+c";
        String s = "a*b+c";
        // String s = "a*b+c/d";
        s = "(" + s;
        s += ")";
        Node root = build(s);
        ExpTree expTree = new ExpTree(root);
        // System.out.println("exp size : " + expTree.treeSize());
        System.out.println("exp t height : " + expTree.height());

        // Function call
        postorder(root);


        // buildTreeFromPostOrder(root);

        System.out.println();
        System.out.println("root = " + root.data);
        System.out.println("left child of root = " + root.left.data);
        System.out.println("right child of root = " + root.right.data);

        System.out.println("left child of * = " + root.left.left.data);
        System.out.println("right child of * = " + root.left.right.data);


        System.out.println("-----------------------------");
        System.out.println("print tree ");
        expTree.printTree();
        System.out.println("-----------------------------");
    }
}
