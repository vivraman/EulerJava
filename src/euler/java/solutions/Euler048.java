package euler.java.solutions;

import java.math.BigInteger;

/**
 * Problem 48: Self powers
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 *
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Euler048 implements EulerProblem {

    private static final int LIMIT = 1000;

    /**
     * Use BigInteger to power and sum as necessary.
     *
     * @return solution to Problem 48
     */
    public String solve() {
        BigInteger total = new BigInteger(1 + "");
        for (int i = 2; i <= LIMIT; i++) {
            total = total.add(new BigInteger(i + "").pow(i));
        }

        String answer = total.toString();
        return answer.substring(answer.length() - 10);
    }
}
