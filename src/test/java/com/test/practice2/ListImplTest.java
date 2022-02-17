package com.test.practice2;

import com.advanced.practice2.ListImpl;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListImplTest extends TestCase {
    ListImpl list = new ListImpl();

    @BeforeEach
    public void setUp() {
        list.addFirst("E");
        list.addFirst("W");
        list.addFirst("Q");
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals("[null]", list.toString());
    }

    @Test
    public void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    public void testAddFirst() {
        list.addFirst("W");
        assertEquals("[W, Q, W, E]", list.toString());
    }

    @Test
    public void testAddLast() {
        list.addLast("R");
        assertEquals("[Q, W, E, R]", list.toString());
    }

    @Test
    public void testRemoveFirst() {
        list.removeFirst();
        assertEquals("[W, E]", list.toString());
    }

    @Test
    public void testRemoveLast() {
        list.removeLast();
        assertEquals("[Q, W]", list.toString());
    }

    @Test
    public void testGetFirst() {
        assertEquals("Q", list.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals("E", list.getLast());
    }

    @Test
    public void testSearch() {
        assertEquals("Q", list.search("Q"));
    }

    @Test
    public void testRemove() {
        list.remove("W");
        assertEquals("[Q, E]", list.toString());
    }
}