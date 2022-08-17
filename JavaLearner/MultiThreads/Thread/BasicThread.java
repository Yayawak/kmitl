package JavaLearner.MultiThreads.Thread;

public class BasicThread implements Runnable {
    String sItem;
    public BasicThread(String sItem){
        this.sItem = sItem;
    }
    public void run (){
        for (int i=0; i < 5; i++) {
            System.out.println("Item thread " + this.sItem + " value = " + i); 
            try {
                Thread.sleep(2000);
                System.out.println("=================");
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }   
    public static void main(String[] args) throws Exception {
        Thread th1 = new Thread(new BasicThread("A"));
        th1.start();
        Thread th2 = new Thread(new BasicThread("B"));
        th2.start();
        Thread th3 = new Thread(new BasicThread("C"));
        th3.start();
    }
}
