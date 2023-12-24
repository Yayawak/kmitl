package cg.assignment2;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class JavaHungry {
    public static void main(String args[]) {
      try
      {
        System.out.println("Start of delay: "+ new Date());
        // Delay for 7 seonds
        TimeUnit.SECONDS.sleep(7);   
        System.out.println("End of delay: "+ new Date());
        // Delay for 1 minute
        TimeUnit.MINUTES.sleep(1);
        // Delay for 5000 Milliseconds
        TimeUnit.MILLISECONDS.sleep(5000);
      }
      catch(InterruptedException ex)
      {
          ex.printStackTrace();
      }
    }
}