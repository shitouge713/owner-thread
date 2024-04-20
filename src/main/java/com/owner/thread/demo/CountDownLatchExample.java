package com.owner.thread.demo;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch实现方案：
 * 实现所有线程在等待线程1发生后才会去执行
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        MyThreadDemo myRunnable = new MyThreadDemo(latch);
        Thread threadA = new Thread(myRunnable);
        Thread threadB = new Thread(() -> {
            try {
                latch.await(); // 等待线程A执行完毕
                System.out.println("Thread B is running after Thread A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                latch.await(); // 等待线程A执行完毕
                System.out.println("Thread C is running after Thread A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
    }
}
