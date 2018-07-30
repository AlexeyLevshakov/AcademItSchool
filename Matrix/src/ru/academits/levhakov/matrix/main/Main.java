package ru.academits.levhakov.matrix.main;

import ru.academits.levshakov.matrix.matrix.Matrix;
import ru.academits.levshakov.matrix.matrix.Vector;

public class Main {
    public static void main(String[] args) {
        System.out.println("Проверим работу конструкторов, методов getColumnsNumber, getRowsNumber и toString");
        System.out.println("Создадим пустую матрицу размером 2 на 3");
        Matrix matrix1 = new Matrix(2, 3);
        System.out.println(matrix1);
        System.out.println(matrix1.getRowsNumber());
        System.out.println(matrix1.getColumnsNumber());

        System.out.println();
        System.out.println("Создадим новую матрицу - копию первой");
        Matrix matrix2 = new Matrix(matrix1);
        System.out.println(matrix2);
        System.out.println(matrix2.getRowsNumber());
        System.out.println(matrix2.getColumnsNumber());

        System.out.println();
        System.out.println("Создадим новую матрицу через заданный двумерный массив");

        double[][] array = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        Matrix matrix3 = new Matrix(array);
        System.out.println(matrix3);
        System.out.println(matrix3.getRowsNumber());
        System.out.println(matrix3.getColumnsNumber());

        System.out.println();
        System.out.println("Создадим ещё одну матрицу через массив векторов");

        double[] array1 = {1, 2, 3};
        double[] array2 = {4, 5, 6};
        double[] array3 = {7, 8, 9};
        Vector[] arrayVector = new Vector[3];
        arrayVector[0] = new Vector(array1);
        arrayVector[1] = new Vector(array2);
        arrayVector[2] = new Vector(array3);

        Matrix matrix4 = new Matrix(arrayVector);
        System.out.println(matrix4.getRowsNumber());
        System.out.println(matrix4.getColumnsNumber());
        System.out.println(matrix4);

        System.out.println();
        System.out.println("Проверим геттеры и сеттеры для векторов-строк");
        System.out.println(matrix4.getRowAtIndex(1));

        double[] array4 = {10, 20, 30};
        Vector vector = new Vector(array4);
        matrix4.setRowAtIndex(1, vector);
        System.out.println(matrix4);

        System.out.println();
        System.out.println("И геттер для вектор-столбцов");
        System.out.println(matrix4.getColumnAtIndex(1));

        System.out.println();
        System.out.println("Сделаем транспонирование");
        matrix4.transpose();
        System.out.println(matrix4);

        System.out.println();
        System.out.println("Умножение на скаляр");
        matrix4.multiplyByScalar(2);
        System.out.println(matrix4);

        System.out.println();
        System.out.println("Вычисление определителя");
        System.out.println(matrix4.calculateDeterminant());

        System.out.println();
        System.out.println("Умножение матрицы на вектор-столбец");
        System.out.println(matrix4.multiplyByVectorColumn(vector));

        System.out.println();
        System.out.println("Умножение матрицы на вектор-строку");
        double[][] columnVectorArray = {{2}, {3}, {4}};
        Matrix columnVectorMatrix = new Matrix(columnVectorArray);
        columnVectorMatrix.multiplyByVectorRow(vector);
        System.out.println(columnVectorMatrix);

        System.out.println();
        System.out.println("Сложение");
        matrix4.addMatrix(matrix3);
        System.out.println(matrix4);

        System.out.println();
        System.out.println("Вычитание");
        matrix4.subtractMatrix(matrix3);
        System.out.println(matrix4);

        System.out.println();
        System.out.println("Статическое сложение матриц");
        System.out.println(matrix3);
        System.out.println(matrix4);
        System.out.println(Matrix.getMatrixesSum(matrix3, matrix4));
        System.out.println(matrix3);
        System.out.println(matrix4);

        System.out.println();
        System.out.println("Статическая разность матриц");
        System.out.println(matrix3);
        System.out.println(matrix4);
        System.out.println(Matrix.getMatrixesDifference(matrix3, matrix4));
        System.out.println(matrix3);
        System.out.println(matrix4);

        System.out.println();
        System.out.println("Статическое перемножение матриц");

        double[][] newArray1 = {{-1, 1}, {2, 0}, {0, 3}};
        double[][] newArray2 = {{3, 1, 2}, {0, -1, 4}};
        Matrix newMatrix1 = new Matrix(newArray1);
        Matrix newMatrix2 = new Matrix(newArray2);
        System.out.println(newMatrix1);
        System.out.println(newMatrix2);
        System.out.println(Matrix.getMatrixesProduct(newMatrix1, newMatrix2));
        System.out.println(Matrix.getMatrixesProduct(newMatrix2, newMatrix1));
        System.out.println(newMatrix1);
        System.out.println(newMatrix2);
    }
}
