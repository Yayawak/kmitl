// package BST;

// public class BST{
//     TreeNode root;
//     public BST() 
//     { 
//         root = null; 
//     }


//     public void insert(int d) {
//         if (root == null) {
//             root = new TreeNode(d);
//             return;
//         } else {
//             TreeNode cur = root;
//             while (cur != null) {
//                 if (d < cur.data) {
//                     if (cur.left != null){
//                         cur = cur.left;
//                     }
//                     else {
//                         cur.left = new TreeNode(d);
//                         cur.left.parent = cur;
//                         return;
//                     }
//                 } else { //! (d < p.data)
//                     if (cur.right != null)
//                         cur = cur.right;
//                     else {
//                         cur.right = new TreeNode(d);
//                         cur.right.parent = cur;
//                         return;
//                     }
//                 }
//             } //while
//         }
//     } //insert by iteration
//     public void printPreOrder() {
//         printPreOrderRecurse(root);
//     }

//     // private void printInOrder(TreeNode node) { 
//     public void printInOrder() { 
//         printInOrder(root);
//     } 

//     public void printInOrder(TreeNode node) { 
//         if(node.left != null)
//             printInOrder(node.left);
//         System.out.print(node.data + " ");
//         if(node.right != null)
//             printInOrder(node.right);
//     }

//     private void printPreOrderRecurse(TreeNode node) { 
//         System.out.print(node.data + " ");
//         if(node.left != null){
//             printPreOrderRecurse(node.left);
//         }
//         if(node.right != null){
//             printPreOrderRecurse(node.right);
//         }
//     }
    
//     public int height()
//     {
//         return root == null ? 0 : height(root);
//     }

//     public int height(TreeNode node)
//     {
//         if (node == null)
//             return 0;
//         // max
//         // Math.max(0, 0)
//         // !!!!!!1 find the h of l, r subtrees
//         int leftH = height(node.left);
//         int rightH = height(node.right);
//         return Math.max(leftH, rightH) + 1;

//     }

//     public TreeNode findMaxFrom(TreeNode parentNode)
//     {
//         // return 
//         // if (parentNode.left != null &&
//         //     parentNode.left.data)
//         // {
//         // }
//         if (parentNode != null)
//         {
//             if (parentNode.right != null)
//             {
//                 return findMaxFrom(parentNode.right);
//             }
//             else
//                 return parentNode;
//         }
//         return null;
//         // if (parentNode != null && parentNode.right != null)
//         // {
//         //     return findMaxFrom(parentNode.right);
//         // }
//         // else
//         // {
//         //     return parentNode;
//         // }
//     }

//     @Override
//     public String toString() {
//         return "BST [root=" + root + "]";
//     }

//     public TreeNode getRoot()
//     {
//         return root;
//     }


//     public void delete(int d, TreeNode current) {
//         if (current == null)
//             return; // not found

//         if (d < current.data) {
//             delete(d, current.left);
//         } else if (d > current.data) {
//             delete(d, current.right);
//         } else { // found ... time to delete
//             if (current.left == null || current.right == null) { // 0 or 1 child
//                 TreeNode q = (current.left == null) ? current.right : current.left;
//                 if (current.parent != null) {
//                     if (current.parent.left == current) {
//                         current.parent.left = q; // this node is left child
//                     } else {
//                         current.parent.right = q;
//                     }
//                 }
//                 if (q != null) {
//                     q.parent = current.parent;
//                 }
//             } else { // two children
//                 TreeNode q = findMaxFrom(current.left);
//                 int maxValue = q.data;
//                 delete(maxValue, current.left);
//                 current.data = maxValue;
//             }
//         }
//     }
// }

package BST;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null) {
                        cur = cur.left;
                    } else {
                        cur.left = new TreeNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                } else { // (d >= cur.data)
                    if (cur.right != null) {
                        cur = cur.right;
                    } else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            }
        }
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
        System.out.println();
    }

    private void printPreOrderRecurse(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrderRecurse(node.left);
            printPreOrderRecurse(node.right);
        }
    }

    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }

    private void printInOrderRecurse(TreeNode node) {
        if (node != null) {
            printInOrderRecurse(node.left);
            System.out.print(node.data + " ");
            printInOrderRecurse(node.right);
        }
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
        System.out.println();
    }

    private void printPostOrderRecurse(TreeNode node) {
        if (node != null) {
            printPostOrderRecurse(node.left);
            printPostOrderRecurse(node.right);
            System.out.print(node.data + " ");
        }
    }

    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
    }

    public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null) {
            return null;
        }
        if (d == n.data) {
            return n;
        } else {
            if (d < n.data) {
                return searchRecurse(d, n.left);
            } else {
                return searchRecurse(d, n.right);
            }
        }
    }
    
    
    public TreeNode searchIter(int key) {
        TreeNode current = root;
        while (current != null) {
            if (key == current.data) {
                return current;
            } else if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }    

    public int height() {
        return root == null ? 0 : height(root);
    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;
        
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public TreeNode findMaxFrom(TreeNode findMaxFrom) {
        TreeNode current = findMaxFrom;
        
        while (current.right != null) {
            current = current.right;
        }
        
        return current;
    }

    public void delete(int d, TreeNode current) {
        if (current == null)
            return; // not found

        if (d < current.data) {
            delete(d, current.left);
        } else if (d > current.data) {
            delete(d, current.right);
        } else { // found ... time to delete
            if (current.left == null || current.right == null) { // 0 or 1 child
                TreeNode q = (current.left == null) ? current.right : current.left;
                if (current.parent != null) {
                    if (current.parent.left == current) {
                        current.parent.left = q; // this node is left child
                    } else {
                        current.parent.right = q;
                    }
                }
                if (q != null) {
                    q.parent = current.parent;
                }
            } else { // two children
                TreeNode q = findMaxFrom(current.left);
                int maxValue = q.data;
                delete(maxValue, current.left);
                current.data = maxValue;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("demo 1");
        demo1();
        System.out.println("demo 2");
        demo2();        
        System.out.println("demo 3");
        demo3();
        System.out.println("demo 4");
        demo4();
    }

    public static void demo1(){
        int[] data = {2, 1, 3, 4, 5, 6, 7, 8, 9};
        BST2 bst = new BST2();
        for (int j = 0; j < data.length; j++)
            bst.insert(data[j]);
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());
    
        int[] dat = {15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        bst = new BST2();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());
        
    }

    public static void demo2(){
        BST2 bst = new BST2();
        int[] dat = {15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);

        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());

        System.out.println("Node with max value: " + bst.findMaxFrom(bst.getRoot()));
    }

    public static void demo3() {
        BST2 bst = new BST2();
        int[] dat = {15, 20, 10, 18, 16, 12, 8, 25, 19, 30};
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        bst.delete(12, bst.getRoot());
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(16)); // null<-16->null
        System.out.println(bst.search(10)); // 8<-10->null
        System.out.println(bst.search(12)); // not found
    }
    
    public static void demo4() {
        BST2 bst = new BST2();
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 30, 19, 25 };
        bst = new BST2();
        for (int j = 0; j < dat.length; j++) {
            bst.insert(dat[j]);
        }
        bst.printInOrder();
        bst.delete(20,  bst.getRoot()); // default TreeNode is root
        bst.printInOrder();
        bst.delete(15,  bst.getRoot()); // root -> complete the delete(int, TreeNode)
        bst.printInOrder();
    }
    
}
