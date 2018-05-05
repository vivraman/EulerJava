package euler.java.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another. There
 * are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one
 * other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Euler049 implements EulerProblem {

    /**
     * Brute-force solution using a nested HashMap for the storage of potential solutions. First, find all four-digit
     * primes and iterate through all possible differences between two primes. Since we only wish to note differences
     * that possibly indicate a match between two palindromes, we can check if the difference in question is divisible
     * by 9. This is true because palindromes of a number all share the same digit-sum (sum of the number's digits), and
     * all numbers with the same digit-sum yield the same remainder when divided by 9.
     *
     * In regards to storage of potential candidates, the choice here is to use a nested HashMap. For an arithmetic
     * sequence x y z, the center value y is equidistant from x and z by some difference d. Therefore, if we map all
     * potential values of y (that is, every four-digit prime) to every valid difference value, a collision in y -> d
     * mappings implies that the two colliding scenarios are y + d and y - d, which correspond to x and z. With this
     * setup, the nested map takes the form {centerPrime -> {difference, otherPrime}}, where otherPrime could be either
     * x or z. Once a collision is found, check whether all three primes are palindromes of one another.
     *
     * @return solution to Problem 49
     */
    public String solve() {
        ArrayList<Integer> primeList = getPrimeSetFourDigits();

        // {centerPrime -> {difference, upperPrime}}
        HashMap<Integer, HashMap<Integer, Integer>> differenceMapping = new HashMap();

        for (int i = 0; i < primeList.size(); i++) {
            differenceMapping.put(primeList.get(i), new HashMap());
        }

        for (int i = 0; i < primeList.size(); i++) {
            for (int j = i + 1; j < primeList.size(); j++) {
                int difference = primeList.get(j) - primeList.get(i);
                if (difference % 9 == 0) {
                    if (differenceMapping.get(primeList.get(i)).containsKey(difference)) {
                        int[] candidatePalindromePrimes = {primeList.get(j), differenceMapping.get(primeList.get(i)).get(difference), primeList.get(i)};

                        String permutedResult = getPalindromeResult(candidatePalindromePrimes);
                        if (permutedResult != null) {
                            return permutedResult;
                        }
                    }
                    differenceMapping.get(primeList.get(i)).put(difference, primeList.get(j));
                    differenceMapping.get(primeList.get(j)).put(difference, primeList.get(i));
                }
            }
        }
        return "";
    }

    /**
     * Generates all four-digit primes and returns them as an ArrayList
     *
     * @return ArrayList of four-digit primes
     */
    private static ArrayList<Integer> getPrimeSetFourDigits() {
        ArrayList<Integer> primes = new ArrayList();
        ArrayList<Integer> fourDigitPrimes = new ArrayList();

        primes.add(2);

        for (int i = 3; i < 10000; i += 2) {
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
                if (i > 1000) {
                    fourDigitPrimes.add(i);
                }
            }
        }
        return fourDigitPrimes;
    }

    /**
     * Checks whether all numbers in the given array are palindromes of each other. Breaks down each number and
     * populates a frequency table for the digits of each number, and compares to see if the frequency arrays are
     * identical.
     *
     * @param nums numbers to verify as palindromes
     * @return null if nums does not contain palindromes or if nums contains the invalid answer (1487, 4817, 8147),
     *         otherwise returns an ordered concatenation of nums
     */
    private String getPalindromeResult(int[] nums) {
        Arrays.sort(nums);
        if (nums[1] == 4817) {
            return null;
        }
        int[][] values = new int[10][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while (temp > 0) {
                values[temp % 10][i]++;
                temp /= 10;
            }
        }

        for (int i = 0; i < values.length; i++) {
            for (int j = 1; j < values[i].length; j++) {
                if (values[i][j - 1] != values[i][j]) {
                    return null;
                }
            }
        }

        return "" + nums[0] + nums[1] + nums[2];
    }
}
