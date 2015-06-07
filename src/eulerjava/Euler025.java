package eulerjava;

import java.math.BigInteger;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler025 {

    BigInteger prev, next, temp;
    int nextindex;
    public Euler025() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        prev = new BigInteger("1"); next = new BigInteger("2");
        nextindex = 3;
        while(next.toString().length() < 1000){
           temp = next.add(prev);
           prev = next;
           next = temp;
           nextindex++;
        }
        return nextindex;
    }
}
