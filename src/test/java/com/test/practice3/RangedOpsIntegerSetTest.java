package com.test.practice3;

import com.advanced.practice3.RangedOpsIntegerSet;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RangedOpsIntegerSetTest extends TestCase {
    RangedOpsIntegerSet set;

    @BeforeEach
    public void setUp() {
        set = new RangedOpsIntegerSet(5);
    }

    @Test
    public void testAdd() {
        assertEquals(true, set.add(1));
    }

    @Test
    public void testTestAdd() {
        assertEquals(true, set.add(1, 15));
        assertEquals(false, set.add(3, 14));
    }

    @Test
    public void testRemove() {
        set.add(1, 15);
        assertEquals(true, set.remove(5));
    }

    @Test
    public void testTestRemove() {
        set.add(1, 15);
        assertEquals(true, set.remove(3, 13));
    }

    @Test
    public void testSize() {
        set.add(1, 15);
        assertEquals(14, set.size());
    }
}