package euler.java.solutions;

import java.math.BigInteger;

/**
 * Problem 26: Reciprocal cycles
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Euler026 extends EulerProblem {

    /**
     * Brute force all odd numbers up to 1000, with the exception of numbers divisible by 5, in order to find
     * the solution. Solution can be quickly found by finding the multiplicative order of the denominator in
     * question.
     *
     * @return solution to Problem 26
     */
    @Override
    protected String solve() {
        int maxrep = 0, repnum = 0, temp = 0;
        for (int i = 3; i < 1000; i += 2) {
            if (i % 5 != 0) {
                if ((temp = repetitionNumber(i)) > maxrep) {
                    maxrep = temp;
                    repnum = i;
                }
            }
        }
        return repnum + "";
    }

    /**
     * Used multiplicative order to solve: 10^x = 1 (mod n) for all n relatively
     * prime to 10. That is, consider all odd n not divisible by five.
     *
     * @param i
     * @return
     */
    private int repetitionNumber(int i) {
        BigInteger tenpow = new BigInteger("10"), denom = new BigInteger(i + ""), temp;
        int counter = 1;
        while (!(temp = tenpow.mod(denom)).equals(BigInteger.ONE)) {
            if (temp.equals(BigInteger.ZERO)) {
                return 0;
            }
            tenpow = tenpow.multiply(BigInteger.TEN);
            counter++;
        }
        return counter;
    }
}
