package euler.java.solutions;

import java.math.BigInteger;

/**
 * Problem 16: Power digit sum
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */
public class Euler016 implements EulerProblem {

    /**
     * BigInteger makes this relatively simple to implement.
     *
     * @return solution to Problem 16
     */
    public String solve() {
        long answer = 0;
        String temp = new BigInteger("2").pow(1000).toString();
        for (int i = 0; i < temp.length(); i++) {
            answer += temp.charAt(i) - '0';
        }
        return answer + "";
    }
}
