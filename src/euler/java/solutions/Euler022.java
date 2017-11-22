package euler.java.solutions;

import java.io.*;
import java.util.*;

/**
 * Problem 22: Names scores
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand
 * first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for
 * each name, multiply this value by its alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12
 * + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 */
public class Euler022 implements EulerProblem {

    /**
     * Solution to this problem involves simply sorting the list and finding the name scores of each element
     * in the list. Using Arrays.sort is a very effective way of sorting in Java; use it and iterate through
     * the sorted list, adding all the scores as necessary.
     *
     * @return solution to Problem 22
     */
    public String solve() {
        long answer = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("src/euler/resources/p022_names.txt")));
            String[] words = br.readLine().split(",");
            Arrays.sort(words);
            for (int i = 0; i < words.length; i++) {
                answer += (i + 1) * alphaVal(words[i]);
            }
        } finally {
            return answer + "";
        }
    }

    /**
     * Finds the alphanumeric score for a word
     *
     * @param word the word to score
     * @return the alphanumeric score of word
     */
    private int alphaVal(String word) {
        int answer = 0;
        for (int i = 1; i < word.length() - 1; i++) {
            answer += word.charAt(i) - 'A' + 1;
        }
        return answer;
    }
}
