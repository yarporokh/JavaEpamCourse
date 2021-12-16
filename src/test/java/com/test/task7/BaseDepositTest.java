package com.test.task7;

import com.company.task7.BaseDeposit;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BaseDepositTest {
    BaseDeposit baseDeposit;

    @Before
    public void setUp() {
        baseDeposit = new BaseDeposit(new BigDecimal(1000), 2);
    }

    @Test
    public void income() {
        assertEquals("income() test error", new BigDecimal(102.50).setScale(2, BigDecimal.ROUND_HALF_EVEN), baseDeposit.income());
    }
}