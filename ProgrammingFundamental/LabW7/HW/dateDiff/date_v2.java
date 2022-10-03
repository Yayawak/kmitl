package PF.LabW7.HW.dateDiff;


public class date_v2 {
    static class DateData {
        int year, month, day;
        public DateData (int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
    public static void main(String[] args) {
        DateData d1 = new DateData(2003, 1, 9);
        DateData d2 = new DateData(2021, 1, 1);
        DateData d3 = new DateData(2021, 1, 31);

        // System.out.println(isDate1BeforeThanDate2(d1, d2));
        // System.out.println(isLastDayInMonth(d3));

    }

    // ? : HELPER METHODS
    public void increaseOneDate() {
        DateData d = new DateData(2000, 5, 28);
        if (isLastDayInMonth(d)) {
            // if (isLas)
        }
    }
    // static is last
    public static boolean isLastDayInMonth(DateData date) {
        return (
            (date.month==1 && date.day==31) ||
            (   isLeapYear(date.year)
                ? (date.month==2 && date.day==29)
                : (date.month==2 && date.day==28)
            ) ||
            (date.month==3 && date.day==31) ||
            (date.month==4 && date.day==30) ||

            (date.month==5 && date.day==31) ||
            (date.month==6 && date.day==30) ||
            (date.month==7 && date.day==31) ||
            (date.month==8 && date.day==31) ||

            (date.month==9 && date.day==30) ||
            (date.month==10 && date.day==31) ||
            (date.month==11 && date.day==30) ||
            (date.month==12 && date.day==31)
        );
    }
    public static boolean isLeapYear(int year) {
        return (year%4==0) && ((year%100!=0) || (year%400==0));
    }
    public static boolean isDate1BeforeThanDate2(
        DateData date1, DateData date2
    ) {
        return (date1.year < date2.year ? true
            : ( date1.year == date2.year ?
                (date1.month < date2.month ? true
                    : (date1.month == date2.month ?
                        date1.day < date2.day : false)
                ) : false
            ));
    }
}
