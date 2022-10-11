package LinkedList;

public class MyList {
    Node headNode;

    void add(int v) {
        Node newNode = new Node(v);
        // if head == null -> create new node to be head;
        // ! Only ocuured once when headNode creation
        if(headNode==null) headNode = newNode;
        // * if head is already exist -> curN = headN;
        else
        {
            Node currentNode = headNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
        // traverse();
    }
    // * Yeapy ! i did it myself :D ?????????
    // todo : bug ???
    void removeLastNode() {
        Node currentNode = headNode;
        while(currentNode != null) {
            // if (currentNode.nextNode == )
        }
        // ? after above iteration the currentNode now is last node
        Node lastNode = currentNode;
        currentNode = null;
        System.out.println("Last node is : " + lastNode
            + "data is : " + lastNode.data
            );
        // lastNode = null;
        traverse();
    }

    void traverse() {
        // ? tmp = currentNode
        Node tmpN = headNode;
        while (tmpN != null) {
            System.out.print(tmpN.data + " "
                // ! ค่าตรงนี้จะยังเป็น null เสมอไป เพราะรอการ add จาก method ด้านบน
                + tmpN.nextNode + " -> "
                );
            tmpN = tmpN.nextNode;
        }
        System.out.println();
    }
}
