package euler.java.solutions;

/**
 * Problem 30: Digit fifth powers
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Euler030 implements EulerProblem {

    /**
     * The most significant aspect of this problem to immediately tackle is the upper bound of the
     * numbers that we have to search for. Specifically, we must find the solution to the expression
     * 9^5 * n < 10^n, since at that point, we will know that no n-digit number can be summed by the
     * fifth powers of its digits. Therefore, since n = 7 is the first value for which no fifth power
     * sum can add up to the minimum n-digit value (10^n), our upper bound to check is 6 * 9^5, which
     * is 354294. From here, we do a brute force check on each value between 1 and the upper bound.
     *
     * @return solution to Problem 30
     */
    public String solve() {
        long answer = 0;
        for (int i = 2; i < 354294; i++) {
            if (powerSumValid(i)) {
                answer += i;
            }
        }
        return answer + "";
    }

    /**
     * Calculates the sum of fifth powers of a number's digits and checks whether the sum is equal to
     * the parameter passed
     *
     * @param i the number to calculate the power sum of
     * @return true if sum of the fifth powers of digits of i is equal to i, false otherwise.
     */
    private boolean powerSumValid(int i) {
        int sum = 0, itemp = i;
        for (int j = 0; itemp > 0; j++) {
            int digit = itemp % 10;
            sum += digit * digit * digit * digit * digit;
            if (sum > i) {
                return false;
            }
            itemp /= 10;
        }
        return sum == i;
    }

}
