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

    /**
     * Finds the number of divisors of the parameter by finding prime factors. A number's divisors
     * can be found by multiplying the frequency + 1 of all of its prime factors together. Uses brute-force check.
     * Upper bound of the prime facotrs to check is number/2, since beyond that point either the number would
     * already have been factored by 2, or the number is prime. Returns 1 if the number is prime.
     *
     * @param number number to find number of divisors of
     * @param primes array of primes, must at minimum contain all primes less than number / 2
     * @return number of divisors in number, -1 if primes is insufficiently large
     */
    public static int numberOfDivisors(int number, int[] primes) {
        if (number / 2 < primes[primes.length - 1]) {
            return -1;
        }

        int current = number, numberOfDivisors = 1, primeFactorFreq = 0, limit = number / 2;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i] > limit) {
                break;
            }
            primeFactorFreq = 1;
            while (current % primes[i] == 0) {
                primeFactorFreq++;
                current /= primes[i];
            }
            if (primeFactorFreq > 1) {
                numberOfDivisors *= primeFactorFreq;
            }
        }
        return numberOfDivisors;
    }

    /**
     * Generate array of squares from 1 to limit inclusive.
     *
     * @param limit size of array, upper bound of squares to find
     * @return array of squares from 1 to limit
     */
    public static int[] generateSquares(int limit) {
        int[] squares = new int[limit + 1];
        for (int i = 0; i <= limit; i++) {
            squares[i] = i * i;
        }
        return squares;
    }

    /**
     * Sequentially generates triangle numbers up to a certain upper bound (instead of explicit generation,
     * which is more expensive overall).
     *
     * @param upperBound Upper limit on triangle numbers that are generated. Once a generated triangle number
     *                   exceeds this upperBound, generation will end.
     * @return set of triangle numbers
     */
    public static ArrayList<Integer> generateTriangleNumbers(int upperBound) {
        ArrayList<Integer> triangleNums = new ArrayList();
        int counter = 1, sum = 1;
        triangleNums.add(sum);

        while ((sum += ++counter) < upperBound) {
            triangleNums.add(sum);
        }

        return triangleNums;
    }

    /**
     * Generates the ith triangle number
     *
     * @param i index of number to generate
     * @return triangle number at position i in the sequence
     */
    public static long getTriangleNumber(long i) {
        return i * (i + 1) / 2;
    }

    /**
     * Generates the ith pentagonal number
     *
     * @param i index of number to generate
     * @return pentagonal number at position i in the sequence
     */
    public static long getPentagonalNumber(long i) {
        return i * (3 * i - 1) / 2;
    }

    /**
     * Generates the ith hexagonal number
     *
     * @param i index of number to generate
     * @return hexagonal number at position i in the sequence
     */
    public static long getHexagonalNumber(long i) {
        return i * (2 * i - 1);
    }


    /**
     * Simplifies the fraction represented by the given parameters, and returns the simplified fraction as an int[].
     * Iterates through list of primes and divides both numbers by each prime if divisible. Continues until current
     * prime exceeds both numbers, at which point the fraction is fully simplified.
     *
     * @param num numerator of the fraction to be simplified
     * @param den denominator of the fraction to be simplified
     * @return the simplified fraction in the form of an int[]
     */
    public static int[] getSimplifiedFraction(int num, int den) {
        int[] simplified = {num, den};
        int limit = num > den ? num : den;

        ArrayList<Integer> primes = Utility.getPrimeListBounded(limit);

        for (int p : primes) {
            while (simplified[0] % p == 0 && simplified[1] % p == 0) {
                simplified[0] /= p;
                simplified[1] /= p;
                limit /= p;
            }

            if (p > limit) {
                return simplified;
            }
        }

        return simplified;
    }
}
