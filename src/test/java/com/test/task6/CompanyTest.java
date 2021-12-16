package com.test.task6;

import com.company.task6.Company;
import com.company.task6.Employee;
import com.company.task6.Manager;
import com.company.task6.SalesPerson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CompanyTest {
    Employee e1;
    Employee e2;
    Employee e3;
    Employee e4;
    Company c;

    @Before
    public void setUp() throws Exception {
        System.out.println("Run @Before");
        e1 = new SalesPerson("Ivanov", 1200, 130);
        e2 = new Manager("Smith", 1400, 1230);
        e3 = new Manager("Nixon", 1500, 500);
        e4 = new SalesPerson("Ratatouille", 1600, 210);
        c = new Company(e1, e2, e3, e4);
        c.giveEverbodyBonus(new BigDecimal(500));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Run @After"); // for illustration
    }

    @Test
    public void totalToPay() {
        assertEquals("test totalToPay() error", new BigDecimal(11200), (c.totalToPay()));
    }

    @Test
    public void nameMaxSalary() {
        assertEquals("test nameMaxSalary() error", "Ratatouille", c.nameMaxSalary());
    }
}