package euler.java.solutions;

import java.math.BigInteger;

/**
 * Problem 25: 1000-digit Fibonacci number
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Euler025 extends EulerProblem {

    /**
     * Brute force solution involving BigInteger.
     *
     * @return solution to Problem 25
     */
    @Override
    protected String solve() {
        BigInteger prev, next, temp, upper;

        prev = new BigInteger("1");
        next = new BigInteger("2");
        upper = new BigInteger("10");
        upper = upper.pow(999);
        int nextindex = 3;
        while (next.compareTo(upper) == -1) {
            temp = next.add(prev);
            prev = next;
            next = temp;
            nextindex++;
        }
        return nextindex + "";
    }
}
