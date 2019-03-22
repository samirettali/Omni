package euler;

public class E19 {


    public static void start() {
        int sundays = 0;

        for (int year = 1901; year <= 2000; year++)
            for (int month = 1; month <= 12; month++)
                if (util.Date.dayOfWeek(year, month, 1).equals("Sunday"))
                    sundays++;

        System.out.println(sundays);
    }
}
