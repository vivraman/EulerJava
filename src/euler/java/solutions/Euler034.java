package euler.java.solutions;

import euler.java.main.Utility;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Euler034 implements EulerProblem {

    private static final int FACTORIAL_GENERATION_LIMIT = 10;
    private static final int[] FACTORIALS = Utility.getFactorialArray(FACTORIAL_GENERATION_LIMIT);

    /**
     * Brute force solution with appropriate upper bound. For every number from 10 (since numbers below 10 can't be
     * summed), checks if the number is equal to the sum of their digits' factorials. Sum all numbers that meet
     * this criteria.
     *
     * @return solution to Problem 34
     */
    public String solve() {
        int sum = 0, searchLimit = getSearchLimit();
        for (int i = 10; i <= searchLimit; i++) {
            if (i == getFactorialSum(i)) {
                sum += i;
            }
        }
        return sum + "";
    }

    /**
     * Find the upper bound of numbers to search for. Here, the upper bound can be found at the value n*9!,
     * where n is the smallest value such that 10^n < n * 9!. Above this number, it is not possible for a number
     * to be equal to the sum of the factorials of its digits.
     *
     * @return upper bound of factorial sums to search for
     */
    private int getSearchLimit() {
        int sum = FACTORIALS[9], limit = 10;
        while (sum > limit) {
            sum += FACTORIALS[9];
            limit *= 10;
        }
        return sum;
    }

    /**
     * Returns the integer value corresponding to the sum of the factorials of the digits of i
     *
     * @param i the number to compute the sum of
     * @return sum of the factorials of the digits of i
     */
    private int getFactorialSum(int i) {
        int sum = 0, current = i;
        while (current > 0) {
            sum += FACTORIALS[current % 10];
            if (sum > i) {
                return 0;
            }
            current /= 10;
        }

        return sum;
    }
}
