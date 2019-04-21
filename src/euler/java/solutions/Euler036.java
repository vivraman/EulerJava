package euler.java.solutions;

import euler.java.main.Utility;

/**
 * Problem 36: Double-base palindromes
 *
 * The decimal number, 585 = 1001001001_2 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2. The palindromic
 * number, in either base, may not include leading zeros.
 */
public class Euler036 implements EulerProblem {

    private static final int LIMIT = 1000000;

    /**
     * Generate all palindromes below the upper limit (in this case, 1000000), and check to see if each generated
     * palindrome is binary. To generate palindromes, use a steadily incrementing counter and mirror it against
     * itself to generate all even-length palindromes. To generate all odd-length palindromes, remove a trailing digit
     * from the same counter, then mirror the remaining number against the original counter value. These two
     * cases of generation run concurrently, and each individual case is stopped when a generated palindrome exceeds
     * LIMIT. See generatePalindrome for further details.
     *
     * @return solution to Problem
     */
    public String solve() {
        int sum = 0;
        int[] pValues = {0, 0};
        boolean[] pStatus = {true, true};

        for (int i = 1; pStatus[0] || pStatus[1]; i++) {
            for (int j = 0; j < 2; j++) {
                if (pStatus[j]) {
                    pValues[j] = generatePalindrome(i, j);
                    if (pValues[j] > LIMIT) {
                        pStatus[j] = false;
                    } else if (Utility.isBinaryPalindrome(pValues[j])) {
                        sum += pValues[j];
                    }
                }
            }
        }

        return sum + "";
    }

    /**
     * Generates a palindrome based on a given input, which is mirrored based on a given buffer. A buffer of 0 returns
     * a palindrome strictly mirrored off of input, whereas any other buffer returns a palindrome mirrored around the
     * final digit of input.
     *
     * @param input value to generate palindrome from
     * @param buffer type of palindrome to generate: 0 gives a strict palindrome based off of input, other values give
     *               palindrome mirrored around final digit of input
     * @return a palindrome based on the given input and buffer values
     */
    private int generatePalindrome(int input, int buffer) {
        int palindrome = input, append = buffer != 0 ? input /= 10 : input;

        while (append > 0) {
            palindrome = palindrome * 10 + (append % 10);
            append /= 10;
        }
        return palindrome;
    }

}
