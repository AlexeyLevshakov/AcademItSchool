package ru.academits.levshakov.shapes.main;

import ru.academits.levshakov.shapes.shape.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Square(1));
        shapes.add(new Circle(1));
        shapes.add(new Circle(3));
        shapes.add(new Rectangle(2, 3));
        shapes.add(new Triangle(0, 0, 0, 3, 4, 0));
        shapes.add(new Triangle(-2, -2, 0, 4, 2, -2));

        System.out.println();
    }
}
