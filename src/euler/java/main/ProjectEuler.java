package euler.java.main;

import java.util.Scanner;
import euler.java.solutions.*;

public class ProjectEuler {

    private static final String SOLUTION_PREPEND_CLASS = "euler.java.solutions.Euler";

    public static void main(String[] args) {
        new ProjectEuler();
    }

    public ProjectEuler() {
        System.out.println("Type the problem number to run");
        Scanner sc = new Scanner(System.in);
        try {
            Class problem = findEulerClass(sc.next().trim());
            Object prob = problem.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Issue with accessing class. Problem likely does not exist or has not been solved."
                    + ex);
        }
    }

    private Class findEulerClass(String input) throws ClassNotFoundException{
        while (input.length() < 3) {
            input = '0' + input;
        }
        System.out.println("Accessing "+ SOLUTION_PREPEND_CLASS + input);

        return Class.forName(SOLUTION_PREPEND_CLASS + input);
    }
}
