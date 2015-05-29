package eulerjava;

/* Problem X: Description
 * INSERT TEXT HERE
 */
public class Euler017 {

    //one to nineteen
    int[] val_twenty = {3, 3, 5, 4, 4, 3, 5, 5, 4, 3,
        6, 6, 8, 8, 7, 7, 9, 8, 8};
    //twenty to ninety
    int[] val_hundred = {6, 6, 5, 5, 5, 7, 6, 6};
    int[] val_other = {7, 8};

    public Euler017() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 0;
        for (int i = 1; i < 1001; i++) {
            int temp = i;
            if (temp == 1000) {
                answer += val_twenty[0] + val_other[1];
                temp %= 1000;
            }
            if (temp > 99) {
                answer += val_twenty[(temp / 100) - 1] + val_other[0];
                temp %= 100;
                if(temp != 0){
                    answer += 3;
                }
            }
            if(temp >= 20){
                answer += val_hundred[temp/10 - 2];
                temp %= 10;
            } 
            if (temp < 20 && temp != 0){
                answer += val_twenty[temp - 1];
            }
        }
        return answer;
    }
}
