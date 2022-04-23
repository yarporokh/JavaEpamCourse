package com.advanced.practice5.task9;


public class Lot {
    private int number;
    private int price;

    public Lot(int number, int price) {
        this.number = number;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public synchronized void addPrice() {
        price += 5;
    }


}
