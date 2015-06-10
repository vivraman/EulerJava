package eulerjava;

import java.util.*;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler027 {

    Hashtable<Integer, Integer> primes;
    ArrayList<Integer> primelist;

    public Euler027() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        primes = new Hashtable<>();
        primelist = new ArrayList<>();
        primes.put(2, 1);
        primelist.add(2);
        for (int i = 3; i <= 5000; i += 2) {
            boolean isPrime = true;
            int limit = (int) (Math.sqrt(i));
            for (int j = 0; primelist.get(j) <= limit && j < primelist.size(); j++) {
                if (i % primelist.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.put(i, 1);
                primelist.add(i);
            }
        }
        int maxnum = 0, product = 0;
        for (int a = -1000; a < 1001; a++) {
            int b = 0;
            for(int test = 0; (b = primelist.get(test)) < 1000; test++){
                int consecprimes;
                if ((consecprimes = consecPrimes(a,b)) > maxnum) {
                    maxnum = consecprimes;
                    product = a*b;
                }
            }
        }
        return product;
    }

    private int consecPrimes(int a, int b) {
        for (int i = 0; ; i++) {
            if(!primes.containsKey(i*i + a*i + b)){
                return i;
            }
        }
    }
}
