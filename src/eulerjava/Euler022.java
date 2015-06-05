package eulerjava;

import java.io.*;
import java.util.*;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler022 {

    public Euler022() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 0;
        try {
             BufferedReader br = new BufferedReader(new FileReader(new File("data/p022_names.txt")));
             String[] words = br.readLine().split(",");
            Arrays.sort(words);
            for (int i = 0; i < words.length; i++) {
                answer += (i + 1) * alphaVal(words[i]);
            }
        } finally {
            return answer;
        }
    }

    private int alphaVal(String word) {
        int answer = 0;
        for (int i = 1; i < word.length() - 1; i++) {
            answer += word.charAt(i) - 'A' + 1;
        }
        return answer;
    }
}
