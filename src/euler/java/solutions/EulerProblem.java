package euler.java.solutions;

/** Superclass for all Euler problems.
 */
public class EulerProblem {

    public EulerProblem() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    protected String solve() {
        return "";
    }

    protected String solveByHand() {
        return "";
    }
}
