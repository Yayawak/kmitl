package LinkedList;

public class Main {
    public static void main(String[] args) {
        MyList mList = new MyList();
        // mList.traverse();
        mList.add(2);
        // mList.traverse();

        mList.add(3);
        // mList.traverse();

        mList.add(4);
        // mList.traverse();
        mList.add(1);

        mList.removeLastNode();
        mList.removeLastNode();
        mList.removeLastNode();

        mList.add(40);
    }
}
