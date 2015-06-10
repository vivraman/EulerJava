package eulerjava;

import java.math.BigInteger;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler025 {

    BigInteger prev, next, temp, upper;
    int nextindex;

    public Euler025() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        prev = new BigInteger("1");
        next = new BigInteger("2");
        upper = new BigInteger("10");
        upper = upper.pow(999);
        nextindex = 3;
        while (next.compareTo(upper) == -1) {
            temp = next.add(prev);
            prev = next;
            next = temp;
            nextindex++;
        }
        return nextindex;
    }
}
