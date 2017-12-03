package euler.java.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.HashMap;

/**
 * A common security method used for online banking is to ask the user for three random characters from a passcode.
 * For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply
 * would be: 317.
 *
 * The text file, keylog.txt, contains fifty successful login attempts.
 *
 * Given that the three characters are always asked for in order, analyse the file so as to determine the shortest
 * possible secret passcode of unknown length.
 */
public class Euler079 implements EulerProblem {

    /**
     * Assumes (via inspection) no recurring digits. First, generate a map from every digit that appears in a login
     * attempt to every digit that appears after it. After this, iterate through each key in the map and see if the
     * mapped set of digits is empty. If so, remove the key from the map, and remove the key's digit from each remaining
     * key's mapped set. Add the removed key to the front of the answer string. Repeat this process until the map is
     * empty.
     *
     * @return solution to Problem 79
     */
    public String solve() {
        String answer = "";
        HashMap<Character, HashSet<Character>> digits = new HashMap();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/euler/resources/p079_keylog.txt")));

            String temp;
            while ((temp = reader.readLine()) != null) {
                for (int i = 0; i < temp.length(); i++) {
                    if (!digits.containsKey(temp.charAt(i))) {
                        digits.put(temp.charAt(i), new HashSet<Character>());
                    }

                    if (i + 1 < temp.length()) {
                        digits.get(temp.charAt(i)).add(temp.charAt(i + 1));
                    }
                }
            }

            while (digits.keySet().size() > 0) {
                char addToAnswer = 0;
                for (Character c : digits.keySet()) {
                    if (digits.get(c).size() == 0) {
                        addToAnswer = c;
                        digits.remove(c);
                        for (Character d : digits.keySet()) {
                            digits.get(d).remove(c);
                        }
                        break;
                    }
                }
                answer = addToAnswer + answer;
            }
        } catch (IOException e) {}

        return answer;
    }

    /**
     * Solve by manual inspection and insertion. Choose arbitrary login attempt as starting point and manually
     * inspect to insert digits in correct locations. Assume 0 is final digit since all attempts with 0
     * end with 0. Assume 7 is first digit since all attempts with 7 begin with 7. Inspection reveals no number
     * appears twice in passcode.
     *
     * @return solution to Problem 79
     */
    public String solveByHand() {
        return "73162890";
    }
}
