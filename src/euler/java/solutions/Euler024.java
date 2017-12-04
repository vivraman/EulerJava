package euler.java.solutions;

import euler.java.main.Utility;

/**
 * Problem 24: Lexicographic permutations
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits
 * 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic
 * order.
 * <p>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Euler024 implements EulerProblem {

    private static final int DIGITS = 10;

    /**
     * To find the millionth lexicographic permutation we effectively have to find the proper digit for each
     * location systematically, starting at the leftmost digit. This leftmost digit's value is the largest
     * available digit p_n such that n * 9! < 1000000, where p is the sorted sequence of all remaining digits.
     * From here, we subtract n * 9! from 1000000 (call this s_11), remove p_n from the sequence, and resume with
     * a lower factorial count and a newly-refined sequence (that is, the next digit's value is the largest
     * available digit p_n such that n * 8! < s_1. We continue until all digits are filled.
     *
     * @return solution to Problem 24
     */
    public String solve() {
        long answer = 0;
        int lexnum = 1000000;
        boolean[] nums = new boolean[DIGITS];
        int[] fact = Utility.getFactorialArray(DIGITS);

        for (int i = fact.length - 1; i > 0; i--) {
            int counter = 0;
            while (lexnum > fact[i]) {
                lexnum -= fact[i];
                counter++;
            }
            for (int j = 0; j < nums.length; j++) {
                if (!nums[j]) {
                    --counter;
                }
                if (counter == 0) {
                    answer += (j + 1) * Math.pow(10, i);
                    nums[j] = true;
                    break;
                }
            }
        }
        return answer + "";
    }

}
