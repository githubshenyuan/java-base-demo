package com.example.service.impl;

/**
 * @author sh 2018/11/6 22:24
 * @version ideaIU-2018.2.5.win
 */
import com.example.service.CalculatorService;

import java.util.concurrent.Callable;

public class CalculatorServiceImpl implements CalculatorService {
    /**
     * 加法计算
     * @param a
     * @param b
     * @return
     */
    public int plus(int a, int b) {
        //
        return a+b;
    }
}
