package com.functional_programming;

import java.util.Arrays;
import java.util.List;

public class FP01ForEach {
    // print each number from list one by one
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        List<Integer> numbers=List.of(3,5,2,1,43);
        for(int num: numbers){
            System.out.println(num);
        }
        // use stream if u want to do chain operation like  filter map etc. also want to run parallel stream
        numbers.stream().forEach(System.out::println);
        // only to print
        numbers.forEach(System.out::println);
        // as array is not part of collection u can't use directly like List ,set
        Arrays.stream(arr).forEach(System.out::println);
    }
}
