package euler.java.main;

import java.util.*;

public class Utility {

    /**
     * Convert a Set (or any Collection) to a sorted List
     *
     * @param c collection to convert
     * @param <T> type being held by c
     * @return sorted list containing all objects held by c
     */
    public static <T extends Comparable<? super T>> List<T> setToSortedList(Collection<T> c) {
        List<T> list = new ArrayList<T>(c);
        Collections.sort(list);
        return list;
    }

    /**
     * Generate a list of factorial values, from 0 to limit - 1 inclusive, so that continuous calculation is not
     * necessary. Note that 0! = 1
     *
     * @param limit upper bound of factorials to generate, exclusive
     * @return integer array containing factorial values based on index
     */
    public static int[] getFactorialArray(int limit) {
        int[] fact = new int[limit];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++) {
            fact[i] = fact[i - 1] * i;
        }
        return fact;
    }
}
