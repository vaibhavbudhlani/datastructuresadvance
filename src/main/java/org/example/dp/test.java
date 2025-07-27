package org.example.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Person {

    private String name;
    private int age;
    private String department;

    public Person(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Getters and setters (optional)
}


public class test {


    public static void main(String[] args) {

//    Return a map where key is department and value is list of it's employees sorted in descending order of their age
        List<Person> people = Arrays.asList(
                new Person("John", 21, "HR"),
                new Person("Jane", 20, "Finance"),
                new Person("Tom", 45, "HR"),
                new Person("Alice", 17, "Finance"),
                new Person("Bob", 29, "HR"),
                new Person("Charlie", 30, "Finance")
        );




       Map<String, List<Person>> departmentGroup = people.stream()

       // .sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()))
               .sorted(Comparator.comparing(Person::getAge).reversed())
        .collect(Collectors.groupingBy(Person::getDepartment));

//       people.stream().collect(Collectors.toMap())
        people.stream().collect(Collectors.toMap(Person::getDepartment, person -> person));


        departmentGroup.forEach((department, persons) -> {
            System.out.println("Department: " + department);
            persons.forEach(person -> System.out.println("Person: " + person.getName()));
        });


    }

}


