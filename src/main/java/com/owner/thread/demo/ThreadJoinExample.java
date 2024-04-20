package com.owner.thread.demo;

public class ThreadJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("T1 is running");
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join(); // 等待T1执行完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 is running");
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join(); // 等待T2执行完毕
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3 is running");
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
