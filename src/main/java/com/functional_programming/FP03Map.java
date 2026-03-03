package com.functional_programming;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FP03Map {
    /*
    How map() works:
    The function you pass to map() must transform an element and return a new value (of any type).
        1 - For each element in the stream, the function is applied.
        2 - A new stream is created where each original element is replaced with its transformed version.
        3 - The size of the stream remains the same; only the contents are changed.

    The Java Stream map() method is an intermediate operation used to transform elements in a stream.
    It takes a Function<T, R> as an argument — a function that accepts an input and produces an output.
    map() processes each element, applies the function, and produces a new stream of the transformed elements.
    Common use cases include converting strings to uppercase, squaring numbers, extracting specific fields from objects,
    converting data types (e.g., String to Integer), and formatting values.
    It is often chained with other stream operations like filter(), collect(), and distinct().
    Since map() does not modify the original collection and works on a new stream, it promotes
    clean, readable, and immutable data transformations in a functional programming style.
*/

    public static void main(String[] args) {
        //✅ 1. Convert strings to uppercase
        List<String> fruits = List.of("apple", "banana", "mango");
        System.out.println(fruits.stream().map(fruit->fruit.toUpperCase())
                .collect(Collectors.joining(", ")));

        //✅ 2. Square all numbers in a list
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().map(num->num*num).map(String::valueOf)
                .collect(Collectors.joining(", ")));

        //✅ 3. Convert list of integer numbers to strings
        List<Integer> nums = List.of(10, 20, 30);
        System.out.println(
                nums.stream().map(num->String.valueOf(num)).collect(Collectors.joining(", "))
        );
        //✅ 4. Extract names from a list of custom objects
        class Person {
            public String getName() {
                return name;
            }

            String name;

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        '}';
            }

            Person(String name) { this.name = name; }
        }
        List<Person> people = List.of(new Person("Alice"), new Person("Bob"));
        System.out.println(
                people.stream().map(Person::getName).collect(Collectors.joining(", "))
        );
        // ✅ 5. Trim whitespace from each string in a list
        List<String> inputs = List.of("  java ", " streams ", " map  ");
        System.out.println(
                inputs.stream().map(input->input.trim()).collect(Collectors.joining(","))
        );

        // ✅ 6. Convert list of numeric strings to integers
        List<String> stringNumbers = List.of("1", "2", "3", "4");
        stringNumbers.stream().map(Integer::valueOf).forEach(System.out::println);

        //✅ 7. Extract domain from email addresses
        List<String> emails = List.of("a@gmail.com", "b@yahoo.com", "c@gmail.com");
        System.out.println(emails.stream().map(mail->mail.split("@")[1])
                .collect(Collectors.joining(", ")));

        //✅ 8. Get lengths of each string in a list
        List<String> words = List.of("apple", "banana", "kiwi");
        System.out.println(
                words.stream().map(word->word.length()).toList()
        );
        //✅ 9. Parse dates from strings to LocalDate
        List<String> dates = List.of("2023-01-01", "2024-05-15", "2025-12-31");
        dates.stream().map(LocalDate::parse)
                .collect(Collectors.toList());





    }
}
