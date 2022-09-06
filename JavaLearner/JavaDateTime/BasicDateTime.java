package JavaLearner.JavaDateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
// import java.util.Date;

public class BasicDateTime {
    public static void main(String[] args) {
        // Calendar d = new Calendar();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentCalendar = df.format(c.getTime());
        System.out.println();
        System.out.println("Current calendar : " + currentCalendar);

        // *
        // Date date = new Date();
        // System.out.println("Date " + date);

    }
}
