package euler.java.main;

import java.util.*;

public class Utility {

    /**
     * Convert a Set (or any Collection) to a sorted List
     *
     * @param c   collection to convert
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
        for (int temp = number; temp > 0; temp >>= 1) {
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
     * Checks to see whether a number is pentagonal
     *
     * @param i the number to check
     * @return true if the number is pentagonal, false otherwise
     */
    public static boolean isPentagonaNumber(long i) {
        return (Math.sqrt(24 * i + 1) + 1) % 6 == 0;
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

    /**
     * Checks whether a x-digit number is pandigital (1-x). Uses a 9-bit integer to keep track of each potential digital
     * value. Each digit value is represented by a 1 in the (x - 1)th place of the 9 bit integer, where x is the value
     * of the digit. Then, continuously performing bitwise OR on each bitshifted integer allows us to check for
     * duplicates; if there is no change after the OR, the digit in question has already appeared. Returns true if the
     * end result of those consecutive ORs is equal to 1...1, with length x.
     *
     * @param num the number to check
     * @return true if num is pandigital from 1-x, false otherwise
     */
    public static boolean isPandigital(int num) {
        int allDigits = 0, count = 0, temp;

        for (; num > 0; num /= 10, ++count) {
            temp = allDigits;
            if (temp == (allDigits |= 1 << (num % 10 - 1)))
                return false;
        }

        return allDigits == (1 << count) - 1;
    }

    /**
     * Generate pandigital numbers iteratively and in increasing (lexicographic) order. Generate list of digits from 1
     * to n, and then apply the following algorithm:
     * <p>
     * 1) Find the largest index k such that a[k] < a[k + 1]. If no such index exists (k = -1), the permutation is the
     * last permutation.
     * 2) Find the largest index l greater than k such that a[k] < a[l].
     * 3) Swap the value of a[k] with that of a[l].
     * 4)Reverse the sequence from a[k + 1] up to and including the final element a[n].
     * 5) Continuously convert each array sequence to number form after each permutation and add to list.
     *
     * @param start digit to start generation at
     * @param end   digit to end generation at
     * @return list of all pandigital permutations with digits from start to end
     */
    public static ArrayList<Integer> generatePandigitalsOrdered(int start, int end) {
        ArrayList<Integer> pandigitals = new ArrayList();

        if (end < start) return null;

        // generate starting pandigital values (lowest lexicographic pandigital number)
        int[] values = new int[end - start + 1];
        for (int i = 0; start <= end; i++) {
            values[i] = start++;
        }

        pandigitals.add(Utility.getArrayNumericValue(values));

        int k = 0;
        // break if k value isn't assigned
        while (k >= 0) {
            k = -1;
            // find value of k (
            for (int i = values.length - 2; k < 0 && i >= 0; i--) {
                if (values[i] < values[i + 1]) {
                    k = i;
                }
            }

            if (k != -1) {
                // if k was found, find value of l
                for (int l = values.length - 1; l > k; l--) {
                    if (values[k] < values[l]) {
                        // swap k and l values
                        int temp = values[l];
                        values[l] = values[k];
                        values[k] = temp;

                        k++;
                        // reverse sequence from k + 1 to end
                        for (int i = 0; i < ((values.length - 1) - k + 1) / 2; i++) {
                            // swap outer layers one by one until reversed
                            temp = values[k + i];
                            values[k + i] = values[values.length - 1 - i];
                            values[values.length - 1 - i] = temp;
                        }

                        break;
                    }
                }
                pandigitals.add(Utility.getArrayNumericValue(values));
            }
        }

        return pandigitals;
    }

    /**
     * Converts array of digits to number represented by those digits, ordered by index
     *
     * @param values the array to convert
     * @return integer representation of array
     */
    public static int getArrayNumericValue(int[] values) {
        int num = values[0];
        for (int i = 1; i < values.length; i++) {
            num *= 10;
            num += values[i];
        }

        return num;
    }

    public static int getNumberOfDigits(long value) {
        int digits = 1;

        if (value >= 100000000) {
            digits += 8;
            value /= 100000000;
        }
        if (value >= 10000) {
            digits += 4;
            value /= 10000;
        }
        if (value >= 100) {
            digits += 2;
            value /= 100;
        }
        if (value >= 10) {
            digits += 1;
        }

        return digits;
    }

    public static ArrayList<Integer> getDigitPermutations(int num) {
        ArrayList<Integer> permutations = new ArrayList();

        int[] digits = new int[Utility.getNumberOfDigits(num)];

        int temp = num;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        heapPermutation(digits, digits.length, digits.length, permutations);

        return permutations;
    }

    private static void heapPermutation(int a[], int size, int n, ArrayList<Integer> permutations) {
        // if size becomes 1 then prints the obtained permutation
        if (size == 1) {
            if (a[0] != 0) {
                int val = a[a.length - 1];
                for (int i = a.length - 2; i >= 0; i--) {
                    val = val * 10 + a[i];
                }

                permutations.add(val);
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(a,size - 1, n, permutations);

            // if size is odd, swap first and last element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }
            // If size is even, swap ith and last// element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }

}
