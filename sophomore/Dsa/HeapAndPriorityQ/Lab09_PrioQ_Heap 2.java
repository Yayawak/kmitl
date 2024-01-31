package HeapAndPriorityQ;
import java.util.ArrayList;
import java.util.Objects;




public class Lab09_PrioQ_Heap
{


    static ArrayList<Integer> least3;
    public static void main(String[] args) {
        System.out.println("-demo1---");
        demo1();
        System.out.println("-demo2---");
        demo2();
    }
    static void demo1() {
        least3 = new ArrayList<>();
        MyMinHeap heap = new MyMinHeap();
        heap.insert(11); heap.insert(15);
        heap.insert(16); heap.insert(13);
        heap.insert(17); heap.insert(18);
        System.out.println("heap strucutre is " + heap);
        least3.add(heap.remove());
        least3.add(heap.remove());
        least3.add(heap.remove());
        System.out.println("least 3 value is " + least3);
    }
    static void demo2() {
        least3 = new ArrayList<>();
        MyPriorityQueue pq = new MyPriorityQueue();
        pq.enqueue(11); pq.enqueue(15);
        pq.enqueue(16); pq.enqueue(13);
        pq.enqueue(17); pq.enqueue(18);
        pq.enqueue(19); // <-- isFull() is true ... discard
        System.out.println("pq structure is " + pq);
        least3.add(pq.dequeue());
        least3.add(pq.dequeue());
        least3.add(pq.dequeue());
        System.out.println("least 3 value is " + least3);
    }
}
class MyMinHeap{
    ArrayList<Integer> heap;
    int size;
    public MyMinHeap(){
        heap = new ArrayList<Integer>();
        size = 0;
    }
    public void insert(int data){
        heap.add(data);
        size++;
        int c = size-1;
        int p = (c-1)/2;
        while(p >= 0 && heap.get(c)<heap.get(p)){
            swap(p, c);
            c = p;
            p = (c-1)/2;
        }
    }
    public int remove(){
        swap(0, --size);
        int output = heap.remove(size);
        int p = 0;
        while(p < size){
            int left = 2*p+1;
            if(left >= size){
                // No Child
                break;
            }
            int right = 2*p+2;
            if(right >= size){
                // No right child, has only left child
                if(heap.get(p) > heap.get(left)){
                    swap(p, left);
                }
                break;
            }
            else{
                int swaper = heap.get(left) < heap.get(right) ? left : right;
                if(heap.get(p) > heap.get(swaper)) swap(p, swaper);
                else break;
                p = swaper;
            }
        }
        return output;
    }
    private void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    @Override
    public String toString() {
        return heap + ", size=" + size;
    }
}
class MyPriorityQueue implements MyQueueInterface{
    class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    Node head;
    int size;

    public MyPriorityQueue(){

    }
    public MyPriorityQueue(int size){
        this.size = size;
    }

    @Override
    public int dequeue() {
        int output = head.data;
        head = head.next;
        return output;
    }

    @Override
    public void enqueue(int d) {
        if(head == null){
            head = new Node(d);
            return;
        }
        Node tail = head;
        while(tail.next != null) tail = tail.next;
        tail.next = new Node(d);
    }

    @Override
    public int front() {
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean isFull() {
        int count = 0;
        Node iter = head;
        while(iter.next != null){
            iter = iter.next;
            count++;
        }
        return Objects.isNull(size) ? false : size == count;
    }
    
}


interface MyQueueInterface {
    public void enqueue(int d);
    public int dequeue();
    public int front();
    public boolean isFull();
    public boolean isEmpty();
}