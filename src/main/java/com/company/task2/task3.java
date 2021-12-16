package com.company.task2;

import java.util.Arrays;

public class task3 {
    public static void function(int[][] arr) {


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j > i) {
                    arr[i][j] = 1;
                } else if (j < i) {
                    arr[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
    }
}
