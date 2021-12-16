package com.company.task1;

public class task4 {
    public static int num(int n) {
        int temp;
        int count = 0;

        while (n > 0) {
            temp = n % 2;

            if (temp == 1) {
                count++;
            }

            n /= 2;
        }
        return count;
    }
}
