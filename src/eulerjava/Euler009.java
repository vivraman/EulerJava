package eulerjava;

/* Problem X: Special Pythagorean triplet
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for 
 * which, a^2 + b^2 = c^2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Euler009 {

    public Euler009() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    private int solve() {
        int answer = 0, k = 0;
        for (int i = 3; i < 1000; i++) {
            for (int j = i + 1; j < 1000; j++) {
                if (i + j >= (k = 1000 - (i + j))) {
                    if (i * i + j * j == k * k) {
                        return i * j * k;
                    }
                }
            }
        }
        return answer;
    }

}
