package eulerjava;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/* Problem 14: Longest Collatz sequence
 * The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)

 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

 * It can be seen that this sequence (starting at 13 and finishing at 1) 
 * contains 10 terms. Although it has not been proved yet (Collatz Problem), it
 * is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Euler014 {

    int[] reference = new int[10000001];

    public Euler014() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        int answer = 0, maxterm = 0;
        reference[1] = 1;
        reference[2] = 2;
        ArrayList<Long> sequence = new ArrayList();
        for (int num = 3; num < 1000000; num += 2) {
            sequence.clear();
            int termcount = 1;
            long latestseq = num;
            while (latestseq != 1) {
                if (latestseq % 2 == 0) {
                    latestseq = latestseq >> 1;
                } else {
                    latestseq = 3 * latestseq + 1;
                }
                if (latestseq < reference.length) {
                    if (reference[(int) latestseq] != 0) {
                        reference[num] = reference[(int) latestseq] + termcount;
                        Iterator<Long> it = sequence.iterator();
                        int next = 0, temp = reference[num];
                        while (it.hasNext() && (next = it.next().intValue()) < reference.length && reference[next] == 0) {
                            reference[next] = --temp;
                        }
                        break;
                    }
                }
                sequence.add(latestseq);
                termcount++;
            }
            if (reference[num] > maxterm) {
                answer = num;
                maxterm = reference[num];
            }
        }
        return answer;
    }

    public long solve2() {
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

}
