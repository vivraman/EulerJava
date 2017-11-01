package euler.java.solutions;

/**
 * Problem 9: Special Pythagorean triplet
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a^2 + b^2 = c^2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Euler009 extends EulerProblem {

    /**
     * Standard brute force algorithm, using a and b as variables while c is the difference
     * between the sum of a and b and 1000. Checks every possible triplet to find the valid
     * solution.
     *
     * @return solution to Problem 9
     */
    @Override
    protected String solve() {
        int k = 0;
        for (int i = 3; i < 1000; i++) {
            for (int j = i + 1; j < 1000; j++) {
                if (i + j >= (k = 1000 - (i + j))) {
                    if (i * i + j * j == k * k) {
                        return (i * j * k) + "";
                    }
                }
            }
        }
        return "";
    }

}
