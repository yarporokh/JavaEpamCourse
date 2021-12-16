package com.company.task1;

public class task3 {
    public static int num(int n) {
        int res = 0;

        while (n > 0) {
            int temp = n % 10;

            if ((n % 2) == 1) {
                res = res + temp;
            }
            n = n / 10;
        }
        return res;
    }
}
