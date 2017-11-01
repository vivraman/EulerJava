package euler.java.solutions;

/**
 * Problem 10: Summation of primes
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */
public class Euler010 extends EulerProblem {

    int[] primes;

    /**
     * Brute force method using standard algorithm for finding primes. Sums all found primes under
     * the upper bound specified in the problem.
     *
     * @return solution to Problem 10
     */
    @Override
    protected String solve() {
        long answer = 2;
        boolean isPrime;
        int limit, counter = 0;
        primes = new int[500000];
        primes[counter++] = 2;
        for (int i = 3; i < 2000000; i += 2) {
            isPrime = true;
            limit = (int) (Math.sqrt(i));
            for (int j = 0; j < counter; j++) {
                if (primes[j] > limit) {
                    break;
                }
                if (i % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[counter++] = i;
                answer += i;
            }
        }
        return answer + "";
    }
}
