package euler.java.solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem 81: Path sum (two ways)
 *
 * Find the minimal path sum, in matrix.txt, a 31K text file containing a 80 by 80 matrix, from the top left to the
 * bottom right by only moving right and down.
 */
public class Euler081 implements EulerProblem {

    public static final int DIMENSIONS = 80;
    public static final String PATHNAME = "src/euler/resources/p081_matrix.txt";

    /**
     * Uses an 80 x 80 array and steadily populates each cell with the minimum path sum required to get to that point.
     * This can be calculated while reading each line in the txt file, which corresponds to each row. The value of the
     * minimal path sum MPT of any cell (A, B) can be represented as VAL(A, B) + MIN(VAL(A - 1, B), VAL(A, B - 1)).
     * Based off of this, we can deduct:
     *
     *  - MPT(0, 0) = VAL(0,0).
     *  - MPT(A, 0) = MPT(A - 1, 0) + VAL(A, 0)
     *  - MPT(0, B) = MPT(0, B - 1) + VAL(0, B)
     *
     * By steadily parsing each row as it is read by the BufferedReader, we can find MPT(80, 80) just as the file is
     * finished being read.
     *
     * @return solution to Problem 81
     */
    public String solve() {
        int[][] matrix = new int[DIMENSIONS][DIMENSIONS];

        try {
            int row = 0;

            String[] cell;
            String rowLine;
            BufferedReader br = new BufferedReader(new FileReader(new File(PATHNAME)));
            while ((rowLine = br.readLine()) != null) {
                cell = rowLine.split(",");

                matrix[row] = new int[matrix.length];
                for (int column = 0; column < matrix.length; column++) {
                    if (row == 0 && column == 0) {
                        matrix[row][column] = Integer.parseInt(cell[column]);
                    } else if (column == 0) {
                        matrix[row][column] = matrix[row - 1][column] + Integer.parseInt(cell[column]);
                    } else if (row == 0) {
                        matrix[row][column] = matrix[row][column - 1] + Integer.parseInt(cell[column]);
                    } else {
                        int min = matrix[row - 1][column] < matrix[row][column - 1] ? matrix[row - 1][column] : matrix[row][column - 1];
                        matrix[row][column] = Integer.parseInt(cell[column]) + min;
                    }
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return matrix[matrix.length - 1][matrix.length - 1] + "";
        }
    }

}
