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
     * Generate a list of factorial values, from 0 to limit - 1 inclusive, so that continuous calculation is not
     * necessary. Note that 0! = 1
     *
     * @param limit upper bound of factorials to generate, exclusive
     * @return integer array containing factorial values based on index
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
}
