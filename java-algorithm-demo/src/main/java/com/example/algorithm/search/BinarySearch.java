package com.example.algorithm.search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] search = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int index = binary(search, search.length, 7);

        System.out.println("查询到数据 索引:" + index + " 值:" + search[index]);
    }

    public static int binary(int[] search, int n, int key) {
        int low = 0;
        int high = n - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (key > search[mid]) {
                low = mid++;
            }
            if (key < search[mid]) {
                high = mid--;
            }
            if (key == search[mid]) {
                return mid;
            }


        }
        return 0;

    }
}
