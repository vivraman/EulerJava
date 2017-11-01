package euler.java.solutions;

import java.math.BigInteger;

/**
 * Problem 20: Factorial digit sum
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * <p>
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */
public class Euler020 extends EulerProblem {

    /**
     * BigInteger makes this implementation straightforward
     *
     * @return solution to Problem 20
     */
    @Override
    protected String solve() {
        long answer = 0;
        BigInteger fact = new BigInteger("1");
        for (int i = 2; i < 100; i++) {
            if (i % 5 != 0) {
                fact = fact.multiply(new BigInteger(i + ""));
            } else {
                fact = fact.multiply(new BigInteger(i + ""));
                fact = fact.divide(new BigInteger(10 + ""));
            }
        }
        String temp = fact.toString();
        for (int i = 0; i < temp.length(); i++) {
            answer += temp.charAt(i) - '0';
        }
        return answer + "";
    }
}
