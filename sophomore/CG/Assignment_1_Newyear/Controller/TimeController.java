package Assignment_1_Newyear.Controller;

public class TimeController {
    private float startTime;
    private float lastFrameTime;
    private float currentFrameTime;
    private float currentTimeSec;
    private float dt;
    private static TimeController ins;

    public static TimeController getInstance()
    {
        if (ins == null)
        {
            ins = new TimeController();
        }
        return ins;
    }

    public float getDt()
    {
        return dt;
    }

    public float getCurrentTimeSec()
    {
        return currentTimeSec;
    }

    private TimeController()
    {
        startTime = System.currentTimeMillis();

        var t = new Thread(() -> {
            while (true) {
                currentFrameTime = System.currentTimeMillis();

                currentTimeSec = currentFrameTime - startTime;


                dt = currentFrameTime - lastFrameTime;

                System.out.println(dt);
                lastFrameTime = currentFrameTime;
            }
        }, "timer");
        t.start();
    }
}
