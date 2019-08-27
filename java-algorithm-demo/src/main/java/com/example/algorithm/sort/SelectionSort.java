package com.example.algorithm.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] sort = new int[]{7, 3, 3, 9, 2, 4, 7, 2, 3, 9, 4, 7, 3, 2, 8, 9, 0};
        select(sort);
        for (int i : sort) {
            System.out.println(i);
        }
    }

    public static void select(int sort[]) {

        for (int i = 0; i < sort.length; i++) {
            int minIndex = i;
            for (int j = i; j < sort.length; j++) {
                if (sort[j] < sort[minIndex]) {
                    minIndex = j;
                }
            }
            swap(sort, i, minIndex);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
