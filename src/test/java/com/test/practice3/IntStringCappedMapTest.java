package com.test.practice3;

import com.advanced.practice3.IntStringCappedMap;
import junit.framework.TestCase;

public class IntStringCappedMapTest extends TestCase {
    IntStringCappedMap map = new IntStringCappedMap(25);

    public void testTestToString() {
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(12, "Twelve");
        map.put(9, "Nine");
        map.put(1, "One");

        assertEquals("{1=One, 7=Seven, 8=Eight, 9=Nine, 12=Twelve}", map.toString());
    }
}