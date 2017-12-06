package euler.java.solutions;

import java.util.HashSet;

public class Euler045 implements EulerProblem {

    public static final int INVALID_ANSWER = 40755;

    /**
     * Brute-force solution. From n = 1 onwards, continuously generate triangle, pentagonal, and hexagonal numbers
     * for values of n. Since exagonal numbers increase at a faster rate than pentagonal ones, which in turn increase
     * faster than triangle numbers, we know that if t_a = p_b = h_c, then a > b > c for a, b, c > 1. With this in
     * mind, first store all generated hexagonal values in a HashSet for quick access. Then, check each generated
     * pentagonal value to see if it is also hexagonal by checking against the hashset; if the number is found, store
     * the pentagonal/hexagonal value in another HashSet. Finally, check each generated triangle number against the
     * second HashSet. If the triangle number is found and the solution is not 40755 (the first tri-penta-hex number),
     * the solution is found. 1 is an additional solution and is skipped as a result.
     *
     * @return solution to Problem 45
     */
    public String solve() {
        HashSet<Long> hexNums = new HashSet(), hexPenNums = new HashSet();

        long solution = 0, tri = 0, pen = 0, hex = 0;
        for (long i = 1; solution < 2; i++) {
            tri = getTriangleNumber(i);
            pen = getPentagonalNumber(i);
            hex = getHexagonalNumber(i);

            hexNums.add(hex);
            if (hexNums.contains(pen)) {
                hexPenNums.add(pen);
            }
            if (hexPenNums.contains(tri) && tri != INVALID_ANSWER) {
                solution = tri;
            }

        }
        return solution + "";
    }

    /**
     * Generates the ith triangle number
     *
     * @param i index of number to generate
     * @return triangle number at position i in the sequence
     */
    public long getTriangleNumber(long i) {
        return i * (i + 1) / 2;
    }

    /**
     * Generates the ith pentagonal number
     *
     * @param i index of number to generate
     * @return pentagonal number at position i in the sequence
     */
    public long getPentagonalNumber(long i) {
        return i * (3 * i - 1) / 2;
    }

    /**
     * Generates the ith hexagonal number
     *
     * @param i index of number to generate
     * @return hexagonal number at position i in the sequence
     */
    public long getHexagonalNumber(long i) {
        return i * (2 * i - 1);
    }
}
