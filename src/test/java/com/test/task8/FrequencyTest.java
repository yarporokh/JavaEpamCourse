package com.test.task8;

import com.company.task8.Frequency;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrequencyTest {
    Frequency fr;

    @Before
    public void setUp() throws Exception {
        fr = new Frequency();
    }

    @Test
    public void getResult() {
        String str = """
                dog ==> 8
                lion ==> 4
                monkey ==> 6
                """;
        assertTrue("gerResult() test error", str.equals(fr.getResult()));
    }
}