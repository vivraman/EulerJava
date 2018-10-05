package euler.java.main;

import java.io.*;
import java.util.List;
import java.util.Hashtable;
import java.util.Scanner;

import euler.java.solutions.*;

public class ProjectEuler {

    // Current account name: 'altasig'
    private static final String SOLUTION_PREPEND_PACKAGE = "euler.java.solutions";
    private static final String SOLUTION_PREPEND_CLASS = "Euler";

    private static final String INPUT_RUNALL = "runall";
    private static final int REPS_TO_AVERAGE = 1;

    public static void main(String[] args) {
        new ProjectEuler();
    }

    public ProjectEuler() {
        System.out.println("Type the problem number to run");
        String input = null;
        Scanner sc = new Scanner(System.in);
        try {
            input = sc.next().trim();
            if (input.toLowerCase().equals(INPUT_RUNALL)) {
                solveAllProblems(REPS_TO_AVERAGE);
            } else {
                input = String.format("%03d", Integer.parseInt(input));
                Class problem = findEulerClass(input);
                solveProblem((EulerProblem) problem.newInstance(), true);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Issue with accessing class. Problem likely does not exist or has not been solved. "
                    + ex);
        } catch (ClassCastException ex) {
            System.out.printf("Class Euler%s does not properly implement the EulerProblem interface.", input);
        }
    }

    private Class findEulerClass(String input) throws ClassNotFoundException {
        String path = SOLUTION_PREPEND_PACKAGE + "." + SOLUTION_PREPEND_CLASS + input;
        return Class.forName(path);
    }

    private double solveProblem(EulerProblem problem, boolean printSolution) {
        double time = System.currentTimeMillis();

        String solution = problem.solve();
        for (int i = 1; i < REPS_TO_AVERAGE; i++) {
            problem.solve();
        }
        time = (System.currentTimeMillis() - time) / REPS_TO_AVERAGE;

        if (printSolution) System.out.printf("Solution to %s: %s%n", problem.getClass().getSimpleName(), solution);
        System.out.printf("Average execution time (%s iterations) for %s: %05.1f ms", REPS_TO_AVERAGE, problem.getClass().getSimpleName(), time);

        return time;
    }

    private void solveAllProblems(int rep) {
        Hashtable<String, Double> values = retrieveTimes();
        System.out.printf("Times retrieved for %d problems%n", values.size());

        for (int i = 1; i < 1000; i++) {
            try {
                String problemString = String.format("%03d", i);
                EulerProblem problem = (EulerProblem) (findEulerClass(problemString).newInstance());

                double result = solveProblem(problem, false);

                boolean update;
                if (update = (!values.containsKey(problemString) || values.get(problemString) < result)) {
                    values.put(problemString, result);
                }
                System.out.printf(update ? " Updated.%n" : "%n");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {}
        }

        writeTimes(values);
    }

    private Hashtable<String, Double> retrieveTimes () {
        Hashtable<String, Double> values = new Hashtable<>();

        File f = new File("src/euler/resources/times.csv");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));

            String temp = null;
            while ((temp = reader.readLine()) != null) {
                String[] lineVals = temp.split(",");
                values.put(lineVals[0], Double.parseDouble(lineVals[1]));
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("times.csv does not exist. Creating new file based on current execution times.");
        }

        return values;
    }

    private void writeTimes(Hashtable<String, Double> values) {
        File f = new File("src/euler/resources/times.csv");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));

            List<String> keys = Utility.setToSortedList(values.keySet());
            for (String key : keys) {
                String line = String.format("%s,%05.1f%n", key, values.get(key));
                writer.write(line);
            }

            writer.close();
        } catch (IOException e) {}

    }
}
