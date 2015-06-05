package eulerjava;

import java.util.ArrayList;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler023 {

    ArrayList<Integer> abundants;

    public Euler023() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        abundants = new ArrayList();
        long answer = 0;
        for (int i = 1; i <= 28123; i++) {
            if (isAbundant(i)) {
                abundants.add(i);
            }
            answer += sumOfAbundants(i);
        }
        return answer;
    }

    private boolean isAbundant(int num) {
        int sum = 1;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum > num;
    }

    public int sumOfAbundants(int i) {
        /*int sum = 0;
        for (int j = 0; j < abundants.size(); j++) {
            if (abundants.get(j) > i) {
                break;
            } else {
                for (int k = 0; k < abundants.size(); k++) {
                    if (abundants.get(k) > i) {
                        break;
                    } else {
                        if((sum = abundants.get(j) + abundants.get(k)) == i){
                            
                        }
                    }
                }
            }
        }
        return i;*/
        int start = 0, end = abundants.size() - 1, sum = 0;
        while (end > start) {
            if(abundants.get(start) << 1 == i){
                return 0;
            }
            if ((sum = abundants.get(start) + abundants.get(end)) == i) {
                return 0;
            } else if (sum > i) {
                end--;
            } else {
                start++;
            }
        }
        System.out.println(i);
        return i;
    }
}
