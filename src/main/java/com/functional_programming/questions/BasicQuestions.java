package com.functional_programming.questions;

import java.util.List;
import java.util.stream.Collectors;

public class BasicQuestions {
    public static void main(String[] args) {
        //1️⃣ Convert a list of integers to a list of their squares using Streams.
        List<Integer> integerList= List.of(12,14,13,12);
        List<Integer> squaredList = integerList.stream().map(x -> x * x).toList();
        System.out.println(squaredList);

        //2️⃣ Given a list of strings, filter only those starting with “A”.
        List<String> names=List.of("Ritesh","Rakesh","Ashu","Arvin","Baron");
        String nameWithA = names.stream().filter
                (name -> name.startsWith("A")).collect(Collectors.joining(","));

        System.out.println(nameWithA);
    }
}
