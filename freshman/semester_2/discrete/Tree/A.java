import java.util.Stack;

class TreeNode {
    char val;
    TreeNode left, right;

    TreeNode(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class A {
    public static void main(String[] args) {
        String expression = "34*7+";
        TreeNode root = buildExpressionTree(expression);
        displayTree(root, "");
    }

    public static TreeNode buildExpressionTree(String expression) {
        if (expression == null || expression.length() == 0) {
            return null;
        }
        char[] expArr = expression.toCharArray();
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < expArr.length; i++) {
            if (Character.isLetterOrDigit(expArr[i])) {
                stack.push(new TreeNode(expArr[i]));
            } else {
                TreeNode node = new TreeNode(expArr[i]);
                node.right = stack.pop();
                node.left = stack.pop();
                stack.push(node);
            }
        }
        return stack.pop();
    }

    public static void displayTree(TreeNode root, String indent) {
        if (root == null) {
            return;
        }
        System.out.println(indent + root.val);
        if (root.left != null || root.right != null) {
            displayTree(root.left, indent + "  ");
            displayTree(root.right, indent + "  ");
        }
    }
}
