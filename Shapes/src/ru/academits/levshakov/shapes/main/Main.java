package ru.academits.levshakov.shapes.main;

import ru.academits.levshakov.shapes.comparators.ShapeAreaComparator;
import ru.academits.levshakov.shapes.comparators.ShapePerimeterComparator;
import ru.academits.levshakov.shapes.shape.*;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    private static Shape findMaxAreaShape(ArrayList<Shape> shapes) {
        Shape[] shapesArray = new Shape[shapes.size()];
        shapes.toArray(shapesArray);

        Arrays.sort(shapesArray, new ShapeAreaComparator());
        return shapesArray[shapesArray.length - 1];
    }

    private static Shape findSecondMaxPerimeterShape(ArrayList<Shape> shapes) {
        Shape[] shapesArray = new Shape[shapes.size()];
        shapes.toArray(shapesArray);

        Arrays.sort(shapesArray, new ShapePerimeterComparator());
        return shapesArray[shapesArray.length - 2];
    }

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(1));
        shapes.add(new Circle(1));
        shapes.add(new Circle(3));
        shapes.add(new Rectangle(2, 3));
        shapes.add(new Triangle(0, 0, 0, 3, 4, 0));
        shapes.add(new Triangle(-2, -2, 0, 4, 2, -2));

        System.out.println("В этом списке фигура с максимальной площадью это:");
        System.out.println(findMaxAreaShape(shapes));

        System.out.println("В этом списке фигура со вторым по величине периметром это:");
        System.out.println(findSecondMaxPerimeterShape(shapes));
    }
}
