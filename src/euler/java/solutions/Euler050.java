package euler.java.solutions;

import euler.java.main.Utility;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Problem 50: Consecutive prime sum
 * The prime 41, can be written as the sum of six consecutive primes: 41 = 2 + 3 + 5 + 7 + 11 + 1. This is the longest
 * sum of consecutive primes that adds to a prime below one-hundred. The longest sum of consecutive primes below
 * one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Euler050 implements EulerProblem {

    private static final int LIMIT = 1000000;

    /**
     * First, retrieve all primes less than LIMIT. Then, starting from the smallest prime, continuously add primes
     * such that the sum is maximized and less than LIMIT. Mark the index of the last prime added as end. Then, for
     * each prime from index 0 onwards (referred to as start), check if sum from start to end is a prime. If not,
     * reduce end by 1 and continuously check until a prime is found. Once a prime sum is found, check current length
     * (end - start + 1) against maxLength and assign if current length is greater. Continue for all values in list of
     * primes. Further optimized if loop to find sum is cut short once current length becomes smaller than maxLength.
     *
     * @return solution to Problem 50
     */
    public String solve() {
        ArrayList<Integer> primes = Utility.getPrimeListBounded(LIMIT);

        int currentEndIndex = 0, currentSum = 0;
        for (int i = 0; i < primes.size(); i++) {
            if (currentSum + primes.get(i) > LIMIT) {
                currentEndIndex = i - 1 ;
                break;
            } else {
                currentSum += primes.get(i);
            }
        }

        HashSet<Integer> primeLookup = new HashSet();
        primeLookup.addAll(primes);
        int maxLength = 0, answer = 0;
        for (int start = 0; start < primes.size(); start++) {
            int tempSum = currentSum, length = 0;
            for (int end = currentEndIndex; (length = end - start + 1) > maxLength; end--) {
                if (primes.contains(tempSum)) {
                    maxLength = length;
                    answer = tempSum;
                } else {
                    tempSum -= primes.get(end);
                }
            }

            currentSum -= primes.get(start);
            while (currentEndIndex + 1 < primes.size() && currentSum + primes.get(currentEndIndex + 1) < LIMIT) {
                currentSum += primes.get(++currentEndIndex);
            }
        }
        return answer + "";
    }
}
