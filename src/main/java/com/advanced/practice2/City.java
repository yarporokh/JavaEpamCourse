package com.advanced.practice2;

public class City {
    private String name;
    private int id;
    private static int counter = 0;

    public City(String name) {
        this.name = name;
        id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        City city = new City("A");
        City city1 = new City("A");
        City city2 = new City("A");
        City city3 = new City("A");
        System.out.println(city.getId());
        System.out.println(city1.getId());
        System.out.println(city2.getId());
        System.out.println(city3.getId());
    }
}
