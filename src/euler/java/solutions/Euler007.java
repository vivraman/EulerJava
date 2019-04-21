package euler.java.solutions;

import euler.java.main.Utility;
/**
 * Problem 7: 10001st prime
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10,001st prime number?
 */
public class Euler007 implements EulerProblem {

    private static final int LIMIT = 10001;

    /**
     * Brute force solution. Find primes using previously established methods,
     * except use array for efficiency since we know how many primes we need.
     * Count to 10001, break and print solution.
     *
     * @return solution to Problem 1
     */
    public String solve() {
        return Utility.getPrimeArray(LIMIT)[LIMIT - 1] + "";
    }
}
