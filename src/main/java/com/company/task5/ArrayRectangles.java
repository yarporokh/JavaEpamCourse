package com.company.task5;

public class ArrayRectangles {
    private Rectangle[] rectangle_array;

    public ArrayRectangles(int n) {
        rectangle_array = new Rectangle[n];
    }

    public ArrayRectangles(Rectangle... rectangles) {
        this(rectangles.length);

        System.arraycopy(rectangles, 0, rectangle_array, 0, rectangles.length);// fill array
    }

    public boolean addRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangle_array.length; i++) {
            if (rectangle_array[i] == null) {
                rectangle_array[i] = rectangle;
                return true;
            }
        }
        return false;
    }

    public int numberMaxArea() {
        int index = 0;
        double maxArea = rectangle_array[0].area();

        for (int i = 0; i < rectangle_array.length - 1; i++) {
            if (maxArea < rectangle_array[i + 1].area()) {
                maxArea = rectangle_array[i + 1].area(); // assigs a new number of max area
                index = i + 1;
            }
        }

        return index;
    }

    public int numberMinPerimeter() {
        int index = 0;
        double minPerimeter = rectangle_array[0].perimeter();

        for (int i = 0; i < rectangle_array.length - 1; i++) {
            if (minPerimeter > rectangle_array[i + 1].perimeter()) {
                minPerimeter = rectangle_array[i + 1].perimeter(); // assigs a new number of min perimeter
                index = i + 1;
            }
        }
        return index;
    }

    public int numberSquare() {
        int count = 0;
        for (Rectangle r : rectangle_array) {
            if (r.isSquare())
                count++;
        }
        return count;
    }
}
