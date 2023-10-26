// 65050988
class SharedNum5 {
    private int val = 0;
    Object lock;

    SharedNum5() {
        val = 0;
        lock = new Object();
    }

    int getVal() {
        synchronized (lock) {
            try {
                System.out.println("waiting");
                lock.wait();
            } catch (InterruptedException ie) { }
            return val;
        }
    }

    void setVal(int x) {
        synchronized (lock) {
            val = x;
            lock.notifyAll();
        }
    }
}
