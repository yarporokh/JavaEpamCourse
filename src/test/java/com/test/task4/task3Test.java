package com.test.task4;


import com.company.task3.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class task3Test {
    @Test
    public void testTask1(){
        assertSame(true, task1.IsSorted(new int[] {1, 2, 3, 4, 5, 6}, SortOrder.ASCENDING));
    }

    @Test
    public void testTask2(){
        assertArrayEquals(new int[] {1, 3, 5, 7, 9, 11}, task2.Transform(new int[] {1, 2, 3, 4, 5, 6}, SortOrder.ASCENDING));
    }

    @Test
    public void testTask3() {
        assertEquals(6160, task3.MultArithmeticElements(5, 3, 4));
    }

    @Test
    public void testTask4() {
        assertEquals(175.0, task4.SumGeometricElements(100f, 0.5f, 20f), 1.0);
    }

}
