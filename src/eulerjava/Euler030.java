package eulerjava;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler030 {

    public Euler030() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 0;
        for (int i = 2; i < 400000; i++) {
            if (powerSumValid(i)) {
                answer += i;
            }
        }
        return answer;
    }

    private boolean powerSumValid(int i) {
        int pow = 10000, sum = 0, itemp = i;
        for (int j = 0; itemp > 0; j++) {
            int digit = itemp % 10;
            sum += digit * digit * digit * digit * digit;
            if(sum > i){
                return false;
            }
            itemp /= 10;
        }
        return sum == i;
    }

}
