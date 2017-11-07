package euler.java.solutions;

import java.util.*;

/**
 * Problem 27: Quadratic primes
 * Euler discovered the remarkable quadratic formula: n^2 + n + 41. It turns out that the formula will produce 40
 * primes for the consecutive integer values 0 ≤ n ≤ 39.
 * <p>
 * The incredible formula n^2 − 79n + 1601 was discovered, which produces 80 primes for the consecutive values
 * 0 ≤ n ≤ 79. The product of the coefficients, −79 and 1601, is −126479.
 * <p>
 * Considering quadratics of the form: n^2 + an + b, where |a| < 1000 and |b| ≤ 1000, find the product of
 * the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for
 * consecutive values of n, starting with n=0.
 */
public class Euler027 extends EulerProblem {

    private static final int PRIME_LIMIT = 10000;

    /**
     * Generate an initial list of primes up to an arbitrary number, in this case, 10000. Then, for each possible
     * value of a and b, brute force iterate through each quadratic and find the max number of consecutive primes
     * found. Use hash table for prime list for quick lookup
     *
     * Note that for n = 0 in the quadratic the solution is 0^2 + 0a + b = b. Hence b must be prime.
     *
     * @return solution to Problem 27
     */
    @Override
    protected String solve() {
        ArrayList<Integer> primeList = new ArrayList<>();
        HashSet<Integer> primes = generatePrimes(primeList, PRIME_LIMIT);

        int maxPrimeCount = 0, product = 0;
        int a = 0, b = 0;
        for (int test = 0; (b = primeList.get(test)) < 1000; test++) {
            for (a = -1000; a < 1001; a++) {
                int consecPrimeCount;
                if ((consecPrimeCount = consecPrimes(a, b, primes)) > maxPrimeCount) {
                    maxPrimeCount = consecPrimeCount;
                    product = a * b;
                }
            }
        }
        return product + "";
    }

    /**
     * Generates a HashSet containing all primes from 2 to limit, inclusive. Also adds these primes to
     * primeList
     *
     * @param primeList the list to add primes to
     * @param searchLimit the upper bound (inclusive) of primes to search for
     * @return a HashSet containing all primes found
     */
    private HashSet<Integer> generatePrimes(ArrayList<Integer> primeList, int searchLimit){
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        primeList.add(2);

        for (int i = 3; i <= searchLimit; i += 2) {
            boolean isPrime = true;
            int limit = (int) (Math.sqrt(i));
            for (int j = 0; primeList.get(j) <= limit && j < primeList.size(); j++) {
                if (i % primeList.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                set.add(i);
                primeList.add(i);
            }
        }
        return set;
    }

    /**
     * Returns the total number of consecutive primes generated by the quadratic expression n^2 + an + b
     *
     * @param a coefficient a for the quadratic expression
     * @param b coefficient b for the quadratic expression
     * @return number of consecutive primes generated by the quadratic expression
     */
    private int consecPrimes(int a, int b, HashSet<Integer> primes) {
        for (int i = 0; ; i++) {
            if (!primes.contains(i * i + a * i + b)) {
                return i;
            }
        }
    }
}