package com.test.task7;

import com.company.task7.BaseDeposit;
import com.company.task7.Client;
import com.company.task7.LongDeposit;
import com.company.task7.SpecialDeposit;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.Assert.*;


public class ClientTest {
    BaseDeposit baseDeposit;
    SpecialDeposit specialDeposit;
    LongDeposit longDeposit1;
    LongDeposit longDeposit2;
    Client client;

    @Before
    public void setUp() {
        longDeposit1 = new LongDeposit(new BigDecimal(1000), 7);
        longDeposit2 = new LongDeposit(new BigDecimal(1000), 5);
        baseDeposit = new BaseDeposit(new BigDecimal(1000), 2);
        specialDeposit = new SpecialDeposit(new BigDecimal(1000), 2);
        client = new Client();
    }


    @Test
    public void addDeopist() {
        assertTrue(client.addDeopist(longDeposit1));
    }


    @Test
    public void totalIncome() {
        client.addDeopist(longDeposit1);
        client.addDeopist(longDeposit2);
        client.addDeopist(baseDeposit);
        client.addDeopist(specialDeposit);
        assertEquals("totalIncome() test error", new BigDecimal(832.70).setScale(2, BigDecimal.ROUND_HALF_EVEN), client.totalIncome());
    }

    @Test
    public void maxIncome() {
        client.addDeopist(longDeposit1);
        client.addDeopist(longDeposit2);
        client.addDeopist(baseDeposit);
        client.addDeopist(specialDeposit);
        assertEquals("maxIncome() test error", new BigDecimal(700.00).setScale(2, BigDecimal.ROUND_HALF_EVEN), client.maxIncome());
    }

    @Test
    public void getIncomeByNumber() {
        client.addDeopist(longDeposit1);
        client.addDeopist(longDeposit2);
        client.addDeopist(baseDeposit);
        client.addDeopist(specialDeposit);
        assertEquals("getIncomeByNumber() test error", new BigDecimal(0), client.getIncomeByNumber(8));
        assertEquals("getIncomeByNumber() test error", new BigDecimal(700).setScale(2, BigDecimal.ROUND_HALF_EVEN), client.getIncomeByNumber(1));
    }
}