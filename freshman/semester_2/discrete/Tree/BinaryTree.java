package Tree;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    // public BinaryTree(Node<T> root) {
    public BinaryTree(T rootT) {
        this.root = new Node<T>(rootT);
    }

    public void inorderTraverse() {
        inorderTraverse(root);
    }
    private void inorderTraverse(Node<T> current) {
        if (current == null)
            return ;
        inorderTraverse(current.getLeft());
        System.out.println(current.getData() + " ");
        inorderTraverse(current.getRight());
    }
    public void preorderTraverse() {
        preorderTraverse(root);
    }
    private void preorderTraverse(Node<T> current) {
        if (current == null)
            return ;
        System.out.println(current.getData() + " ");
        preorderTraverse(current.getLeft());
        preorderTraverse(current.getRight());
    }
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            return ;
        }
        insert(root, data);
    }

    private void insert(Node<T> node, T data) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(data));
            } else {
                insert(node.getLeft(), data);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<>(data));
            } else {
                insert(node.getRight(), data);
            }
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
