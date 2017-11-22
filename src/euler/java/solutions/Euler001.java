package euler.java.solutions;

/**
 * Problem 1: Multiples of 3 and 5
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Euler001 implements EulerProblem {

    /**
     * Brute force solution, iterate through full range
     *
     * @return solution to Problem 1
     */
    public String solve() {
        int answer = 0;
        for (int i = 1; i < 1000; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                answer += i;
            }
        }
        return answer + "";
    }
}
