package com.test.practice1.array;

import com.advanced.practice1.task2.ArrayImpl;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;




public class ArrayImplTest{
    ArrayImpl array = new ArrayImpl();


    @Test
    public void testAdd() {
        array.add("Q");
        array.add("W");
        array.add("E");
        array.add("R");
        assertEquals("[Q, W, E, R]", array.toString());
    }

    @Test
    public void testSet() {
        array.add("Q");
        array.add("W");
        array.add("E");
        array.add("R");
        array.set(2, "T");
        assertEquals("[Q, W, T, E, R]", array.toString());
    }

    @Test
    public void testGet() {
        array.add("Q");
        array.add("W");
        array.add("E");
        array.add("R");
        assertEquals("W", array.get(1));
    }

    @Test
    public void testIndexOf() {
        array.add("Q");
        array.add("W");
        array.add("E");
        array.add("R");
        assertEquals(2, array.indexOf("E"));
    }

    @Test
    public void testRemove() {
        array.add("Q");
        array.add("W");
        array.add("E");
        array.add("R");
        array.remove(3);
        assertEquals("[Q, W, E]", array.toString());
    }

    @Test
    public void testClear() {
        array.add("Q");
        array.add("W");
        array.add("E");
        array.add("R");
        array.clear();
        assertEquals("[]", array.toString());
    }

    @Test
    public void testSize() {
        array.add("Q");
        array.add("W");
        array.add("E");
        array.add("R");
        assertEquals(4, array.size());
    }
}