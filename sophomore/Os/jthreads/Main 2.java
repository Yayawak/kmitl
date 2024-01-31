public class Main
{
    public static void main(String[] args) {
        System.out.println("Main thread is = " + Thread.currentThread().threadId());
        L7_Obj x = new L7_Obj();        
        Thread t1 = new Thread(new Worker1(x));
        t1.start();
        Thread t2 = new Thread(new Worker2(x));
        t2.start();

        try {
            t1.join();    
            t2.join();    
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("from main x value is " + x.getValue());
    }
}

class L7_Obj
{
    private int value;

    L7_Obj()
    {
        value = 0;
    }

    void inc(int x)
    {
        value += x;
    }

    int getValue()
    {
        return value;
    }
}

class Worker1 implements Runnable
{
    private L7_Obj o;
    Worker1(L7_Obj y)
    {
        o = y;
    }

    @Override
    public void run() {
        o.inc(3);
        System.out.println("worker 1 thread " + Thread.currentThread().getId()
            +
            " x value is " + o.getValue()
            );
    }

}
class Worker2 implements Runnable
{
    private L7_Obj o;

    Worker2(L7_Obj y)
    {
        o = y;
    }

    @Override
    public void run() {
        o.inc(4);
        System.out.println("worker 2 thread " + Thread.currentThread().getId()
            +
            " x value is " + o.getValue()
            );
    }

}