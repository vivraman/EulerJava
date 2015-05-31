package eulerjava;

import java.util.Calendar;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler019 {

    int day = 7, month = 1, year = 1900;
    int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Euler019() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        int counter = 0;
        while (year < 2001) {
            if (day == 1 && year > 1900) {
                ++counter;
            }

            day += 7;
            if (day > daysInMonth[month]) {
                if (month == 2 && year % 4 == 0) {
                    if (year % 100 == 0 && year % 400 != 0) {
                        day -= daysInMonth[month];
                        month++;
                    } else {
                        if (day > 29) {
                            day -= 29;
                            month++;
                        }
                    }
                } else {
                    day -= daysInMonth[month];
                    month++;
                }
            }
            if (month > 12) {
                month -= 12;
                year++;
            }
        }
        return counter;
    }
}
