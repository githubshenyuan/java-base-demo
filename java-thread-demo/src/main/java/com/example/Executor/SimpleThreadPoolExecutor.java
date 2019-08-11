package com.example.Executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThreadPoolExecutor {
    public static void main(String[] args) {
        SimpleThreadPoolExecutor executor = new SimpleThreadPoolExecutor();
        executor.simple();

    }


    public void simple() {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        ThreadFactory threadFactory = new myTreadFactory();
        RejectedExecutionHandler handler = new myRejectedExecutionHandler();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);

        executor.prestartAllCoreThreads(); // 预启动所有核心线程

        executor.execute(new myTask());


    }


    public class myTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        public Thread newThread(Runnable r) {

            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }

    public class myRejectedExecutionHandler implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("达到最大并发量，拒绝执行");
        }
    }

    public class myTask implements Runnable {
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
