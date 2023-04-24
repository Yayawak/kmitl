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

// clas exp3
class Cop2 {
    public static void main(String[] args) {
        String expression = "+1*35";
        // String expression = "5 3 * 1 +";
        // String expression = "+-a*b-cd/ef";
        TreeNode root = buildExpressionTree(expression);
        displayTree(root, "", "");
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

                // if (!stack.isEmpty())
                node.right = stack.pop();
                // if (!stack.isEmpty())
                node.left = stack.pop();
                stack.push(node);
            }
        }
        return stack.pop();
    }

    public static void displayTree(TreeNode root, String indent, String prefix) {
        if (root != null) {
            System.out.println(indent + prefix + root.val);
            displayTree(root.left, indent + "  ", "/ ");
            displayTree(root.right, indent + "  ", "\\ ");
        }
    }
}
