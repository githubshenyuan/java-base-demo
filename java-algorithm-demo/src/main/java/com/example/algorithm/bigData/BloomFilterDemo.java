package com.example.algorithm.bigData;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class BloomFilterDemo {

    private static Long size = 9170116754L;
   private static BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.ISO_8859_1), size,0.01);


    public static void main(String[] args) {
        System.out.println(Long.MIN_VALUE);

        int success = 0;
        int fail = 0;
        for (int i = 0; i < 10000; i++) {
            boolean bloom = bloom(success, fail);
            if (bloom) {
                success++;
            } else {
                fail++;
            }

        }
        System.out.println("成功:" + success + "失败:" + fail);
    }

    public static boolean bloom(int success, int fail) {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        boolean b = bloomFilter.mightContain(uuid);
        if (b) {
            System.out.println(uuid + " 存在的情况下:" + bloomFilter.put(uuid));
            return false;
        } else {
            System.out.println(uuid + " 不存在的情况下:" + bloomFilter.put(uuid));
            return true;

        }
    }


}
