package com.test.finalTask;

import com.company.finalTask.BLL.City;
import com.company.finalTask.BLL.Country;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class finalTaskTest {
    Country country;
    City city;

    @Before
    public void setUp() throws Exception {
        country = new Country("Ukraine", "ab123456");
        city = new City("Kyiv", "ac123456", 123456, "yes", "Ukraine");
    }

    @Test
    public void isCaptial() {
        assertEquals("yes", city.getIsCapital());
        city.setIsCapital("no");
        assertEquals("no", city.getIsCapital());
    }

    @Test
    public void setPopulation() {
        city.setPopulation(130);
        assertEquals(20000, city.getPopulation());
    }
}
