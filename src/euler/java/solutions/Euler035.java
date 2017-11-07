package euler.java.solutions;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are
 * themselves prime. There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 */
public class Euler035 extends EulerProblem {

    private static final int LIMIT = 1000000;
    private static final int[] POWERS = {1, 10, 100, 1000, 10000, 100000, 1000000};

    /**
     * First, generate a list of primes up to 1000000. Store this in both a HashSet (for quick
     * lookup of potential primes) and in an ArrayList (since we need a sorted list of currently-found
     * primes to find the next primes). From here, we check if every found prime is circular or not,
     * and if so, we add to a counter.
     *
     * @return solution to Problem 35
     */
    @Override
    protected String solve() {
        ArrayList<Integer> primeList = new ArrayList<>();
        HashSet<Integer> primes = generatePrimes(primeList, LIMIT);

        int counter = 0;
        for (int i = 0 ; i < primeList.size(); i++) {
            if (isCircular(primeList.get(i), primes)) {
                counter++;
            }
        }
        return counter + "";
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
     * Finds whether a number is circular. A circular number has n rotations (including itself, all of which are
     * prime, where n is one less than the number of digits that the number has. Since every number passed to
     * this method is prime, check all of its other rotations one by one  and verify that they are prime.
     *
     * @param num the number to check for circularity
     * @param primes set of primes to compare against
     * @return true if num is circular, false otherwise
     */
    private boolean isCircular(int num, HashSet<Integer> primes) {
        int numberOfDigits = 0;
        for (int i = 1; i < POWERS.length; i++) {
            if (num > POWERS[i]) {
                numberOfDigits = i;
            } else break;
        }

        for (int i = 0; i < numberOfDigits; i++) {
            num = rotate(num, numberOfDigits);
            if (!primes.contains(num)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Rotates a number to the left
     *
     * @param input number to rotate
     * @param powerLimit power of first digit of the number, needed to move the last digit of the initial number
     *                   to the first digit of the newly-rotated number
     * @return result of the rotation of input to the left
     */
    private int rotate (int input, int powerLimit) {
        int firstDig = input % 10;
        return firstDig * POWERS[powerLimit] + (input - firstDig) / 10;
    }
}
