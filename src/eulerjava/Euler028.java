package eulerjava;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler028 {

    public Euler028() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 1;
        int gap = 0, gapcounter = 0, cornernum = 0;
        for (int i = 3; (2 * gap + 4) - 1 < 1002; i+= 2) {
            if(gapcounter == 0){
                answer += i;
                cornernum++;
                gapcounter = gap;
            } else {
                gapcounter--;
            }
            if(cornernum == 4){
                gap++;
                cornernum = 0;
                gapcounter = gap;
            }
        }
        return answer;
    }
}
