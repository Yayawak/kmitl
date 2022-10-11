package PF.LabW7.HW.dateDiff;

// * Time Diff exercise
public class dateDiif_v1 {
    public static void main(String[] args) {
        numDaysFromDate(9, 1, 2003, 4);
    }
    static void numDaysFromDate(int d, int m, int y, int myBD) {
        int dayBornTil31Dec2021 = 0;
        int diffDate =
            getDaysSince1800(31, 12, 2021)
            - getDaysSince1800(d, m, y);
        // System.out.println(diffDate);
        dayBornTil31Dec2021 = diffDate;

        // shift to Sunday Jan 02 2022
        int daysBornTil2Jan2022 = dayBornTil31Dec2021 + 2;

        // System.out.println(daysBornTil2Jan2022);
        String result = showResult(d, m, y, myBD, daysBornTil2Jan2022);
        System.out.println(result);
    }

    static int getDaysSince1800(int d, int m, int y) {
        int countTotalDays = 0;

        // kom, pan, yon
        String[] thaiMonthSurfix = ("kpky"+"kykk"+"ykyk").split("");

        // Include Last Day
        // ? : Add date by years
        for (int currentYear=1800; currentYear<y; ++currentYear) {
            // todo : if i was born in 3th : set functionality
            if (isLeapYear(currentYear)) {
                countTotalDays += 366;
            }else {
                countTotalDays += 365;
            }
        }

        // ? : Add date by remainder month
        for (int monthIdx=1; monthIdx<m; ++monthIdx) {
            int daysInMonth = 0;
            String suffixCurrentMonth = thaiMonthSurfix[monthIdx];

            if (suffixCurrentMonth.equals("k")) daysInMonth = 31;
            else if (suffixCurrentMonth.equals("p")) {
                if (isLeapYear(y)) daysInMonth = 29;
                else daysInMonth = 28;
            }else if (suffixCurrentMonth.equals("y")) daysInMonth = 30;

            countTotalDays += daysInMonth;
        }
        return countTotalDays += d - 1;
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

        // todo : code
        // calculate dayFromSun to work
        dayFromSun = 7 - modResult;

        String format = "\nYou were born on %s and have been"
            + " born for %d days until (2 Jan 2022)\n\n"
            + "Your program says :  %s\n";
        String str = String.format(format,
            dayName[myBD], fromNumDaysFromDate, dayName[dayFromSun]);

        return str;
    }
}
