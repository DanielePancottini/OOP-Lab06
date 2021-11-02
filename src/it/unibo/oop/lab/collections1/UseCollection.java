package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
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
    	
    	List<Integer> intList = new ArrayList<>();
    	
    	for(int i = 0; i < 1000; i++) {
    		intList.add(1000 + i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	List<Integer> intLinkedList = new LinkedList<>(intList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	final int firstIndex = 0;
    	final int lastIndex = intList.size() - 1;
    	
    	final int tempValue = intList.get(firstIndex);
    	
    	intList.set(firstIndex, intList.get(lastIndex));
    	intList.set(lastIndex, tempValue);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	/*
    	for(int elem : intList) {
    		System.out.println(elem);
    	}
    	*/
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	final int N_ELEMS = 100_000;
    	final int TO_MS = 1_000_000;
    	
    	//array list
    	
    	long startTime = System.nanoTime();
    	
    	for(int i = 0; i < N_ELEMS; i++) {
    		intList.add(i + 2_000);
    	}
    	
    	long endTime = System.nanoTime();
    	
    	System.out.println("Array List Time: " + (endTime - startTime) / TO_MS + "ms");
    	
    	//linked list
    	
    	startTime = System.nanoTime();
    	
    	for(int i = 0; i < N_ELEMS; i++) {
    		intLinkedList.add(i + 2_000);
    	}
    	
    	endTime = System.nanoTime();
    	
    	System.out.println("Linked List Time: " + (endTime - startTime) / TO_MS + "ms");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	//array list
    	
    	startTime = System.nanoTime();
    	
    	for(int i = 0; i < 1_000; i++) {
    		int x = intList.get(intList.size() / 2 - 500 + i);
    	}
    	
    	endTime = System.nanoTime();
    	
    	System.out.println("Array List Time: " + (endTime - startTime) / TO_MS + "ms");
    	
    	//linked list
    	
    	startTime = System.nanoTime();
    	
    	for(int i = 0; i < 1_000; i++) {
    		int x = intLinkedList.get(intLinkedList.size() / 2 - 500 + i);
    	}
    	
    	endTime = System.nanoTime();
    	
    	System.out.println("Linked List Time: " + (endTime - startTime) / TO_MS + "ms");
    	
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
    	
    	Map<String, Long> continentsMap = new HashMap<>() {{
    		put("Africa", 1_110_635_000L);
    		put("Americas", 972_005_000L);
    	}};
    	
        /*
         * 8) Compute the population of the world
         */
    	
    	long population = 0;
    	
    	for(String key : continentsMap.keySet()) {
    		population += continentsMap.get(key);
    	}
    	
    	System.out.println("Population: " + population);
    	
    }
}
