package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int READ = 1000;
    private static final int ELEMS = 2000;
    private static final int ADDS = 100_000;

    private static final long AFRICA_POP = 1_110_635_000L;
    private static final long EUROPE_POP = 742_452_000L;
    private static final long ASIA_POP = 4_298_723_000L;
    private static final long AMERICAS_POP = 972_005_000L;
    private static final long OCEANIA_POP = 38_304_000L;
    private static final long ANTARCTICA_POP = 0;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> numArray= new ArrayList<>();
        for (int i=1000 ; i<ELEMS; i++) {
            numArray.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> numList = new LinkedList<>();
        numList.addAll(numArray);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = numArray.get(0);
        int index = numArray.size()-1;
        numArray.set(0, numArray.get(index));
        numArray.set(index, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer curr : numArray ){
            System.out.println(curr);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        addelements(numList);
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + numList.size()
                + " ints in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        time = System.nanoTime();
        addelements(numArray);
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting "
                + numArray.size()
                + " ints in an ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time = System.nanoTime();
        readelements(numArray);
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading a "
                + READ
                + " times the middle element of ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        time = System.nanoTime();
        readelements(numList);
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading a "
                + READ
                + " times the middle element of LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> world = new HashMap<>();
        world.put("Africa", AFRICA_POP);
        world.put("Americas", AMERICAS_POP);
        world.put("Europe", EUROPE_POP);
        world.put("Asia", ASIA_POP);
        world.put("Antarctica", ANTARCTICA_POP);
        world.put("Oceania", OCEANIA_POP);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for (final long pop : world.values()) {
            worldPopulation += pop;
        }
        System.out.println("The global population is " + worldPopulation);
    }

    private static void addelements(List<Integer> list) {
        for (int i = 0; i < ADDS; i++) {
            list.add(0, i);
        }
    }

    private static void readelements(List<Integer> list) {
        for (int i = 0; i<READ; i++) {
            list.get(list.size()/2);
        }
    }
}