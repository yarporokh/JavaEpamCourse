package com.company.task3;

public class task4 {
    public static float SumGeometricElements(float a1, float t, float alim) {
        if (a1 < alim) {
            return 0;
        }
        return a1 + SumGeometricElements(a1 * t, t, alim);
    }

    public static void main(String[] args) {
        System.out.println(SumGeometricElements(100f, 0.5f, 20f)); //Output 175.0
    }
}
