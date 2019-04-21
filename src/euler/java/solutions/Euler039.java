package euler.java.solutions;

import euler.java.main.Utility;

/**
 * Problem 39: Integer right triangles
 *
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three
 * solutions for p = 120. {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Euler039 implements EulerProblem {

    private static final int LIMIT = 1000;
    /**
     * Here, we apply a straightforward brute-force approach but use several limited search ranges in order to
     * refine our search. Firstly and most trivially, we start the perimeter at 12 because the first
     * Pythagorean triplet (3,4,5) has that perimeter. Additionally, for a triplet with perimeter, a < b < c.
     * Finally, we generate a list of squares beforehand
     *
     * @return solution to Problem 39
     */
    public String solve() {
        int maxP = 0, maxCounter = 0;
        int[] squares = Utility.generateSquares(LIMIT);
        for (int p = 12; p <= LIMIT; p++) {
            int counter = 0;
            for (int a = 1; a < p; a++) {
                for (int b = a + 1; b < p - (a + b); b++) {
                    int c = p - (a + b);
                    if (squares[a] + squares[b] - squares[c] == 0) {
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
}
