package com.test.task10;

import com.company.task10.User;
import com.company.task10.UserKMDAHelper;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.ArrayList;

public class UserKMDAHelperTest extends TestCase {
    String[] urls;

    public void setUp() throws Exception {
        urls = new String[]{"https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/d2b1a7d2-9222-4dfa-b57e-c0bb0b21485b/download/sichen-zp-2021.csv",
                "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/38ef4e5e-72ec-4715-95d7-28c0fd42176c/download/liutii-zp-2021.csv",
                "https://data.gov.ua/dataset/770cc750-4333-424f-b6e9-6e6c5c76aec9/resource/953aae94-8c82-4296-881f-f57b3a7be389/download/berezen-2021.csv"};
}

    public void testMaxSalary() throws IOException {
        assertEquals(17760.0, UserKMDAHelper.maxSalary(urls), 1.0);
    }

    public void testGetUserWithMinSalary() throws IOException {
        String str1 = "[\n" +
                "User{name='Хонда М. П.', position='Заступник голови КМДА з питань здійснення самоврядних повноважень', salary=13125.0}]";
        String str2 = "[\n" +
                "User{name='Хонда М. П.', position='Заступник голови КМДА з питань здійснення самоврядних повноважень', salary=14625.0}]";
        String str3 = "[\n" +
                "User{name='Кличко В. В.', position='Київський міський голова', salary=17760.0}]";

        assertEquals(str1, UserKMDAHelper.getUserWithMinSalary(UserKMDAHelper.getUserFromURL(urls[0])).toString());
        assertEquals(str2, UserKMDAHelper.getUserWithMinSalary(UserKMDAHelper.getUserFromURL(urls[1])).toString());
        assertEquals(str3, UserKMDAHelper.getUserWithMinSalary(UserKMDAHelper.getUserFromURL(urls[2])).toString());
    }

    public void testGetAverageSalary() throws IOException {
        assertEquals(12396.57, UserKMDAHelper.getAverageSalary(urls), 1.0);
    }

    public void testGetMonthWithMaxAverageSalary() throws IOException {
        assertEquals("January", UserKMDAHelper.getMonthWithMaxAverageSalary(urls));
    }
}