package euler.java.solutions;

/** Problem 21: Amicable numbers
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly
 * into n). If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and
 * b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore
 * d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Euler021 extends EulerProblem {

    /**
     * Brute force. Iterate through first 10000 numbers and check for divisor sums.
     *
     * @return solution to Problem 21
     */
    @Override
    protected String solve() {
        long answer = 0;
        int temp = 0;
        for (int i = 1; i < 10001; i++) {
            if (i == properDivisorSum(temp = properDivisorSum(i)) && i != temp) {
                answer += i;
            }
        }
        return answer + "";
    }

    /**
     * Retrieves divisor sum of number (with the exception of perfect squares). Checks divisibility up to (but
     * not inlcuding) square root of number because a perfect square will never fulfill the necessary divisor equality
     * required for the problem [that is, d(n^2) = n + 1 != n^2].
     *
     * @param num the number to find a divisor sum for
     * @return the divisor sum of num
     */
    public int properDivisorSum(int num) {
        int sum = 0;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum + 1;
    }
}
