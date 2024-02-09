package src.helpers;


public class TimeTime
{
    private static long startTime = System.currentTimeMillis();
    private static long lastTime = startTime;
    private static long currentTime, elapsedTime;


    public static long getStartTime() {
        return startTime;
    }

    public static void setStartTime(long startTime) {
        TimeTime.startTime = startTime;
    }

    public static long getCurrentTime() {
        return currentTime;
    }

    public static void setCurrentTime(long currentTime) {
        TimeTime.currentTime = currentTime;
    }

    public static long getElapsedTime() {
        return elapsedTime;
    }

    public static void setElapsedTime(long elapsedTime) {
        TimeTime.elapsedTime = elapsedTime;
    }

    public static long getLastTime() {
        return lastTime;
    }

    public static void setLastTime(long lastTime) {
        TimeTime.lastTime = lastTime;
    }


}