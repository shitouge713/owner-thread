package com.owner.thread.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * CompletableFuture实现方案
 * 实现所有线程在等待线程1发生后才会去执行
 */
public class CompletableFutureExample {

    static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("com.alibaba.nacos.client.config.security.updater-%d");
            return t;
        }
    });

    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 1 is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorService);
        future1.thenRunAsync(() -> {
            System.out.println("Task 2 is running");
        }, executorService);
        future1.thenRunAsync(() -> {
            System.out.println("Task 3 is running");
        }, executorService);
        future1.thenRunAsync(() -> {
            System.out.println("Task 4 is running");
        }, executorService);
        //CompletableFuture.
        // 等待所有任务执行完毕
        //CompletableFuture.allOf(future1, future2, future3).join();
    }
}
