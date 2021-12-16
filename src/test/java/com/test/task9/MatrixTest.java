package com.test.task9;

import com.company.task9.DifferentMatrixSizesException;
import com.company.task9.Matrix;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    Matrix m1;
    Matrix m2;

    @Before
    public void setUp() throws Exception {
        double[][] arr = {{1, 2}, {3, 4}};
        double[][] arr1 = {{5, 2}, {1, 3}};
        m1 = new Matrix(arr);
        m2 = new Matrix(arr1);
    }

    @Test
    public void addition() throws DifferentMatrixSizesException {
        String str = "[[6.0, 4.0], [4.0, 7.0]]";
        assertTrue(str.equals(m1.addition(m2).getMatrix()));
    }

    @Test
    public void deduction() throws DifferentMatrixSizesException {
        String str = "[[-4.0, 0.0], [2.0, 1.0]]";
        assertTrue(str.equals(m1.deduction(m2).getMatrix()));
    }

    @Test
    public void multiplication() throws DifferentMatrixSizesException {
        String str = "[[7.0, 8.0], [19.0, 18.0]]";
        assertTrue(str.equals(m1.multiplication(m2).getMatrix()));
    }
}