package euler.java.solutions;

import java.util.ArrayList;

/**
 * Problem 10: Summation of primes
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */
public class Euler010 implements EulerProblem {

    private static final int LIMIT = 2000000;

    /**
     * Brute force method using standard algorithm for finding primes. Sums all found primes under
     * the upper bound specified in the problem. Uses array instead of ArrayList to optimize speed
     *
     * Uses modified version of Utility.getPrimeListBounded
     *
     * @return solution to Problem 10
     */
    public String solve() {
        long solution = 2;

        ArrayList<Integer> primes = new ArrayList();
        primes.add(2);

        for (int i = 3; i < LIMIT; i += 2) {
            boolean isPrime = true;

            int searchLimit = (int) (Math.sqrt(i));
            for (int j = 0; primes.get(j) <= searchLimit; j++) {
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
                solution += i;
            }
        }
        return solution + "";
    }
}
