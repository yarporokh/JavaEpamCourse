package com.company.task3;

import java.util.Arrays;

public class task2 {
    public static int[] Transform(int[] arr, SortOrder sortOrder) {
        int[] tempArr = Arrays.copyOf(arr, arr.length);
        if (sortOrder == SortOrder.ASCENDING) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) return arr;
            }
        } else if (sortOrder == SortOrder.DESCENDING) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) return arr;
            }
        }

        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] += i;
        }
        return tempArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(Transform(arr, SortOrder.ASCENDING)));
        System.out.println(Arrays.toString(Transform(arr, SortOrder.DESCENDING)));
    }
}
