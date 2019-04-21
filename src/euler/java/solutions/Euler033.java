package euler.java.solutions;

import euler.java.main.Utility;

/**
 * Problem 33: Digit cancelling fractions
 *
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
 * incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples. There are exactly four non-trivial examples
 * of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Euler033 implements EulerProblem {

    /**
     * Brute-force solution that iterates through all possible two-digit values for numerator and denominator. Since
     * the fraction is less than one, the numerator must be less than the denominator at all times. If we consider a
     * fraction a/b and its simplified version c/d, the two fractions are equal if ad = bc. Therefore, after identifying
     * whether there is a cancellable digit, we check if the remaining numerator digit multiplied by the original
     * denominator equals the remaining denominator multiplied by the original numerator. If so, we multiply the
     * aggregate fraction (initially just 1/1) with the cancelled fraction and immediately simplify. Doing this across
     * the entire set of possible numerators/denominators and taking the denominator of the aggregate fraction at the
     * end yields our answer.
     *
     * @return solution to Problem 33
     */
    public String solve() {
        int[] fraction = {1, 1};

        for (int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                if ((i % 10 != 0) || (j % 10 != 0)) {
                    int[] iDigits = {i % 10, i / 10}, jDigits = {j % 10, j / 10};
                    int iRemain = 0, jRemain = 0;

                    // Identifying which digits remain after cancelling common digit
                    for (int a = 0; a < iDigits.length; a++) {
                        for (int b = 0; b < jDigits.length; b++) {
                            if (iDigits[a] == jDigits[b]){
                                iRemain = iDigits[(a + 1) % 2];
                                jRemain = jDigits[(b + 1) % 2];
                            }
                        }
                    }

                    if (iRemain > 0 && jRemain > 0 && i * jRemain == j * iRemain) {
                        fraction = Utility.getSimplifiedFraction(fraction[0] * iRemain, fraction[1] * jRemain);
                    }
                }
            }
        }


        return fraction[1] + "";
    }
}
