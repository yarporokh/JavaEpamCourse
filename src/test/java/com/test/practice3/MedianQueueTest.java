package com.test.practice3;

import com.advanced.practice3.MedianQueue;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MedianQueueTest extends TestCase {
    MedianQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new MedianQueue(5);
    }

    @Test
    public void testOffer() {
        queue.offer(14);
        queue.offer(25);
        assertEquals("[14, 25, null, null, null]", queue.toString());
    }

    @Test
    public void testPoll() {
        queue.offer(14);
        assertEquals(new Integer(14), queue.poll());
    }

    @Test
    public void testPeek() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertEquals(1, queue.peek());
    }

    @Test
    public void testSize() {
        queue.offer(13);
        queue.offer(25);
        queue.offer(33);
        assertEquals(3, queue.size());
    }

    @Test
    public void testGetMedian() {
        queue.offer(1);
        queue.offer(987);
        queue.offer(4);
        queue.offer(2);
        queue.offer(3);
        assertEquals(3, queue.getMedian());
    }
}