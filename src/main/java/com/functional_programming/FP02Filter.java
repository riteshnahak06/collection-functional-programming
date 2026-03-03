package com.functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Filter {
    /*
    How filter() works:
    The predicate you pass to filter() must return a boolean value (true or false).
        1-For each element in the stream, the predicate is evaluated.
//        2-If it returns true, the element passes through and remains in the resulting stream.
        3-If it returns false, the element is excluded.

        Memory Aid:
        Map = "Transform each" (1-to-1 transformation)
        Filter = "Select some" (1-to-0-or-1 selection)

    The Java Stream filter() method is an intermediate operation that allows you to select elements from a stream based
     on a given condition, defined as a predicate (a function returning true or false). It processes each element and returns
     a new stream containing only the elements that satisfy the predicate, without modifying the original collection.
     Common uses include filtering numbers (like even or prime), strings (by prefix, pattern, or non-null/non-blank),
     and objects based on their fields. It is often combined with other stream operations like map(), collect(), or distinct(),
     and is executed only when a terminal operation triggers the stream pipeline. Using filter() helps write clean, readable,
     and efficient code for selective data processing in a functional style.
     */
    public static void main(String[] args) {


        // as joining works on Strings not integer so map will convert integer to String
        //✅ Q2. Given a list of strings, filter names that start with "A".
        List<String> names = List.of("Amit", "Ravi", "Anil", "Sita");
        System.out.println(names.stream().filter(name->name.startsWith("A"))
                .collect(Collectors.joining(", ")));

        // ✅ Q3. Filter words with length > 4 from a list of strings.
        List<String> words = List.of("cat", "elephant", "dog", "tiger");
        System.out.println(words.stream().filter(word->word.length()>4)
                .collect(Collectors.joining(", ")));
        //✅ Q4. Given a list of Employee objects, filter those with salary > 50,000.
        class Employee {
            @Override
            public String toString() {
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", salary=" + salary +
                        '}';
            }

            public int getSalary() {
                return salary;
            }

            public String getName() {
                return name;
            }

            String name;
            int salary;

            public Employee(String name, int salary) {
                this.name = name;
                this.salary = salary;
            }

        }
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee("Ritesh",10000));
        employeeList.add(new Employee("Rakesh",30000));
        employeeList.add(new Employee("Ram",40000));
        employeeList.add(new Employee("Hari",60000));

       employeeList.stream()
               .filter(employee -> employee.getSalary()>50000) // Employee{name='Hari', salary=60000}
               .map(Employee::getName) //Hari
               .forEach(System.out::println);

//       ✅ Q5. Remove null or blank values from a list of strings.
        List<String> inputs = Arrays.asList("Java", "", null, "  ", "Spring");
        System.out.println(inputs.stream().filter(num->num!=null)
                        .filter(num->num.trim().length()>0)
                .collect(Collectors.toList()));

        //✅ Q6. Filter only prime numbers from a list of integers.
        List<Integer> nums = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(nums.stream().filter(FP02Filter::isPrime)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        // ✅ Q7. From a list of strings, filter those that contain digits.
        List<String> inputList = List.of("abc", "abc123", "hello", "a1b2c3");
        System.out.println(inputList.stream().filter(num->num.matches(".*\\d.*"))
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        //✅ Q8. Filter duplicates from a list (keep only first occurrence).
        List<String> items = List.of("apple", "banana", "apple", "orange", "banana");
        System.out.println(items.stream().distinct().collect(Collectors.joining(", ")));

        //✅ Q9. Filter users whose email domain is "gmail.com".
        List<String> emails = List.of("a@gmail.com", "b@yahoo.com", "c@gmail.com");
        System.out.println(emails.stream().filter(email->email.contains("@gmail"))
                .collect(Collectors.joining(", ")));
        //.filter(email -> email.endsWith("@gmail.com"))



















    }
    private static boolean isPrime(Integer num) {
        int count=0;
        for (int i=2;i<num;i++){
            if (num%i==0) return false;
        }
        return true;
    }

}
