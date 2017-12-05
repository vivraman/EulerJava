package euler.java.solutions;

/**
 * An irrational decimal fraction is created by concatenating the positive integers: 0.1234567891011121314151617...
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If d_n represents the nth digit of the fractional part, find the value of the following expression:
 * d_1 × d_10 × d_100 × d_1000 × d_10000 × d_100000 × d_1000000
 */
public class Euler040 implements EulerProblem {

    private static final int LIMIT = 1000000;

    /**
     * Brute-force solution achieved by counting digits continuously until digitCounter exceeds LIMIT (the maximum d
     * value to find). Each time digitCounter reaches or exceeds a power of 10 (the nearest of which is tracked by
     * indexToFind), d_indexToFind is identified and multiplied into solution. Solution starts at 1 in order to factor
     * in d_1. The digit increment following every loop (represented by currentDigitIncrement) is increased as
     * currentNumber reaches a new power of 10 (denoted by digitIncrementLimit).
     *
     * @return solution to Problem 40
     */
    public String solve() {
        int solution = 1;

        int currentNumber = 0, currentDigitIncrement = 1, digitIncrementLimit = 10, indexToFind = 10, digitCounter = 0;
        while (digitCounter <= LIMIT) {
            currentNumber++;

            if (currentNumber == digitIncrementLimit) {
                currentDigitIncrement++;
                digitIncrementLimit *= 10;
            }
            digitCounter += currentDigitIncrement;

            if (digitCounter >= indexToFind) {
                int diff = digitCounter - indexToFind, temp = currentNumber;
                for (int i = 0; i < diff; i++) {
                    temp /= 10;
                }
                solution *= temp % 10;

                indexToFind *= 10;
            }
        }

        return solution + "";
    }
}
