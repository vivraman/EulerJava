package eulerjava;

/* Problem 17: Number letter counts
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in 
 * words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and 
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 
 * letters. The use of "and" when writing out numbers is in compliance with British
 * usage.
 */
public class Euler015 {

    int num = 20;
    public Euler015() {
        long time = System.currentTimeMillis();

        System.out.println("The answer is: " + solve());
        System.out.println("Time Elapsed: " + (System.currentTimeMillis() - time) + "ms");
    }

    public long solve() {
        long answer = 1;
        for (int i = 40; i > 20; i--) {
            answer *= i;
            answer /= (40 - i + 1);
        }
        return answer;
    }
}