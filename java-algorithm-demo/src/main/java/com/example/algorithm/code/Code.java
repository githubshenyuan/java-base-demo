package com.example.algorithm.code;

import jdk.nashorn.internal.objects.annotations.Where;

public class Code {
    public static void main(String[] args) {

        isPalindrome(1234);

    }


    /**
     * 序号: 9
     * 判断给定数字是否事回文
     * @param x 字符串
     * @return 是:true 否:false
     */
    public static boolean isPalindrome(String x) {



        return false;
    }

    /**
     * 序号: 9
     * 判断给定数字是否事回文
     * @param x 数组
     * @return 是:true 否:false
     */
    public static boolean isPalindrome(int x) {
        int num = 0;
        new StringBuilder();
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();

        return false;
    }

    /**
     * 序号 1
     * 两数之和算法
     * 从数组中随机选出两个整数，且整数相加之和等于给定的数。
     * @param nums 数组
     * @param target 两数之和
     * @return 返回满足要求的小标
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < nums.length; i1++) {
                if (nums[i] + nums[i1] == target) {
                    return new int[]{i, i1};
                }
            }

        }

        throw new RuntimeException();


    }
}
