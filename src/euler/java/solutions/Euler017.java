package euler.java.solutions;

/**
 * Problem 17: Number letter counts
 *
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in
 * words, how many letters would be used?
 * <p>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with British
 * usage.
 */
public class Euler017 implements EulerProblem {

    //one to nineteen
    private static final int[] VAL_TWENTY = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3,
            6, 6, 8, 8, 7, 7, 9, 8, 8};
    //twenty to ninety
    private static final int[] VAL_HUNDRED = {6, 6, 5, 5, 5, 7, 6, 6};
    //hundred, thousand
    private static final int[] VAL_OTHER = {7, 8};

    /**
     * Use the constants for each number as necessary, taking care to add each "and" for numbers
     * greater than 100, etc.
     *
     * @return solution to Problem 17
     */
    public String solve() {
        long answer = 0;
        for (int i = 1; i < 1001; i++) {
            int temp = i;
            if (temp == 1000) {
                answer += VAL_TWENTY[0] + VAL_OTHER[1];
                temp %= 1000;
            }
            if (temp > 99) {
                answer += VAL_TWENTY[(temp / 100) - 1] + VAL_OTHER[0];
                temp %= 100;
                if (temp != 0) {
                    answer += 3;
                }
            }
            if (temp >= 20) {
                answer += VAL_HUNDRED[temp / 10 - 2];
                temp %= 10;
            }
            if (temp < 20 && temp != 0) {
                answer += VAL_TWENTY[temp - 1];
            }
        }
        return answer + "";
    }
}
