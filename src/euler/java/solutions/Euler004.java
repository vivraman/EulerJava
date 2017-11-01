package euler.java.solutions;

/** Problem 4: Largest palindrome product
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Euler004 extends EulerProblem {

    /**
     * Brute force: assume that multiples will be between 900 and 999 and that
     * the solution will be six digits. Then, algebra dictates that our solution
     * follows the form
     * xyzzyx = 100000x + 10000y + 1000z + 100z + 10y + 1x
     *        = 100001x + 10010y + 1100z
     *        = 11(9091x + 910y + 100z) (answer is divisible by 11)
     * Hence check all products with 900 <= i, j <= 999 that is divisible by 11.
     *
     * @return solution to Problem 4
     */
    @Override
    protected String solve() {
        int answer = 0;
        for (int i = 999; i > 900; i--) {
            for (int j = 999; j > 900; j--) {
                if (i % 11 == 0) {
                    int temp = i * j;
                    if (isPalindromeARITH(temp) && temp > answer) {
                        answer = temp;
                    }
                }
            }
        }
        return answer + "";
    }


    /**
     * Quick check of palindrome using string conversion
     *
     * @param number integer to check
     * @return true if number is a palindrome, false otherwise
     */
    private boolean isPalindromeSTR(int number) {
        String num = number + "";
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Quick check of palindrome using arithmetic reversal
     *
     * @param number integer to check
     * @return true if number is a palindrome, false otherwise
     */
    private boolean isPalindromeARITH(int number) {
        int num = number, reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return reverse == number;
    }
}
