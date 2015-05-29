package eulerjava;

import java.math.BigInteger;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler016 {

    public Euler016() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 0;
        String temp = new BigInteger("2").pow(1000).toString();
        for (int i = 0; i < temp.length(); i++) {
            answer += temp.charAt(i) - '0';
        }
        return answer;
    }
}
