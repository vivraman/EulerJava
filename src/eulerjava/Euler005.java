package eulerjava;

import java.util.ArrayList;

/* Problem X: Smallest multiple
 * 2520 is the smallest number that can be divided by each of the numbers from
 * 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of
 * the numbers from 1 to 20?
 */
public class Euler005 extends EulerTemplate{

    ArrayList<Integer> primes;

    /* Multiply together the highest powers of primes less than x that are
     * also less than x. First find all primes less than x, then while finding
     * these primes, see how many times they can be raised while still staying 
     * below x. Multiply that result with current answer.
     */
    public long solve() {
        int answer = 1;
        primes = new ArrayList<Integer>();
        for (int i = 2; i < 20; i++) {
            boolean isPrime = true;
            int limit = (int) (Math.sqrt(i));
            for (int j = 0; j < primes.size(); j++) {
                if (primes.get(j) > limit) {
                    break;
                }
                if (i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
                int temp = i;
                while (temp * i < 20) {
                    temp = temp * i;
                }
                answer *= temp;
            }
        }
        return answer;
    }

    /* Multiply together the highest powers of primes less than x that are also
     * less than x. For x = 20, the only prime powers that fit are 2^4 = 16 < 20 
     * and 3^2 = 9 < 20. All other primes cannot be raised to more than 1
     * before becoming greater than 20. Hence: 
     */
    private int solveByHand() {
        return (2 * 2 * 2 * 2) * (3 * 3) * 5 * 7 * 11 * 13 * 17 * 19;
    }
}
