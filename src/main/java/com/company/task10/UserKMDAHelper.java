package com.company.task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class UserKMDAHelper {

    public static ArrayList<User> getUserFromURL(String url) throws IOException {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                connection.getInputStream(), StandardCharsets.UTF_8))) {
            br.readLine();
            while (br.ready()) {
                String text = br.readLine();
                String[] words = text.split(";");
                users.add(new User(
                        words[0],
                        words[1],
                        Double.parseDouble(words[2].replace(",", ".").replace("₴", "").replaceAll(" ", ""))
                ));
            }
        }
        return users;
    }

    public static double maxSalary(String... urls) throws IOException {
        double maxSalary = 0d;
        for (String url : urls) {
            for (User user : getUserFromURL(url)) {
                if (maxSalary < user.getSalary())
                    maxSalary = user.getSalary();
            }
        }
        return maxSalary;
    }

    public static ArrayList<User> getUserWithMinSalary(ArrayList<User> users) throws IOException {
        ArrayList<User> minSalaryUsers = new ArrayList<>();

        User minSalaryUser = users.get(0);
        for (var user : users) {
            if (minSalaryUser.getSalary() < user.getSalary())
                minSalaryUser = user;
        }
        for (var user : users) {
            if (minSalaryUser.getSalary() == user.getSalary())
                minSalaryUsers.add(user);
        }
        return minSalaryUsers;
    }


    public static ArrayList<User> getUserWithAverageSalary(String... urls) throws IOException {
        ArrayList<User> averageSalaryUsers = new ArrayList<>();
        for (String url : urls) {
            int count = 0;
            double salaryInMonth = 0;
            for (User user : getUserFromURL(url)) {
                count++;
                salaryInMonth += user.getSalary();
            }
            double averageSalary = salaryInMonth / count;
            for (User user : getUserFromURL(url)) {
                if (user.getSalary() <= averageSalary + averageSalary * 0.2 &&
                        user.getSalary() >= averageSalary - averageSalary * 0.2) {
                    averageSalaryUsers.add(user);
                }
            }
        }
        return averageSalaryUsers;
    }

    public static double getAverageSalary(String... urls) throws IOException {
        double count = 0d;
        double salary = 0d;
        for (String url : urls) {
            for (User user : getUserFromURL(url)) {
                count++;
                salary += user.getSalary();
            }
        }
        double averageSalary = salary / count;
        BigDecimal bd = BigDecimal.valueOf(averageSalary);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String getMonthWithMaxAverageSalary(String... urls) throws IOException {
        String[] months = {"January", "February", "March"};

        TreeMap<Double, String> monthsSalary = new TreeMap<>();
        for (int i = 0; i < urls.length; i++) {
            monthsSalary.put(averSalary(getUserFromURL(urls[i])), months[i]);
        }

        Collection<String> sortedMonths = monthsSalary.values();
        return sortedMonths.iterator().next();
    }

    public static double averSalary(ArrayList<User> users) {
        double salary = 0;
        for (User user : users)
            salary += user.getSalary();

        double averageSalary = salary / users.size();
        BigDecimal bd = BigDecimal.valueOf(averageSalary);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
