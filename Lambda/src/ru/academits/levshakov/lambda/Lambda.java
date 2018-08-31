package ru.academits.levshakov.lambda;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Lambda {
    public static void main(String[] args) {
        List<Person> people = new LinkedList<>();
        people.add(new Person("Алексей", 29));
        people.add(new Person("Анастасия", 21));
        people.add(new Person("Дмитрий", 28));
        people.add(new Person("Алексей", 27));
        people.add(new Person("Даша", 5));
        people.add(new Person("Даша", 7));
        people.add(new Person("Надя", 6));

        List<String> uniqueNames = people.stream().map(person -> person.getName()).distinct().collect(Collectors.toList());

        String allUniqueNames = uniqueNames.stream().collect(Collectors.joining(", "));
        System.out.println(allUniqueNames);

        List<Person> peopleYounger18 = people.stream().filter(person -> person.getAge() < 18).collect(Collectors.toList());
        double averageAge = peopleYounger18.stream().mapToInt(person -> person.getAge()).average().getAsDouble();
        System.out.println(averageAge);

        Map<String, List<Person>> peopleByName = people.stream().collect(Collectors.groupingBy(person -> person.getName()));
        System.out.println(peopleByName.get("Алексей"));


    /*    Scanner scanner = new Scanner(System.in);

        System.out.println("Вветите количество элементов, которые нужно вычислить и распечатать");
        int numberOfElements = scanner.nextInt();

        DoubleStream squareRoots = DoubleStream.iterate(0, x -> x + 1).map(x -> Math.sqrt(x)); */
    }


}
