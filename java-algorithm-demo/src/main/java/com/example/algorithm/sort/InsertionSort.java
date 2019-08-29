package com.example.algorithm.sort;

public class InsertionSort {
    public static void main(String[] args) {

        int[] sort = {9, 0, 7, 2, 3, 2, 5, 2, 0, 4, 7, 4, 9, 3, 0, 2};
        insert(sort);

        for (int i : sort) {
            System.out.println(i);
        }
    }

    public static void insert(int[] sort) {

        for (int i = 1; i < sort.length; i++) {
            int current = sort[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && current < sort[preIndex]) {
                sort[preIndex + 1] = sort[preIndex];
                preIndex--;
            }

            sort[preIndex + 1] = current;
        }


    }
}
