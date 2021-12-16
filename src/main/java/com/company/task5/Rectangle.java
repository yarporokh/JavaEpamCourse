package com.company.task5;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double a, double b) {
        this.sideA = a;
        this.sideB = b;
    }

    public Rectangle(double a) {
        this(a, 5);
    }

    public Rectangle() {
        this(4, 3);
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double area() { // Return area of rectangle
        return sideA * sideB;
    }

    public double perimeter() { // Return perimeter of rectangle
        return sideA * 2.0 + sideB * 2.0;
    }

    public boolean isSquare() {
        return sideA == sideB; // checks if the rectangle is a square
    }

    public void replaceSides() {
        double temp = sideA;
        sideA = sideB;
        sideB = temp;
    }
}
