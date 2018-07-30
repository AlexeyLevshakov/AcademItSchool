package ru.academits.levshakov.range.main;

import ru.academits.levshakov.range.range.Range;

public class Main {
    public static void main(String[] args) {
        Range firstRange = new Range(0, 10);
        Range secondRange = new Range(0, 4);

        Range.print(firstRange);
        System.out.println();
        Range.print(secondRange);
        System.out.println();
        Range.print(firstRange.getComplement(secondRange));
    }
}
