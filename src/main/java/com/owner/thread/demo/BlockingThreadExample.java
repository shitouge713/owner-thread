package com.owner.thread.demo;

public class BlockingThreadExample {
    private static final Object lock = new Object();
    private static boolean isReady = false;
    public static void main(String[] args) {
        Thread waitingThread = new Thread(() -> {
            synchronized (lock) {
                //这里要用while，不能用if，线程可能因为虚假唤醒而被意外唤醒，或者是notifyAll唤醒时，还不满足条件，所以要用while避免
                while (!isReady) {
                    try {
                        System.out.println("Waiting thread is waiting");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Waiting thread is awake");
            }
        });
        Thread notifyingThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifying thread is starting");
                isReady = true;
                lock.notify();
                System.out.println("Notifying thread is done");
            }
        });
        waitingThread.start();
        notifyingThread.start();
    }
}
