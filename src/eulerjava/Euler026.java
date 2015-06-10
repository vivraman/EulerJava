package eulerjava;

import java.math.BigInteger;
import java.util.Hashtable;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler026 {

    public Euler026() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        int maxrep = 0, repnum = 0, temp = 0;
        for (int i = 3; i < 1000; i += 2) {
            if (i % 5 != 0) {
                if ((temp = repetitionNumber(i)) > maxrep) {
                    maxrep = temp;
                    repnum = i;
                }
            }
        }
        return repnum;
    }

    /* Used multiplicative order to solve: 10^x = 1 (mod n) for all n relatively 
     * prime to 10. That is, consider all odd n not divisible by five.
    */
    private int repetitionNumber(int i) {
        BigInteger tenpow = new BigInteger("10"), denom = new BigInteger(i + ""), temp;
        int counter = 1;
        while (!(temp = tenpow.mod(denom)).equals(BigInteger.ONE)) {
            if (temp.equals(BigInteger.ZERO)) {
                return 0;
            }
            tenpow = tenpow.multiply(BigInteger.TEN);
            counter++;
        }
        return counter;
    }
}
