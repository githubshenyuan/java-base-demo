package com.example.algorithm.sort;

/**
 * 希尔排序算法
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] sort = {8, 0, 6, 4, 8, 3, 7, 6, 3, 0, 4, 7};
        shell(sort);
    }

    public static void shell(int[] sort) {
        int gap = sort.length / 2;

        while (gap > 0) {
            for (int i = 0; i < sort.length; i++) {
                int current = sort[i];
                int preIndex = i - gap;

                while (preIndex > 0 && current > sort[preIndex]) {
                    sort[i] = sort[i - gap];
                    preIndex -= gap;
                }
                sort[preIndex + gap] = current;
            }

            gap /= 2;
        }
    }
}
