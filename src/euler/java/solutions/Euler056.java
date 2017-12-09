package euler.java.solutions;

import java.math.BigInteger;

/**
 * Problem 56: Powerful digit sum
 *
 * Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
 */
public class Euler056 implements EulerProblem {

    private static final int LIMIT = 100;

    /**
     * Brute-force solution with constraints to improve runtime. Base values divisible by ten are unlikely to be
     * desired solutions, since these results leave several trailing zeroes. Values start at 2 to avoid trivial
     * 1 and 0 cases.
     *
     * @return solution to Problem 56
     */
    public String solve() {
        int sum = 0, tempSum;
        String pow;

        for (int i = 2; i <=  LIMIT; i++) {
            for (int j = 2; j <=  LIMIT; j++) {
                if (i % 10 != 0) {
                    tempSum = 0;
                    pow = new BigInteger(i + "").pow(j).toString();
                    for (int k = 0; k < pow.length(); k++) {
                        tempSum += pow.charAt(k) - '0';
                    }
                    if (tempSum > sum) {
                        sum = tempSum;
                    }
                }
            }
        }

        return sum + "";
    }
}
