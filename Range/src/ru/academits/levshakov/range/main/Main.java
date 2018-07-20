package ru.academits.levshakov.range.main;

import ru.academits.levshakov.range.range.Range;

public class Main {
    public static void main(String[] args) {
        Range firstRange = new Range(0, 10);
        Range secondRange = new Range(-5, -3);

        firstRange.print();
        secondRange.print();

        Range intersection = firstRange.getIntersection(secondRange);
        intersection.print();
    }
}
