package euler.java.main;

import java.util.*;

public class Utility {

    /**
     * Convert a Set (or any Collection) to a sorted List
     *
     * @param c collection to convert
     * @param <T> type being held by c
     * @return sorted list containing all objects held by c
     */
    public static <T extends Comparable<? super T>> List<T> setToSortedList(Collection<T> c) {
        List<T> list = new ArrayList<T>(c);
        Collections.sort(list);
        return list;
    }

    /**
     * Generate an array of factorial values, from 0! to (limit - 1)! inclusive, so that continuous calculation is not
     * necessary. Note that 0! = 1
     *
     * @param limit upper bound of factorials to generate, exclusive
     * @return integer array containing factorial values ordered based on index
     */
    public static int[] getFactorialArray(int limit) {
        int[] fact = new int[limit];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i;
        }
        return fact;
    }

    /**
     * Generate an array of power values, from base ^ 0 to base ^ (limit - 1) inclusive, so that continuous calculation is not
     * necessary.
     *
     * @param maxPower upper bound of powers to generate, exclusive
     * @return integer array containing power values ordered based on index
     */
    public static int[] getPowerArray(int base, int maxPower) {
        int[] power = new int[maxPower + 1];
        power[0] = 1;
        for (int i = 1; i < power.length; i++) {
            power[i] = power[i - 1] * base;
        }
        return power;
    }

    /**
     * Checks if parameter is palindrome using arithmetic reversal
     *
     * @param number integer to check
     * @return true if number is a palindrome, false otherwise
     */
    public static boolean isPalindrome(int number) {
        int num = number, reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return reverse == number;
    }

    /**
     * Checks if parameter is binary palindrome via generating reversal through bit operations.
     *
     * @param number number to check
     * @return true if number is a binary palindrome, false otherwise
     */
    public static boolean isBinaryPalindrome(int number) {
        int reverseTry = 0;
        for(int temp = number; temp > 0; temp >>= 1) {
            reverseTry = (reverseTry << 1) + (temp & 1);
        }
        return number == reverseTry;
    }

    /**
     * Generates the first n primes and returns them in an array.
     *
     * @param n number of primes to generate
     * @return array containing first n primes
     */
    public static int[] getPrimeArray(int n) {
        int[] primes = new int[n];

        primes[0] = 2;

        for (int counter = 1, i = 3; counter < n; i += 2) {
            boolean isPrime = true;
            int searchLimit = (int) (Math.sqrt(i));
            for (int j = 0; primes[j] <= searchLimit; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[counter++] = i;
            }
        }

        return primes;
    }

    /**
     * Generates an ArrayList containing all primes less than or equal to upperBound.
     *
     * @param upperBound upper bound of prime search
     * @return ArrayList of primes bounded by limit
     */
    public static ArrayList<Integer> getPrimeListBounded(int upperBound) {
        ArrayList<Integer> primes = new ArrayList();

        primes.add(2);

        for (int i = 3; i < upperBound; i += 2) {
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
            }
        }
        return primes;
    }
}
