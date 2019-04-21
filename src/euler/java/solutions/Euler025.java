package euler.java.solutions;

import java.math.BigInteger;

/**
 * Problem 25: 1000-digit Fibonacci number
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Euler025 implements EulerProblem {

    private static final BigInteger THOUSAND_DIGITS = new BigInteger("10").pow(999);
    /**
     * Brute force solution involving BigInteger.
     *
     * @return solution to Problem 25
     */
    public String solve() {
        BigInteger prev, next, temp, upper;

        prev = new BigInteger("1");
        next = new BigInteger("2");
        int nextindex = 3;
        while (next.compareTo(THOUSAND_DIGITS) == -1) {
            temp = next.add(prev);
            prev = next;
            next = temp;
            nextindex++;
        }
        return nextindex + "";
    }
}
