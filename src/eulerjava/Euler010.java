package eulerjava;

/* Problem X: Summation of primes
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */
public class Euler010 {

    int[] primes2;

    public Euler010() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    private long solve() {
        long answer = 2;
        boolean isPrime;
        int limit, counter = 0;
        primes2 = new int[500000];
        primes2[counter++] = 2;
        for (int i = 3; i < 2000000; i += 2) {
            isPrime = true;
            limit = (int) (Math.sqrt(i));
            for (int j = 0; j < counter; j++) {
                if (primes2[j] > limit) {
                    break;
                }
                if (i % primes2[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes2[counter++] = i;
                answer += i;
            }
        }
        return answer;
    }
}
