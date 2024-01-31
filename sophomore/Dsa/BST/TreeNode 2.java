package BST;

public class TreeNode {
    int data;
    TreeNode left, right, parent;
    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        String sLeft = "null<-", sRight="->null";
        if(left != null){
            sLeft = left.toString(); 
        }
        if(right != null){
            sRight = right.toString();
        }
        // There are 4 cases no child,
        // left-child-only,
        // right-child-only,
        //and both children
        // return sLeft + sRight;
        return "";
    }
}