package eulerjava;

import java.util.ArrayList;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler014 {

    int[] reference = new int[10000001];

    public Euler014() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    private int solve() {
        int answer = 0, maxterm = 0;
        for (int num = 1; num < 1000000; num += 2) {
            int termcount = 1;
            long latestseq = num;
            while (latestseq != 1) {
                if (latestseq % 2 == 0) {
                    latestseq = latestseq >> 1;
                } else {
                    latestseq = 3 * latestseq + 1;
                }
                termcount++;
            }
            if (termcount > maxterm) {
                answer = num;
                maxterm = termcount;
            }
        }
        return answer;
    }

    public int solve2() {
        int answer = 0, maxterm = 0;
        reference[1] = 1;
        ArrayList<Long> sequence = new ArrayList();
        for (int num = 2; num < reference.length; num++) {
            sequence.clear();
            int termcount = 1;
            long latestseq = num;
            while (latestseq != 1) {
                sequence.add(latestseq);
                if (latestseq % 2 == 0) {
                    latestseq = latestseq >> 1;
                } else {
                    latestseq = 3 * latestseq + 1;
                }

                if (latestseq < reference.length) {
                    if (reference[(int)latestseq] != 0) {
                          
                    }
                }
                termcount++;
            }
        }
        return answer;
    }
}
