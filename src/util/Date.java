package util;

/**
 * Created by Sam on 21/03/2017.
 */
public class Date {

    public static boolean isLeap(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        return false;
    }

    public static String dayOfWeek(int year, int month, int day) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        if (year < 0 || year > 10000 || month < 1 || month > 12 || day < 1 || day > 31)
            throw new IllegalArgumentException();

        // Zeller's congruence algorithm
        int m = (month - 3 + 4800) % 4800;
        int y = (year + m / 12) % 400;
        m %= 12;
        int dayIndex = (y + y / 4 - y / 100 + (13 * m + 2) / 5 + day + 2) % 7;
        return days[dayIndex];
    }
}
