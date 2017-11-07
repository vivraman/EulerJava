package euler.java.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Problem 67: Maximum path sum II
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom in triangle.txt, a 15K text file containing a triangle with one-hundred rows.
 */
public class Euler067 extends EulerProblem {

    /**
     * Use the same method that was used in Problem 18 to solve this. First, generate the int[][] needed for the
     * previous algorithm, then simply insert and return the topmost value in the triangle.
     *
     * @return solution to Problem 67
     */
    @Override
    protected String solve() {
        int[][] triangle = new int[100][];

        try {
            int counter = 1;
            String[] words;
            BufferedReader br = new BufferedReader(new FileReader(new File("src/euler/resources/p067_triangle.txt")));
            while ((words = br.readLine().split(" ")) != null) {
                triangle[counter - 1] = new int[counter];
                for (int i = 0; i < triangle[counter - 1].length; i++) {
                    triangle[counter - 1][i] = Integer.parseInt(words[i]);
                }
                counter++;
            }
        } finally {
            return findBestPath(triangle);
        }
    }

    /**
     * Same method used to solve Problem 18. Start from the bottom instead of the top. Look at value i and i+1,
     * determine which is larger, and then add to i from the row above. This guarantees the largest sum subpath
     * for each value in the above row. Iterate for each row until the solution is found.
     *
     * @param triangle
     * @return
     */
    private String findBestPath(int[][] triangle) {
        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < triangle[i].length - 1; j++) {
                if (triangle[i][j] < triangle[i][j + 1]) {
                    triangle[i - 1][j] += triangle[i][j + 1];
                } else {
                    triangle[i - 1][j] += triangle[i][j];
                }
            }
        }
        return triangle[0][0] + "";
    }
}
