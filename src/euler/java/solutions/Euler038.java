package euler.java.solutions;

import euler.java.main.Utility;

/**
 * Problem 38: Pandigital multiples
 *
 * Take the number 192 and multiply it by each of 1, 2, and 3. By concatenating each product we get the 1 to 9
 * pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3). The same can be achieved
 * by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated
 * product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer
 * with (1,2, ... , n) where n > 1?
 */
public class Euler038 implements EulerProblem {

    /**
     * Brute-force approach with restricted bounds. Consider our solution to be the concatenated product of x and
     * (1,...n). We know that x cannot contain more than five digits since the minimum concatenation would be ten
     * digits long, so the exclusive upper bound for x is 10000. From here, we check every possible x value by
     * continuously concatenating until the number is or exceeds 9 digits. If the concatenated product is 9 digits,
     * check if it is pandigital, otherwise, check the next x value. Continue until all potential x values are
     * exhausted.
     *
     * @return solution to Problem 38
     */
    public String solve () {
        int maxPandigital = 0;

        for (int i = 1; i < 10000; i++) {
            StringBuilder current = new StringBuilder();
            current.append(i);

            for (int j = 2; current.length() < 10; j++) {
                current.append(i * j);

                if (current.length() == 9) {
                    int candidate = Integer.parseInt(current.toString());
                    if (Utility.isPandigital(candidate) && candidate > maxPandigital) {
                        maxPandigital = candidate;
                    }
                }
            }
        }
        return maxPandigital + "";
    }
}
