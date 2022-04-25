package com.advanced.practice6.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array) {
        return Arrays.stream(array).flatMap(value -> IntStream.of(value, value)).iterator();
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return Arrays.stream(array).flatMap(value -> IntStream.of(value, value, value)).iterator();
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return Arrays.stream(array).flatMap(value -> IntStream.of(value, value, value, value, value)).iterator();
    }

    public static Iterable<String> table(String[] columns, int[] rows) {
        int len = columns.length * rows.length;
        String[] arr = new String[len];
        int column = 0;
        int row = 0;

        for (int i = 0; i < arr.length; i++) {

            if (row % rows.length == 0 && row > 0) {
                row = 0;
                column++;
            }
            arr[i] = columns[column] + rows[row];
            row++;
        }

        return List.of(arr);
    }


}
