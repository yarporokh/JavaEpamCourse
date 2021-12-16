package com.company.task3;


public class task1 {
    public static boolean IsSorted(int[] arr, SortOrder sortOrder) {
        if (sortOrder == SortOrder.ASCENDING) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) return false;
            }
        } else if (sortOrder == SortOrder.DESCENDING) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(IsSorted(arr, SortOrder.ASCENDING));
        System.out.println(IsSorted(arr, SortOrder.DESCENDING));
    }

}
