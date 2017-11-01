package euler.java.solutions;

/**
 * Problem 19: Counting Sundays
 * You are given the following information, but you may prefer to do some research for yourself.
 * <p>
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * <p>
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Euler019 extends EulerProblem {

    private static final int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /**
     * Simple iteration through sundays, resetting if the day count goes above the limit for the month.
     *
     * @return solution for Problem 19
     */
    @Override
    protected String solve() {
        int day = 7, month = 1, year = 1900;
        int counter = 0;
        while (year < 2001) {
            if (day == 1 && year > 1900) {
                ++counter;
            }

            day += 7;
            if (day > daysInMonth[month]) {
                // February check
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
        return counter + "";
    }
}
