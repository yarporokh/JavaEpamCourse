package com.test.task7;

import com.company.task7.LongDeposit;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class LongDepositTest {
    LongDeposit longDeposit1;
    LongDeposit longDeposit2;

    @Before
    public void setUp() {
        longDeposit1 = new LongDeposit(new BigDecimal(1000), 7);
        longDeposit2 = new LongDeposit(new BigDecimal(1000), 5);
    }


    @Test
    public void income() {
        assertEquals("income() test error", new BigDecimal(700.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), longDeposit1.income());
        assertEquals("income() test error", new BigDecimal(0.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), longDeposit2.income());
    }
}