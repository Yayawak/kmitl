package PF.LabW7.HW.dateDiff;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// * Time Diff exercise
public class dateDiif_v1 {
    public static void main(String[] args) {
        // exampleTimeDiff(); // 6932

        // numDaysFromDate(9, 1, 2003, 4); // 6942
        // numDaysFromDate(9, 1, 2003, 4); // 6942
        int diffDate = getDaysSince1800(31, 12, 2022)
            - getDaysSince1800(9,1,2003);
        System.out.println(diffDate);
    }
    // static int getDaysSinceEpoch(int d, int m, int y) {
    //     return 0;
    // }

    // static void numDaysFromDate(int date, int month,
        // int year, int myBD) {
    static int getDaysSince1800(int d, int m, int y) {
        int ans = 0;

        // todo : my code
        // kom, pan, yon
        String[] thaiMonthSurfix = ("kpky"+"kykk"+"ykyk").split("");

        // Include Last Day
        for (int currentYear=1800; currentYear<y; ++currentYear) {
            // System.out.println(currentYear+"========".repeat(5));
            // todo : if i was born in 3th : set functionality
            if (isLeapYear(currentYear)) {
                ans += 366;
            }else {
                ans += 365;
            }
        }
        // for (int monthIdx=0; monthIdx<12; ++monthIdx) {
        for (int monthIdx=1; monthIdx<m; ++monthIdx) {
            int daysInMonth = 0;
            String suffixCurrentMonth = thaiMonthSurfix[monthIdx];

            if (suffixCurrentMonth.equals("k")) daysInMonth = 31;
            else if (suffixCurrentMonth.equals("p")) {
                if (isLeapYear(y)) daysInMonth = 29;
                else daysInMonth = 28;
            }else if (suffixCurrentMonth.equals("y")) daysInMonth = 30;

            ans += daysInMonth;
            // if ((monthIdx+1) % 4 == 0) System.out.println("xxxxxxxxxxxxxxxxx");
        }

        // shift for Sunday ( 0th of the weekend )
        // int daysBornTil2Jan2022 = ans + 2;
        return ans - 1;
    }

    static boolean isLeapYear(int year) {
        return (year%400==0)
            ? true
            : (year%100==0) ? true
                : (year%4==0) ? true : false;
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
//  static void numDaysFromDate(int date, int month,
//         int year, int myBD) {
//         int daysBornTil31Dec2021 = 0;

//         // todo : my code
//         // kom, pan, yon
//         String[] thaiMonthSurfix = ("kpky"+"kykk"+"ykyk").split("");

//         // 2003 < 2021
//         // Include Last Day
//         for (int currentYear=year; currentYear<2022; ++currentYear) {
//             // System.out.println(currentYear+"========".repeat(5));
//             // todo : if i was born in 3th : set functionality
//             if (isLeapYear(currentYear)) {
//                 daysBornTil31Dec2021 += 366;
//             }else {
//                 daysBornTil31Dec2021 += 365;
//             }
//         }
//         // for (int monthIdx=0; monthIdx<12; ++monthIdx) {
//         for (int monthIdx=1; monthIdx<month; ++monthIdx) {
//             int daysInMonth = 0;
//             String suffixCurrentMonth = thaiMonthSurfix[monthIdx];

//             if (suffixCurrentMonth.equals("k")) daysInMonth = 31;
//             else if (suffixCurrentMonth.equals("p")) {
//                 if (isLeapYear(year)) daysInMonth = 29;
//                 else daysInMonth = 28;
//             }else if (suffixCurrentMonth.equals("y")) daysInMonth = 30;

//             // System.out.println(daysInMonth);
//             daysBornTil31Dec2021 += daysInMonth;
//             // if ((monthIdx+1) % 4 == 0) System.out.println("xxxxxxxxxxxxxxxxx");
//         }

//         // shift for Sunday ( 0th of the weekend )
//         int daysBornTil2Jan2022 = daysBornTil31Dec2021 + 2;
//         String result = showResult(date, month, year, myBD, daysBornTil2Jan2022);
//         System.out.println(result);
//     }
