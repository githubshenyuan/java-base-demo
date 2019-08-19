package com.example.sort;

import com.example.common.utils.ConsumeUtil;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7};
        int[] b = {7, 6, 5, 4, 3, 2, 1};
        ConsumeUtil.initConsume();
        bubble(a);
        System.out.println(ConsumeUtil.getValue());

    }

    public static int[] bubble(int[] sort) {

        for (int i = 0; i < sort.length; i++) {
            for (int j = 0; j < sort.length - i - 1; j++) {
                if (sort[j] > sort[j + 1]) {
                    ConsumeUtil.increase();
                    int a = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = a;
                }

            }
        }
        return sort;

    }
}
