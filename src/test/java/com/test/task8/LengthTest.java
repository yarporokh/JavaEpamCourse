package com.test.task8;

import com.company.task8.Length;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LengthTest {
    Length len;

    @Before
    public void setUp() throws Exception {
        len = new Length();
    }

    @Test
    public void getThreeWords() {
        String str = """
                cccccc ==> 6
                eeeee ==> 5
                dddd ==> 4""";
        assertTrue("getThreeWords() test error", str.equals(len.getThreeWords()));
    }
}