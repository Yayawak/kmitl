package java_syncronization;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Fork[] forks = new Fork[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % numPhilosophers]);
            new Thread(philosophers[i]).start();
        }
    }

}

class Philosopher implements Runnable {
    private int id;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (true) {
            think();
            eat();
        }
    }

    private void think() {
        System.out.println("Philosopher " + id + " is thinking.");
        try {
            // Thread.sleep((int) (Math.random() * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println("Philosopher " + id + " is hungry and trying to eat.");
        leftFork.pickUp();
        rightFork.pickUp();
        System.out.println("Philosopher " + id + " is eating.");
        try {
            Thread.sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        leftFork.putDown();
        rightFork.putDown();
    }
}

class Fork {
    // private Lock lock;
    Semaphore mutex;
    boolean isUsing;

    public Fork() {
        // lock = new ReentrantLock();
    }

    public void pickUp() {
        // lock.lock();
        try {
            mutex.acquire();    



            mutex.release();
        } catch (Exception e) {
        }
    }

    public void putDown() {
        // lock.unlock();
    }
}
