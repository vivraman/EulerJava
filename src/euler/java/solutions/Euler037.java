package euler.java.solutions;

import euler.java.main.Utility;

import java.util.LinkedHashSet;
import java.util.Iterator;

/**
 * Problem 37: Truncatable primes
 *
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits
 * from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Euler037 implements EulerProblem {


    private static final int[] POWERS = Utility.getPowerArray(10, 8);

    /**
     * Continuously generate primes until 11 truncated primes are found, sum the found primes as
     * necessary. Use a final int[] of powers of ten so that there is no need to constantly generate them.
     *
     * Uses modified version of Utility.getPrimeListBounded
     *
     * @return solution to Problem 37
     */
    public String solve() {
        LinkedHashSet<Integer> set = new LinkedHashSet();
        set.add(2);

        Iterator<Integer> it = null;

        int product = 0, counter = 0, j = 0;
        for (int i = 3; counter < 11; i+= 2) {
            boolean isPrime = true;
            int searchLimit = (int) (Math.sqrt(i));
            it = set.iterator();
            while ((j = it.next()) <= searchLimit) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                set.add(i);
                if (i > 10 && isTruncatable(i, set)) {
                    product += i;
                    counter++;
                }
            }
        }

        return product + "";
    }

    /**
     * Checks whether a number is truncatable in both directions. Checking from left to right merely involves
     * dividing by ten and allowing java to floor the result. Checking from right to left requires us to find the
     * number of digits in num and iteratively remove the first digit.
     *
     * @param num the number to verify
     * @param primes set of primes to check results against
     * @return true if num can be truncated in both directions, false otherwise
     */
    private boolean isTruncatable(int num, LinkedHashSet<Integer> primes) {
        int tempNum = num;
        while ((tempNum /= 10) > 0) {
            if (!primes.contains(tempNum)) {
                return false;
            }
        }

        for (int i = 1; POWERS[i - 1] < num; i++) {
            if (!primes.contains(num % POWERS[i])) {
                return false;
            }
        }

        return true;
    }
}
