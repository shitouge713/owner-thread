package com.owner.thread.demo;

import java.util.concurrent.CountDownLatch;

public class MyThreadDemo implements Runnable {
    CountDownLatch latch;

    public MyThreadDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        // 模拟线程A执行一些任务
        try {
            Thread.sleep(2000);
            System.out.println("Thread A finished");
            latch.countDown(); // 线程A执行完毕后调用countDown()
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
