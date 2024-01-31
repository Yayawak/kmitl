package BST;


public class BSTLab{

    static BST bst;

    public static void main(String[] args) {
        bst =  new BST();
        System.out.println("--demo1--");
        // bst = new BST();
        demo1();
        // demo2();
    }
    // public static void demo1() {
    //     System.out.println("-insert and preOrder traversal-");
    //     int[] dat = { 15, 20, 10, 18, 16,
    //     12, 8, 25, 19, 30 };

    //     BST bst = new BST();
    //     for (int j = 0; j < dat.length; j++)
    //     bst.insert(dat[j]);
    //     // System.out.println(bst);
    //     bst.printPreOrder();
    //     //8 10 12 15 16 18 19 20 25 30
    //     System.out.println();
    //     // demo2(bst);
    // }

    public static void demo1() {
        int[] data = { 2, 1, 3, 4, 5, 6, 7, 8, 9 };
        // bst = new BST();
        for (int j = 0; j < data.length; j++)
            bst.insert(data[j]);

        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());



        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
        bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        // bst.printInOrder();
        bst.printInOrder();
        System.out.println("Tree height = " + bst.height());
    }

    public static void demo2() {
        System.out.println("node with max value " +
            bst.findMaxFrom(bst.getRoot()));
    }

    static void demo3(BST bst) {
        System.out.println("-search recursive---");
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(12)); // null<-12->null
        System.out.println(bst.search(1));  // null

        System.out.println(bst.searchRecurse(10, bst.getRoot()));//if searchRecurse and getRoot is available

        System.out.println("-search iterative---");
        System.out.println(bst.searchIter(20));
        System.out.println(bst.searchIter(25));
        System.out.println(bst.searchIter(12));
        System.out.println(bst.searchIter(1));
    }
}
