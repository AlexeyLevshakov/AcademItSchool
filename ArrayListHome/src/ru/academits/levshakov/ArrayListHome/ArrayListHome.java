package ru.academits.levshakov.ArrayListHome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Прочитаем в список все строки из файла");

        ArrayList<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome\\Input.txt"), "windows-1251")) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        }

        System.out.println(strings);

        System.out.println();
        System.out.println("Теперь удалим все чётные числа из списка целых чисел");

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(13, 24, 2, 13, 3, 4, 5, 14, 7, 16, 18, 13, 5, 9, 2));

        System.out.println(numbers);

        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }

        System.out.println(numbers);

        System.out.println();
        System.out.println("Теперь создадим такой же список, но без повторяющихся элементов");

        ArrayList<Integer> newNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (!newNumbers.contains(number)) {
                newNumbers.add(number);
            }
        }

        System.out.println(newNumbers);
    }
}
