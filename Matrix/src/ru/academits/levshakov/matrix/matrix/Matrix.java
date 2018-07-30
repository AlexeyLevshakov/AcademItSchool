package ru.academits.levshakov.matrix.matrix;

public class Matrix {
    private Vector[] rows;

    public Matrix(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException("Количество строк и столбцов матрицы должно быть строго больше нуля");
        }

        this.rows = new Vector[m];
        for (int i = 0; i < m; i++) {
            this.rows[i] = new Vector(n);
        }
    }

    public Matrix(Matrix matrix) {
        this.rows = new Vector[matrix.rows.length];
        for (int i = 0; i < matrix.rows.length; i++) {
            this.rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            throw new IllegalArgumentException("Длина массива должна быть отлична от нуля");
        }

        for (double[] arrayRow : array) {
            if (array[0].length != arrayRow.length) {
                throw new IllegalArgumentException("Все строки матрицы должны быть одной длины");
            }
        }

        this.rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            this.rows[i] = new Vector(array[i]);
        }
    }

    public Matrix(Vector[] vectorsArray) {
        if (vectorsArray.length == 0) {
            throw new IllegalArgumentException("Длина массива векторов должна быть отлична от нуля");
        }

        for (Vector vector : vectorsArray) {
            if (vector.getSize() != vectorsArray[0].getSize()) {
                throw new IllegalArgumentException("Все строки матрицы должны быть одной длины");
            }
        }

        this.rows = new Vector[vectorsArray.length];
        for (int i = 0; i < vectorsArray.length; i++) {
            this.rows[i] = new Vector(vectorsArray[i]);
        }
    }

    public int getRowsNumber() {
        return this.rows.length;
    }

    public int getColumnsNumber() {
        return rows[0].getSize();
    }

    public Vector getRowAtIndex(int index) {
        if (index < 0 || index >= this.getRowsNumber()) {
            throw new IllegalArgumentException("Введён некорректный индекс");
        }

        return this.rows[index];
    }

    public void setRowAtIndex(int index, Vector vector) {
        if (index < 0 || index >= this.getRowsNumber()) {
            throw new IllegalArgumentException("Введён некорректный индекс");
        }

        if (vector.getSize() != this.getColumnsNumber()) {
            throw new IllegalArgumentException("Длина передаваемого вектора должна равняться количеству столбцов в матрице");
        }

        this.rows[index] = new Vector(vector);
    }

    public Vector getColumnAtIndex(int index) {
        if (index < 0 || index >= this.getColumnsNumber()) {
            throw new IllegalArgumentException("Введён некорректный индекс");
        }

        Vector column = new Vector(this.getRowsNumber());
        for (int i = 0; i < this.getRowsNumber(); i++) {
            column.setComponentAtIndex(i, this.rows[i].getComponentAtIndex(index));
        }

        return column;
    }

    public void transpose() {
        Vector[] newRows = new Vector[this.rows[0].getSize()];
        for (int i = 0; i < this.rows[0].getSize(); i++) {
            newRows[i] = new Vector(this.rows.length);
            for (int j = 0; j < this.rows.length; j++) {
                newRows[i].setComponentAtIndex(j, rows[j].getComponentAtIndex(i));
            }
        }

        this.rows = newRows;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector row : this.rows) {
            for (int j = 0; j < rows[0].getSize(); j++) {
                row.setComponentAtIndex(j, row.getComponentAtIndex(j) * scalar);
            }
        }
    }

    public double calculateDeterminant() {
        if (this.getRowsNumber() != this.getColumnsNumber()) {
            throw new IllegalArgumentException("Определитель вычисляется только для квадратной матрицы");
        }

        if (this.getRowsNumber() == 2) {
            return this.rows[0].getComponentAtIndex(0) * this.rows[1].getComponentAtIndex(1) -
                    this.rows[1].getComponentAtIndex(0) * this.rows[0].getComponentAtIndex(1);
        } else {
            double determinant = 0;
            for (int p = 0; p < this.getColumnsNumber(); p++) {
                determinant += Math.pow(-1, 2 + p) * this.rows[0].getComponentAtIndex(p) * Matrix.getAdditionalMinor(this, 0, p).calculateDeterminant();
            }
            return determinant;
        }
    }

    private static Matrix getAdditionalMinor(Matrix matrix, int i, int j) {
        Vector[] newRows = new Vector[matrix.getRowsNumber() - 1];
        for (int m = 0; m < i; m++) {
            newRows[m] = new Vector(matrix.getColumnsNumber() - 1);

            for (int n = 0; n < j; n++) {
                newRows[m].setComponentAtIndex(n, matrix.rows[m].getComponentAtIndex(n));
            }

            for (int n = j + 1; n < matrix.getColumnsNumber(); n++) {
                newRows[m].setComponentAtIndex(n - 1, matrix.rows[m].getComponentAtIndex(n));
            }
        }

        for (int m = i + 1; m < matrix.getRowsNumber(); m++) {
            newRows[m - 1] = new Vector(matrix.getColumnsNumber() - 1);

            for (int n = 0; n < j; n++) {
                newRows[m - 1].setComponentAtIndex(n, matrix.rows[m].getComponentAtIndex(n));
            }

            for (int n = j + 1; n < matrix.getColumnsNumber(); n++) {
                newRows[m - 1].setComponentAtIndex(n - 1, matrix.rows[m].getComponentAtIndex(n));
            }
        }

        return new Matrix(newRows);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{ ");
        for (Vector row : rows) {
            string.append(row);
            string.append(", ");
        }
        string.deleteCharAt(string.lastIndexOf(","));
        string.append("}");

        return string.toString();
    }

    public Vector multiplyByVectorColumn(Vector vectorColumn) {
        if (this.getColumnsNumber() != vectorColumn.getSize()) {
            throw new IllegalArgumentException("При умножении матрицы на вектор-столбец число столбцов в матрице должно" +
                    " совпадать с числом строк в векторе-столбце");
        }

        Vector resultVectorColumn = new Vector(this.getRowsNumber());
        for (int i = 0; i < this.getColumnsNumber(); i++) {
            resultVectorColumn.setComponentAtIndex(i, Vector.getScalarProductOfVectors(this.rows[i], vectorColumn));
        }
        return resultVectorColumn;
    }

    public void multiplyByVectorRow(Vector vectorRow) {
        if (this.getColumnsNumber() != 1) {
            throw new IllegalArgumentException("Умножаемая матрица должна быть вектором-столбцом");
        }

        if (this.getRowsNumber() != vectorRow.getSize()) {
            throw new IllegalArgumentException("Количество строк в векторе-столбце должно совпадать с количеством стобцов в векторе-строке");
        }

        Vector[] newRows = new Vector[vectorRow.getSize()];
        for (int i = 0; i < vectorRow.getSize(); i++) {
            newRows[i] = new Vector(vectorRow.getSize());
            for (int j = 0; j < vectorRow.getSize(); j++) {
                newRows[i].setComponentAtIndex(j, this.rows[i].getComponentAtIndex(0) * vectorRow.getComponentAtIndex(j));
            }
        }

        this.rows = newRows;
    }

    public void addMatrix(Matrix matrix) {
        if (this.getColumnsNumber() != matrix.getColumnsNumber() || this.getRowsNumber() != matrix.getRowsNumber()) {
            throw new IllegalArgumentException("Складывать можно только матрицы одного размера");
        }

        for (int i = 0; i < this.rows.length; i++) {
            for (int j = 0; j < this.rows[0].getSize(); j++) {
                this.rows[i].setComponentAtIndex(j, this.rows[i].getComponentAtIndex(j) + matrix.rows[i].getComponentAtIndex(j));
            }
        }
    }

    public void subtractMatrix(Matrix matrix) {
        if (this.getColumnsNumber() != matrix.getColumnsNumber() || this.getRowsNumber() != matrix.getRowsNumber()) {
            throw new IllegalArgumentException("Вычитать можно только матрицы одного размера");
        }

        for (int i = 0; i < this.rows.length; i++) {
            for (int j = 0; j < this.rows[0].getSize(); j++) {
                this.rows[i].setComponentAtIndex(j, this.rows[i].getComponentAtIndex(j) - matrix.rows[i].getComponentAtIndex(j));
            }
        }
    }

    public static Matrix getMatrixesSum(Matrix matrix1, Matrix matrix2) {
        Matrix newMatrix = new Matrix(matrix1);
        newMatrix.addMatrix(matrix2);
        return newMatrix;
    }

    public static Matrix getMatrixesDifference(Matrix matrix1, Matrix matrix2) {
        Matrix newMatrix = new Matrix(matrix1);
        newMatrix.subtractMatrix(matrix2);
        return newMatrix;
    }

    public static Matrix getMatrixesProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsNumber() != matrix2.getRowsNumber()) {
            throw new IllegalArgumentException("Матрицы должны быть согласованы");
        }

        Matrix newMatrix = new Matrix(matrix2.getColumnsNumber(), matrix1.getRowsNumber());
        for (int i = 0; i < matrix1.getRowsNumber(); i++) {
            for (int j = 0; j < matrix2.getColumnsNumber(); j++) {
                newMatrix.rows[i].setComponentAtIndex(j, Vector.getScalarProductOfVectors(matrix1.getRowAtIndex(i), matrix2.getColumnAtIndex(j)));
            }
        }

        return newMatrix;
    }
}
