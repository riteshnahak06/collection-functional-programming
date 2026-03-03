package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student{
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Integer> nums=new ArrayList<>();
        nums.add(12);
        nums.add(16);
        nums.add(13);
        nums.add(39);
        /*Collections.sort(nums);
        System.out.println(nums); //[2, 6, 12, 32]
        Collections.sort(nums,Collections.reverseOrder());
        System.out.println(nums);//[39, 16, 13, 12]*/

        //if I want to sort by last no in descending
        Collections.sort(nums,(a,b)->b%10-a%10);
        System.out.println(nums);

        List<Student> students=new ArrayList<>();
        students.add(new Student(12,"Ritesh"));
        students.add(new Student(11,"Ashu"));
        students.add(new Student(18,"Rakesh"));
        students.add(new Student(10,"Nitesh"));

        Collections.sort(students,(a,b)-> b.getAge()- a.getAge());
        System.out.println(students);
        //[Student{age=18, name='Rakesh'}, Student{age=12, name='Ritesh'}, Student{age=11, name='Ashu'}, Student{age=10, name='Nitesh'}]
    }
}
