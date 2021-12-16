package com.company.task3;

import java.time.temporal.IsoFields;

public class task3 {
    public static int MultArithmeticElements(int a1, int t, int n) {
        if (n == 0) {
            return 1;
        }
        return a1 * MultArithmeticElements(a1 + t, t, --n);
    }

    public static void main(String[] args) {
        System.out.println(MultArithmeticElements(5, 3, 4)); //Output 6160
    }
}
