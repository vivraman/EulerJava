package euler.java.solutions;

/** Problem 15: Lattice paths
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 */
public class Euler015 extends EulerProblem {

    /**
     * Since movement in this question is restricted to downward and rightward paths, for an n x n lattice,
     * there are n downward and n rightward paths, for a total of 2n movements per lattice traversal
     * (d r d r ... d r). The total number of routes for a 20 x 20 lattice, then, is equal to the total number of
     * possible arrangements of this 40-value sequence. This is equivalent to a stars and bars combinatorics
     * problem with 20 objects to be placed in 21 buckets, which is equal to 40 choose 20.
     *
     * @return solution to Problem 15
     */
    @Override
    protected String solve() {
        long answer = 1;
        for (int i = 40; i > 20; i--) {
            answer *= i;
            answer /= (40 - i + 1);
        }
        return answer + "";
    }
}