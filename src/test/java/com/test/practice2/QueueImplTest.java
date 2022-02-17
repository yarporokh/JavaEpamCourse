package com.test.practice2;

import com.advanced.practice2.QueueImpl;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueImplTest extends TestCase {
    QueueImpl queue = new QueueImpl();

    @BeforeEach
    public void setUp() {
        queue.enqueue("Q");
        queue.enqueue("W");
        queue.enqueue("E");
    }

    @Test
    public void testClear() {
        queue.clear();
        assertEquals("[null]", queue.toString());
    }

    @Test
    public void testSize() {
        assertEquals(3, queue.size());
    }

    @Test
    public void testEnqueue() {
        queue.enqueue("R");
        assertEquals("[Q, W, E, R]", queue.toString());
    }

    @Test
    public void testDequeue() {
        assertEquals("E", queue.dequeue());
    }

    @Test
    public void testTop() {
        assertEquals("Q", queue.top());
    }
}