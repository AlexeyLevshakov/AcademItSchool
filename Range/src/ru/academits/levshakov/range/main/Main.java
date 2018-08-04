package ru.academits.levshakov.range.main;

import ru.academits.levshakov.range.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range firstRange = new Range(0, 10);

        System.out.println("Первый интервал");
        Range.print(firstRange);
        System.out.println();
        System.out.println("Начало первого интервала:");
        System.out.println(firstRange.getFrom());
        System.out.println("Конец первого интервала:");
        System.out.println(firstRange.getTo());
        System.out.println("Длина первого интервала");
        System.out.println(firstRange.getLength());
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");

        if (firstRange.isInside(scanner.nextDouble())) {
            System.out.println("Это число лежит внутри первого интервала");
        } else {
            System.out.println("Это число НЕ лежит внутри первого интервала");
        }

        System.out.println();

        Range secondRange = new Range(0, 10);

        System.out.print("Введите начало второго интервала:");
        secondRange.setFrom(scanner.nextDouble());
        System.out.print("Введите конец второго интервала:");
        secondRange.setTo(scanner.nextDouble());

        System.out.println("Второй интервал");
        Range.print(secondRange);
        System.out.println();
        System.out.println("Длина второго интервала");
        System.out.println(secondRange.getLength());
        System.out.println();

        System.out.println("Пересечение первого и второго интервалов");
        Range.print(firstRange.getIntersection(secondRange));
        System.out.println();

        System.out.println("Пересечение второго и первого");
        Range.print(secondRange.getIntersection(firstRange));
        System.out.println();

        System.out.println("Объединение первого и второго интервалов");
        Range.print(firstRange.getUnion(secondRange));
        System.out.println();

        System.out.println("Объединение второго и первого");
        Range.print(secondRange.getUnion(firstRange));
        System.out.println();

        System.out.println("Разность первого и второго интервалов");
        Range.print(firstRange.getComplement(secondRange));
        System.out.println();

        System.out.println("Разность второго и первого интервалов");
        Range.print(secondRange.getComplement(firstRange));
    }
}
