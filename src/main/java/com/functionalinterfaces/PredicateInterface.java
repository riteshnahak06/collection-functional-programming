package com.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterface {
    public static void main(String[] args) {
        // remove the empty list from string and return new string
        List<String> list=new ArrayList<>();
        list.add("Ritesh");list.add("");
        list.add("Kumar");list.add("");list.add("Nahak");


        Predicate<String> predicate=s -> !s.isEmpty();
        List<String> filtered=filteredList(list,predicate);
        System.out.println(filtered);

        // check if element contain particular string or not
        List<String> list2=new ArrayList<>();
        list2.add("RiteshBasic");list2.add("");
        list2.add("Basic");list2.add("");list2.add("NahakBas");
        Predicate<String> predicate1=s->s.contains("Basic");
        // so no need to write another method to filter string contains with basic
        // just create the predicate and pass to the same method
        System.out.println(filteredList(list2,predicate1));

    }

    private static List<String> filteredList(List<String> list, Predicate<String> predicate) {
        List<String> newList=new ArrayList<>();
        for(String str:list){
            if (predicate.test(str)){
                newList.add(str);
            }
        }
        return newList;
    }

}
