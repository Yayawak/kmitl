package PF.LabW7.HW.dateDiff;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// * Time Diff exercise
public class dateDiif_v4 {
    public static void main(String[] args) {
        // exampleTimeDiff(); // 6932

        // numDaysFromDate(9, 1, 2003, 4); // 6942
        // numDaysFromDate(9, 1, 2003, 4); // 6942
        int diffDate = getDaysSince1800(31, 12, 2021)
            - getDaysSince1800(9,1,2003);
        System.out.println(diffDate);
    }
    static int getDaysSince1800(int d, int m, int y) {
        int countDays = 0;

        // Include Last Day
        for (int currentYear=1800; currentYear<y; ++currentYear) {
            if(isLeapYear(currentYear)) {
                countDays += 366;
            }
            else countDays += 365;
        }

        // เศษเหลือจากเดือนในปีนั้น
        for (int monthIdx=1; monthIdx<m; ++monthIdx) {
            switch(monthIdx) {
                case 1: case 3: case 5: case 7:
                case 8: case 10:
                case 12:
                    countDays += 31;
                    break;

                case 4: case 6: case 9:
                case 11:
                    countDays += 30;
                    break;
                case 2:
                    int x = isLeapYear(y) ? 29 : 28;
                    countDays += x;
                    break;
            }
        }

        // shift for Sunday ( 0th of the weekend )
        // int daysBornTil2Jan2022 = ans + 2;
        // exclusive
        // return countDays - 1;
        return countDays += d - 1;
    }

    static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0);
    }
    static String showResult(int date, int month, int year,
            int myBD, int fromNumDaysFromDate) {
        String[] dayName = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
        };
        int dayFromSun = 0;
        int modResult = fromNumDaysFromDate % 7;

        // System.out.println(modResut);
        // todo : code
        // calculate dayFromSun to work
        dayFromSun = 7 - modResult;

        String format = "You were born on %s and have been"
            + " born for %d days until (2 Jan 2022)\n"
            + "Your program says %s\n";
        String str = String.format(format,
            dayName[myBD], fromNumDaysFromDate, dayName[dayFromSun]);

        return str;
    }
    static void exampleTimeDiff() {
        // Monday
        // LocalDate nov1yr21 = LocalDate.of(2021, 11, 1);
        LocalDate nov1yr21 = LocalDate.of(2003, 1, 9);
        // Saturday
        // LocalDate jan1yr22 = LocalDate.of(2022, 1, 1);
        LocalDate jan1yr22 = LocalDate.of(2021, 12, 31);

        long daysBetween;
        // Exclude Last day
        daysBetween = ChronoUnit.DAYS.between(nov1yr21, jan1yr22);
        System.out.printf("%s was %s . It is %s"
            + " days to %s %s.\n",
            nov1yr21, nov1yr21.getDayOfWeek(), daysBetween,
            jan1yr22, jan1yr22.getDayOfWeek());
    }
}
