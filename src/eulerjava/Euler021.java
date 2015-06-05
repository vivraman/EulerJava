package eulerjava;

import java.util.ArrayList;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler021 {

    int counter;

    public Euler021() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 0;
        int temp = 0;
        for (int i = 1; i < 10001; i++) {
            if (i == properDivisorSum(temp = properDivisorSum(i)) && i != temp) {
                answer += i;
            }
        }
        return answer;
    }

    public int properDivisorSum(int num) {
        int sum = 0;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum + 1;
    }
}
