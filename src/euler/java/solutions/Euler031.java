package euler.java.solutions;

/**
 * Problem 31: Coin sums
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * <p>
 * It is possible to make £2 in the following way: 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * <p>
 * How many different ways can £2 be made using any number of coins?
 */
public class Euler031 implements EulerProblem {

    private static final int[] CURRENCY_VALUES = {1, 2, 5, 10, 20, 50, 100, 200};
    private static final int TARGET = 200;

    /**
     * Use recursion for the quickest solution by iterating through the currency values from smallest to largest
     * as necessary. Start counter at 1 and currencyIndex at 6 (instead of 7) since the 200 value is a
     * solution by itself.
     *
     * @return solution to Problem 31
     */
    public String solve() {
        return checkSum(CURRENCY_VALUES[6], 6, 0, 1) + "";
    }

    /**
     * Recursive algorithm that finds total number of sums to 200.
     *
     * @param currentCurrency current currency value being iterated through
     * @param currencyIndex   index of current currency being iterated through
     * @param sumTotal        current total sum of currency values
     * @param counter         current count of valid sums to 200
     * @return total number of sums to 200 using values of CURRENCY_VALUES
     */
    private int checkSum(int currentCurrency, int currencyIndex, int sumTotal, int counter) {
        for (int i = 0; sumTotal + i * currentCurrency <= TARGET; i++) {
            int currentSum = sumTotal + i * currentCurrency;
            if (currentSum < TARGET && currencyIndex != 0) {
                counter = checkSum(CURRENCY_VALUES[currencyIndex - 1], currencyIndex - 1, currentSum, counter);
            } else if (currentSum == 200) {
                ++counter;
            }
        }
        return counter;
    }
}
