package eulerjava;

/* Problem X: 10001st prime
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see 
 * that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 */
public class Euler007 {

    int[] primes;

    public Euler007() {;
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    /* Brute force solution. Find primes using previously established methods,
     * exceept use array for efficiency since we know how many primes we need.
     * Count to 10001, break and print solution.
     */
    public int solve() {
        primes = new int[10001];
        primes[0] = 2;
        int counter = 1;
        int answer = 3;
        while (counter < 10001) {
            boolean isPrime = true;
            int limit = (int) (Math.sqrt(answer));
            for (int j = 0; j < counter; j++) {
                if(primes[j] > limit){
                    break; 
                }
                if (answer % primes[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[counter++] = answer;
            }
            answer += 2;
        }
        return primes[10000];
    }
}
