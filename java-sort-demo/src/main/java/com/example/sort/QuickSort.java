package com.example.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] sort = {3, 8, 9, 2, 5, 4, 0, 1, 7};
    }

    public static int getIndex(int[] sort, int low, int high) {
        int tem = sort[low];
        while (low < high) {
            while (low < high && sort[high] >= tem) {
                high--;
            }
            sort[low] = sort[high];
            while (low < high && sort[low] <= tem) {
                low++;
            }
        }

        return 1;

    }
}
