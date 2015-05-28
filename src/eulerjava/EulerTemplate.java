package eulerjava;

/* Problem X: Description
 * INSERT TEXT HERE
 */
abstract class EulerTemplate {

    public EulerTemplate() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public abstract long solve();
}
