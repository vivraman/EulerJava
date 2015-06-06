package eulerjava;

import java.util.ArrayList;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler023 {

    ArrayList<Integer> abundants;
    boolean[] sums;
    final int UPPERBOUND = 28123;

    public Euler023() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        abundants = new ArrayList();
        sums = new boolean[UPPERBOUND + 1];
        long answer = 0;
        for (int i = 1; i < UPPERBOUND; i++) {
            if (isAbundant(i)) {
                abundants.add(i);
            }
            //answer += sumOfAbundants(i);
        }

        int sum = 0;
        for (int i = 0; i < abundants.size(); i++) {
            for (int j = 0; j < abundants.size(); j++) {
                if ((sum = abundants.get(i) + abundants.get(j)) < UPPERBOUND) {
                    sums[sum] = true;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < sums.length - 1; i++) {
            if(!sums[i]){
                System.out.println(i);
                answer+=i;}
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

    /*
     public int sumOfAbundants(int i) {
     int start = 0, end = abundants.size() - 1, sum = 0;
     while (end >= start) {
     if ((sum = abundants.get(start) + abundants.get(end)) == i) {
     System.out.println(i + "=" + abundants.get(start) + "+" + abundants.get(end));
     return 0;
     } else if (sum > i) {
     end--;
     } else {
     start++;
     }
     }
     System.out.println(i + " adding to sum");
     return i;
     }*/
}
