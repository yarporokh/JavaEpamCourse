package com.test.task5;

import com.company.task5.Rectangle;
import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    Rectangle r1;
    Rectangle r2;

    @Before
    public void setUp() throws Exception {
        System.out.println("Run @Before");
        r1 = new Rectangle(10, 3);
        r2 = new Rectangle(4, 4);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Run @After"); // for illustration
    }

    @Test
    public void testGetter() {
        assertEquals("error testGetter()", 10.0, r1.getSideA(), 0.1); // Checks if sideA of r1 equals 10
        assertEquals("error testGetter()", 3.0, r1.getSideB(), 0.1); // Checks if sideB of r1 equals 3
    }

    @Test
    public void testArea() {
        assertEquals("error testArea()", 30, r1.area(), 0.1);
    }

    @Test
    public void testPerimeter() {
        assertEquals("error testPerimeter()", 26, r1.perimeter(), 0.1);
    }

    @Test
    public void testIsSquare() {
        assertFalse("error testIsSquare()", r1.isSquare()); // checks if the rectangle is a square
        assertTrue("error testIsSquare()", r2.isSquare());
    }

    @Test
    public void testReplaceSides() {
        r1.replaceSides();
        assertEquals("error testReplaceSides()", 3, r1.getSideA(), 0.1);
        assertEquals("error testReplaceSides()", 10, r1.getSideB(), 0.1);
    }
}