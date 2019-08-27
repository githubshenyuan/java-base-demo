package com.example.algorithm.search;

public class SequenceSearch {

    public static void main(String[] args) {

        String[] search = new String[]{"a", "b", "c", "d", "e", "f", "g"};

        int index = sequenceIndex(search, "g");

        System.out.println("查询到数据 索引:" + index + " 值:" + search[index]);

    }


    public static int sequenceIndex(String[] search, String key) {

        for (int i = 0; i < search.length; i++) {
            if (search[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
