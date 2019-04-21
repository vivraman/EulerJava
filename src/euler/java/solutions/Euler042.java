package euler.java.solutions;

import euler.java.main.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

/**
 * Problem 42: Coded triangle numbers
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values
 * we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a
 * triangle number then we shall call the word a triangle word.
 *
 * Using words.txt, a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 */
public class Euler042 implements EulerProblem {

    private static final int TRIANGLE_LIMIT = 10000;
    public static final String PATHNAME = "src/euler/resources/p042_words.txt";

    /**
     * Use hashed set of triangle numbers for quick recall, then find score for every triangle number in the
     * file and calculate score. Upper bound of triangle numbers to hash is arbitrary, but assumes that words
     * in words.txt are real words and not excessively long.
     *
     * @return solution to Problem 42
     */
    public String solve() {
        HashSet<Integer> triangleNums = new HashSet();
        triangleNums.addAll(Utility.generateTriangleNumbers(TRIANGLE_LIMIT));
        String[] words;

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(PATHNAME)));
            words = br.readLine().split(",");
        } catch (Exception e) {
            return null;
        }

        int triangleWordCount = 0;
        for (int i = 0; i < words.length; i++) {
            int scoreCounter = 0;
            for (int j = 1; j < words[i].length() - 1; j++) {
                scoreCounter += words[i].charAt(j) - 'A' + 1;
            }
            if (triangleNums.contains(scoreCounter)) {
                triangleWordCount++;
            }
        }

        return triangleWordCount + "";
    }

}
