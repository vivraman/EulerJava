package euler.java.solutions;

import java.util.ArrayList;

/**
 * Problem 3: Largest prime factor
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Euler003 implements EulerProblem {


    public static final long COMPOSITE = 600851475143L;

    /**
     * Brute force; find all primes (skip 2 since our value is odd) less than
     * half of our value. If prime, divide (if divisible) our value by the new prime
     * repeatedly until it is no longer divisible. Continue until value = 1 (done)
     *
     * Uses modified version of Utility.getPrimeListBounded
     *
     * @return solution to Problem 3
     */
    public String solve() {
        long value = COMPOSITE;
        int answer = 0;

        ArrayList<Integer> primes = new ArrayList();
        primes.add(2);

        for (int i = 3; value != 1; i += 2) {
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
                while (value % i == 0) {
                    value /= i;
                    answer = i;
                }
            }
        }

        return answer + "";
    }
}
