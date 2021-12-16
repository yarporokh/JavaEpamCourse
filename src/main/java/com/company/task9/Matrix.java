package com.company.task9;

import java.util.Arrays;

class ValueNotInRangeException extends Exception {
    public ValueNotInRangeException(String message) {
        super(message);
    }
}

public class Matrix {
    private double[][] matrix;
    final int rows;
    final int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new double[rows][columns];
    }

    public Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = Arrays.copyOf(matrix, matrix.length);


    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String getMatrix() {
        return Arrays.deepToString(matrix);
    }

    public void getValue(int row, int column) {
        try {
            if (row < matrix.length || row > matrix.length
                    || column < matrix[0].length || column > matrix.length) {
                throw new ValueNotInRangeException("Value not in range");
            }
            System.out.println(matrix[row][column]);
        } catch (ValueNotInRangeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setValue(int row, int column, double number) {
        matrix[row][column] = number;
    }

    public Matrix addition(Matrix mat) throws DifferentMatrixSizesException {
        Matrix mat3 = new Matrix(rows, columns);
        if (rows != mat.rows || columns != mat.columns) {
            throw new DifferentMatrixSizesException("Matrices have different sizes");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat3.matrix[i][j] = this.matrix[i][j] + mat.matrix[i][j];
            }
        }
        return mat3;
    }

    public Matrix deduction(Matrix mat) throws DifferentMatrixSizesException {
        Matrix mat3 = new Matrix(rows, columns);
        if (rows != mat.rows || columns != mat.columns) {
            throw new DifferentMatrixSizesException("Matrices have different sizes");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                mat3.matrix[i][j] = this.matrix[i][j] - mat.matrix[i][j];
            }
        }
        return mat3;
    }

    public Matrix multiplication(Matrix mat) throws DifferentMatrixSizesException {
        Matrix mat3 = new Matrix(rows, columns);
        if (rows != mat.rows || columns != mat.columns) {
            throw new DifferentMatrixSizesException("Matrices have different sizes");
        }
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < columns; ++j)
                for (int k = 0; k < columns; ++k)
                    mat3.matrix[i][j] += matrix[i][k] * mat.matrix[k][j];
        return mat3;
    }
}
