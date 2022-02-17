package com.test.practice2;

import com.advanced.practice2.StackImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class StackImplTest extends TestCase {
    StackImpl stack = new StackImpl();

    @BeforeEach
    public void setUp() {
        stack.push("E");
        stack.push("W");
        stack.push("Q");
    }

    @Test
    public void testClear() {
        stack.clear();
        assertEquals("[null]", stack.toString());
    }

    @Test
    public void testSize() {
        assertEquals(3, stack.size());
    }

    @Test
    public void testPush() {
        stack.push("R");
        assertEquals("[R, Q, W, E]", stack.toString());
    }

    @Test
    public void testPop() {
        assertEquals("Q", stack.pop());
    }

    @Test
    public void testTop() {
        assertEquals("Q", stack.top());
    }
}