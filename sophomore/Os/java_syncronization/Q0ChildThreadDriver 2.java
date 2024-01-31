package java_syncronization;

import java.util.concurrent.Semaphore;

class SharedNum2 {
    private int value = 0;
    private Semaphore mutex;

    SharedNum2()
    {
        mutex = new Semaphore(1);
        value  = 0;
    }

    void increment()
    {
        try {
            mutex.acquire();
            value++;
            mutex.release();
        } catch (Exception e) {
        }
    }
    int getVal() { return value;}

}

public class Q0ChildThreadDriver 
{
    public static void main(String[] args) {
        int nThreads = 100000;
        // SharedNum1 sn = new SharedNum1();
        SharedNum2 sn = new SharedNum2();
        Thread[] thr = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++)
        {
            thr[i] = new ChildSimple(sn);
            thr[i].start();
        }

        for (int i = 0; i < nThreads; i++)
        {
            try {
                thr[i].join();
            } catch (InterruptedException e) {
            } 
        }
        if (sn.getVal() < nThreads)
        {
            System.out.printf("v0 val = % Not");
            System.out.printf("100,000\n", sn.getVal());
        }
        else
        {
            System.out.printf("vo good job! %d\n",
                sn.getVal()
            );
        }

    }
}