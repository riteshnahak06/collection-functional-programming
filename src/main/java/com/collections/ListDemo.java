package com.collections;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        System.out.println(list.size()); //0
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size()); //3
        System.out.println(list.get(0)); //1
        list.add(2,12);
        System.out.println(list); // [1, 2, 12, 3]
        list.set(0, 4);
        System.out.println(list); // [4, 2, 12, 3] replace existing index value
        list.remove(2);
        System.out.println(list); //[4, 2, 3]

        List<String> list2=Arrays.asList("a","b","c","d");
        // list2.add("s"); // This will give exc exception
        System.out.println(list2.getClass().getName()); //java.util.Arrays$ArrayList
        // If you are using asList then u cannot add or remove but u can replace
        list2.set(0,"e");
        System.out.println(list2); //[e, b, c, d]

        List<Integer> list3=List.of(1,2,3);
        System.out.println(list3.getClass().getName()); //java.util.ImmutableCollections$ListN
        // for List.of as class is immutable collection list so u cannot add remove or replace






    }
}
