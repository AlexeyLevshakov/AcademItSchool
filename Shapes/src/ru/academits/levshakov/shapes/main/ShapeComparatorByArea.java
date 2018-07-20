package ru.academits.levshakov.shapes.main;

import ru.academits.levshakov.shapes.shape.Shape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparable<Shape>, Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return shape1.getArea().compareTo(shape2.getArea());
    }
}
