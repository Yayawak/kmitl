package java_syncronization;

public class ChildSimple extends Thread
{
    // SharedNum1 resource;
    SharedNum2 resource;
    
    public ChildSimple(SharedNum2 ref)
    {
        resource = ref;
    }

    @Override
    public void run()
    {
        resource.increment();
    }
}