package com.test.task6;

import com.company.task6.SalesPerson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SalesPersonTest {
    SalesPerson sp;

    @Before
    public void setUp() throws Exception {
        System.out.println("Run @Before");
        sp = new SalesPerson("Smith", 1000, 210);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Run @After"); // for illustration
    }

    @Test
    public void toPay(){
        sp.setBonus(new BigDecimal(200));
        assertEquals("test ToPay() error", new BigDecimal(1600), sp.toPay());
    }
}