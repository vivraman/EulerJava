package projecteuler;

/* Problem 2: Even Fibonacci numbers
 *  INSERT TEXT HERE
 */
public class Euler002 {

    public Euler002() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    private int solve() {
        int answer = 0;
        int n = 1;
        int n_ = 1;
        while (n < 4000000) {
            int temp = n;
            n += n_;
            n_ = temp;
            if (n_ % 2 == 0) {
                answer += n_;
            }
        }
        return answer;
    }
}
