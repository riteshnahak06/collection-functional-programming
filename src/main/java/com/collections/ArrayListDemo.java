package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1); // it will remove 1st index but we want to remove 1 value so remove as an object
        System.out.println(list); //[1, 3]

        list.remove(Integer.valueOf(3));
        System.out.println(list); //[1]

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Ritesh");
        list2.add("Rakesh");
        list2.add("Rocky");
        list2.remove("Rocky"); // as string itself is an object
        System.out.println(list2); // [Ritesh, Rakesh]

        List list1=Arrays.asList(2,3,"sdf");
        System.out.println(list1.getClass().getSimpleName());
    }
}
