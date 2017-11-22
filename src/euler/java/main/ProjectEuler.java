package euler.java.main;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import org.reflections.Reflections;

import euler.java.solutions.*;

public class ProjectEuler {

    private static final String SOLUTION_PREPEND_PACKAGE = "euler.java.solutions";
    private static final String SOLUTION_PREPEND_CLASS = "Euler";

    private static final String INPUT_RUNALL = "runall";

    public static void main(String[] args) {
        new ProjectEuler();
    }

    public ProjectEuler() {
        System.out.println("Type the problem number to run");
        Scanner sc = new Scanner(System.in);
        try {
            String input = sc.next().trim();
            if (input.toLowerCase().equals(INPUT_RUNALL)) {
                solveAllProblems();
            } else {
                Class problem = findEulerClass(sc.next().trim());
                solveProblem((EulerProblem) problem.newInstance());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Issue with accessing class. Problem likely does not exist or has not been solved. "
                    + ex);
        }
    }

    private Class findEulerClass(String input) throws ClassNotFoundException {
        while (input.length() < 3) {
            input = '0' + input;
        }

        String path = SOLUTION_PREPEND_PACKAGE + "." + SOLUTION_PREPEND_CLASS + input;
        System.out.printf("Accessing %s%n", path);
        return Class.forName(path);
    }

    private long solveProblem(EulerProblem problem) {
        long time = System.currentTimeMillis();

        System.out.printf("The answer is: %s%n", problem.solve());
        System.out.printf("Time Elapsed: %s ms", (time = System.currentTimeMillis() - time));

        return time;
    }

    private void solveAllProblems() {
        Reflections reflections = new Reflections(SOLUTION_PREPEND_PACKAGE);
        Set<Class<? extends Object>> eulerClasses = reflections.getSubTypesOf(Object.class);
        Iterator<Class<? extends Object>> it = eulerClasses.iterator();

        System.out.println(eulerClasses.size());
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }
}
