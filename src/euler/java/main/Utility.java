package euler.java.main;

import java.util.*;

public class Utility {

    public static <T extends Comparable<? super T>> List<T> setToSortedList(Collection<T> c) {
        List<T> list = new ArrayList<T>(c);
        Collections.sort(list);
        return list;
    }
}
