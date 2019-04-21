package euler.java.solutions;

import java.util.ArrayList;

/**
 * Problem 46: Goldbach's other conjecture
 *
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and
 * twice a square. It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class Euler046 implements EulerProblem {

    /**
     * Brute-force solution that can be integrated into the iterative prime-finding algorithm established in previous
     * problems. Firstly, store all perfect squares below the number being searched in an additional ArrayList,
     * iteratively adding more as necessary. Since we are only checking odd numbers with the prime-finding algorithm,
     * any number that is found to be not prime (that is, composite) needs to be checked against Goldbach's conjecture
     * (using the list of primes and squares the algorithm already has). Thus, the first number to fail this check is
     * the solution
     *
     * Uses modified version of Utility.getPrimeListBounded
     *
     * @return solution to Problem 46
     */
    public String solve() {
        int solution = 0;

        ArrayList<Integer> primes = new ArrayList(), squares = new ArrayList();
        primes.add(2);
        squares.add(1);

        int temp = squares.size() + 1, nextSquare = temp * temp;
        for (int i = 3; solution == 0; i += 2) {
            //Checks to see if square should be added
            if (i > nextSquare) {
                squares.add(nextSquare);
                temp = squares.size() + 1;
                nextSquare = temp * temp;
            }

            //Checks to see if prime should be added
            boolean isPrime = true;
            int searchLimit = (int) (Math.sqrt(i));
            for (int j = 0; primes.get(j) <= searchLimit; j++) {
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            } else if (!isValidGoldbach(i, primes, squares)){
                solution = i;
            }
        }
        return solution + "";
    }

    /**
     * Checks to see whether a number i fits the Goldbach conjecture, given a list of primes less than i and a list
     * of squares less than i
     *
     * @param i the number to verify
     * @param primes ArrayList of all primes less than i
     * @param squares ArrayList of all squares less than i
     * @return true if i fits the Goldbach conjecture, false otherwise
     */
    private boolean isValidGoldbach(int i, ArrayList<Integer> primes, ArrayList<Integer> squares) {
        int sum;

        for (int p = 0; p < primes.size(); p++) {
            for (int s = 0; s < squares.size(); s++) {
                sum = primes.get(p) + 2 * squares.get(s);
                if (sum == i) {
                    return true;
                } else if (sum > i) {
                    break;
                }
            }
        }

        return false;
    }
}
