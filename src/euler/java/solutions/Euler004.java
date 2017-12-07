package euler.java.solutions;

import euler.java.main.Utility;

/**
 * Problem 4: Largest palindrome product
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Euler004 implements EulerProblem {

    /**
     * Brute force: assume that multiples will be between 900 and 999 and that
     * the solution will be six digits. Then, algebra dictates that our solution
     * follows the form
     * xyzzyx = 100000x + 10000y + 1000z + 100z + 10y + 1x
     * = 100001x + 10010y + 1100z
     * = 11(9091x + 910y + 100z) (answer is divisible by 11)
     * Hence check all products with 900 <= i, j <= 999 that is divisible by 11.
     *
     * @return solution to Problem 4
     */
    public String solve() {
        int answer = 0;
        for (int i = 999; i > 900; i--) {
            for (int j = 999; j > 900; j--) {
                if (i % 11 == 0) {
                    int temp = i * j;
                    if (Utility.isPalindrome(temp) && temp > answer) {
                        answer = temp;
                    }
                }
            }
        }
        return answer + "";
    }
}