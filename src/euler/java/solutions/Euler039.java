package euler.java.solutions;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three
 * solutions for p = 120. {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Euler039 extends EulerProblem {

    private static final int LIMIT = 1000;
    /**
     * Here, we apply a straightforward brute-force approach but use several limited search ranges in order to
     * refine our search. Firstly and most trivially, we start the perimeter at 12 because the first
     * Pythagorean triplet (3,4,5) has that perimeter. Additionally, for a triplet with perimeter, a < b < c.
     * Finally, we generate a list of squares beforehand
     *
     * @return solution to Problem 39
     */
    @Override
    protected String solve() {
        int maxP = 0, maxCounter = 0;
        int[] squares = generateSquares(LIMIT);
        for (int p = 12; p <= LIMIT; p++) {
            int counter = 0;
            for (int a = 1; a < p; a++) {
                for (int b = a + 1; b < p - (a + b); b++) {
                    int c = p - (a + b);
                    if (squares[a - 1] + squares[b - 1] - squares[c - 1] == 0) {
                        counter++;
                    }
                }
            }

            if (counter > maxCounter) {
                maxCounter = counter;
                maxP = p;
            }
        }

        return maxP + "";
    }

    /**
     * Generate array of squares from 1 to limit, with index lookup shifted down by 1.
     * @param limit size of array, upper bound of squares to find
     * @return array of squares from 1 to limit
     */
    private int[] generateSquares(int limit) {
        int[] squares = new int[limit];
        for (int i = 1; i <= limit; i++) {
            squares[i - 1] = i * i;
        }
        return squares;
    }
}
