package ru.academits.levshakov.vector.main;

import ru.academits.levshakov.vector.vector.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверим работу конструкторов, методов getSize() и toString()");

        Vector vector1 = new Vector(3);
        System.out.println(vector1.getSize());
        System.out.println(vector1.toString());

        double[] array = {1, 2, 3, 4, 5};

        Vector vector2 = new Vector(array);
        System.out.println(vector2.getSize());
        System.out.println(vector2.toString());

        Vector vector3 = new Vector(vector2);
        System.out.println(vector3.getSize());
        System.out.println(vector3.toString());

        Vector vector4 = new Vector(7, array);
        System.out.println(vector4.getSize());
        System.out.println(vector4.toString());

        System.out.println("Проверим нестатические методы");

        double[] array2 = {2, 4, 6, 8, 10};
        Vector vector5 = new Vector(array2);
        System.out.println(vector5);

        System.out.println("Сложение");
        vector5.addVector(vector4);
        System.out.println(vector5);

       /* System.out.println("Вычитание");
        vector5.subtractVector(vector2);
        System.out.println(vector5);

        System.out.println("Умножение на скаляр");
        vector5.multiplyByScalar(3);
        System.out.println(vector5);

        System.out.println("Разворот");
        vector5.rotate180degrees();
        System.out.println(vector5);

        System.out.println("Получение длины вектора");
        System.out.println(vector5.getLength());

        System.out.println("Получение и установка компонента вектора по индексу");
        System.out.println(vector5.getComponentAtIndex(0));
        vector5.setComponentAtIndex(0, 10);
        System.out.println(vector5);

        System.out.println("Equals");
        System.out.println(vector5.equals(vector1));

        double[] array3 = {10, -12, -18, -24, -30};
        Vector vector6 = new Vector(array3);

        System.out.println(vector5.equals(vector6));
        System.out.println(vector6.equals(vector5));

        double[] array4 = {10.11, -12, -18, -24, -30};
        Vector vector7 = new Vector(array4);

        System.out.println(vector5.equals(vector7));

        System.out.println("HashCode");
        System.out.println(vector5.hashCode());
        System.out.println(vector6.hashCode());
        System.out.println(vector7.hashCode());

        System.out.println("Проверим статические методы");

        System.out.println("Сложение");
        System.out.println(Vector.getVectorsSum(vector6, vector2));

        System.out.println("Разность");
        System.out.println(Vector.getVectorDifference(vector6, vector2));

        System.out.println("Скалярное произведение");
        System.out.println(Vector.getScalarProductOfVectors(vector6, vector2)); */
    }
}
