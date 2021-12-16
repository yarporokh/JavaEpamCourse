package com.company.task1;

public class task2 {
    public static String num(int n) {
        int temp;
        int[] array = new int[3];
        int pos = 0;
        String result = "";
        //Filling array
        while (n > 0) {
            array[pos] = n % 10;
            pos++;
            n = n / 10;
        }

        //Sorting array
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        }

        for (int i = 0; i < 3; i++) {
            result += array[i];
        }
        return result;
    }
}
