package com.saravana.multithreading.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptibleTask implements Runnable {
    private final ReentrantLock lock;

    public InterruptibleTask(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
            try {
                System.out.println("Lock acquired by " + Thread.currentThread().getName());
                Thread.sleep(2000);
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
        }
    }
}
