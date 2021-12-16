package com.company.task2;

public class task2 {
    public static void function(int[] arr) {
        int max = arr[0];

        int result = 0;
        for (int curr : arr) {
            max = Math.max(max, curr);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                int counter = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    counter++;
                    if (arr[j] == max) {
                        result = counter;
                    }
                }
                break;
            }
        }
        System.out.println(result);

    }
}
