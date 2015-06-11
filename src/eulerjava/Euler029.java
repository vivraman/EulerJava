package eulerjava;

import java.math.BigInteger;
import java.util.Hashtable;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler029 {

    Hashtable<BigInteger, Integer> powers;

    public Euler029() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        int counter = 0;
        String temprep;
        powers = new Hashtable<>();
        for (int i = 2; i < 101; i++) {
            BigInteger currentPow = new BigInteger(i + ""), pow = new BigInteger(i + "");
            for (int j = 2; j < 101; j++) {
                currentPow = currentPow.multiply(pow);
                if (!powers.containsKey(currentPow)) {
                    powers.put(currentPow, 1);
                    counter++;
                }
            }
        }
        return counter;
    }
}
