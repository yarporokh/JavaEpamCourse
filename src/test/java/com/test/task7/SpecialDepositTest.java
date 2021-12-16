package com.test.task7;

import com.company.task7.SpecialDeposit;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SpecialDepositTest {
    SpecialDeposit specialDeposit;


    @Before
    public void setUp(){
        specialDeposit = new SpecialDeposit(new BigDecimal(1000), 2);
    }


    @Test
    public void income() {
        assertEquals("income() test error", new BigDecimal(30.20).setScale(2, BigDecimal.ROUND_HALF_EVEN), specialDeposit.income());
    }
}