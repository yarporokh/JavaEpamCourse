package com.test.task5;

import com.company.task5.ArrayRectangles;
import com.company.task5.Rectangle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayRectanglesTest {
    ArrayRectangles arr;

    @Before
    public void setUp() throws Exception {
        System.out.println("Run @Before");
        Rectangle r1 = new Rectangle(10, 3);
        Rectangle r2 = new Rectangle(4, 4);
        Rectangle r3 = new Rectangle(1);
        Rectangle r4 = new Rectangle();
        arr = new ArrayRectangles(r1, r2);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Run @After"); // for illustration
    }

    @Test
    public void testAddRectangle() {
        assertFalse("error testGetter()", arr.addRectangle(new Rectangle(5, 5)));
    }

    @Test
    public void testNumberMaxArea() {
        assertEquals("error testNumberMaxArea()", 0, arr.numberMaxArea());
    }

    @Test
    public void testNumberMinPerimeter() {
        assertEquals("error testNumberMinPerimeter()", 1, arr.numberMinPerimeter());
    }

    @Test
    public void testNumberSquare() {
        assertEquals("error testNumberSquare()", 1, arr.numberSquare());
    }
}