package com.example.algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] sort = {3, 8, 9, 2, 5, 4, 0, 1, 7};
        quick(sort, 0, sort.length-1);
        for (int i : sort) {
            System.out.println(i);
        }
    }


    public static void quick(int[] sort, int low, int high) {
        if (low < high) {
            int re = getIndex(sort, low, high);
            quick(sort, low, re-1);
            quick(sort, re + 1, high);
        }
    }

    public static int getIndex(int[] sort, int low, int high) {
        int tmp = sort[low];
        while (low < high) {
            while (low < high && sort[high] >= tmp) {
                high--;
            }
            sort[low] = sort[high];
            while (low < high && sort[low] <= tmp) {
                low++;
            }
            sort[high] = sort[low];
        }
        sort[low] = tmp;
        return low;
    }

}
