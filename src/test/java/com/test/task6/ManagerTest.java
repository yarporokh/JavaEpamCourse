package com.test.task6;

import com.company.task6.Manager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ManagerTest {
    Manager manager;

    @Before
    public void setUp() throws Exception {
        System.out.println("Run @Before");
        manager = new Manager("Ivanov", 1000, 120);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Run @After"); // for illustration
    }

    @Test
    public void tPay(){
        manager.setBonus(new BigDecimal(200));
        assertEquals("test ToPay() error", new BigDecimal(1700), manager.toPay());
    }
}