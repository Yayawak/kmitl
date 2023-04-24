public class TreeNode {
    private String value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String value) {
        this.value = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public String getValue() {
        return value;
    }
}

class ExpressionConversion {
    private static char[] operatorSet = {'+', '-', '*', '/', '^'};

    private static boolean isOperator(char c) {
        for (char operator : operatorSet) {
            if (operator == c)
                return true;
        }
        return false;
    }

    private static int getPrecedence(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }
    public static TreeNode infixToPrefixPostfix(String infix, String notation) {
        int n = infix.length();
        char c;
        // * base case : single operand
        if (n == 0)
            return null;
        if (n == 1)
            return new TreeNode(infix);

        int index = -1;
        int minPrecedence = Integer.MAX_VALUE;
        int countParentheses = 0;
        for (int i = 0; i < n; i++) {
            c = infix.charAt(i);
            if (c == '(')
                countParentheses++;
            else if (c == ')')
                countParentheses--;
            else if (countParentheses == 0
                    && isOperator(c)
                    && getPrecedence(c) <= minPrecedence
            ) {
                index = i;
                minPrecedence = getPrecedence(c);
            }
        }

        String operator = null;
        if (index != -1) {
            operator = infix.substring(index, index + 1);
        }

        TreeNode node = new TreeNode(operator);

        TreeNode leftOperand = infixToPrefixPostfix(
                infix.substring(0, index), notation
        );
        TreeNode rightOperand = infixToPrefixPostfix(
                infix.substring(index + 1), notation
        );

        if (notation.equals("prefix")) {
            node.setLeft(leftOperand);
            node.setRight(rightOperand);
        } else if (notation.equals("postfix")) {
            node.setLeft(rightOperand);
            node.setRight(leftOperand);
        }

        return node;
    }

    public static void printExpression(TreeNode root, String notation) {
        if (root == null) {
            return;
        }

        if (notation.equals("prefix")) {
            System.out.print(root.getValue() + " ");
            printExpression(root.getLeft(), notation);
            printExpression(root.getRight(), notation);
        } else if (notation.equals("postfix")) {
            printExpression(root.getLeft(), notation);
            printExpression(root.getRight(), notation);
            System.out.print(root.getValue() + " ");
        } else {
            printExpression(root.getLeft(), notation);
            System.out.print(root.getValue() + " ");
            printExpression(root.getRight(), notation);
        }
    }

    public static void main(String[] args) {
        // String infix = "1 + 3 * 5";
        String infix = "1+3*5";
        TreeNode root = infixToPrefixPostfix(infix, "prefix");
        printExpression(root, "prefix");
        System.out.println();

        root = infixToPrefixPostfix(infix, "postfix");
        printExpression(root, "postfix");
        System.out.println();

        root = infixToPrefixPostfix(infix, "infix");
        printExpression(root, "infix");
        System.out.println();
    }
    // public static void main(String[] args) {
    //     String infix = "1 + 3 * 5";
    //     // String infix = "1+3";
    //     String ret = infixToPrefixPostfix(infix, "prefix");
    //     System.out.println("infix : " + infix);
    //     System.out.println("prefix : " + ret);
    //     System.out.println("postfix : " + infixToPrefixPostfix(infix, "postfix"));
    // }

}
