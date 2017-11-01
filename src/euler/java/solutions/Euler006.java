package euler.java.solutions;

/** Problem 6: Description
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural 
 * numbers and the square of the sum is 3025 − 385 = 2640.

 * Find the difference between the sum of the squares of the first one hundred 
 * natural numbers and the square of the sum.
 */
public class Euler006 extends EulerProblem {

    /**
     * A simple expansion of (1 + 2 + 3 + ... n)^2 - 1^2 + 2^2 + 3^2 + ... + n^2
     * reveals the answer to be 2 times the sum of all unique combinations of 
     * two numbers between 1 and n, inclusive. Brute force solution of this sum:
     *
     * @return solution to Problem 6
     */
    @Override
    protected String solve() {
        int answer = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = i + 1; j <= 100; j++) {
                answer += i * j;
            }
        }
        return (2 * answer) + "";
    }
}
