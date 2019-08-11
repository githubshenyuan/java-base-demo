package com.example.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorService {
    public static void main(String[] args) {

        SimpleExecutorService simpleExecutor = new SimpleExecutorService();
        simpleExecutor.fixedThreadPool();

    }
    /**
     * 单线程线程池
     */
    public  void singleThreadExecutor() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new myRunnable());
            System.out.println("线程" + i + "启动完成");

        }
    }
    /**
     * 缓存线程池
     */
    public  void cachedThreadPool() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new myRunnable());
            System.out.println("线程" + i + "启动完成");

        }
    }

    /**
     * 固定长度线程池
     */
    public void fixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new myRunnable());
            System.out.println("线程" + i + "启动完成");
        }
    }

    /**
     * 固定长度线程池
     */
    public void scheduledThreadPool() {
        ExecutorService executorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.execute(new myRunnable());
            System.out.println("线程" + i + "启动完成");
        }
    }
    /**
     * 实现runnable
     */
     class myRunnable implements Runnable{
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(Thread.currentThread().getName() + ":" + "结束");
        }
    }



}
