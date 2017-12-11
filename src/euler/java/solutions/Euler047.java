package euler.java.solutions;

import euler.java.main.Utility;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Problem 47: Distinct prime factors
 * Find the first four consecutive integers to have four distinct prime factors each. What is the first of
 * these numbers?
 */
public class Euler047 implements EulerProblem {

    private static final int CONSECUTIVE_PRIME_FACTOR_NUM = 4;

    /**
     * Continuously find primes using previously-established methodology, but change iterator to +1 instead of +2 on
     * odd numbers. Conditionally look for primes if the numbers are odd, and afterwards for each composite number
     * check if the number has four distinct prime factors. Once four consecutive numbers are found, return i - 4
     * since the sequence is (i - 4, i - 3, i - 2, i - 1)
     *
     * Uses modified version of Utility.getPrimeListBounded
     *
     * @return solution to Problem 47
     */
    public String solve() {
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);

        int i = 3, repeat = 0;
        while (repeat != 4) {
            boolean isPrime = i % 2 == 1;

            if (i % 2 == 1) {
                int limit = (int) (Math.sqrt(i));
                for (int j = 0; primes.get(j) <= limit; j++) {
                    if (i % primes.get(j)  == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(i);
                }
            }

            if (!isPrime && primeFactorNum(i, primes)) {
                repeat++;
            } else repeat = 0;

            i++;
        }

        return (i - 4) + "";
    }
    /**
     * Checks to see if a number's distinct prime factors equal CONSECUTIVE_PRIME_FACTOR_NUM. Iterates through
     * currently-found primes until i is fully factorized or loop is broken prematurely. Loop can be broken if
     * limit (i/2 + 1) is exceeded (since there are no integers that will divide i beyond this point, or if
     * the number of distinct prime factors exceeds CONSECUTIVE_PRIME_FACTOR_NUM.
     *
     * @param i number to find prime factors of
     * @param primes array list of primes to check against
     * @return true if number of prime factors equals CONSECUTIVE_PRIME_FACTOR_NUM, false otherwise
     */
    private boolean primeFactorNum(int i, ArrayList<Integer> primes) {
        int limit = i / 2 + 1, currentPrime = 0, counter = 0;
        for (int j = 0; i > 1 && currentPrime <= limit; j++) {
            currentPrime = primes.get(j);
            if (i % currentPrime == 0) {
                if (++counter > CONSECUTIVE_PRIME_FACTOR_NUM) {
                    return false;
                }
                while (i % currentPrime == 0) {
                    i /= currentPrime;
                }
            }
        }

        return counter == CONSECUTIVE_PRIME_FACTOR_NUM;
    }


    public String solve2() {
        ArrayList<Integer> primes = Utility.getPrimeListBounded(1000000);
        ArrayList<Integer> fourPrimeFactors = getNPrimeFactors(primes, 4);
    }


    public ArrayList<Integer> getNPrimeFactors(ArrayList<Integer> primes, int num) {
        ArrayList<Integer> nPrimeFactorNums = new ArrayList();
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i), temp = 1;
            HashSet<Integer> tempSet = new HashSet();
            tempSet.add(prime);
            while (temp * prime < 1000000) {
                temp *= prime;
                nPrimeFactorNums.addAll(getNPrimeFactorsR(primes, num - 1, tempSet, temp));
            }
        }

    }

    public ArrayList<Integer> getNPrimeFactorsR(ArrayList<Integer> primes, int num, HashSet<Integer> set, int current) {
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i), temp = current;
            if (!set.contains(prime)) {
                HashSet<Integer> tempSet = (HashSet) set.clone();
                tempSet.add(prime);
                while (temp * prime < 1000000) {
                    temp *= prime;
                    getNPrimeFactors
                }
            }
        }
    }

}