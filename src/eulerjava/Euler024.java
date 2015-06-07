package eulerjava;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler024 {

    final int DIGITS = 10;
    int lexnum = 1000000;
    int[] fact;
    boolean[] nums;

    public Euler024() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 0;
        nums = new boolean[DIGITS];
        genfact(fact = new int[DIGITS]);

        for (int i = fact.length - 2; i >= 0; i--) {
            int counter = 0;
            while (lexnum > fact[i]) {
                lexnum -= fact[i];
                counter++;
            }
            for (int j = 0; j < nums.length; j++) {
                if (!nums[j]) {
                    --counter;
                }
                if (counter == 0) {
                    answer += (j + 1) * Math.pow(10, i + 1);
                    nums[j] = true;
                    break;
                }
            }
        }
        return answer;
    }

    public void genfact(int[] fact) {
        int temp = 1;
        for (int i = 0; i < fact.length; i++) {
            fact[i] = (temp *= (i + 1));
        }
    }
}
