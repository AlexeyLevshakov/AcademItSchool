package ru.academits.levshakov.shapes.comparators;

import ru.academits.levshakov.shapes.shape.Shape;

import java.util.Comparator;

public class ShapePerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double perimeter1 = shape1.getPerimeter();
        double perimeter2 = shape2.getPerimeter();

        if (perimeter1 > perimeter2) {
            return 1;
        } else if (perimeter1 < perimeter2) {
            return -1;
        } else {
            return 0;
        }
    }
}
