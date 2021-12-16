package com.company.task2;

import java.util.Arrays;

public class task1 {
    public static void function(int[] arr) {
        int temp;
        int halfLength = arr.length / 2;

        for (int i = 0; i < halfLength; i++) {
            if ((arr[i] % 2 == 0) && (arr[arr.length - i - 1] % 2 == 0)) {
                temp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
