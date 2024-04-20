package com.owner.thread.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Service
public class DemoServiceImpl {

    private static ReentrantLock lock = new ReentrantLock();

    /**
     * 验证未获取到synchronizedMethod的线程处于什么状态
     */
    public synchronized void synchronizedMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("执行结束");
    }

    public void lockMethod() {
        lock.lock();
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


}
