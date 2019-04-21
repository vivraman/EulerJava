package euler.java.solutions;

import java.util.ArrayList;

/**
 * Problem 92:
 *
 * A number chain is created by continuously adding the square of the digits in a number to form a new number until it
 * has been seen before. Any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing
 * is that every starting number will eventually arrive at 1 or 89.
 *
 * How many starting numbers below ten million will arrive at 89?
 */
public class Euler092 implements EulerProblem {

    private static final int SEARCH_LIMIT = 10000000;
    private static final int DIGIT_UPPER_BOUND = 7;
    private static final int CHAIN_UPPER_BOUND = 9 * 9 * DIGIT_UPPER_BOUND;

    /**
     * Brute force solution with an upper bound for square sum chain calculations. This process takes place in two
     * stages. The first stage takes advantage of the chained behavior of square sum calculations. For example, when
     * considering the square sum properties of 2, we note that since 2 -> 4 -> 16 -> 37 -> 58 -> 89, every number in
     * that chain eventually leads to 89. Tracking the values and end results of chains (in this case, within an array)
     * allows us to quickly end future chain calculations before ending at either 1 or 89. Furthermore, since the number
     * search limit upper bound is 10000000, the largest square sum possible corresponds to that of 9999999. Hence, we
     * can stop calculating chained square sums at 9^2 * 7 = 567. The second stage applies for all numbers above 567,
     * for which we simply have to perform one square sum calculation and check against the previously-generated table.
     *
     * @return solution to Problem 92
     */
    public String solve() {
        int size89 = 1;

        int[] squares = new int[10];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = i * i;
        }

        boolean[][] placements = new boolean[CHAIN_UPPER_BOUND + 1][2];
        placements[1][0] = true;
        placements[89][1] = true;

        ArrayList<Integer> currentChain = new ArrayList();
        for (int i = 1; i < SEARCH_LIMIT; i++) {
            if (i <= CHAIN_UPPER_BOUND) {

                int temp = i;
                while (!placements[temp][0] && !placements[temp][1]) {
                    currentChain.add(temp);
                    temp = getNextSquareSum(temp, squares);
                }

                if (placements[temp][0]) {
                    for (int c : currentChain) {
                        placements[c][0] = true;
                    }
                } else if (placements[temp][1]) {
                    for (int c : currentChain) {
                        placements[c][1] = true;
                    }

                    size89 += currentChain.size();
                }

                currentChain.clear();
            } else {
                int squareSumVal = getNextSquareSum(i, squares);

                if (squareSumVal == 89 || placements[squareSumVal][1]) {
                    size89++;
                }
            }

        }
        return size89 + "";
    }

    /**
     * Calculates the sum of the square of all digits of a number. Uses a lookup table for square values in order to
     * avoid repeated calculations.
     *
     * @param num the number to calculate the square sum of
     * @param squares a lookup array for squares
     * @return the sum of the square of all digits of num
     */
    private int getNextSquareSum(int num, int[] squares) {
        int val = 0;

        for (int digit = 0; num > 0; num /= 10) {
            digit = num % 10;
            val += squares[digit];
        }

        return val;
    }
}

