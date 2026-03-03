package com;

import java.util.*;

public class Demo {
    public static void main(String[] args) {



        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.addAll(Arrays.asList(50, 20, 60, 10, 40));

        // SortedSet specific methods
        System.out.println("First: " + sortedSet.first());
        System.out.println("Last: " + sortedSet.last());
        System.out.println("HeadSet(<40): " + sortedSet.headSet(40));
        System.out.println("TailSet(>=40): " + sortedSet.tailSet(40));
        System.out.println("SubSet(20,50): " + sortedSet.subSet(20, 50));

        // NavigableSet extends SortedSet with navigation methods
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.addAll(Arrays.asList(50, 20, 60, 10, 40));

        System.out.println("\nNavigableSet operations:");
        System.out.println("Lower than 35: " + navigableSet.lower(35));
        System.out.println("Floor of 35: " + navigableSet.floor(35));
        System.out.println("Ceiling of 35: " + navigableSet.ceiling(35));
        System.out.println("Higher than 35: " + navigableSet.higher(35));

        // Poll operations
        System.out.println("Poll first: " + navigableSet.pollFirst());
        System.out.println("Poll last: " + navigableSet.pollLast());
        System.out.println("After polling: " + navigableSet);




    }
}
