package euler.java.solutions;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits
 * from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Euler037 extends EulerProblem {


    private static final int[] POWERS = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

    /**
     * Continuously generate primes until 11 truncated primes are found, sum the found primes as
     * necessary. Use a final int[] of powers of ten so that there is no need to constantly generate them.
     *
     * @return solution to Problem 37
     */
    @Override
    protected String solve() {
        ArrayList<Integer> primeList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        long product = 0, counter = 0;

        set.add(2);
        primeList.add(2);

        int i = 3;
        while (counter < 11) {
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
                if (i > 10 && isTruncatable(i, set)) {
                    product += i;
                    counter++;
                }
            }
            i += 2;
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
    private boolean isTruncatable(int num, HashSet<Integer> primes) {
        int tempNum = num;
        while ((tempNum /= 10) > 0) {
            if (!primes.contains(tempNum)) {
                return false;
            }
        }

        tempNum = num;
        int powerNum = 0;
        for (int i = 1; i < POWERS.length; i++) {
            if (num > POWERS[i]) {
                powerNum = i;
            } else break;
        }

        while ((tempNum -= (tempNum / POWERS[powerNum]) * POWERS[powerNum]) > 0) {
            if (!primes.contains(tempNum)) {
                return false;
            }
            powerNum--;
        }

        return true;
    }
}
