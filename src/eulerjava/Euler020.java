package eulerjava;

import java.math.BigInteger;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler020 {

    public Euler020() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 0;
        BigInteger fact = new BigInteger("1");
        for (int i = 2; i < 100; i++) {
            if (i % 5 != 0) {
                fact = fact.multiply(new BigInteger(i + ""));
            } else {
                fact = fact.multiply(new BigInteger(i + ""));
                fact = fact.divide(new BigInteger(10 + ""));
            }
        }
        String temp = fact.toString();
        for (int i = 0; i < temp.length(); i++) {
            answer += temp.charAt(i) - '0';
        }
        return answer;
    }
}
