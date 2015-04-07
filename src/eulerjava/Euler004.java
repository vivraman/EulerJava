package eulerjava;

/* Problem X: Description
 *  INSERT TEXT HERE
 */
public class Euler004 {

    public Euler004() {
        long time = System.currentTimeMillis();
        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    private int solve() {
        int answer = 0;
        for (int i = 999; i > 900; i--) {
            for (int j = 999; j > 900; j--) {
                if (i % 11 == 0) {
                    int temp = i * j;
                    if (isPalindrome(temp) && temp > answer) {
                        answer = temp;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isPalindrome(int temp) {
        String num = temp + "";
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }
}
