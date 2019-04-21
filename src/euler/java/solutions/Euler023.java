package euler.java.solutions;

/**
 * Problem 23: Non-abundant sums
 *
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28
 * is a perfect number.
 * <p>
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called
 * abundant if this sum exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written
 * as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers
 * greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot
 * be reduced any further by analysis even though it is known that the greatest number that cannot be expressed
 * as the sum of two abundant numbers is less than this limit.
 * <p>
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Euler023 implements EulerProblem {

    private static final int UPPERBOUND = 28123;

    /**
     * Iterates through all numbers until the upperbound specified in the problem, checks whether
     * the number is an abundant number, adds to an array if so, and then checks to see if number
     * can be summed by existing abundants.
     *
     * @return solution to Problem 23
     */
    public String solve() {
        int[] abundants = new int[UPPERBOUND];
        int abundnum = 0;
        long answer = 0;
        for (int i = 1; i < UPPERBOUND; i++) {
            if (isAbundant(i)) {
                abundants[abundnum++] = i;
            }
            answer += sumOfAbundants(i, abundnum, abundants);
        }
        return answer + "";
    }

    /**
     * Determines whether the number passed in is abundant or not
     *
     * @param num the parameter that is either abundant or not
     * @return true if num is abundant, false otherwise
     */
    private boolean isAbundant(int num) {
        int sum = 1;
        int sqrt = (int) (Math.sqrt(num));
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i + (num / i);
            }
        }
        if (sqrt * sqrt == num) {
            return sum - sqrt > num;
        }
        return sum > num;
    }

    /**
     * Determines whether a number can be summed to by two abundant numbers by taking the current
     * list of abundant numbers and iterating through the list and trying potential sums. Search starts
     * at each end and narrows the left or right end if the attempted sum is less or greater than i, respectively.
     * <p>
     * This returns a number instead of a boolean in order to simplify the code where this method is called
     * (that is, avoiding if-else statements).
     *
     * @param i         number to find abundant numbers to sum to
     * @param abundnum  number of abundant numbers current found
     * @param abundants array of currently found abundant numbers
     * @return 0 if there are abundant numbers that sum up to i, i otherwise
     */
    private int sumOfAbundants(int i, int abundnum, int[] abundants) {
        int start = 0, end = abundnum - 1, sum = 0;
        while (end >= start) {
            if ((sum = abundants[start] + abundants[end]) == i) {
                return 0;
            } else if (sum > i) {
                end--;
            } else {
                start++;
            }
        }
        return i;
    }

}
