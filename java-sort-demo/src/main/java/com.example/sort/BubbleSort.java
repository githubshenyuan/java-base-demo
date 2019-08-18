package com.example.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = { 9, 7, 2, 3, 9, 7, 4, 8, 3, 2};
        bubble(a);
    }

    public static int[] bubble(int[] sort) {

        for (int i = 0; i < sort.length; i++) {
            for (int j = 0; j < sort.length - i - 1; j++) {
                if (sort[j] > sort[j + 1]) {
                    int a = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = a;
                }

            }
        }
        return sort;

    }
}
