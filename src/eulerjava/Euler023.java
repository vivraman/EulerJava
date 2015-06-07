package eulerjava;

import java.util.*;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler023 {

    int[] abundants2;
    final int UPPERBOUND = 28123;

    public Euler023() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve2());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve2() {
        abundants2 = new int[UPPERBOUND];
        int abundnum = 0;
        long answer = 0;
        for (int i = 1; i < UPPERBOUND; i++) {
            if (isAbundant(i)) {
                abundants2[abundnum++] = i;
            }
            answer += sumOfAbundants(i, abundnum);
        }
        return answer;
    }

    private boolean isAbundant(int num) {
        int sum = 1;
        int sqrt = (int) (Math.sqrt(num));
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i + (num / i);
            }
        }
        if (sqrt * sqrt == num) {
            return sum - sqrt > num;
        }
        return sum > num;
    }

    public int sumOfAbundants(int i, int abundnum) {
        int start = 0, end = abundnum - 1, sum = 0;
        while (end >= start) {
            if ((sum = abundants2[start] + abundants2[end]) == i) {
                return 0;
            } else if (sum > i) {
                end--;
            } else {
                start++;
            }
        }
        return i;
    }

}
