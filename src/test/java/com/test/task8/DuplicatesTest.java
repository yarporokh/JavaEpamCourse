package com.test.task8;

import com.company.task8.Duplicates;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicatesTest {
    Duplicates duplicates;

    @Before
    public void setUp() throws Exception {
        duplicates = new Duplicates();
    }

    @Test
    public void findDuplicates() {
        String str = """
                IDNED
                LOL
                REWAD""";
        assertTrue("findDuplicates() test error", str.equals(duplicates.findDuplicates()));
    }
}