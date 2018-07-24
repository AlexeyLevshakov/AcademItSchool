package ru.academits.levshakov.vector.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Переданный конструктору аргумент должен быть положительным");
        }

        this.components = new double[n];
    }

    public Vector(Vector vector) {
        this.components = new double[vector.components.length];

        System.arraycopy(vector.components, 0, this.components, 0, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Переданный конструктору массив должен быть ненулевой длины");
        }

        this.components = new double[array.length];

        System.arraycopy(array, 0, components, 0, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Переданный конструктору аргумент должен быть положительным");
        }

        this.components = new double[n];

        if (n <= array.length) {
            System.arraycopy(array, 0, components, 0, n);
        } else {
            System.arraycopy(array, 0, components, 0, array.length);

            for (int i = array.length; i < n; i++) {
                components[i] = 0;
            }
        }
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("{ ");
        for (double component : components) {
            string.append(component);
            string.append(", ");
        }
        string.deleteCharAt(string.lastIndexOf(","));
        string.append("}");

        return string.toString();
    }

    public void addVector(Vector vector) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] += vector.components[i];
        }
    }

    public void subtractVector(Vector vector) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] -= vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < this.components.length; i++) {
            this.components[i] *= scalar;
        }
    }

    public void rotate180degree() {
        this.multiplyByScalar(-1);
    }

    public double getLength() {
        double sum = 0;
        for (double component : this.components) {
            sum += Math.pow(component, 2);
        }

        return Math.sqrt(sum);
    }

    public double getComponentAtIndex(int index) {
        return this.components[index];
    }

    public void setComponentAtIndex(int index, double number) {
        this.components[index] = number;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Vector vector = (Vector) object;

        if (this.getSize() != vector.getSize()) {
            return false;
        }

        for (int i = 0; i < this.components.length; i++) {
            if (this.components[i] != vector.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);

        return hash;
    }

    public static Vector getVectorsSum(Vector vector1, Vector vector2) {
        if (vector1.getSize() >= vector2.getSize()) {
            Vector resultVector = new Vector(vector1.getSize());

            for (int i = 0; i < vector2.getSize(); i++) {
                resultVector.components[i] = vector1.components[i] + vector2.components[i];
            }

            for (int i = vector2.getSize(); i < vector1.getSize(); i++) {
                resultVector.components[i] = vector1.components[i];
            }

            return resultVector;
        } else {
            Vector resultVector = new Vector(vector2.getSize());

            for (int i = 0; i < vector1.getSize(); i++) {
                resultVector.components[i] = vector1.components[i] + vector2.components[i];
            }

            for (int i = vector1.getSize(); i < vector2.getSize(); i++) {
                resultVector.components[i] = vector2.components[i];
            }

            return resultVector;
        }
    }

    public static Vector getVectorDifference(Vector vector1, Vector vector2) {
        if (vector1.getSize() >= vector2.getSize()) {
            Vector resultVector = new Vector(vector1.getSize());

            for (int i = 0; i < vector2.getSize(); i++) {
                resultVector.components[i] = vector1.components[i] - vector2.components[i];
            }

            for (int i = vector2.getSize(); i < vector1.getSize(); i++) {
                resultVector.components[i] = vector1.components[i];
            }

            return resultVector;
        } else {
            Vector resultVector = new Vector(vector2.getSize());

            for (int i = 0; i < vector1.getSize(); i++) {
                resultVector.components[i] = vector1.components[i] - vector2.components[i];
            }

            for (int i = vector1.getSize(); i < vector2.getSize(); i++) {
                resultVector.components[i] = -vector2.components[i];
            }

            return resultVector;
        }
    }

    public static double getScalarProductOfVectors(Vector vector1, Vector vector2) {
        int minVectorSize;

        if (vector1.getSize() >= vector2.getSize()) {
            minVectorSize = vector2.getSize();
        } else {
            minVectorSize = vector1.getSize();
        }

        double scalarProductOfVectors = 0;

        for (int i = 0; i < minVectorSize; i++) {
            scalarProductOfVectors += vector1.components[i] * vector2.components[i];
        }

        return scalarProductOfVectors;
    }
}