package euler.java.solutions;

import euler.java.main.Utility;

import java.util.ArrayList;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For
 * example, 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */
public class Euler041 implements EulerProblem {

    /**
     * Iterate through all n-digit pandigitals, starting from n = 7 and decreasing the value of n as potential solutions
     * are discounted. Ensure that each list of pandigitals is sorted, in this case through sequential generation. Note
     * that all 8-digit and 9-digit pandigitals are all divisible by 9 (since the sum of all 8-digit pandigitals is 36
     * and the sum of all 9-digit pandigitals is 45, which are both divisible by 9) and hence do not need to be checked
     * for primeness. Checking pandigitals for primeness relies on the square root divisibility rule: a number p is
     * prime if it is not divisible by all primes less than the square root of p.
     *
     * @return solution to Problem 41
     */
    public String solve() {
       final int max = 7654321;

        ArrayList<Integer> primes = Utility.getPrimeListBounded((int) Math.sqrt(max));

        for (int p = 7; p > 0; p--) {
            ArrayList<Integer> pandigitals = Utility.generatePandigitalsOrdered(1, p);
            int temp;
            for (int i = pandigitals.size() - 1; i >= 0; i--) {
                temp = pandigitals.get(i);
                if (isPrime(temp, primes)) {
                    return pandigitals.get(i) + "";
                }
            }
        }

        return "";
    }

    /**
     * Checks whether a number is prime, assuming a sufficiently large set of previously-found primes has been found.
     *
     * @param num number to check for primeness
     * @param primes list of primes to check against
     * @return true if num is prime, false otherwise
     */
    private boolean isPrime(int num, ArrayList<Integer> primes) {
        for (int prime : primes) {
            if (num % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
