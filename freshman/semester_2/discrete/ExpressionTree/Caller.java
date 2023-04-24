import java.util.Scanner;

public class Caller {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("provide infix form");
        String infix = sc.nextLine();
        // String s = "(a^b^(c/d/e-f)^(x*y-m*n))";
        String s = "a*b+c";
        // String s = "a*b+c/d";
        // s = "(" + s;
        // s += ")";
        // infix = "(" + infix + ")";
        // infix = s;
        infix = "(" + infix;
        infix += ")";
        ExpressionCvt converter = new ExpressionCvt();
        Node root = converter.buildPostfixTree(infix);
        ExpTree expTree = new ExpTree(root);

        System.out.println("postfix form");
        converter.postorder(root);
        System.out.println("-----------------------------");
        System.out.println("print tree ");
        expTree.printTree();
        System.out.println("-----------------------------");

        System.out.println("prefix form");
    }

}
