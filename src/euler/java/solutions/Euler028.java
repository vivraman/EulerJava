package euler.java.solutions;

/**
 * Problem 28: Number spiral diagonals
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class Euler028 extends EulerProblem {

    /**
     * The diagonal sum is equal to the sum of all four corners of each consecutive box of numbers, the dimensions
     * of which increase by two every time (that is, 1x1, 3x3, 5x5, etc.). Start with the 1x1 sum being 1, and from
     * there, note that the first (base) corner's value for the next dimension is (side - 1), where the side is the current
     * square's dimensions's. From there, the other three corners are c + (side - 1), c + 2(side - 1), and
     * c + 3(side - 1), where c is the value of the first corner. Adding all four of these gives us 4c + 6 (side - 1).
     * Add this value to sum, then set the new base corner's value to be the last corner, that is, c^2. Continue for
     * each square.
     *
     * @return solution to Problem 28
     */
    @Override
    protected String solve() {
        long sum = 1, baseCorner = 1;
        for (int side = 3; side <= 1001; side += 2) {
            baseCorner += side - 1;
            sum += 4 * baseCorner + 6 * (side - 1);
            baseCorner = side * side;
        }
        return sum + "";
    }
}
